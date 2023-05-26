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


@datatype class Container(val project: String,
                          val packageName: String,
                          val objectName: String,

                          val prettyName: String,
                          val tag: String,

                          val node: String
                         ) {
  def dscPrefix: String = {
    return s"$project-$tag"
  }
}

@datatype class TContainer(val timeouts: ISZ[Z],
                           val containers: ISZ[Container])

val isolette = "isolette" ~> TContainer(
  ISZ(1, 3, 30, 360),
  ISZ(
    Container("isolette", "isolette.Monitor", "Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm",
      "Manage Alarm", "ma", "linux64-santos16-minion"),
    Container("isolette", "isolette.Monitor", "Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface",
      "Manage Monitor Interface", "mmi", "linux64-santos16-minion"),
    Container("isolette", "isolette.Monitor", "Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode",
      "Manage Monitor Mode", "mmm", "linux64-santos16-minion"),

    Container("isolette", "isolette.Regulate", "Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source",
      "Manage Heat Source", "mhs", "linux64-santos16-minion"),
    Container("isolette", "isolette.Regulate", "Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source",
      "Manage Regulator Interface", "mri", "linux64-santos16-minion"),
    Container("isolette", "isolette.Regulate", "Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode",
      "Manage Regulator Mode", "mrm", "linux64-santos16-minion")
  )
)

val rts = "rts" ~> TContainer(
  ISZ(1, 5, 30),
  ISZ(
    Container("rts", "RTS.Actuation", "Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator",
      "Saturation Actuator", "saturationActuator", "mac-mini-intel"),

    Container("rts", "RTS.Actuation", "Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator",
      "TempPressure Actuator Unit", "tempPressureActuator", "mac-mini-intel"),

    Container("rts", "RTS.Actuation", "CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic",
      "Actuation Unit 1 Pressure Logic", "au1-pressureLogic", "mac-mini-intel"),
    Container("rts", "RTS.Actuation", "CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic",
      "Actuation Unit 1 Saturation Logic", "au1-saturationLogic", "mac-mini-intel"),
    Container("rts", "RTS.Actuation", "CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic",
      "Actuation Unit 1 Temperature Logic", "au1-temperatureLogic", "mac-mini-intel"),


    Container("rts", "RTS.Actuation", "CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic",
      "Actuation Unit 2 Pressure Logic", "au2-pressureLogic", "mac-mini-intel"),
    Container("rts", "RTS.Actuation", "CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic",
      "Actuation Unit 2 Saturation Logic", "au2-saturationLogic", "mac-mini-intel"),
    Container("rts", "RTS.Actuation", "CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic",
      "Actuation Unit 2 Temperature Logic", "au2-temperatureLogic", "mac-mini-intel"),


    Container("rts", "RTS.Actuation", "OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic",
      "Actuation Unit 1 TempPressureTripOut or Logic", "au1-tempPressureTripOut", "mac-mini-intel"),
    Container("rts", "RTS.Actuation", "OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic",
      "Actuation Unit 2 TempPressureTripOut or Logic", "au2-tempPressureTripOut", "mac-mini-intel"),

    Container("rts", "RTS.Actuation", "OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic",
      "Actuate Saturation Actuator", "actuateSaturationActuator", "mac-mini-intel"),

    Container("rts", "RTS.Actuation", "OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic",
      "Actuate TempPressure Actuator", "actuateTempPressureActuator", "mac-mini-intel"),
  )
)

val projects: Map[String, TContainer] = Map.empty[String, TContainer] ++ ISZ(isolette, rts)


for (e <- projects.entries) {
  var components: ISZ[ST] = ISZ()
  for (p <- e._2.containers) {
    var rows: ISZ[ST] = ISZ()
    for (t <- e._2.timeouts) {
      val timeoutPrefix = s"${p.project}_timeout_${t}"

      val directoryPrefix = s"results/${timeoutPrefix}/"

      val prefix = s"${p.dscPrefix}-${p.node}"

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
      val metrics = s"${directoryPrefix}/${jPrefix}/${p.packageName}/index.source.html"
      val ccov = s"${directoryPrefix}/${jPrefix}/${p.packageName}/${p.objectName}.scala.html"
      val gcov = s"${directoryPrefix}/${jPrefix}/${p.packageName}/${p.objectName}_GumboX.scala.html"

      rows = rows :+
        st"""<tr>
            |  <td>${t}</td>
            |  <td>$total</td>
            |  <td>$passing</td>
            |  <td>$failing</td>
            |  <td>$unsat</td>
            |  <td><a href="$metrics">link</a></td>
            |  <td><a href="$ccov">link</a></td>
            |  <td><a href="$gcov">link</a></td>
            |  <td><a href="$csv">csv</a></td>
            |  <td><a href="results/${timeoutPrefix}.zip">zip</a></td>
            |</tr>"""
    }

    components = components :+
      st"""<h2>${p.prettyName}</h2>
          |<table border=1>
          |  <tr>
          |    <th>Timeout (s)</th>
          |    <th>Total<br>Tests</th>
          |    <th>Passing<br>Tests</th>
          |    <th>Failing<br>Tests</th>
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
