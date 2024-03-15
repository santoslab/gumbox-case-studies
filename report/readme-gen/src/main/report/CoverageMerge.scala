// #Sireum
package report

import org.sireum._
import MergeUtils._
import report.CoverageMerge.genPaperVersions

object CoverageMerge extends App {
  val genPaperVersions: B = T

  val removeDump: B = F
  val regenMergedReports: B = F

  val dsc_prefix: String = "dsc_gumbox_journal_cust"

  val reportRoot: Os.Path = Os.path("/opt") / "santos" / "jenkins" / dsc_prefix / "tester"

  val filter: B = F
  val filters: ISZ[String] = ISZ("tc")

  def main(args: ISZ[String]): Z = {
    merge()
    return 0
  }

  def merge(): Unit = {

    var map: cmap = HashSMap.empty
    var results: ISZ[Results] = ISZ()
    def walk(p: Os.Path): Unit = {
      if (p.isFile && p.name == "sireum.version") {
        println(p.up.toUri)
        val passingP = fetch(".passing", p.up.list).get
        val failingP = fetch(".failing", p.up.list).get
        val unsatP = fetch(".unsat", p.up.list).get
        val execP = fetch(".exec", p.up.list).get
        val csvP = fetch(".csv", p.up.list).get
        val coverageP = fetch(".coverage", p.up.list).get
        val dumpP = fetch(".dump", p.up.list)
        val project = p.up.up.up.up.name
        val dscTestName = p.up.up.up.name
        val componentName = ops.StringOps(dscTestName).replaceAllLiterally("_DSC_UnitTests", "")
        val configName = p.up.up.name
        val timeout = Z(p.up.name).get

        val hamrRoot = Projects.projects.get(project).get.hamrRoot
        val configJsonP: Os.Path = {
          val configFileName = s".$dscTestName.scala.json"
          val cached = reportRoot / project / dscTestName / configFileName
          if (cached.exists) {
            println(s"Using cached config for ${dscTestName}")
            cached
          } else {
            val actual = Os.Path.walk(hamrRoot / "src" / "test" / "bridge", F, F, p => p.name == configFileName)(0)
            cached.writeOver(actual.read)
            actual
          }
        }

        val behaviorP = Os.Path.walk(hamrRoot / "src" / "main" / "component", F, F, p => p.name == s"$componentName.scala")(0)
        val gumboxP: Option[Os.Path] = {
          val ll = Os.Path.walk(hamrRoot / "src" / "main" / "bridge", F, F, p => p.name == s"${componentName}_GumboX.scala")
          if (ll.nonEmpty) Some(ll(0))
          else None()
        }
        val componentPackage = s"${behaviorP.up.up.name}.${behaviorP.up.name}"
        val r = Results(
          project = project,
          component = componentName,
          componentNickName = getNickName(componentName),
          dscTestName = dscTestName,
          componentPackage = componentPackage,
          configName = configName,
          configDescription = getConfigDescription(configName, configJsonP),
          timeout = timeout,
          passing = numVectors(passingP) - numVectors(unsatP),
          failing = numVectors(failingP),
          unsat = numVectors(unsatP),
          passingP = passingP,
          failingP = failingP,
          unsatP = unsatP,
          exec = execP,
          csv = csvP,
          coverageP = coverageP,
          dumpP = dumpP,
          configJsonP = configJsonP,
          gumboXP = gumboxP,
          behaviorP = behaviorP
        )
        if (!filter || ops.ISZOps(filters).contains(project)) {
          results = results :+ r
          map = add2Map(r, map)
        } else {
          println(s"Not process ${project} due to filter ...")
        }
      } else if (p.isDir) {
        val x = ops.StringOps(p.name)
        if (!x.endsWith(".coverage") && !x.endsWith(".dump")) {
          for (l <- p.list) {
            walk(l)
          }
        }
      }
    }
    walk(reportRoot)

    //println(map)

    var topLevelProjs: ISZ[(String, Os.Path)] = ISZ()

    for (projects <- map.entries) {
      var projectResults = ISZ[Results]()
      for (components <- projects._2.entries) {
        var componentResults = ISZ[Results]()
        for (configs <- components._2.entries) {
          var configResults = ISZ[Results]()
          for (timeouts <- configs._2.entries) {
            val results = timeouts._2
            configResults = configResults :+ results
            componentResults = componentResults :+ results
            projectResults = projectResults :+ results
            addTimeoutReport(results, reportRoot)
          }
          val configurationRoot = configResults(0).passingP.up.up
          addConfigurationReport(configResults, configurationRoot, reportRoot, regenMergedReports)
        }
        val componentRoot = componentResults(0).passingP.up.up.up
        addComponentReport(componentResults, components._2.keys, componentRoot, reportRoot, regenMergedReports)
      }
      val projectRoot = projectResults(0).passingP.up.up.up.up
      val components: ISZ[(String, String)] = for (p <- projects._2.keys) yield (p, getNickName(p))
      addProjectReport(projectResults, components, projectRoot, reportRoot, F) // never T

      topLevelProjs = topLevelProjs :+ (projects._1, projectRoot)
    }

    addRootReport(reportRoot, topLevelProjs)
  } // end of merge
}

object MergeUtils {
  def addTimeoutReport(r: Results, reportRoot: Os.Path): Unit = {
    val root1 = r.passingP.up

    val reportDir = root1

    val r0 = reportDir.relativize(reportRoot / "report.html")
    val r1 = reportDir.relativize(reportRoot / r.project / "report.html")
    val r2 = reportDir.relativize(reportRoot / r.project / r.dscTestName / "report.html")
    val r3 = reportDir.relativize(reportRoot / r.project / r.dscTestName / r.configName / "report.html")

    val cookieCrumb = cookies(ISZ(("Report", r0), (r.project, r1), (r.componentNickName, r2), (r.configName, r3)))

    val resultTable: ST = genResultTable(
      results = ISZ(r),
      parentDir = reportDir,
      reportDir = reportDir,
      isActualRun = T
    )

    val html = reportTemplate(cookieCrumbs = cookieCrumb,
      purpose = st"""This presents the combined coverage information along with the number of passing/failing/unsat test vectors
                    |for the ${r.configName} configuration with a ${r.timeout} second timeout""",
      project = st"""<a href="$r1">${r.project}</a>""",
      system = Some(st"""<a href="$r2">${r.componentNickName}</a>"""),
      families = Some(st"""<a href="$r3">${r.configName}</a> : ${r.configDescription}"""),
      timeouts = Some(st"""${r.timeout}"""),
      resultTables = ISZ(resultTable),
      reportDir = reportDir,
    )
    val report = reportDir / "report.html"
    report.writeOver(html.render)
    println(s"Wrote: ${report}")
  }

  def getEntrypointMethodName(r: Results): String = {
    val o = ops.StringOps(r.configName)
    if (o.contains("Compute")) {
      return "timeTriggered"
    } else if (o.contains("Initialize")) {
      return "initialise"
    } else {
      halt(s"Couldn't determine entrypoint for ${r.configName}")
    }
  }

  //                                                       component     entrypoint     timeout
  def splitProjectResults(results: ISZ[Results]): HashSMap[String, HashSMap[String, HashSMap[Z, ISZ[Results]]]] = {
    var t = HashSMap.empty[String, ISZ[Results]]
    for (r <- results) {
      val e: ISZ[Results] = t.get(r.component) match {
        case Some(ee) => ee
        case _ => ISZ()
      }
      t = t + r.component ~> (e :+ r)
    }
    var ret = HashSMap.empty[String, HashSMap[String, HashSMap[Z, ISZ[Results]]]]
    for (e <- t.entries) {
      ret = ret + e._1 ~> splitResults(e._2)
    }
    return ret
  }

  //                                                 entrypoint     timeout
  def splitResults(results: ISZ[Results]) : HashSMap[String, HashSMap[Z, ISZ[Results]]] = {
    var ret = HashSMap.empty[String, HashSMap[Z, ISZ[Results]]]
    for(r <- results) {
      val typ: String = if (ops.StringOps(r.configName).contains("Compute")) "Compute" else "Initialize"
      val e: HashSMap[Z, ISZ[Results]] = ret.get(typ) match {
        case Some(ee) => ee
        case _ => HashSMap.empty[Z, ISZ[Results]]
      }
      val e2: ISZ[Results] = e.get(r.timeout) match {
        case Some(ee2)=> ee2
        case _ => ISZ()
      }
      ret = ret + typ ~> (e + (r.timeout ~> (e2 :+ r)))
    }
    return ret
  }

  def addConfigurationReport(configResults: ISZ[Results], configRoot: Os.Path, reportRoot: Os.Path, regenMergedReports: B): Unit = {
    val reportDir = configRoot

    val r = configResults(0)
    val r0 = reportDir.relativize(reportRoot / "report.html")
    val r1 = reportDir.relativize(reportRoot / r.project / "report.html")
    val r2 = reportDir.relativize(reportRoot / r.project / r.dscTestName / "report.html")

    val stimeouts = ops.ISZOps(for(r <- configResults) yield r.timeout).sortWith((a,b) => a <= b)
    val timeOuts: ISZ[String] = for(t <- stimeouts) yield s"<a href=\"${(reportDir.relativize(reportDir / t.string / "report.html")).string}\">${t.string}</a>"

    val cookieCrumb = cookies(ISZ(("Report", r0), (r.project, r1), (r.componentNickName, r2)))

    val splits = splitResults(configResults)

    var resultTables: ISZ[ST] = ISZ()
    for (typ <- splits.entries) {
      val timeoutResults: ISZ[Results] = for (timeout <- typ._2.entries) yield
        mergeResults (results = timeout._2, regenMergedReports = regenMergedReports, jacocoDirName = s"jacocoCoverage_${timeout._1}", relativeTo = reportDir)

      resultTables = resultTables :+
        genResultTable(
          results = timeoutResults,
          parentDir = reportDir,
          reportDir = reportDir,
          isActualRun = T)
    }

    val html = reportTemplate(cookieCrumbs = cookieCrumb,
      purpose = st"""This presents the combined coverage information along with the number of passing/failing/unsat test vectors
                    |for the ${r.configName} configuration""",
      project = st"""<a href="$r1">${r.project}</a>""",
      system = Some(st"""<a href="$r2">${r.componentNickName}</a>"""),
      families = Some(st"""${r.configName} : ${r.configDescription}"""),
      timeouts = Some(st"""${(timeOuts, " ")}"""),
      resultTables = resultTables,
      reportDir = reportDir
    )
    val report = reportDir / "report.html"
    report.writeOver(html.render)
    println(s"Wrote: ${report}")
  }
  
  @datatype class CoverageInfo(val behavior: ST, val gumbox: Option[ST], val fullReport: ST)

  def addComponentReport(allConfigResults: ISZ[Results], configurations: ISZ[String], componentRoot: Os.Path, reportRoot: Os.Path, regenMergedReports: B): Unit = {
    val reportDir = componentRoot

    val r = allConfigResults(0)

    val r0 = reportDir.relativize(reportRoot / "report.html")
    val r1 = reportDir.relativize(reportRoot / r.project / "report.html")

    val configLinks: ISZ[String] = for(t <- configurations) yield
      s"""<a href="${(reportDir.relativize(reportDir / t / "report.html")).string}">${t}</a><br>"""

    val cookieCrumb = cookies(ISZ(("Report", r0), (r.project, r1)))

    val splits: HashSMap[String, HashSMap[Z, ISZ[Results]]] = splitResults(allConfigResults)
    val resultTablesX: ISZ[ST] = commonSpitter(splits, regenMergedReports, reportDir, reportDir)

    val resultsTables: ISZ[ST] =
      if (!genPaperVersions) {
        ISZ(st"<table><tr>${(resultTablesX, "<td>&nbsp;&nbsp</td>\n")}</tr></table>")
      } else {
        if (resultTablesX.size == 2) {
          ISZ(st"""${resultTablesX(1)}
                  |<br>
                  |${resultTablesX(0)}""")
        } else {
          resultTablesX
        }
      }

    val html = reportTemplate(
      cookieCrumbs = cookieCrumb,
      purpose = st"""The presents the combined coverage information along with the number of passing/failing/unsat test vectors
                    |for running all the configurations for ${r.componentNickName}""",
      project = st"""<a href="$r1">${r.project}</a>""",
      system = Some(st"${r.componentNickName}"),
      families = Some(st"${(configLinks, " ")}"),
      timeouts = None(),
      resultTables = resultsTables,
      reportDir = reportDir
    )

    val report = reportDir / "report.html"
    report.writeOver(html.render)
    println(s"Wrote: ${report}")
  }

  def commonSpitter(splits: HashSMap[String, HashSMap[Z, ISZ[Results]]], regenMergedReports: B, parentDir: Os.Path, reportDir: Os.Path): ISZ[ST] = {
    var resultTables: ISZ[ST] = ISZ()
    for (typ <- splits.entries) {
      val timeoutResults: ISZ[Results] = for (timeout <- typ._2.entries) yield
        mergeResults (
          results = timeout._2, regenMergedReports = regenMergedReports,
          jacocoDirName = s"jacocoCoverage_${typ._1}_${timeout._1}", relativeTo = reportDir)
      val configNames: ISZ[String] = (Set.empty[String] ++ (for (tr <- typ._2.values; trr <- tr) yield trr.configName)).elements
      val configLinks: ISZ[String] = for (tr <- configNames) yield s"""<a href="${(parentDir.relativize(reportDir / tr / "report.html")).string}">${tr}</a><br>"""

      val table =
        genResultTable(
          results = timeoutResults,
          parentDir = parentDir,
          reportDir = reportDir,
          isActualRun = F)

      resultTables = resultTables :+
        st"""<td valign="bottom" style='vertical-align: bottom'>
            |  ${(configLinks, "\n")}
            |  $table
            |</td>"""
    }
    return resultTables
  }


  def addProjectReport(allConfigResults: ISZ[Results], components: ISZ[(String, String)], projectRoot: Os.Path, reportRoot: Os.Path, regenMergedReports: B): Unit = {
    val reportDir = projectRoot

    val r0 = reportDir.relativize(reportRoot / "report.html")

    val componentLinks: ISZ[String] = for(component <- components) yield s"<a href=\"${(reportDir.relativize(reportDir / s"${component._1}_DSC_UnitTests" / "report.html")).string}\">${component._2}</a>"

    val cookieCrumb = cookies(ISZ(("Report", r0)))

    val projSplits = splitProjectResults(allConfigResults)
    var resultTables: ISZ[ST] = ISZ()
    for (projSplit <- projSplits.entries) {
      val resultTablesx: ISZ[ST] = commonSpitter(projSplit._2, regenMergedReports, reportDir, reportDir / s"${projSplit._1}_DSC_UnitTests")

      if (!genPaperVersions) {
        resultTables = resultTables :+
          st"""<h3>${getNickName(projSplit._1)} <a style="font-size: medium; font-weight: normal;" href="${(reportDir.relativize(reportDir / s"${projSplit._1}_DSC_UnitTests" / "report.html")).string}">link</a></h3>
              |
              |<table><tr>${(resultTablesx, "<td>&nbsp;&nbsp</td>\n")}</tr></table>
              |"""
      } else {
        val paperFormatted: ST = if (resultTablesx.size == 2){
          st"""${resultTablesx(1)}
              |<br>
              |${resultTablesx(0)}"""
        } else {
          resultTablesx(0)
        }

        resultTables = resultTables :+
          st"""<h3>${getNickName(projSplit._1)} <a style="font-size: medium; font-weight: normal;" href="${(reportDir.relativize(reportDir / s"${projSplit._1}_DSC_UnitTests" / "report.html")).string}">link</a></h3>
              |
              |$paperFormatted
              |"""
      }
    }
    val r = allConfigResults(0)
    val html = reportTemplate(
      cookieCrumbs = cookieCrumb,
      purpose = st"""This presents the combined coverage information along with the number of passing/failing/unsat test vectors
                    |for each of the ${r.project}'s components under testing""",
      project = st"${r.project}",
      system = Some(st"${(componentLinks, "<br><br> ")}"),
      resultTables = resultTables,
      families = None(),
      timeouts = None(),
      reportDir = reportDir
    )
    val report = reportDir / "report.html"
    report.writeOver(html.render)
    println(s"Wrote: ${report}")
  }


  def addRootReport(root: Os.Path, topLevelProjs: ISZ[(String, Os.Path)]): Unit = {
    val projects: ISZ[ST] = for (p <- topLevelProjs) yield st"""<a href="${root.relativize(p._2 / "report.html")}">${p._1}</a>"""
    val html = reportTemplate(
      cookieCrumbs = st"",
      purpose = st"",
      project = st"${(projects, "<br><br>")}",
      resultTables = ISZ(),
      system = None(),
      families = None(),
      timeouts = None(),
      reportDir = root
    )
    val f = root / "report.html"
    f.writeOver(html.render)
    println(s"Wrote: $f")
  }

  @datatype class Results(val project: String,
                          val component: String,
                          val componentNickName: String,
                          val componentPackage: String,
                          val dscTestName: String,
                          val configName: String,
                          val timeout: Z,

                          val configDescription: String,

                          val passing: Z,
                          val failing: Z,
                          val unsat: Z,

                          val passingP: Os.Path,
                          val failingP: Os.Path,
                          val unsatP: Os.Path,

                          val exec: Os.Path,
                          val csv: Os.Path,
                          val coverageP: Os.Path,
                          val dumpP: Option[Os.Path],

                          val configJsonP: Os.Path,
                          val gumboXP: Option[Os.Path],
                          val behaviorP: Os.Path)

  def fetch(suffix: String, paths: ISZ[Os.Path]): Option[Os.Path] = {
    val ret: Option[Os.Path] = (ops.ISZOps(paths).filter(f => ops.StringOps(f.name).endsWith(suffix)) match {
      case ISZ(e) => Some(e)
      case _ => None()
    })
    return ret
  }

  //                     proj             component        config           timeout
  type cmap = HashSMap[String, HashSMap[String, HashSMap[String, HashSMap[Z, Results]]]]

  def add2Map(r: Results, projMap: HashSMap[String, HashSMap[String, HashSMap[String, HashSMap[Z, Results]]]]): cmap = {
    val compMap: HashSMap[String, HashSMap[String, HashSMap[Z, Results]]] = projMap.get(r.project) match {
      case Some(componentMap) => componentMap
      case _ => HashSMap.empty[String, HashSMap[String, HashSMap[Z, Results]]]()
    }
    val configMap: HashSMap[String, HashSMap[Z, Results]] = compMap.get(r.component) match {
      case Some(configMap) => configMap
      case _ => HashSMap.empty[String, HashSMap[Z, Results]]()
    }
    val timMap: HashSMap[Z, Results] = configMap.get(r.configName) match {
      case Some(timmap) => timmap
      case _ => HashSMap.empty[Z, Results]()
    }
    assert(!timMap.contains(r.timeout))

    return projMap + r.project ~> (compMap + (r.component ~> (configMap + r.configName ~> (timMap + (r.timeout ~> r)))))
  }

  def numVectors(p: Os.Path): Z = {
    return ops.StringOps(p.read).split(c => c == '\n').size
  }

  def getConfigDescription(configName: String, p: Os.Path): String = {
    var c = ops.StringOps(ops.StringOps(ops.StringOps(p.read).replaceAllLiterally("[ ", "")).replaceAllLiterally(" ]", ""))
    for (e <- c.split(c => c == ',')) {
      c = ops.StringOps(ops.StringOps(e).trim)
      val list = ops.StringOps(c.substring(1, c.size - 1)).split(c => c == '|')
      if (list(0) == configName) {
        return list(1)
      }
    }
    halt(s"Couldn't find description for ${configName}")
  }

  def cookies(ps: ISZ[(String, Os.Path)]): ST = {
    val x: ISZ[ST] = for(p <- ps) yield st"""<a href="${p._2}">${p._1}</a>"""
    return st"${(x, " > ")}"
  }

  def getLineCoverage(methodName: String, r: Results, reportDir: Os.Path): (Option[ST], Option[ST]) = {
    val p: Os.Path = r.coverageP / r.componentPackage
    val behavior = p / s"${r.component}$$.html"
    //val summary = reportDir.relativize(p / s"${r.component}$$.html")
    val gumbox = p / s"${r.component}_GumboX$$.html"

    def mine(method: String, contents: String): (Z, Z) = {
      var contents_ = ops.StringOps(contents)
      val p1 = contents_.stringIndexOf(method)
      contents_ = ops.StringOps(contents_.substring(p1, contents_.stringIndexOfFrom("el_method", p1)))
      val p2 = contents_.stringIndexOf("id=\"h")
      val missed = contents_.substring(p2 + 8, contents_.stringIndexOfFrom("</td>", p2))
      val p3 = contents_.stringIndexOf("id=\"i")
      val total = contents_.substring(p3 + 8, contents_.stringIndexOfFrom("</td>", p3))
      if (Z(total).isEmpty) {
        println(total)
        println()
      }
      val totalz = Z(total).get
      val covered = totalz - Z(missed).get
      return (covered, totalz)
    }

    val b: Option[ST] = if (behavior.exists) {
      val info = mine(methodName, behavior.read)
      Some(st"${info._1}/${info._2}")
    } else {
      None()
    }
    val g: Option[ST] = if (gumbox.exists) {
      None()
    } else {
      None()
    }
    //val gumboxR = reportDir.relativize(gumbox)
    //val optGumbox: Option[ST] =
    //  if (gumbox.exists) Some(st"<a href=$gumboxR>link</a>")
    // else None()
    //return (st"""<a href=$summary>link</a>""", optGumbox)
    return (b, g)
  }

  def getCoverage(r: Results, reportDir: Os.Path): (ST, Option[ST]) = {
    val p: Os.Path = r.coverageP / r.componentPackage
    val summary = reportDir.relativize(p / s"${r.component}$$.html")
    val gumbox = p / s"${r.component}_GumboX$$.html"
    val gumboxR = reportDir.relativize(gumbox)
    val optGumbox: Option[ST] =
      if (gumbox.exists) Some(st"<a href=$gumboxR>link</a>")
      else None()
    return (st"""<a href=$summary>link</a>""", optGumbox)
  }

  def genResultTable(results : ISZ[Results], parentDir: Os.Path, reportDir: Os.Path, isActualRun: B): ST = {
    var tableEntries: ISZ[ST]= ISZ()
    for (r <- ops.ISZOps(results).sortWith((a,b) => a.timeout <= b.timeout)) {
      def optLink(num: Z, p: Os.Path): ST = {
        return (
          if (isActualRun && num > 0) st"""<a href="${parentDir.relativize(p)}">$num</a>"""
          else st"$num")
      }
      val subs: (ST, Option[ST]) = getCoverage(r, parentDir)
      val codeCoverage = getLineCoverage(getEntrypointMethodName(r), r, parentDir)
      val entrypointCoverageOpt: ST =
        if (codeCoverage._1.nonEmpty) {
          st"${codeCoverage._1.get} "
        } else {
          st"??"
        }
      val timeoutSt: ST =
        if (isActualRun) st"""<td><a href="${reportDir.relativize(r.unsatP.up / "report.html")}">${r.timeout}</a></td>"""
        else st"""<td>${r.timeout}</td>"""

      val coverage = CoverageInfo(subs._1, subs._2, st"""<a href="${parentDir.relativize(r.coverageP)}/index.html">link</a>""")
      val cells = ISZ(
        timeoutSt,
        st"""<td id=col_a title="Number of test vectors that passed">${optLink(r.passing, r.passingP)}</td>""",
        st"""<td id=col_a title="Number of test vectors that failed">${optLink(r.failing, r.failingP)}</td>""",
        st"""<td id=col_a title="Number of test vectors that failed to satisfy filter">${optLink(r.unsat, r.unsatP)}</td>""",
        st"<td>${entrypointCoverageOpt}${coverage.behavior}</td>",
        st"<td>${coverage.gumbox}</td>",
        st"<td>${coverage.fullReport}</td>"
      )
      tableEntries = tableEntries :+ st"<tr>${(cells, "\n")}</tr>"
    }
    def colName(str: String): String = {
      return if (genPaperVersions) s"${ops.StringOps(str).first}" else str
    }
    val stats =
      st"""<table class=resultTable border=1>
          |<th>${colName("Timeouts")}</th>
          |<th>${colName("Passing<br>Tests")}</th>
          |<th>${colName("Failing<br>Tests")}</th>
          |<th>${colName("Unsat<br>Tests")}</th>
          |<th>Behavior<br>Coverage</th>
          |<th>GumboX<br>Coverage</th>
          |<th>Full<br>Coverage</th>
          |${(tableEntries, "\n")}
          |</table>"""
    return stats
  }

  def reportTemplate(cookieCrumbs: ST,
                     purpose: ST,
                     project: ST,
                     system: Option[ST],
                     families: Option[ST],
                     timeouts: Option[ST],
                     resultTables: ISZ[ST],
                     reportDir: Os.Path): ST = {

    @strictpure def wrap(n: String, title: String, o: Option[ST]): Option[ST] =
      if (o.nonEmpty) Some(st"""<tr><td id=col_a title="$title">${n}: </td><td>${o.get}<br><br></td></tr>""")
      else None()

    return(
      st"""<html>
          |  <head>
          |    <style>
          |      *{ font-family: monospace }
          |
          |      a, a:visited {
          |        color: blue;
          |        text-decoration: none;
          |      }
          |
          |      table.resultTable {
          |        border: collapse;
          |        table-layout: fixed;
          |        font-family: monospace;
          |      }
          |      table.resultTable th {
          |        background-color: #E5E4E2;
          |        padding-left: 5px;
          |        padding-right: 5px;
          |      }
          |      table.resultTable td {
          |        padding-left: 5px;
          |        padding-right: 5px;
          |      }
          |      table.resultTable tr:nth-child(odd) { background-color: #f2f2f2; }
          |      td { vertical-align: top; }
          |      #col_a { font-weight: bold; }
          |      </style>
          |    </head>
          |  </head>
          |  <body>
          |$cookieCrumbs
          |<br><br><br>
          |
          |$purpose
          |<br><br><br>
          |
          |<table>
          |  <tr><td id=col_a title="Project name">Projects:</td><td>$project<br><br></td></tr>
          |    ${wrap("Components", "The component being tested", system)}
          |    ${wrap("Configurations", "The test configuration(s) used during testing", families)}
          |    ${wrap("Timeouts", "The timeout(s) used while generating test vectors", timeouts)}
          |</table>
          |
          |  ${(resultTables, "<br>\n<br>\n")}
          |
          |  </body>
          |</html>
          |""")
  }

  def mergeResults(results: ISZ[Results], regenMergedReports: B, jacocoDirName: String, relativeTo: Os.Path): Results = {
    var (passing, failing, unsat) = (0, 0, 0)
    var execsPaths: ISZ[Os.Path] = ISZ()
    var dumpLoc: Option[Os.Path] = None()

    val t = results(0).timeout
    for (r <- results) {
      passing = passing + r.passing
      failing = failing + r.failing
      unsat = unsat + r.unsat
      execsPaths = execsPaths :+ r.exec
      if (r.dumpP.nonEmpty && dumpLoc.isEmpty) {
        dumpLoc = r.dumpP
      }
    }
    assert (dumpLoc.nonEmpty, "Wasn't able to find a dump")

    val jacocoOutDir = relativeTo / jacocoDirName

    if (regenMergedReports) {
      val jacocoCli = Os.home / "devel" / "sireum" / "kekinian" / "lib" / "jacococli.jar"

      val csv = relativeTo / "jacoco.csv"

      val sireumHome = Sireum.homeOpt.get
      val javaExe = Sireum.javaHomeOpt.get / "bin" / (if (Os.isWin) "java.exe" else "java")

      val execs: ISZ[String] = for(x <- execsPaths) yield x.string

      println(s"Working on ${relativeTo.string} ...")
      val commands = ISZ[String](javaExe.string, "-jar", jacocoCli.string, "report") ++ execs ++ ISZ[String]("--encoding",
        "UTF-8", "--classfiles", dumpLoc.get.string, "--csv", csv.string, "--html", jacocoOutDir.string, "--sourcefiles", dumpLoc.get.string)

      Os.proc(commands).console.echo.runCheck()
      println()
    }

    val x = results(0)(passing = passing, failing = failing, unsat = unsat, coverageP = jacocoOutDir)

    return x
  }

  def getNickName(s: String): String = {
    val nicknames = Map.empty[String, String] ++
      ISZ(
        "Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm" ~> "Manage Alarm (MA)",
        "Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source" ~> "Manage Heat Source (MHS)",
        "Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface" ~> "Manage Monitor Interface (MMI)",
        "Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode" ~> "Manage Monitor Mode (MMM)",
        "Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface" ~> "Manage Regulator Interface (MRI)",
        "Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode" ~> "Manage Regulator Mode (MRM)",

        "FanPeriodic_p_tcproc_fan" ~> "Fan",
        "OperatorInterfacePeriodic_p_tcproc_operatorInterface" ~> "Operator Interface",
        "TempControlPeriodic_p_tcproc_tempControl" ~> "Temp Control",
        "TempSensorPeriodic_p_tcproc_tempSensor" ~> "Temp Sensor",

        
        "CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic" ~> "au1_press_coincidenceLogic",
        "CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic" ~> "au1_satLogic_coincidenceLogic",
        "CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic" ~> "au1_temp_coincidenceLogic",
        "OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic" ~> "au1_tempPressTripOut_orLogic",

        "CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic" ~> "au2_press_coincidenceLogic",
        "CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic" ~> "au2_sat_coincidenceLogic",
        "CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic" ~> "au2_temp_coincidenceLogic",
        "OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic" ~> "au2_tempPressTripOut_orLogic",

        "OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic" ~> "TPAU_actTempPA_orLogic",
        "Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator" ~> "TPAU_tempPressA_actuator",

        "OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic" ~> "SAU_actSatActuator_orLogic",
        "Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator" ~> "SAU_satActuator_actuator"
      )

    val ret: String = nicknames.get(s) match {
      case Some(n) => n
      case _ => s
    }
    return ret
  }
}