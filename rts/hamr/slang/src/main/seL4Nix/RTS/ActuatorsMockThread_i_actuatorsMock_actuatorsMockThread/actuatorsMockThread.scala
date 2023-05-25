// #Sireum

// This file was auto-generated.  Do not edit

package RTS.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread

import org.sireum._
import art._
import art.Art.BridgeId._
import art.Art.PortId._
import art.DispatchPropertyProtocol._
import art.PortMode._
import RTS._
import RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_seL4Nix

object actuatorsMockThread extends App {

  val actuatorsMockThreadBridge : RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge = {
    val tempPressureActuate = Port[Base_Types.Boolean] (id = portId"0", name = "RTS_i_Instance_actuatorsMock_actuatorsMockThread_tempPressureActuate", mode = DataIn)
    val saturationActuate = Port[Base_Types.Boolean] (id = portId"1", name = "RTS_i_Instance_actuatorsMock_actuatorsMockThread_saturationActuate", mode = DataIn)

    RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge(
      id = bridgeId"0",
      name = "RTS_i_Instance_actuatorsMock_actuatorsMockThread",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      tempPressureActuate = tempPressureActuate,
      saturationActuate = saturationActuate
    )
  }

  val entryPoints: Bridge.EntryPoints = actuatorsMockThreadBridge.entryPoints
  val noData: Option[DataContent] = None()

  // tempPressureActuate: In DataPort Base_Types.Boolean
  val tempPressureActuate_id: Art.PortId = actuatorsMockThreadBridge.tempPressureActuate.id
  var tempPressureActuate_port: Option[DataContent] = noData

  // saturationActuate: In DataPort Base_Types.Boolean
  val saturationActuate_id: Art.PortId = actuatorsMockThreadBridge.saturationActuate.id
  var saturationActuate_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == tempPressureActuate_id) {
      return tempPressureActuate_port
    } else if(portId == saturationActuate_id) {
      return saturationActuate_port
    } else {
      halt(s"Unexpected: actuatorsMockThread.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    tempPressureActuate_port = ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_seL4Nix.tempPressureActuate_Receive()

    saturationActuate_port = ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_seL4Nix.saturationActuate_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    halt(s"Unexpected: actuatorsMockThread.putValue called with: ${portId}")
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params


  }

  def initialiseArchitecture(): Unit = {
    // nothing to do - CAmkES is responsible for initialization
  }

  def initialiseEntryPoint(): Unit = { entryPoints.initialise() }

  def computeEntryPoint(): Unit = { entryPoints.compute() }

  def finaliseEntryPoint(): Unit = { entryPoints.finalise() }

  def main(args: ISZ[String]): Z = {

    // need to touch the following for transpiler
    initialiseArchitecture()
    initialiseEntryPoint()
    computeEntryPoint()
    finaliseEntryPoint()

    touch()

    return 0
  }

  def touch(): Unit = {
    if(F) {
      TranspilerToucher.touch()

      // add types used in Platform.receive and Platform.receiveAsync
      val mbox2Boolean_Payload: MBox2[Art.PortId, DataContent] = MBox2(portId"0", Base_Types.Boolean_Payload(T))
      val mbox2OptionDataContent: MBox2[Art.PortId, Option[DataContent]] = MBox2(portId"0", None())

      // touch each payload/type in case some are only used as a field in a record
      def printDataContent(a: art.DataContent): Unit = { println(s"${a}") }

      printDataContent(Base_Types.Boolean_Payload(Base_Types.Boolean_example()))
      printDataContent(Base_Types.Integer_Payload(Base_Types.Integer_example()))
      printDataContent(Base_Types.Integer_8_Payload(Base_Types.Integer_8_example()))
      printDataContent(Base_Types.Integer_16_Payload(Base_Types.Integer_16_example()))
      printDataContent(Base_Types.Integer_32_Payload(Base_Types.Integer_32_example()))
      printDataContent(Base_Types.Integer_64_Payload(Base_Types.Integer_64_example()))
      printDataContent(Base_Types.Unsigned_8_Payload(Base_Types.Unsigned_8_example()))
      printDataContent(Base_Types.Unsigned_16_Payload(Base_Types.Unsigned_16_example()))
      printDataContent(Base_Types.Unsigned_32_Payload(Base_Types.Unsigned_32_example()))
      printDataContent(Base_Types.Unsigned_64_Payload(Base_Types.Unsigned_64_example()))
      printDataContent(Base_Types.Float_Payload(Base_Types.Float_example()))
      printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_example()))
      printDataContent(Base_Types.Float_64_Payload(Base_Types.Float_64_example()))
      printDataContent(Base_Types.Character_Payload(Base_Types.Character_example()))
      printDataContent(Base_Types.String_Payload(Base_Types.String_example()))
      printDataContent(art.Empty())

      RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge.c_initialization_api.get.logInfo("")
      RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge.c_initialization_api.get.logDebug("")
      RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge.c_initialization_api.get.logError("")
      RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge.c_operational_api.get.logInfo("")
      RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge.c_operational_api.get.logDebug("")
      RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge.c_operational_api.get.logError("")
      val apiUsage_tempPressureActuate: Option[Base_Types.Boolean] = RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge.c_operational_api.get.get_tempPressureActuate()
      val apiUsage_saturationActuate: Option[Base_Types.Boolean] = RTS.Actuators.ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_Bridge.c_operational_api.get.get_saturationActuate()
    }
  }

  def logInfo(title: String, msg: String): Unit = {
    print(actuatorsMockThreadBridge.name)
    print(": ")
    println(msg)
  }

  def logError(title: String, msg: String): Unit = {
    eprint(actuatorsMockThreadBridge.name)
    eprint(": ")
    eprintln(msg)
  }

  def logDebug(title: String, msg: String): Unit = {
    print(actuatorsMockThreadBridge.name)
    print(": ")
    println(msg)
  }

  def run(): Unit = {}

}
