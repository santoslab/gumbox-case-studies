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

val project = "rts"
val basePackage = "RTS"

val jar = home / "out" / project / "assemble" / s"${project}.jar"
val slangCheckLoc = home / "src" / "main" / "data" / basePackage / "SlangCheckRandom.scala"

val resultServerNodeName = "mac-mini-intel"
val resultServer = "santos_jenkins@e2206hm03.cs.ksu.edu"

val jobName = s"DSC_${project}_Begin"

val jenkinsUser: String = Os.env("jenkins_user") match {
  case Some(u) => u
  case _ => halt("Must set jenkins_user environment variable")
}

val jenkinsToken: String = Os.env("jenkins_token") match {
  case Some(t) => t
  case _ => halt("Must set jenkins_token environment variable")
}

if (Os.cliArgs.size < 1) {
  println("First option must be (test | fetch)")
  Os.exit(-1)
}

val default_timeout: String = {
  if (Os.cliArgs.size == 1) "1"
  else (Os.cliArgs(1))
}

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

val list: ISZ[Container] = ISZ(

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


def test(): Unit = {
  if (!jar.exists) {
    println("Replacing for loops with whiles ...")
    slangCheckLoc.writeOver(ops.StringOps(slangCheckLoc.read).replaceAllLiterally("for(i <- 0 to 100)", "while (true)"))

    println("Assembling ...")
    proc"sireum proyek assemble --include-sources --include-tests -n ${project} .".at(home).console.runCheck()

    println("Reverting back to for loops ...")
    proc"git checkout ${slangCheckLoc.value}".at(home).console.runCheck()

    def upload(server: String): Unit = {
      println(s"Uploading to $server ...")
      proc"ssh santos_jenkins@${server} mkdir -p dsc/${project}".console.runCheck()
      proc"scp ${jar.value} santos_jenkins@${server}:dsc/${project}/${jar.name}".console.runCheck()
    }
    upload("linux.cs.ksu.edu")
    upload("e2206hm02.cs.ksu.edu")
    upload("e2206hm03.cs.ksu.edu")
  }

  for (c <- list) {
    //val (runner_simple_name, timeout, runner_class_name) = l
    val runner_class_name = s"${c.packageName}.${c.objectName}_GumboX_SlangCheck_TestRunner"
    proc"curl  https://jenkins.cs.ksu.edu/job/${jobName}/buildWithParameters --user ${jenkinsUser}:${jenkinsToken} --data RUNNER_CLASS_NAME=${runner_class_name} --data RUNNER_SIMPLE_NAME=${c.dscPrefix} --data TIMEOUT=${default_timeout}".console.runCheck()
  }
}

val timeoutDir = s"/opt/santos/jenkins/dsc-jacoco/${project}/timeout_${default_timeout}"
val zipFile = s"${project}_timeout_${default_timeout}.zip"

def fetch(): Unit = {
  for (c <- list) {
    val dscPrefix = s"${timeoutDir}/${c.dscPrefix}-${resultServerNodeName}-dsc-tested"
    def ffetch(ext: String): Z = {
      val temp = Os.temp()
      proc"scp ${resultServer}:${dscPrefix}.${ext} ${temp.value}".console.runCheck()
      return temp.readLines.size
    }
    val passing = ffetch("passing")
    val failing = ffetch("failing")
    val unsat = ffetch("unsat")
    val ttemp = Os.temp()
    ttemp.writeOver(s"${passing-unsat}\n${failing}\n${unsat}\n")
    proc"scp ${ttemp.value} ${resultServer}:${dscPrefix}.results".console.runCheck()
  }

  //val cmd = s"\"cd $timeoutDir && find . ! -name '*.dump' ! -name '*.7z' | sort | zip -@ ${zipFile}\""
  val cmd = s"\"cd $timeoutDir && zip -r ${zipFile} . -x '*dump*'\""
  proc"ssh ${resultServer} sh -c $cmd".echo.console.runCheck()
  println()
  println(s"Downloading via: scp ${resultServer}:${timeoutDir}/${zipFile} ${zipFile}")

  proc"scp ${resultServer}:${timeoutDir}/${zipFile} ${zipFile}".console.runCheck()
}

Os.cliArgs(0) match {
  case string"test" => test()
  case string"fetch" => fetch()
  case _ => println("Choose an option (test, zip, fetch)")
}