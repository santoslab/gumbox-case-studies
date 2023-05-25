// #Sireum

package RTS

import org.sireum._
import art._
import art.Art.PortId._
import art.scheduling.nop.NopScheduler

// This file was auto-generated.  Do not edit

object Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.entryPoints
  val appPortId: Art.PortId = IPCPorts.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)

  // incoming ports
  val inputPortId: Art.PortId = Arch.RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.input.id
  val inputPortIdOpt: Option[Art.PortId] = Some(inputPortId)
  val manualActuatorInputPortId: Art.PortId = Arch.RTS_i_Instance_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator.manualActuatorInput.id
  val manualActuatorInputPortIdOpt: Option[Art.PortId] = Some(manualActuatorInputPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, inputPortIdOpt)
    Platform.initialise(seed, manualActuatorInputPortIdOpt)

    Art.run(Arch.ad, NopScheduler())
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(inputPortIdOpt, out)
      out.value2 match {
        case Some(v: Base_Types.Boolean_Payload) => ArtNix.updateData(inputPortId, v)
        case Some(v) => halt(s"Unexpected payload on port input.  Expecting something of type Base_Types.Boolean_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(manualActuatorInputPortIdOpt, out)
      out.value2 match {
        case Some(v: Base_Types.Boolean_Payload) => ArtNix.updateData(manualActuatorInputPortId, v)
        case Some(v) => halt(s"Unexpected payload on port manualActuatorInput.  Expecting something of type Base_Types.Boolean_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    entryPoints.compute()
    RTS.Process.sleep(1000)
  }

  def finalise(): Unit = {
    entryPoints.finalise()
  }

  def main(args: ISZ[String]): Z = {

    val seed: Z = if (args.size == z"1") {
      val n = Z(args(0)).get
      if (n == z"0") 1 else n
    } else {
      1
    }

    initialiseArchitecture(seed)

    Platform.receive(appPortIdOpt, IPCPorts.emptyReceiveOut) // pause after setting up component

    initialise()

    Platform.receive(appPortIdOpt, IPCPorts.emptyReceiveOut) // pause after component init

    println("Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_App starting ...")

    ArtNix.timeDispatch()

    var terminated = F
    while (!terminated) {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(appPortIdOpt, out)
      if (out.value2.isEmpty) {
        compute()
      } else {
        terminated = T
      }
    }
    exit()

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

      RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_initialization_api.get.logInfo("")
      RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_initialization_api.get.logDebug("")
      RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_initialization_api.get.logError("")
      RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_operational_api.get.logInfo("")
      RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_operational_api.get.logDebug("")
      RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_operational_api.get.logError("")
      val apiUsage_input: Option[Base_Types.Boolean] = RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_operational_api.get.get_input()
      val apiUsage_manualActuatorInput: Option[Base_Types.Boolean] = RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_operational_api.get.get_manualActuatorInput()
      RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_initialization_api.get.put_output(Base_Types.Boolean_example())
      RTS.Actuation.Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_Bridge.c_operational_api.get.put_output(Base_Types.Boolean_example())
    }
  }

  def exit(): Unit = {
    finalise()
    Platform.finalise()
  }

  override def atExit(): Unit = {
    exit()
  }
}