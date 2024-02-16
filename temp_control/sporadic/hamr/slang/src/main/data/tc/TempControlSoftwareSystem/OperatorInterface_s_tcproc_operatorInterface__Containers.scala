// #Sireum

package tc.TempControlSoftwareSystem

import org.sireum._
import tc._

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

// containers for the pre and post state values of ports and state variables

@sig trait OperatorInterface_s_tcproc_operatorInterface_PreState_Container extends art.DataContent {
  def api_tempChanged: Option[art.Empty]
  def api_currentTemp: TempSensor.Temperature_i
}

// container for incoming ports
@datatype class OperatorInterface_s_tcproc_operatorInterface_PreState_Container_P (
  val api_tempChanged: Option[art.Empty],
  val api_currentTemp: TempSensor.Temperature_i) extends OperatorInterface_s_tcproc_operatorInterface_PreState_Container

// container for incoming ports and state variables
@datatype class OperatorInterface_s_tcproc_operatorInterface_PreState_Container_PS (
  val api_tempChanged: Option[art.Empty],
  val api_currentTemp: TempSensor.Temperature_i) extends OperatorInterface_s_tcproc_operatorInterface_PreState_Container

@sig trait OperatorInterface_s_tcproc_operatorInterface_PostState_Container extends art.DataContent {
  def api_setPoint: Option[TempControlSoftwareSystem.SetPoint_i]
}

// container for outgoing ports
@datatype class OperatorInterface_s_tcproc_operatorInterface_PostState_Container_P (
  val api_setPoint: Option[TempControlSoftwareSystem.SetPoint_i]) extends OperatorInterface_s_tcproc_operatorInterface_PostState_Container

// container for outgoing ports and state variables
@datatype class OperatorInterface_s_tcproc_operatorInterface_PostState_Container_PS (
  val api_setPoint: Option[TempControlSoftwareSystem.SetPoint_i]) extends OperatorInterface_s_tcproc_operatorInterface_PostState_Container
