// #Sireum

package RTS

import org.sireum._
import art._
import art.Art.PortId._
import art.scheduling.nop.NopScheduler

// This file was auto-generated.  Do not edit

object InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.entryPoints
  val appPortId: Art.PortId = IPCPorts.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)

  // incoming ports

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)

    Art.run(Arch.ad, NopScheduler())
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {

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

    println("InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_App starting ...")

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

      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.logInfo("")
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.logDebug("")
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.logError("")
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.logInfo("")
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.logDebug("")
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.logError("")
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_temperatureLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_temperatureLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_temperatureLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_temperatureLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_temperatureLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_temperatureLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_temperatureLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_temperatureLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_pressureLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_pressureLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_pressureLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_pressureLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_pressureLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_pressureLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_pressureLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_pressureLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_saturationLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_saturationLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_saturationLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_saturationLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_saturationLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_saturationLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit1_saturationLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit1_saturationLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_temperatureLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_temperatureLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_temperatureLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_temperatureLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_temperatureLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_temperatureLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_temperatureLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_temperatureLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_pressureLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_pressureLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_pressureLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_pressureLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_pressureLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_pressureLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_pressureLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_pressureLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_saturationLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_saturationLogic_channel1(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_saturationLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_saturationLogic_channel2(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_saturationLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_saturationLogic_channel3(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_initialization_api.get.put_unit2_saturationLogic_channel4(Base_Types.Boolean_example())
      RTS.Instrumentation.InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_Bridge.c_operational_api.get.put_unit2_saturationLogic_channel4(Base_Types.Boolean_example())
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