// This file will be regenerated, do not edit

#include <sb_Actuator_i.h>
#include <Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_output_seqNum;

seqNum_t sb_manualActuatorInput_seqNum;

seqNum_t sb_input_seqNum;

/*****************************************************************
 * sb_input_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_input_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_input);
}

bool sb_input_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_input, value, &new_seqNum) ) {
    sb_input_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  }
}

/*****************************************************************
 * sb_manualActuatorInput_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_manualActuatorInput_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_manualActuatorInput);
}

bool sb_manualActuatorInput_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_manualActuatorInput, value, &new_seqNum) ) {
    sb_manualActuatorInput_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  }
}

bool sb_output_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_output, value, &sb_output_seqNum);
}

// send output: Out DataPort bool
Unit RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix_output_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Actuator_i.c", "", "RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix_output_Send", 0);

  sb_output_write(d);
}

// is_empty input: In DataPort
B RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix_input_IsEmpty(STACK_FRAME_ONLY) {
  return sb_input_is_empty();
}

// receive input: In DataPort union_art_DataContent
Unit RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix_input_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Actuator_i.c", "", "RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix_input_Receive", 0);

  union_art_DataContent val;
  if(sb_input_read((union_art_DataContent *) &val)) {
    // wrap payload in Some and place in result
    DeclNewSome_D29615(some);
    Some_D29615_apply(SF &some, (art_DataContent) &val);
    Type_assign(result, &some, sizeof(union Option_8E9F45));
  } else {
    // put None in result
    DeclNewNone_964667(none);
    Type_assign(result, &none, sizeof(union Option_8E9F45));
  }
}


// is_empty manualActuatorInput: In DataPort
B RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix_manualActuatorInput_IsEmpty(STACK_FRAME_ONLY) {
  return sb_manualActuatorInput_is_empty();
}

// receive manualActuatorInput: In DataPort union_art_DataContent
Unit RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix_manualActuatorInput_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Actuator_i.c", "", "RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_seL4Nix_manualActuatorInput_Receive", 0);

  union_art_DataContent val;
  if(sb_manualActuatorInput_read((union_art_DataContent *) &val)) {
    // wrap payload in Some and place in result
    DeclNewSome_D29615(some);
    Some_D29615_apply(SF &some, (art_DataContent) &val);
    Type_assign(result, &some, sizeof(union Option_8E9F45));
  } else {
    // put None in result
    DeclNewNone_964667(none);
    Type_assign(result, &none, sizeof(union Option_8E9F45));
  }
}


void pre_init(void) {
  DeclNewStackFrame(NULL, "sb_Actuator_i.c", "", "pre_init", 0);

  printf("Entering pre-init of Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator\n");

  // initialise data structure for data port output
  init_sp_union_art_DataContent(sb_output, &sb_output_seqNum);

  // initialise slang-embedded components/ports
  RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_Actuator_i.c", "", "run", 0);

  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    RTS_Actuation_Actuator_i_actuationSubsystem_tempPressureActuatorUnit_tempPressureActuator_actuator_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
