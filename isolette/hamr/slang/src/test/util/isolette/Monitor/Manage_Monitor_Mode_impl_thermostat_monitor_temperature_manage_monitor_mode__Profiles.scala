// #Sireum

package isolette.Monitor

import org.sireum._
import isolette.RandomLib

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

// Profile for initialise entrypoint
@record class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile (
  val name: String,
  val numTests: Z //number of tests to generate
)

// Profile with generators for incoming ports
@record class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_P(
  val name: String,
  val numTests: Z, // number of tests to generate
  var numTestVectorGenRetries: Z, // number of test vector generation retries
  var api_current_tempWstatus: RandomLib, // random lib for generating Isolette_Data_Model.TempWstatus_impl
  var api_interface_failure: RandomLib, // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  var api_internal_failure: RandomLib // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  )

// Profile with generators for state variables and incoming ports
@record class Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_Profile_PS(
  val name: String,
  val numTests: Z, // number of tests to generate
  var numTestVectorGenRetries: Z, // number of test vector generation retries
  var In_lastMonitorMode: RandomLib, // random lib for generating Isolette_Data_Model.Monitor_Mode
  var api_current_tempWstatus: RandomLib, // random lib for generating Isolette_Data_Model.TempWstatus_impl
  var api_interface_failure: RandomLib, // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  var api_internal_failure: RandomLib // random lib for generating Isolette_Data_Model.Failure_Flag_impl
  )
