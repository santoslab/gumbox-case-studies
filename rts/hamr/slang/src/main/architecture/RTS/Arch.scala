// #Sireum

package RTS

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._
import art.Art.BridgeId._
import art.Art.PortId._

// This file was auto-generated.  Do not edit

object Arch {
  val RTS_i_Instance_instrumentationMock_instrumentationMockThread : RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge = {
    val unit1_temperatureLogic_channel1 = Port[Base_Types.Boolean] (id = portId"0", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_temperatureLogic_channel1", mode = DataOut)
    val unit1_temperatureLogic_channel2 = Port[Base_Types.Boolean] (id = portId"1", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_temperatureLogic_channel2", mode = DataOut)
    val unit1_temperatureLogic_channel3 = Port[Base_Types.Boolean] (id = portId"2", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_temperatureLogic_channel3", mode = DataOut)
    val unit1_temperatureLogic_channel4 = Port[Base_Types.Boolean] (id = portId"3", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_temperatureLogic_channel4", mode = DataOut)
    val unit1_pressureLogic_channel1 = Port[Base_Types.Boolean] (id = portId"4", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_pressureLogic_channel1", mode = DataOut)
    val unit1_pressureLogic_channel2 = Port[Base_Types.Boolean] (id = portId"5", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_pressureLogic_channel2", mode = DataOut)
    val unit1_pressureLogic_channel3 = Port[Base_Types.Boolean] (id = portId"6", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_pressureLogic_channel3", mode = DataOut)
    val unit1_pressureLogic_channel4 = Port[Base_Types.Boolean] (id = portId"7", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_pressureLogic_channel4", mode = DataOut)
    val unit1_saturationLogic_channel1 = Port[Base_Types.Boolean] (id = portId"8", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_saturationLogic_channel1", mode = DataOut)
    val unit1_saturationLogic_channel2 = Port[Base_Types.Boolean] (id = portId"9", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_saturationLogic_channel2", mode = DataOut)
    val unit1_saturationLogic_channel3 = Port[Base_Types.Boolean] (id = portId"10", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_saturationLogic_channel3", mode = DataOut)
    val unit1_saturationLogic_channel4 = Port[Base_Types.Boolean] (id = portId"11", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit1_saturationLogic_channel4", mode = DataOut)
    val unit2_temperatureLogic_channel1 = Port[Base_Types.Boolean] (id = portId"12", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_temperatureLogic_channel1", mode = DataOut)
    val unit2_temperatureLogic_channel2 = Port[Base_Types.Boolean] (id = portId"13", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_temperatureLogic_channel2", mode = DataOut)
    val unit2_temperatureLogic_channel3 = Port[Base_Types.Boolean] (id = portId"14", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_temperatureLogic_channel3", mode = DataOut)
    val unit2_temperatureLogic_channel4 = Port[Base_Types.Boolean] (id = portId"15", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_temperatureLogic_channel4", mode = DataOut)
    val unit2_pressureLogic_channel1 = Port[Base_Types.Boolean] (id = portId"16", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_pressureLogic_channel1", mode = DataOut)
    val unit2_pressureLogic_channel2 = Port[Base_Types.Boolean] (id = portId"17", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_pressureLogic_channel2", mode = DataOut)
    val unit2_pressureLogic_channel3 = Port[Base_Types.Boolean] (id = portId"18", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_pressureLogic_channel3", mode = DataOut)
    val unit2_pressureLogic_channel4 = Port[Base_Types.Boolean] (id = portId"19", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_pressureLogic_channel4", mode = DataOut)
    val unit2_saturationLogic_channel1 = Port[Base_Types.Boolean] (id = portId"20", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_saturationLogic_channel1", mode = DataOut)
    val unit2_saturationLogic_channel2 = Port[Base_Types.Boolean] (id = portId"21", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_saturationLogic_channel2", mode = DataOut)
    val unit2_saturationLogic_channel3 = Port[Base_Types.Boolean] (id = portId"22", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_saturationLogic_channel3", mode = DataOut)
    val unit2_saturationLogic_channel4 = Port[Base_Types.Boolean] (id = portId"23", name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread_unit2_saturationLogic_channel4", mode = DataOut)

    RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge(
      id = bridgeId"0",
      name = "RTS_i_Instance_instrumentationMock_instrumentationMockThread",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      unit1_temperatureLogic_channel1 = unit1_temperatureLogic_channel1,
      unit1_temperatureLogic_channel2 = unit1_temperatureLogic_channel2,
      unit1_temperatureLogic_channel3 = unit1_temperatureLogic_channel3,
      unit1_temperatureLogic_channel4 = unit1_temperatureLogic_channel4,
      unit1_pressureLogic_channel1 = unit1_pressureLogic_channel1,
      unit1_pressureLogic_channel2 = unit1_pressureLogic_channel2,
      unit1_pressureLogic_channel3 = unit1_pressureLogic_channel3,
      unit1_pressureLogic_channel4 = unit1_pressureLogic_channel4,
      unit1_saturationLogic_channel1 = unit1_saturationLogic_channel1,
      unit1_saturationLogic_channel2 = unit1_saturationLogic_channel2,
      unit1_saturationLogic_channel3 = unit1_saturationLogic_channel3,
      unit1_saturationLogic_channel4 = unit1_saturationLogic_channel4,
      unit2_temperatureLogic_channel1 = unit2_temperatureLogic_channel1,
      unit2_temperatureLogic_channel2 = unit2_temperatureLogic_channel2,
      unit2_temperatureLogic_channel3 = unit2_temperatureLogic_channel3,
      unit2_temperatureLogic_channel4 = unit2_temperatureLogic_channel4,
      unit2_pressureLogic_channel1 = unit2_pressureLogic_channel1,
      unit2_pressureLogic_channel2 = unit2_pressureLogic_channel2,
      unit2_pressureLogic_channel3 = unit2_pressureLogic_channel3,
      unit2_pressureLogic_channel4 = unit2_pressureLogic_channel4,
      unit2_saturationLogic_channel1 = unit2_saturationLogic_channel1,
      unit2_saturationLogic_channel2 = unit2_saturationLogic_channel2,
      unit2_saturationLogic_channel3 = unit2_saturationLogic_channel3,
      unit2_saturationLogic_channel4 = unit2_saturationLogic_channel4
    )
  }
  val RTS_i_Instance_eventControlMock_eventControlMockThread : RTS.EventControl.EventControlMockThread_i_eventControlMock_eventControlMockThread_Bridge = {
    val manualActuatorInput1 = Port[Base_Types.Boolean] (id = portId"24", name = "RTS_i_Instance_eventControlMock_eventControlMockThread_manualActuatorInput1", mode = DataOut)
    val manualActuatorInput2 = Port[Base_Types.Boolean] (id = portId"25", name = "RTS_i_Instance_eventControlMock_eventControlMockThread_manualActuatorInput2", mode = DataOut)

    RTS.EventControl.EventControlMockThread_i_eventControlMock_eventControlMockThread_Bridge(
      id = bridgeId"1",
      name = "RTS_i_Instance_eventControlMock_eventControlMockThread",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      manualActuatorInput1 = manualActuatorInput1,
      manualActuatorInput2 = manualActuatorInput2
    )
  }
  val RTS_i_Instance_actuatorsMock_actuatorsMockThread : RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge = {
    val tempPressureActuate = Port[Base_Types.Boolean] (id = portId"26", name = "RTS_i_Instance_actuatorsMock_actuatorsMockThread_tempPressureActuate", mode = DataIn)
    val saturationActuate = Port[Base_Types.Boolean] (id = portId"27", name = "RTS_i_Instance_actuatorsMock_actuatorsMockThread_saturationActuate", mode = DataIn)

    RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge(
      id = bridgeId"2",
      name = "RTS_i_Instance_actuatorsMock_actuatorsMockThread",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      tempPressureActuate = tempPressureActuate,
      saturationActuate = saturationActuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"28", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"29", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_channel2", mode = DataIn)
    val channel3 = Port[Base_Types.Boolean] (id = portId"30", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_channel3", mode = DataIn)
    val channel4 = Port[Base_Types.Boolean] (id = portId"31", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_channel4", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"32", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_Bridge(
      id = bridgeId"3",
      name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      channel3 = channel3,
      channel4 = channel4,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"33", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"34", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_channel2", mode = DataIn)
    val channel3 = Port[Base_Types.Boolean] (id = portId"35", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_channel3", mode = DataIn)
    val channel4 = Port[Base_Types.Boolean] (id = portId"36", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_channel4", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"37", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_Bridge(
      id = bridgeId"4",
      name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      channel3 = channel3,
      channel4 = channel4,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"38", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"39", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_channel2", mode = DataIn)
    val channel3 = Port[Base_Types.Boolean] (id = portId"40", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_channel3", mode = DataIn)
    val channel4 = Port[Base_Types.Boolean] (id = portId"41", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_channel4", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"42", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_Bridge(
      id = bridgeId"5",
      name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      channel3 = channel3,
      channel4 = channel4,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic : RTS.Actuation.OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"43", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"44", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_channel2", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"45", name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_actuate", mode = DataOut)

    RTS.Actuation.OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_Bridge(
      id = bridgeId"6",
      name = "RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"46", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"47", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_channel2", mode = DataIn)
    val channel3 = Port[Base_Types.Boolean] (id = portId"48", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_channel3", mode = DataIn)
    val channel4 = Port[Base_Types.Boolean] (id = portId"49", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_channel4", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"50", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_Bridge(
      id = bridgeId"7",
      name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      channel3 = channel3,
      channel4 = channel4,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"51", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"52", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_channel2", mode = DataIn)
    val channel3 = Port[Base_Types.Boolean] (id = portId"53", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_channel3", mode = DataIn)
    val channel4 = Port[Base_Types.Boolean] (id = portId"54", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_channel4", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"55", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_Bridge(
      id = bridgeId"8",
      name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      channel3 = channel3,
      channel4 = channel4,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic : RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"56", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"57", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_channel2", mode = DataIn)
    val channel3 = Port[Base_Types.Boolean] (id = portId"58", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_channel3", mode = DataIn)
    val channel4 = Port[Base_Types.Boolean] (id = portId"59", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_channel4", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"60", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_actuate", mode = DataOut)

    RTS.Actuation.CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_Bridge(
      id = bridgeId"9",
      name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      channel3 = channel3,
      channel4 = channel4,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic : RTS.Actuation.OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"61", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"62", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_channel2", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"63", name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_actuate", mode = DataOut)

    RTS.Actuation.OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_Bridge(
      id = bridgeId"10",
      name = "RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic : RTS.Actuation.OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"64", name = "RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"65", name = "RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_channel2", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"66", name = "RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_actuate", mode = DataOut)

    RTS.Actuation.OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_Bridge(
      id = bridgeId"11",
      name = "RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator : RTS.Actuation.Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge = {
    val input = Port[Base_Types.Boolean] (id = portId"67", name = "RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_input", mode = DataIn)
    val manualActuatorInput = Port[Base_Types.Boolean] (id = portId"68", name = "RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_manualActuatorInput", mode = DataIn)
    val output = Port[Base_Types.Boolean] (id = portId"69", name = "RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_output", mode = DataOut)

    RTS.Actuation.Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_Bridge(
      id = bridgeId"12",
      name = "RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      input = input,
      manualActuatorInput = manualActuatorInput,
      output = output
    )
  }
  val RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic : RTS.Actuation.OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Bridge = {
    val channel1 = Port[Base_Types.Boolean] (id = portId"70", name = "RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_channel1", mode = DataIn)
    val channel2 = Port[Base_Types.Boolean] (id = portId"71", name = "RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_channel2", mode = DataIn)
    val actuate = Port[Base_Types.Boolean] (id = portId"72", name = "RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_actuate", mode = DataOut)

    RTS.Actuation.OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_Bridge(
      id = bridgeId"13",
      name = "RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      channel1 = channel1,
      channel2 = channel2,
      actuate = actuate
    )
  }
  val RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator : RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge = {
    val input = Port[Base_Types.Boolean] (id = portId"73", name = "RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_input", mode = DataIn)
    val manualActuatorInput = Port[Base_Types.Boolean] (id = portId"74", name = "RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_manualActuatorInput", mode = DataIn)
    val output = Port[Base_Types.Boolean] (id = portId"75", name = "RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_output", mode = DataOut)

    RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge(
      id = bridgeId"14",
      name = "RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      input = input,
      manualActuatorInput = manualActuatorInput,
      output = output
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = IS[Art.BridgeId, Bridge] (RTS_i_Instance_instrumentationMock_instrumentationMockThread, RTS_i_Instance_eventControlMock_eventControlMockThread, RTS_i_Instance_actuatorsMock_actuatorsMockThread, RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic, RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic, RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic, RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic, RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic, RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic, RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic, RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic, RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic, RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator, RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic, RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator),

      connections = IS[Art.ConnectionId, UConnection] (Connection(from = RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.actuate, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.channel1),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.actuate, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.channel2),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.actuate, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.channel1),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.actuate, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.channel2),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.actuate, to = RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.input),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.actuate, to = RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.input),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.actuate, to = RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.channel1),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic.actuate, to = RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.channel1),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.actuate, to = RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic.channel2),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic.actuate, to = RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic.channel2),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_temperatureLogic_channel1, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.channel1),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_temperatureLogic_channel2, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.channel2),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_temperatureLogic_channel3, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.channel3),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_temperatureLogic_channel4, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic.channel4),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_pressureLogic_channel1, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.channel1),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_pressureLogic_channel2, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.channel2),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_pressureLogic_channel3, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.channel3),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_pressureLogic_channel4, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic.channel4),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_saturationLogic_channel1, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.channel1),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_saturationLogic_channel2, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.channel2),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_saturationLogic_channel3, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.channel3),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit1_saturationLogic_channel4, to = RTS_i_Instance_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic.channel4),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_temperatureLogic_channel1, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.channel1),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_temperatureLogic_channel2, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.channel2),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_temperatureLogic_channel3, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.channel3),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_temperatureLogic_channel4, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic.channel4),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_pressureLogic_channel1, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.channel1),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_pressureLogic_channel2, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.channel2),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_pressureLogic_channel3, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.channel3),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_pressureLogic_channel4, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic.channel4),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_saturationLogic_channel1, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.channel1),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_saturationLogic_channel2, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.channel2),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_saturationLogic_channel3, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.channel3),
                                                       Connection(from = RTS_i_Instance_instrumentationMock_instrumentationMockThread.unit2_saturationLogic_channel4, to = RTS_i_Instance_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic.channel4),
                                                       Connection(from = RTS_i_Instance_eventControlMock_eventControlMockThread.manualActuatorInput1, to = RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.manualActuatorInput),
                                                       Connection(from = RTS_i_Instance_eventControlMock_eventControlMockThread.manualActuatorInput2, to = RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.manualActuatorInput),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator.output, to = RTS_i_Instance_actuatorsMock_actuatorsMockThread.tempPressureActuate),
                                                       Connection(from = RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.output, to = RTS_i_Instance_actuatorsMock_actuatorsMockThread.saturationActuate))
    )
  }
}
