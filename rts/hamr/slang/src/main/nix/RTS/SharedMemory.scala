// #Sireum

package RTS

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

@ext object SharedMemory {
  def create(id: Z): Z = $
  def get(id: Z): Z = $
  def send(appId: Z, portId: Z, d: DataContent): Unit = $
  def sendAsync(appId: Z, portId: Z, d: DataContent): B = $
  def receive(portId: Z, out: MBox2[Art.PortId, DataContent]): Unit = $
  def receiveAsync(portId: Z, out: MBox2[Art.PortId, Option[DataContent]]): Unit = $
  def remove(id: Z): Unit = $
}