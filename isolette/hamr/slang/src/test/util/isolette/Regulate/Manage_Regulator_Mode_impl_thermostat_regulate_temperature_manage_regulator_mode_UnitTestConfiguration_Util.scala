// #Sireum

package isolette.Regulate

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

import org.sireum._
import isolette.GumboXUtil.GumboXResult
import isolette.util.{Container, Profile, UnitTestConfigurationBatch}
import isolette.RandomLib
import org.sireum.Random.Impl.Xoshiro256

object Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_UnitTestConfiguration_Util {

  def freshRandomLib: RandomLib = {
    return RandomLib(Random.Gen64Impl(Xoshiro256.create))
  }

  def defaultInitializeConfig: Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Initialize_UnitTestConfiguration = {
    return (Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Initialize_UnitTestConfiguration (
      verbose = F,
      name = "Default_Initialize_Config",
      description = "Default Initialize Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Profile (
        name = "Initialize_Default_Profile", // needed for old framework
        numTests = 100, // needed for old framework
      ),
      genReplay = (c: Container, r: GumboXResult.Type) => None())
    )
  }

  def defaultComputeConfig: Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Compute_UnitTestConfiguration = {
    return (Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Compute_UnitTestConfiguration (
      verbose = F,
      name = "Default_Compute_Config",
      description = "Default Compute Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Profile_P (
        name = "Compute_Default_Profile", // needed for old framework
        numTests = 100, // needed for old framework
        numTestVectorGenRetries = 100, // needed for old framework,
        api_current_tempWstatus = freshRandomLib,
        api_interface_failure = freshRandomLib,
        api_internal_failure = freshRandomLib
      ),
      genReplay = (c: Container, r: GumboXResult.Type) => Some(
        st"""val testVector = isolette.JSON.toRegulateManage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_PreState_Container_P(json).left
            |assert (testComputeCBV(testVector) == results)""".render))
    )
  }

  def defaultComputewLConfig: Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_ComputewL_UnitTestConfiguration = {
    return (Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_ComputewL_UnitTestConfiguration (
      verbose = F,
      name = "Default_ComputewL_Config",
      description = "Default ComputewL Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Profile_PS (
        name = "ComputewL_Default_Profile", // needed for old framework
        numTests = 100, // needed for old framework
        numTestVectorGenRetries = 100, // needed for old framework,
        In_lastRegulatorMode = freshRandomLib,
        api_current_tempWstatus = freshRandomLib,
        api_interface_failure = freshRandomLib,
        api_internal_failure = freshRandomLib
      ),
      genReplay = (c: Container, r: GumboXResult.Type) => Some(
        st"""val testVector = isolette.JSON.toRegulateManage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_PreState_Container_PS(json).left
            |assert (testComputeCBwLV(testVector) == results)""".render))
    )
  }
}

@record class Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Initialize_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: Profile,
  var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testInitialiseCB()
  }
}

@record class Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_Compute_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: Profile,
  var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBV(c.asInstanceOf[Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_PreState_Container_P])
  }
}

@record class Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_ComputewL_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: Profile,
  var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBwLV(c.asInstanceOf[Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_PreState_Container_PS])
  }
}
