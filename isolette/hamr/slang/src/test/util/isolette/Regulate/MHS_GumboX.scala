// #Sireum
package isolette.Regulate

import org.sireum._
import isolette.GumboXUtil.GumboXResult
import isolette.util.{Profile, UnitTestConfigurationBatch}
import isolette.{Container, RandomLib}
import org.sireum.Random.Impl.Xoshiro256


object GumboXUtils {
  def freshRandomLib: RandomLib = {
    return RandomLib(Random.Gen64Impl(Xoshiro256.create))
  }

  def defaultInitConfig: MHS_InitUnitTestConfiguration = {
    return MHS_InitUnitTestConfiguration(
      verbose = F,
      name = "Default Init Profile",
      description = "Default Init Profile",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,

      profile = Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Profile(
        name = "Default Init Profile",
        numTests = 100
      ),

      genReplay = (c: Container, r: GumboXResult.Type) => None()
    )
  }

  def defaultComputeConfig: MHS_ComputeUnitConfiguration = {
    return MHS_ComputeUnitConfiguration(
      verbose = F,
      name = "Default Compute Config",
      description = "Default Compute Config",
      numTests = 100,
      numTestVectorGenRetries = 100,
      failOnUnsatPreconditions = F,

      profile = Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Profile_P(
        name = "MHS Default_Compute Profile",
        numTests = 10,
        numTestVectorGenRetries = 10,
        api_current_tempWstatus = GumboXUtils.freshRandomLib,
        api_lower_desired_temp = GumboXUtils.freshRandomLib,
        api_regulator_mode = GumboXUtils.freshRandomLib,
        api_upper_desired_temp = GumboXUtils.freshRandomLib
      ),

      genReplay = (c: Container, r: GumboXResult.Type) => {
        val json = isolette.JSON.from_artDataContent(c, T)
        val tq = "\"\"\""
        Some(
          st"""val json = st${tq}${json}${tq}.render
              |val testVector = isolette.JSON.toRegulateManage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_PreState_Container_P(json).left
              |assert (testComputeCBV(testVector) == isolette.GumboXUtil.GumboXResult.$r)""".render)
      }
    )
  }
}

@record class MHS_InitUnitTestConfiguration(var verbose: B,
                                            var name: String,
                                            var description: String,
                                            var numTests: Z,
                                            var numTestVectorGenRetries: Z,
                                            var failOnUnsatPreconditions: B,

                                            var profile: Profile,
                                            var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_GumboX_TestHarness {


  override def test(c: Container): GumboXResult.Type = {
    return testInitialiseCB()
  }
}

@record class MHS_ComputeUnitConfiguration(var verbose: B,
                                           var name: String,
                                           var description: String,
                                           var numTests: Z,
                                           var numTestVectorGenRetries: Z,
                                           var failOnUnsatPreconditions: B,

                                           var profile: Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Profile_P_Trait,
                                           var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBV(c.asInstanceOf[Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_PreState_Container])
  }
}

@record class MHS_ComputeWlUnitConfiguration(var verbose: B,
                                             var name: String,
                                             var description: String,
                                             var numTests: Z,
                                             var numTestVectorGenRetries: Z,
                                             var failOnUnsatPreconditions: B,

                                             var profile: Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_Profile_PS_Trait,
                                             var genReplay: (Container, GumboXResult.Type) => Option[String])
  extends UnitTestConfigurationBatch with Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_GumboX_TestHarness {

  override def test(c: Container): GumboXResult.Type = {
    return testComputeCBV(c.asInstanceOf[Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_PreState_Container])
  }
}