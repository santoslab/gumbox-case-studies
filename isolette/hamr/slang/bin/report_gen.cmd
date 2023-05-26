::/*#! 2> /dev/null                                 #
@ 2>/dev/null # 2>nul & echo off & goto BOF         #
if [ -z ${SIREUM_HOME} ]; then                      #
  echo "Please set SIREUM_HOME env var"             #
  exit -1                                           #
fi                                                  #
exec ${SIREUM_HOME}/bin/sireum slang run "$0" "$@"  #
:BOF
setlocal
if not defined SIREUM_HOME (
  echo Please set SIREUM_HOME env var
  exit /B -1
)
%SIREUM_HOME%\\bin\\sireum.bat slang run "%0" %*
exit /B %errorlevel%
::!#*/
// #Sireum

import org.sireum._

val homeBin = Os.slashDir
val home = homeBin.up

val sireumBin = Os.path(Os.env("SIREUM_HOME").get) / "bin"
val sireum = sireumBin / (if(Os.isWin) "sireum.bat" else "sireum")


@datatype class Container(
                          val project: String,
                          val componentName: String,
                          val componentShortName: String,
                          val packageName: String,
                          val fullName: String,
                          val node: String,
                         )

val projects: Map[String, ISZ[Container]] = Map.empty ++ ISZ(
  "isolette" ~> ISZ(
    Container("isolette", "Manage Alarm", "ma", "Monitor", "Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm", "linux64-santos16-minion"),
    Container("isolette", "Manage Monitor Interface", "mmi", "Monitor", "Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface", "linux64-santos16-minion"),
    Container("isolette", "Manage Monitor Mode", "mmm", "Monitor", "Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode", "linux64-santos16-minion"),
    Container("isolette", "Manage Heat Source", "mhs", "Regulate", "Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source", "linux64-santos16-minion"),
    Container("isolette", "Manage Regulator Interface", "mri", "Regulate", "Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface", "linux64-santos16-minion"),
    Container("isolette", "Manage Regulator Mode", "mrm", "Regulate", "Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode", "linux64-santos16-minion"),
))

var components: ISZ[ST] = ISZ()
for (e <- projects.entries) {
  for (p <- e._2) {
    var rows: ISZ[ST] = ISZ()
    for (t <- ISZ(1, 3, 30, 360)) {
      val timeoutPrefix = s"${p.project}_timeout_${t}"

      val directoryPrefix = s"results/${timeoutPrefix}/"

      val prefix = s"${p.project}-${p.componentShortName}-${p.node}"

      val jPrefix = s"${prefix}-jacoco.coverage"

      val tr = Os.temp()
      val dscResults = s"${p.project}/${directoryPrefix}/${prefix}-dsc-tested.results"
      proc"scp santos_jenkins@linux.cs.ksu.edu:public_html/dsc_results/$dscResults ${tr.value}".console.runCheck()
      val trl = tr.readLines
      val passing = Z(trl(0)).get
      val failing = Z(trl(1)).get
      val unsat = Z(trl(2)).get
      val total = passing + failing + unsat

      val csv = s"${directoryPrefix}/${jPrefix}.csv"
      val metrics = s"${directoryPrefix}/${jPrefix}/${p.project}.${p.packageName}/index.source.html"
      val ccov = s"${directoryPrefix}/${jPrefix}/${p.project}.${p.packageName}/${p.fullName}.scala.html"
      val gcov = s"${directoryPrefix}/${jPrefix}/${p.project}.${p.packageName}/${p.fullName}_GumboX.scala.html"

      rows = rows :+
        st"""<tr>
            |  <td>${t}</td>
            |  <td>$total</td>
            |  <td>$passing</td>
            |  <td>$failing</td>
            |  <td>0</td>
            |  <td>$unsat</td>
            |  <td><a href="$metrics">link</a></td>
            |  <td><a href="$ccov">link</a></td>
            |  <td><a href="$gcov">link</a></td>
            |  <td><a href="$csv">csv</a></td>
            |  <td><a href="results/${timeoutPrefix}.zip">zip</a></td>
            |</tr>"""
    }

    components = components :+
      st"""<h2>${p.componentName}</h2>
          |<table border=1>
          |  <tr>
          |    <th>Timeout (s)</th>
          |    <th>Total<br>Tests</th>
          |    <th>Passing<br>Tests</th>
          |    <th>Failing<br>Tests</th>
          |    <th>Unsat Data<br>Invariants</th>
          |    <th>Unsat<br>Requires</th>
          |    <th>Package<br>Coverage</th>
          |    <th>Component<br>Coverage</th>
          |    <th>GumboX<br>Coverage</th>
          |    <th>csv<br>Coverage</th>
          |    <th>Zipped<br>Results</th>
          |  </tr>
          |  ${(rows, "\n")}
          |</table>"""
  }

  val projWebsite =
    st"""<html>
        |  <style>
        |    a { text-decoration: none; }
        |    table {
        |      border: collapse;
        |      table-layout: fixed;
        |    }
        |    th {
        |      background-color: #E5E4E2;
        |      padding-left: 5px;
        |      padding-right: 5px;
        |    }
        |    td {
        |      padding-left: 5px;
        |      padding-right: 5px;
        |    }
        |    tr:nth-child(odd) { background-color: #f2f2f2; }
        |  </style>
        |  <body>
        |     ${(components, "\n")}
        |  </body>
        |</html>"""

  val f = Os.temp()
  f.writeOver(projWebsite.render)

  proc"scp ${f.value} santos_jenkins@linux.cs.ksu.edu:public_html/dsc_results/${e._1}/${e._1}.html".console.runCheck()
}

val website =
  st"""<html>
      |  <body>
      |    ${(for(k <- projects.keys) yield s"<a href=\"${k}/${k}.html\">${k}</a>", "\n\n<p>")}
      |  </body>
      |</html>"""

val f = Os.temp()
f.writeOver(website.render)

proc"scp ${f.value} santos_jenkins@linux.cs.ksu.edu:public_html/dsc_results/index.html".console.runCheck()
