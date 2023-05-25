// #Sireum

// This file was auto-generated.  Do not edit

package RTS.Actuators

import org.sireum._
import art._

@ext object ActuatorsMockThread_i_actuatorsMock_actuatorsMockThread_seL4Nix {
  // returns T if seL4's tempPressureActuate port is empty, F otherwise 
  def tempPressureActuate_IsEmpty(): B = $

  // returns result of dequeuing seL4's tempPressureActuate port 
  def tempPressureActuate_Receive(): Option[DataContent] = $

  // returns T if seL4's saturationActuate port is empty, F otherwise 
  def saturationActuate_IsEmpty(): B = $

  // returns result of dequeuing seL4's saturationActuate port 
  def saturationActuate_Receive(): Option[DataContent] = $
}
