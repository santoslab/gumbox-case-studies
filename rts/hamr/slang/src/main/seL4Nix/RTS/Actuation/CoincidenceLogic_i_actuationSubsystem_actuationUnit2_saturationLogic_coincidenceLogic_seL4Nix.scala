// #Sireum

// This file was auto-generated.  Do not edit

package RTS.Actuation

import org.sireum._
import art._

@ext object CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_seL4Nix {
  // returns T if seL4's channel1 port is empty, F otherwise 
  def channel1_IsEmpty(): B = $

  // returns result of dequeuing seL4's channel1 port 
  def channel1_Receive(): Option[DataContent] = $

  // returns T if seL4's channel2 port is empty, F otherwise 
  def channel2_IsEmpty(): B = $

  // returns result of dequeuing seL4's channel2 port 
  def channel2_Receive(): Option[DataContent] = $

  // returns T if seL4's channel3 port is empty, F otherwise 
  def channel3_IsEmpty(): B = $

  // returns result of dequeuing seL4's channel3 port 
  def channel3_Receive(): Option[DataContent] = $

  // returns T if seL4's channel4 port is empty, F otherwise 
  def channel4_IsEmpty(): B = $

  // returns result of dequeuing seL4's channel4 port 
  def channel4_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's actuate port
  def actuate_Send(d: DataContent): Unit = $
}
