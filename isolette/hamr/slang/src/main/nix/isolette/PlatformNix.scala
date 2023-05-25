// #Sireum
package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object PlatformNix {

  var seed: Z = 0
  var ids: IS[Art.PortId, Z] = IS()

  def initialise(seed: Z, portOpt: Option[Art.PortId]): Unit = {
    PlatformNix.seed = seed
    portOpt match {
      case Some(port) =>
        val id = seed + port.toZ
        SharedMemory.create(id)
        ids = ids :+ id
      case _ =>
    }
  }

  def receive(portOpt: Option[Art.PortId], out: MBox2[Art.PortId, DataContent]): Unit = {
    portOpt match {
      case Some(port) =>
        out.value1 = port
        SharedMemory.receive(seed + port.toZ, out)
      case _ => halt("Unsupported receive operation without port.")
    }
  }

  def send(app: Art.PortId, port: Art.PortId, data: DataContent): Unit = {
    SharedMemory.send(app.toZ, seed + port.toZ, data)
  }

  def sendAsync(app: Art.PortId, port: Art.PortId, data: DataContent): B = {
    val r = SharedMemory.sendAsync(app.toZ, seed + port.toZ, data)
    return r
  }

  def receiveAsync(portOpt: Option[Art.PortId], out: MBox2[Art.PortId, Option[DataContent]]): Unit = {
    portOpt match {
      case Some(port) => SharedMemory.receiveAsync(seed + port.toZ, out)
      case _ => halt("Unsupported receive operation without port.")
    }
  }

  def finalise(): Unit = {
    for (id <- ids) {
      SharedMemory.remove(id)
    }
  }
}
