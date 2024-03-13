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
    if (!(c/ "isolette").exists || !(c / "rts").exists) {
      halt(s"Root dir should contain all the subprojects: $c")
    }
    c
  }

  @datatype class TestConfig(val name: String,
                             val schema: String,
                             val profile: String,
                             val filter: String,
                             val property: String)

  @datatype class SystemTestingArtifacts(val systemName: String,
                                         val inputOutputContainers: Os.Path,
                                         val systemTestOutputDir: Os.Path,

                                         val exampleTestFrameworkPrefix: String,
                                         val manualTestingFilename: String,
                                         val exampleTestConfig: TestConfig,

                                         val dscTestingFileName: String,
                                         val dscFQName: String
                                        ) {
    def manualTestingFile: Os.Path = {
      return systemTestOutputDir / manualTestingFilename
    }
    def dscHarnessFile: Os.Path = {
      return systemTestOutputDir / dscTestingFileName
    }
    def simpleManualTestSuiteName: String = {
      return ops.StringOps(manualTestingFilename).replaceAllLiterally(".scala", "")
    }
    def simpleDscHarnessName: String = {
      return ops.StringOps(dscTestingFileName).replaceAllLiterally(".scala", "")
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

                          val testConfigs: ISZ[SystemTestingArtifacts]
                         )

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

  val isolette: Project = {
    val projRootDir = repoRootDir / "isolette"
    val defaultDirs = Util.getDefaultDirectories(projRootDir)

    Project(
      title = "Isolette",
      description = None(),
      projectRootDir = projRootDir,
      //aadlRootDir = defaultDirs.aadlDir,
      air = defaultDirs.json,
      //packageName = Some("isolette"),
      configs = ISZ(Util.baseOptions(
        packageName = Some("isolette"),
        args = ISZ(defaultDirs.json.value),
        outputDir = Some(defaultDirs.slangDir.value),
        aadlRootDir = Some(defaultDirs.aadlDir.value)
      )),
      testConfigs = ISZ(
        SystemTestingArtifacts(
          systemName = "Regulator subsystem",
          inputOutputContainers = defaultDirs.slangDir / "src/main/util/isolette/system_tests/rst/Regulate_Subsystem_Containers.scala",
          systemTestOutputDir = defaultDirs.slangDir / "src/test/system/isolette/system_tests/rst",
          exampleTestFrameworkPrefix = "Example_Regulate_Subsystem_Inputs_Container",
          manualTestingFilename = "Regulate_Subsystem_Test_wSlangCheck.scala",

          dscTestingFileName = "Regulate_Subsystem_Test_wSlangCheck_DSC_Test_Harness.scala",
          dscFQName = "isolette.system_tests.rst.Regulate_Subsystem_Test_wSlangCheck_DSC_Test_Harness",

          exampleTestConfig = TestConfig(
            name = "HC__Normal_____Heat_On",
            schema = "Regulator_1HP_script_schema",
            profile = "validRanges",
            filter = "Regulate_Subsystem_Inputs_Container_GumboX.system_Pre_Container",
            property = "sysProp_NormalModeHeatOn"
          )
        ),
        SystemTestingArtifacts(
          systemName = "Monitor subsystem",
          inputOutputContainers = defaultDirs.slangDir / "src/main/util/isolette/system_tests/monitor1/Monitor_Subsystem_Containers.scala",
          systemTestOutputDir = defaultDirs.slangDir / "src/test/system/isolette/system_tests/monitor1",
          exampleTestFrameworkPrefix = "Example_Monitor_Subsystem_Inputs_Container",
          manualTestingFilename = "Monitor_Subsystem_Test_wSlangCheck.scala",
          dscTestingFileName = "Monitor_Subsystem_DSC_Test_Harness.scala",
          dscFQName = "isolette.system_tests.monitor1.Monitor_Subsystem_DSC_Test_Harness",
          exampleTestConfig = TestConfig(
            name = "MA__Normal_____Alarm_On",
            schema = "Monitor_1HP_script_schema",
            profile = "validRanges",
            filter = "assumeFigureA_7",
            property = "sysProp_NormalModeAlarmOn"
          )
        )
      )
    )
  }

  val rts: Project = {
    val projRootDir = repoRootDir / "rts"
    val defaultDirs = Util.getDefaultDirectories(projRootDir)

    Project(
      title = "RTS",
      description = None(),
      projectRootDir = projRootDir,
      //aadlRootDir = defaultDirs.aadlDir,
      air = defaultDirs.json,
      //packageName = Some("RTS"),
      configs = ISZ(Util.baseOptions(
        packageName = Some("RTS"),
        args = ISZ(defaultDirs.json.value),
        outputDir = Some(defaultDirs.slangDir.value),
        aadlRootDir = Some(defaultDirs.aadlDir.value)
      )),
      testConfigs = ISZ(
        SystemTestingArtifacts(
          systemName = "Actuator subsystem",
          inputOutputContainers = defaultDirs.slangDir / "src/main/util/RTS/system_tests/rts1/Containers.scala",
          systemTestOutputDir = defaultDirs.slangDir / "src/test/system/RTS/system_tests/rts1",
          exampleTestFrameworkPrefix = "Example_Actuation_Subsystem_Inputs_Container",
          manualTestingFilename = "Actuation_Subsystem_Test_wSlangCheck.scala",
          dscTestingFileName = "Actuation_Subsystem_DSC_Test_Harness.scala",
          dscFQName = "RTS.system_tests.rts1.Actuation_Subsystem_DSC_Test_Harness",
          exampleTestConfig = TestConfig(
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

  val projects: ISZ[Project] = ISZ(isolette, rts)

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
