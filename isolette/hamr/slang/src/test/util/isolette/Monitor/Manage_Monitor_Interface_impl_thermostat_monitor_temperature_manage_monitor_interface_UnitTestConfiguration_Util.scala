// #Sireum

package isolette.Monitor

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

import org.sireum._
import isolette.GumboXUtil.GumboXResult
import isolette.util.{Container, Profile, UnitTestConfigurationBatch}
import isolette.RandomLib
import org.sireum.Random.Impl.Xoshiro256

object Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_UnitTestConfiguration_Util {

  def freshRandomLib: RandomLib = {
    return RandomLib(Random.Gen64Impl(Xoshiro256.create))
  }

  def defaultInitializeConfig: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Initialize_UnitTestConfiguration = {
    return (Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Initialize_UnitTestConfiguration (
      verbose = F,
      name = "Default_Initialize_Config",
      description = "Default Initialize Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Profile (
        name = "Initialize_Default_Profile", // needed for old framework
        numTests = 100, // needed for old framework
      ),
      genReplay = (c: Container, r: GumboXResult.Type) => None())
    )
  }

  def defaultComputeConfig: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Compute_UnitTestConfiguration = {
    return (Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Compute_UnitTestConfiguration (
      verbose = F,
      name = "Default_Compute_Config",
      description = "Default Compute Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Profile_P (
        name = "Compute_Default_Profile", // needed for old framework
        numTests = 100, // needed for old framework
        numTestVectorGenRetries = 100, // needed for old framework,
        api_current_tempWstatus = freshRandomLib,
        api_lower_alarm_tempWstatus = freshRandomLib,
        api_monitor_mode = freshRandomLib,
        api_upper_alarm_tempWstatus = freshRandomLib
      ),
      genReplay = (c: Container, r: GumboXResult.Type) => Some(
        st"""val testVector = isolette.JSON.toMonitorManage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_P(json).left
            |assert (testComputeCBV(testVector) == results)""".render))
    )
  }

  def defaultComputewLConfig: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_ComputewL_UnitTestConfiguration = {
    return (Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_ComputewL_UnitTestConfiguration (
      verbose = F,
      name = "Default_ComputewL_Config",
      description = "Default ComputewL Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Profile_PS (
        name = "ComputewL_Default_Profile", // needed for old framework
        numTests = 100, // needed for old framework
        numTestVectorGenRetries = 100, // needed for old framework,
        In_lastCmd = freshRandomLib,
        api_current_tempWstatus = freshRandomLib,
        api_lower_alarm_tempWstatus = freshRandomLib,
        api_monitor_mode = freshRandomLib,
        api_upper_alarm_tempWstatus = freshRandomLib
      ),
      genReplay = (c: Container, r: GumboXResult.Type) => Some(
        st"""val testVector = isolette.JSON.toMonitorManage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_PS(json).left
            |assert (testComputeCBwLV(testVector) == results)""".render))
    )
  }
}

@record class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Initialize_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Profile_Trait,
  var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testInitialiseCB()
  }
}

@record class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Compute_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Profile_P_Trait,
  var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBV(c.asInstanceOf[Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_P])
  }
}

@record class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_ComputewL_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_Profile_PS_Trait,
  var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBwLV(c.asInstanceOf[Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_PreState_Container_PS])
  }
}
