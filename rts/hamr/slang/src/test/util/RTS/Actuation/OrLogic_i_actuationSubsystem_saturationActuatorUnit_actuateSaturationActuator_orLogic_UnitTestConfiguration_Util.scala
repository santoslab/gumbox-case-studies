// #Sireum

package RTS.Actuation

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

import org.sireum._
import RTS.GumboXUtil.GumboXResult
import RTS.util.{Container, Profile, UnitTestConfigurationBatch}
import RTS.RandomLib
import org.sireum.Random.Impl.Xoshiro256

object OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_UnitTestConfiguration_Util {

  def freshRandomLib: RandomLib = {
    return RandomLib(Random.Gen64Impl(Xoshiro256.create))
  }

  def defaultComputeConfig: OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Compute_UnitTestConfiguration = {
    return (OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Compute_UnitTestConfiguration (
      verbose = F,
      name = "Default_Compute_Config",
      description = "Default Compute Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Profile_P (
        name = "Compute_Default_Profile", // needed for old framework
        numTests = 100, // needed for old framework
        numTestVectorGenRetries = 100, // needed for old framework,
        api_channel1 = freshRandomLib,
        api_channel2 = freshRandomLib
      ),
      genReplay = (c: Container, r: GumboXResult.Type) => Some(
        st"""val testVector = RTS.JSON.toActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PreState_Container_P(json).left
            |assert (testComputeCBV(testVector) == results)""".render))
    )
  }
}

@record class OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Compute_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Profile_P_Trait,
  var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBV(c.asInstanceOf[OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PreState_Container_P])
  }
}
