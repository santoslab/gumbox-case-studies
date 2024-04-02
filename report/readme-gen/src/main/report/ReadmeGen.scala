// #Sireum

package report

import org.sireum._
import org.sireum.hamr.codegen.common.symbols.SymbolTable
import org.sireum.hamr.codegen.common.util.CodeGenConfig
import org.sireum.message.Reporter
import report.Report

object ReadmeGen extends App {

  val runCodegen: B = F
  val replaceReadmes: B = F

  val repoRootDir: Os.Path = {
    val c = Os.path(".").up.up.up
    if (!(c/ "isolette").exists || !(c / "rts").exists || ~(c / "temp_control" / "periodic").exists) {
      halt(s"Root dir should contain all the subprojects: $c")
    }
    c
  }

  @enum object EntrypointType {
    "Initialize"
    "Compute"
    "ComputeWstateVars"
  }

  @datatype class UnitTestConfig(val name: String,
                                 val description: String,
                                 val entrypointType: EntrypointType.Type)

  @datatype class ComponentArtifacts(val componentNickName: String,
                                       val componentFullName: String,
                                       val testConfigs: ISZ[UnitTestConfig],
                                       val manualTestingFilename: Os.Path,
                                       val dscTestingFileName: Os.Path
                                        ) {
    def simpleManualTestSuiteName: String = {
      return ops.StringOps(manualTestingFilename.name).replaceAllLiterally(".scala", "")
    }
    def simpleDscHarnessName: String = {
      return ops.StringOps(dscTestingFileName.name).replaceAllLiterally(".scala", "")
    }
  }

  @datatype class Project(val title: String,
                          val description: Option[String],
                          val projectRootDir: Os.Path,
                          //val aadlRootDir: Os.Path,
                          val air: Os.Path,
                          //val packageName: String,

                          // NOTE: ignore tipe warning that it can't find Cli.SireumHamrCodegenOption
                          //       as the source for that is in the jitpack jar file and thus not
                          //       accessible to tipe
                          val configs: ISZ[Cli.SireumHamrCodegenOption],

                          val testConfigs: ISZ[ComponentArtifacts]
                         )


  val isolette: Project = {
    val projRootDir = repoRootDir / "isolette"
    val defaultDirs = Util.getDefaultDirectories(projRootDir)

    Project(
      title = "Isolette",
      description = None(),
      projectRootDir = projRootDir,
      air = defaultDirs.json,
      configs = ISZ(Util.baseOptions(
        packageName = Some("isolette"),
        args = ISZ(defaultDirs.json.value),
        outputDir = Some(defaultDirs.slangDir.value),
        aadlRootDir = Some(defaultDirs.aadlDir.value)
      )),
      testConfigs = getTestArtifacts(defaultDirs.slangDir / "src" / "test"/ "bridge" / "isolette")
        /*
        ISZ(
        ComponentArtifacts(
          componentNickName = "MA",
          componentFullName = "Manage Alarm",

          manualTestingFilename = defaultDirs.slangDir / "src" / "test"/ "isolette" / "Monitor" /  "Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_GumboX_UnitTests.scala",
          dscTestingFileName =  defaultDirs.slangDir / "src" / "test"/ "isolette" / "Monitor" /  "Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_DSC_UnitTests.scala",

          testConfigs = getConfigs(defaultDirs.slangDir / "src" / "test"/ "isolette" / "Monitor" /  "Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_GumboX_UnitTests.scala")
        )*/
    )
  }
/*

  val rts: Project = {
    val projRootDir = repoRootDir / "rts"
    val defaultDirs = Util.getDefaultDirectories(projRootDir)

    Project(
      title = "RTS",
      description = None(),
      projectRootDir = projRootDir,
      air = defaultDirs.json,
      configs = ISZ(Util.baseOptions(
        packageName = Some("RTS"),
        args = ISZ(defaultDirs.json.value),
        outputDir = Some(defaultDirs.slangDir.value),
        aadlRootDir = Some(defaultDirs.aadlDir.value)
      )),
      testConfigs = ISZ(
        UnitTestingArtifacts(
          systemName = "Actuator subsystem",
          inputOutputContainers = defaultDirs.slangDir / "src/main/util/RTS/system_tests/rts1/Containers.scala",
          systemTestOutputDir = defaultDirs.slangDir / "src/test/system/RTS/system_tests/rts1",
          exampleTestFrameworkPrefix = "Example_Actuation_Subsystem_Inputs_Container",
          manualTestingFilename = "Actuation_Subsystem_Test_wSlangCheck.scala",
          dscTestingFileName = "Actuation_Subsystem_DSC_Test_Harness.scala",
          dscFQName = "RTS.system_tests.rts1.Actuation_Subsystem_DSC_Test_Harness",
          exampleTestConfig = UnitTestConfig(
            name = "TempPress_Manual_Trip",
            schema = "Actuation_Subsystem_1HP_script_schema",
            profile = "getDefaultProfile",
            filter = "examplePreStateContainerFilter",
            property = "sysProp_SaturationManualTrip"
          )
        )
      )
    )
  }

 */

  def h(s: String): Unit = {
    halt(s)
  }


  def getTestArtifacts(path: Os.Path): ISZ[ComponentArtifacts] = {
    var artifacts: ISZ[ComponentArtifacts] = ISZ()
    for (json <- Os.Path.walk(path, T, F, p => p.ext == "json")) {
      val name = ops.StringOps(json.name).replaceAllLiterally("_DSC_UnitTests.scala.json", "")
      artifacts = artifacts :+ ComponentArtifacts(
        componentNickName = getNickName(name),
        componentFullName = getComponentFullName(name),

        manualTestingFilename = json.up / s"${name}_GumboX_UnitTests.scala",
        dscTestingFileName =  json.up / s"${name}_DSC_UnitTests.scala",
        testConfigs = getConfigs(json)
      )
    }
    return artifacts
  }

  def getComponentFullName(name: String): String = {
    return name
  }

  def getNickName(name: String): String = {
    return name
  }

  def getConfigs(json: Os.Path): ISZ[UnitTestConfig] = {
    assert (json.exists, json)
    val lines = json.readLines
    assert(lines.size == 1)
    val entries = ops.StringOps(ops.StringOps(lines(0)).substring(2, lines(0).size - 2)).split(c => c == ',')
    var configs: ISZ[UnitTestConfig] = ISZ()
    for (c <- entries) {
      val cc = ops.StringOps(ops.StringOps(c).trim)
      val x = ops.StringOps(cc.substring(1, cc.size - 2)).split(c => c == '|')
      val x0 = ops.StringOps(x(0))
      val etype: EntrypointType.Type = {
        if (x(0) == "Compute_Config_ranges_based_on_requirements" || x0.contains("ComputewL")) {EntrypointType.ComputeWstateVars}
        else if (x0.contains("Compute")) {EntrypointType.Compute}
        else if (x0.contains("Initialize")) {EntrypointType.Initialize}
        else {
          h(x(0))
          EntrypointType.Initialize
        }
      }
      configs = configs :+ UnitTestConfig(name = x(0), description = x(1), entrypointType = etype)
    }
    return configs
  }
  /*
  val tempControlSporadic: Project = {
    val projRootDir = repoRootDir / "temp_control" / "sporadic"
    val defaultDirs = Util.getDefaultDirectories(projRootDir)

    Project(
      title ="Temperature Control Sporadic",
      description = None(),
      projectRootDir = projRootDir,
      //aadlRootDir = defaultDirs.aadlDir,
      //packageName = Some("tc"),
      air = defaultDirs.json,
      configs = ISZ(Util.baseOptions(
        packageName = Some("tc"),
        args = ISZ(defaultDirs.json.value),
        outputDir = Some(defaultDirs.slangDir.value),
        aadlRootDir = Some(defaultDirs.aadlDir.value)
      ))
    )
  }
  */

  val projects: ISZ[Project] = ISZ(isolette)//, rts)

  def main(args: ISZ[String]): Z = {
    run()
    return 0
  }

  def run(): Unit = {
    val reporter = Reporter.create

    var reports: ISZ[Report] = ISZ()

    for(project <- projects) {

      val aadlRootDir = Os.path(project.configs(0).aadlRootDir.get)
      val packageName = project.configs(0).packageName.get

      assert(aadlRootDir.exists)

      for(config <- project.configs) {
        assert (config.aadlRootDir.get == aadlRootDir.value)
        assert (config.packageName.get == packageName)

        println("***************************************")
        println(s"${project.projectRootDir} -- ${config.platform})")
        println("***************************************")

        if (runCodegen) {
          org.sireum.cli.HAMR.codeGen(config, reporter)
        }

        reporter.printMessages()
      }

      if (!reporter.hasError) {
        val readmeLoc = project.projectRootDir / "readme.md"
        val readmeContent = Report.genReport(project, packageName, aadlRootDir, repoRootDir, reporter)
        if (!reporter.hasError) {
          if (!readmeLoc.exists || replaceReadmes) {
            Report.overwrite(readmeLoc, readmeContent)
          } else {
            Report.weave(readmeLoc, readmeContent)
          }
        }
      }
    }
  }
}
