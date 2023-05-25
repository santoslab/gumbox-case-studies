#include <operator_interface_thread_impl_operator_interface_oip_oit_api.h>
#include <operator_interface_thread_impl_operator_interface_oip_oit.h>

static bool apis_initialized = false;
static struct isolette_Isolette_operator_interface_thread_impl_Initialization_Api initialization_api;
static struct isolette_Isolette_operator_interface_thread_impl_Operational_Api operational_api;

static void initialize_apis(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit.c", "", "initialize_apis", 0);

  // Option_689336 = Option[isolette.Isolette.operator_interface_thread_impl_Initialization_Api]
  Option_689336_get_(SF (isolette_Isolette_operator_interface_thread_impl_Initialization_Api) &initialization_api, isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_Bridge_c_initialization_api(SF_LAST));
  // Option_1F7813 = Option[isolette.Isolette.operator_interface_thread_impl_Operational_Api]
  Option_1F7813_get_(SF (isolette_Isolette_operator_interface_thread_impl_Operational_Api) &operational_api, isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_Bridge_c_operational_api(SF_LAST));
  apis_initialized = true;
}

// This file was auto-generated.  Do not edit

bool api_get_regulator_status__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_Status_Type *value){
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_get_regulator_status__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  // Option_3D6E5E = Option[isolette.Isolette_Data_Model.Status.Type]
  // Some_E2AA69 = Some[isolette.Isolette_Data_Model.Status.Type]
  DeclNewOption_3D6E5E(t_0);
  isolette_Isolette_operator_interface_thread_impl_Operational_Api_get_regulator_status_(
    SF
    (Option_3D6E5E) &t_0,
    &operational_api);

  if(t_0.type == TSome_E2AA69){
    *value = t_0.Some_E2AA69.value;
    return true;
  } else {
    return false;
  }
}

bool api_get_monitor_status__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_Status_Type *value){
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_get_monitor_status__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  // Option_3D6E5E = Option[isolette.Isolette_Data_Model.Status.Type]
  // Some_E2AA69 = Some[isolette.Isolette_Data_Model.Status.Type]
  DeclNewOption_3D6E5E(t_0);
  isolette_Isolette_operator_interface_thread_impl_Operational_Api_get_monitor_status_(
    SF
    (Option_3D6E5E) &t_0,
    &operational_api);

  if(t_0.type == TSome_E2AA69){
    *value = t_0.Some_E2AA69.value;
    return true;
  } else {
    return false;
  }
}

bool api_get_display_temperature__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_Temp_impl value){
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_get_display_temperature__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  // Option_0893BB = Option[isolette.Isolette_Data_Model.Temp_impl]
  // Some_78BA16 = Some[isolette.Isolette_Data_Model.Temp_impl]
  DeclNewOption_0893BB(t_0);
  isolette_Isolette_operator_interface_thread_impl_Operational_Api_get_display_temperature_(
    SF
    (Option_0893BB) &t_0,
    &operational_api);

  if(t_0.type == TSome_78BA16){
    Type_assign(value, &t_0.Some_78BA16.value, sizeof(struct isolette_Isolette_Data_Model_Temp_impl));
    return true;
  } else {
    return false;
  }
}

bool api_get_alarm_control__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_On_Off_Type *value){
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_get_alarm_control__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  // Option_8CD3A4 = Option[isolette.Isolette_Data_Model.On_Off.Type]
  // Some_B170F4 = Some[isolette.Isolette_Data_Model.On_Off.Type]
  DeclNewOption_8CD3A4(t_0);
  isolette_Isolette_operator_interface_thread_impl_Operational_Api_get_alarm_control_(
    SF
    (Option_8CD3A4) &t_0,
    &operational_api);

  if(t_0.type == TSome_B170F4){
    *value = t_0.Some_B170F4.value;
    return true;
  } else {
    return false;
  }
}

void api_put_lower_desired_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_TempWstatus_impl value) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_put_lower_desired_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Isolette_operator_interface_thread_impl_Initialization_Api_put_lower_desired_tempWstatus_(
    SF
    &initialization_api,
    value);
}

void api_put_upper_desired_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_TempWstatus_impl value) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_put_upper_desired_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Isolette_operator_interface_thread_impl_Initialization_Api_put_upper_desired_tempWstatus_(
    SF
    &initialization_api,
    value);
}

void api_put_lower_alarm_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_TempWstatus_impl value) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_put_lower_alarm_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Isolette_operator_interface_thread_impl_Initialization_Api_put_lower_alarm_tempWstatus_(
    SF
    &initialization_api,
    value);
}

void api_put_upper_alarm_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  isolette_Isolette_Data_Model_TempWstatus_impl value) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_put_upper_alarm_tempWstatus__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Isolette_operator_interface_thread_impl_Initialization_Api_put_upper_alarm_tempWstatus_(
    SF
    &initialization_api,
    value);
}

void api_logInfo__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_logInfo__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Isolette_operator_interface_thread_impl_Initialization_Api_logInfo_(
    SF
    &initialization_api,
    str);
}

void api_logDebug__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_logDebug__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Isolette_operator_interface_thread_impl_Initialization_Api_logDebug_(
    SF
    &initialization_api,
    str);
}

void api_logError__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "api_logError__isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Isolette_operator_interface_thread_impl_Initialization_Api_logError_(
    SF
    &initialization_api,
    str);
}

Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_initialise(
  STACK_FRAME
  isolette_Isolette_operator_interface_thread_impl_Initialization_Api api) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_initialise", 0);

  isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_initialise_(SF_LAST);
}

Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_finalise(
  STACK_FRAME
  isolette_Isolette_operator_interface_thread_impl_Operational_Api api) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_finalise", 0);

  isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_finalise_(SF_LAST);
}

Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_timeTriggered(
  STACK_FRAME
  isolette_Isolette_operator_interface_thread_impl_Operational_Api api) {
  DeclNewStackFrame(caller, "operator_interface_thread_impl_operator_interface_oip_oit_api.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_timeTriggered", 0);

  isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_timeTriggered_(SF_LAST);
}
