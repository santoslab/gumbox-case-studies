// This file will be regenerated, do not edit

#include <sb_EventControlMockThread_i.h>
#include <EventControlMockThread_i_eventControlMock_eventControlMockThread_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_manualActuatorInput2_seqNum;

seqNum_t sb_manualActuatorInput1_seqNum;

bool sb_manualActuatorInput1_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_manualActuatorInput1, value, &sb_manualActuatorInput1_seqNum);
}

bool sb_manualActuatorInput2_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_manualActuatorInput2, value, &sb_manualActuatorInput2_seqNum);
}

// send manualActuatorInput1: Out DataPort bool
Unit RTS_EventControl_EventControlMockThread_i_eventControlMock_eventControlMockThread_seL4Nix_manualActuatorInput1_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_EventControlMockThread_i.c", "", "RTS_EventControl_EventControlMockThread_i_eventControlMock_eventControlMockThread_seL4Nix_manualActuatorInput1_Send", 0);

  sb_manualActuatorInput1_write(d);
}

// send manualActuatorInput2: Out DataPort bool
Unit RTS_EventControl_EventControlMockThread_i_eventControlMock_eventControlMockThread_seL4Nix_manualActuatorInput2_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_EventControlMockThread_i.c", "", "RTS_EventControl_EventControlMockThread_i_eventControlMock_eventControlMockThread_seL4Nix_manualActuatorInput2_Send", 0);

  sb_manualActuatorInput2_write(d);
}

void pre_init(void) {
  DeclNewStackFrame(NULL, "sb_EventControlMockThread_i.c", "", "pre_init", 0);

  printf("Entering pre-init of EventControlMockThread_i_eventControlMock_eventControlMockThread\n");

  // initialise data structure for data port manualActuatorInput1
  init_sp_union_art_DataContent(sb_manualActuatorInput1, &sb_manualActuatorInput1_seqNum);

  // initialise data structure for data port manualActuatorInput2
  init_sp_union_art_DataContent(sb_manualActuatorInput2, &sb_manualActuatorInput2_seqNum);

  // initialise slang-embedded components/ports
  RTS_EventControl_EventControlMockThread_i_eventControlMock_eventControlMockThread_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  RTS_EventControl_EventControlMockThread_i_eventControlMock_eventControlMockThread_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of EventControlMockThread_i_eventControlMock_eventControlMockThread\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_EventControlMockThread_i.c", "", "run", 0);

  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    RTS_EventControl_EventControlMockThread_i_eventControlMock_eventControlMockThread_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
