#include <Heat_Source_impl_heat_source_cpi_heat_controller_api.h>
#include <Heat_Source_impl_heat_source_cpi_heat_controller.h>

static bool apis_initialized = false;
static struct isolette_Devices_Heat_Source_impl_Initialization_Api initialization_api;
static struct isolette_Devices_Heat_Source_impl_Operational_Api operational_api;

static void initialize_apis(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller.c", "", "initialize_apis", 0);

  // Option_6DC84E = Option[isolette.Devices.Heat_Source_impl_Initialization_Api]
  Option_6DC84E_get_(SF (isolette_Devices_Heat_Source_impl_Initialization_Api) &initialization_api, isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_Bridge_c_initialization_api(SF_LAST));
  // Option_7846A4 = Option[isolette.Devices.Heat_Source_impl_Operational_Api]
  Option_7846A4_get_(SF (isolette_Devices_Heat_Source_impl_Operational_Api) &operational_api, isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_Bridge_c_operational_api(SF_LAST));
  apis_initialized = true;
}

// This file was auto-generated.  Do not edit

bool api_get_heat_control__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller(
  STACK_FRAME
  isolette_Isolette_Data_Model_On_Off_Type *value){
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller_api.c", "", "api_get_heat_control__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  // Option_8CD3A4 = Option[isolette.Isolette_Data_Model.On_Off.Type]
  // Some_B170F4 = Some[isolette.Isolette_Data_Model.On_Off.Type]
  DeclNewOption_8CD3A4(t_0);
  isolette_Devices_Heat_Source_impl_Operational_Api_get_heat_control_(
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

void api_put_heat_out__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller(
  STACK_FRAME
  isolette_Isolette_Environment_Heat_Type value) {
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller_api.c", "", "api_put_heat_out__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Devices_Heat_Source_impl_Initialization_Api_put_heat_out_(
    SF
    &initialization_api,
    value);
}

void api_logInfo__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller_api.c", "", "api_logInfo__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Devices_Heat_Source_impl_Initialization_Api_logInfo_(
    SF
    &initialization_api,
    str);
}

void api_logDebug__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller_api.c", "", "api_logDebug__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Devices_Heat_Source_impl_Initialization_Api_logDebug_(
    SF
    &initialization_api,
    str);
}

void api_logError__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller_api.c", "", "api_logError__isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller", 0);

  if(!apis_initialized) { initialize_apis(SF_LAST); }

  isolette_Devices_Heat_Source_impl_Initialization_Api_logError_(
    SF
    &initialization_api,
    str);
}

Unit isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_initialise(
  STACK_FRAME
  isolette_Devices_Heat_Source_impl_Initialization_Api api) {
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller_api.c", "", "isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_initialise", 0);

  isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_initialise_(SF_LAST);
}

Unit isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_finalise(
  STACK_FRAME
  isolette_Devices_Heat_Source_impl_Operational_Api api) {
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller_api.c", "", "isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_finalise", 0);

  isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_finalise_(SF_LAST);
}

Unit isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_timeTriggered(
  STACK_FRAME
  isolette_Devices_Heat_Source_impl_Operational_Api api) {
  DeclNewStackFrame(caller, "Heat_Source_impl_heat_source_cpi_heat_controller_api.c", "", "isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_timeTriggered", 0);

  isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_timeTriggered_(SF_LAST);
}
