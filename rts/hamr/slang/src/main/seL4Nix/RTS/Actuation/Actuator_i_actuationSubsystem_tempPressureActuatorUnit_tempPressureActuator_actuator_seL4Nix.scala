// #Sireum

// This file was auto-generated.  Do not edit

package RTS.Actuation

import org.sireum._
import art._

@ext object Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix {
  // returns T if seL4's input port is empty, F otherwise 
  def input_IsEmpty(): B = $

  // returns result of dequeuing seL4's input port 
  def input_Receive(): Option[DataContent] = $

  // returns T if seL4's manualActuatorInput port is empty, F otherwise 
  def manualActuatorInput_IsEmpty(): B = $

  // returns result of dequeuing seL4's manualActuatorInput port 
  def manualActuatorInput_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's output port
  def output_Send(d: DataContent): Unit = $
}
