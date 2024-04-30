// #Sireum

package tc.CoolingFan

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

import org.sireum._
import tc.GumboXUtil.GumboXResult
import tc.util.{Container, Profile, UnitTestConfigurationBatch}
import tc.RandomLib
import org.sireum.Random.Impl.Xoshiro256

object FanPeriodic_p_tcproc_fan_UnitTestConfiguration_Util {

  def freshRandomLib: RandomLib = {
    return RandomLib(Random.Gen64Impl(Xoshiro256.create))
  }

  val tq: String = "\"\"\""

  type DefaultComputeProfile = FanPeriodic_p_tcproc_fan_Profile_P

  def defaultComputeConfig: FanPeriodic_p_tcproc_fan_Compute_UnitTestConfiguration = {
    return (FanPeriodic_p_tcproc_fan_Compute_UnitTestConfiguration (
      verbose = F,
      name = "Default_Compute_Config",
      description = "Default Compute Configuration",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,
      profile = FanPeriodic_p_tcproc_fan_Profile_P (
        name = "Compute_Default_Profile",
        api_fanCmd = freshRandomLib
      ),
      genReplay = (c: Container, testName: String, r: GumboXResult.Type) => Some(
       st"""Replay Unit Test:
            |  test("Replay: $testName") {
            |    val results = tc.GumboXUtil.GumboXResult.$r
            |    val json = st${tq}${tc.JSON.fromutilContainer(c, T)}${tq}.render
            |    val testVector = tc.JSON.toCoolingFanFanPeriodic_p_tcproc_fan_PreState_Container_P(json).left
            |    assert (testComputeCBV(testVector) == results)
            |  }""".render))
    )
  }
}

@record class FanPeriodic_p_tcproc_fan_Compute_UnitTestConfiguration (
  var verbose: B,
  var name: String,
  var description: String,
  var numTests: Z,
  var numTestVectorGenRetries: Z,
  var failOnUnsatPreconditions: B,
  var profile: FanPeriodic_p_tcproc_fan_Profile_P_Trait,
  var genReplay: (Container, String, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with FanPeriodic_p_tcproc_fan_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBV(c.asInstanceOf[FanPeriodic_p_tcproc_fan_PreState_Container])
  }
}
