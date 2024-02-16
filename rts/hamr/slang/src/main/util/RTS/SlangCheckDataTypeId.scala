// #Sireum

package RTS

import org.sireum._
import org.sireum.Random.Gen64

/*
GENERATED FROM

Base_Types.scala

CoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic__Containers.scala

CoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic__Containers.scala

CoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic__Containers.scala

OrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic__Containers.scala

CoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic__Containers.scala

CoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic__Containers.scala

CoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic__Containers.scala

OrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic__Containers.scala

OrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic__Containers.scala

Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator__Containers.scala

OrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic__Containers.scala

Actuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator__Containers.scala

DataContent.scala

Aux_Types.scala

*/

@enum object _artDataContent_DataTypeId {
   "ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PostState_Container_P_Id"
   "ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PostState_Container_PS_Id"
   "ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PreState_Container_P_Id"
   "ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PreState_Container_PS_Id"
   "ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PostState_Container_P_Id"
   "ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PostState_Container_PS_Id"
   "ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PreState_Container_P_Id"
   "ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PreState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PostState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PreState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PostState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PreState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PostState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PreState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PostState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PreState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PostState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PreState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PostState_Container_PS_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PreState_Container_PS_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PostState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PostState_Container_PS_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PreState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PreState_Container_PS_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PostState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PostState_Container_PS_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PreState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PreState_Container_PS_Id"
   "ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PostState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PostState_Container_PS_Id"
   "ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PreState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PreState_Container_PS_Id"
   "ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PostState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PostState_Container_PS_Id"
   "ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PreState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PreState_Container_PS_Id"
   "Base_TypesBits_Payload_Id"
   "Base_TypesBoolean_Payload_Id"
   "Base_TypesCharacter_Payload_Id"
   "Base_TypesFloat_32_Payload_Id"
   "Base_TypesFloat_64_Payload_Id"
   "Base_TypesFloat_Payload_Id"
   "Base_TypesInteger_16_Payload_Id"
   "Base_TypesInteger_32_Payload_Id"
   "Base_TypesInteger_64_Payload_Id"
   "Base_TypesInteger_8_Payload_Id"
   "Base_TypesInteger_Payload_Id"
   "Base_TypesString_Payload_Id"
   "Base_TypesUnsigned_16_Payload_Id"
   "Base_TypesUnsigned_32_Payload_Id"
   "Base_TypesUnsigned_64_Payload_Id"
   "Base_TypesUnsigned_8_Payload_Id"
   "_artEmpty_Id"
}

@enum object ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PreState_Container_DataTypeId {
   "ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PreState_Container_P_Id"
   "ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PreState_Container_PS_Id"
}

@enum object ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PostState_Container_DataTypeId {
   "ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PostState_Container_P_Id"
   "ActuationActuator_i_actuationSubsystem_saturationActuatorUnit_saturationActuator_actuator_PostState_Container_PS_Id"
}

@enum object ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PreState_Container_DataTypeId {
   "ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PreState_Container_P_Id"
   "ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PreState_Container_PS_Id"
}

@enum object ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PostState_Container_DataTypeId {
   "ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PostState_Container_P_Id"
   "ActuationActuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_PostState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PreState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PreState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PostState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_pressureLogic_coincidenceLogic_PostState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PreState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PreState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PostState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_saturationLogic_coincidenceLogic_PostState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PreState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PreState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PostState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit1_temperatureLogic_coincidenceLogic_PostState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PreState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PreState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PostState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_pressureLogic_coincidenceLogic_PostState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PreState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PreState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PostState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_saturationLogic_coincidenceLogic_PostState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PreState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PreState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PreState_Container_PS_Id"
}

@enum object ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PostState_Container_DataTypeId {
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PostState_Container_P_Id"
   "ActuationCoincidenceLogic_i_actuationSubsystem_actuationUnit2_temperatureLogic_coincidenceLogic_PostState_Container_PS_Id"
}

@enum object ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PreState_Container_DataTypeId {
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PreState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PreState_Container_PS_Id"
}

@enum object ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PostState_Container_DataTypeId {
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PostState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit1_tempPressureTripOut_orLogic_PostState_Container_PS_Id"
}

@enum object ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PreState_Container_DataTypeId {
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PreState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PreState_Container_PS_Id"
}

@enum object ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PostState_Container_DataTypeId {
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PostState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_actuationUnit2_tempPressureTripOut_orLogic_PostState_Container_PS_Id"
}

@enum object ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PreState_Container_DataTypeId {
   "ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PreState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PreState_Container_PS_Id"
}

@enum object ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PostState_Container_DataTypeId {
   "ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PostState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_saturationActuatorUnit_actuateSaturationActuator_orLogic_PostState_Container_PS_Id"
}

@enum object ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PreState_Container_DataTypeId {
   "ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PreState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PreState_Container_PS_Id"
}

@enum object ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PostState_Container_DataTypeId {
   "ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PostState_Container_P_Id"
   "ActuationOrLogic_i_actuationSubsystem_tempPressureActuatorUnit_actuateTempPressureActuator_orLogic_PostState_Container_PS_Id"
}
