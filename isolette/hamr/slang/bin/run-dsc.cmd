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

val jar = home / "out" / "isolette" / "assemble" / "isolette.jar"
val slangCheckLoc = home / "src" / "main" / "data" / "isolette" / "SlangCheckRandom.scala"

val jobName = "DSC_isolette_Begin"

val jenkinsUser: String = Os.env("jenkins_user") match {
  case Some(u) => u
  case _ => halt("Must set jenkins_users environment variable")
}

val jenkinsToken: String = Os.env("jenkins_token") match {
  case Some(t) => t
  case _ => halt("Must set jenkins_token environment variable")
}

val default_timeout: String = {
  if (Os.cliArgs.isEmpty) "1"
  else (Os.cliArgs(0))
}

val list: ISZ[(String, String, String)] = ISZ(
  ("isolette-ma", default_timeout, "isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_GumboX_SlangCheck_TestRunner"),
  ("isolette-mmi", default_timeout, "isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_GumboX_SlangCheck_TestRunner"),
  ("isolette-mmm", default_timeout, "isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_GumboX_SlangCheck_TestRunner"),

  ("isolette-mhs", default_timeout, "isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_GumboX_SlangCheck_TestRunner"),
  ("isolette-mri", default_timeout, "isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_GumboX_SlangCheck_TestRunner"),
  ("isolette-mri", default_timeout, "isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_GumboX_SlangCheck_TestRunner"),
  ("isolette-mrm", default_timeout, "isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_GumboX_SlangCheck_TestRunner")
)

if (!jar.exists) {
  println("Replacing for loops with whiles ...")
  slangCheckLoc.writeOver(ops.StringOps(slangCheckLoc.read).replaceAllLiterally("for(i <- 0 to 100)", "while (true)"))

  println("Assembling ...")
  proc"sireum proyek assemble --include-sources --include-tests -n isolette .".at(home).console.runCheck()

  println("Uploading ...")
  proc"scp ${jar.value} santos_jenkins@linux.cs.ksu.edu:dsc/isolette/${jar.name}".console.runCheck()

  println("Reverting back to for loops ...")
  proc"git checkout ${slangCheckLoc.value}".at(home).console.runCheck()
}

for(l <- list) {
  val (runner_simple_name, timeout, runner_class_name) = l
  proc"curl  https://jenkins.cs.ksu.edu/job/${jobName}/buildWithParameters --user ${jenkinsUser}:${jenkinsToken} --data RUNNER_CLASS_NAME=${runner_class_name} --data RUNNER_SIMPLE_NAME=${runner_simple_name} --data TIMEOUT=${timeout}".console.runCheck()
}
