// #Sireum

package isolette

import org.sireum._
import art._
import art.Art.PortId._
import art.scheduling.nop.NopScheduler

// This file was auto-generated.  Do not edit

object Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.entryPoints
  val appPortId: Art.PortId = IPCPorts.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)

  // incoming ports
  val airPortId: Art.PortId = Arch.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.air.id
  val airPortIdOpt: Option[Art.PortId] = Some(airPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, airPortIdOpt)

    Art.run(Arch.ad, NopScheduler())
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(airPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.PhysicalTemp_impl_Payload) => ArtNix.updateData(airPortId, v)
        case Some(v) => halt(s"Unexpected payload on port air.  Expecting something of type Isolette_Data_Model.PhysicalTemp_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    entryPoints.compute()
    isolette.Process.sleep(1000)
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

    println("Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_App starting ...")

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

      printDataContent(Isolette_Environment.Heat_Payload(Isolette_Environment.Heat.byOrdinal(0).get))
      printDataContent(Isolette_Environment.Interface_Interaction_Payload(Isolette_Environment.Interface_Interaction.byOrdinal(0).get))
      printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_example()))
      printDataContent(Isolette_Data_Model.PhysicalTemp_impl_Payload(Isolette_Data_Model.PhysicalTemp_impl.example()))
      printDataContent(Isolette_Data_Model.ValueStatus_Payload(Isolette_Data_Model.ValueStatus.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.TempWstatus_impl_Payload(Isolette_Data_Model.TempWstatus_impl.example()))
      printDataContent(Isolette_Data_Model.On_Off_Payload(Isolette_Data_Model.On_Off.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.Status_Payload(Isolette_Data_Model.Status.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.Temp_impl_Payload(Isolette_Data_Model.Temp_impl.example()))
      printDataContent(Isolette_Data_Model.Regulator_Mode_Payload(Isolette_Data_Model.Regulator_Mode.byOrdinal(0).get))
      printDataContent(Base_Types.Boolean_Payload(Base_Types.Boolean_example()))
      printDataContent(Isolette_Data_Model.Failure_Flag_impl_Payload(Isolette_Data_Model.Failure_Flag_impl.example()))
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
      printDataContent(Base_Types.Float_64_Payload(Base_Types.Float_64_example()))
      printDataContent(Base_Types.Character_Payload(Base_Types.Character_example()))
      printDataContent(Base_Types.String_Payload(Base_Types.String_example()))
      printDataContent(Isolette_Data_Model.Monitor_Mode_Payload(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get))
      printDataContent(art.Empty())

      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logInfo("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logDebug("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logError("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logInfo("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logDebug("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logError("")
      val apiUsage_air: Option[Isolette_Data_Model.PhysicalTemp_impl] = isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.get_air()
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.put_current_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.put_current_tempWstatus(Isolette_Data_Model.TempWstatus_impl.example())
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