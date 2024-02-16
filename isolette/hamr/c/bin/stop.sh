#!/usr/bin/env bash
#
# Do not edit this file as it will be overwritten if HAMR codegen is rerun
#
APPS="Demo Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_App Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_App Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_App Detect_Regulator_Failure_impl_thermostat_regulate_temperature_detect_regulator_failure_App Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_App Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_App Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_App Detect_Monitor_Failure_impl_thermostat_monitor_temperature_detect_monitor_failure_App operator_interface_thread_impl_operator_interface_oip_oit_App Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_App Heat_Source_impl_heat_source_cpi_heat_controller_App"
for APP in ${APPS}; do
  pkill -SIGTERM -f $APP
done
ME=`whoami`

# message queue
IPCS_Q=`ipcs -q | egrep "[0-9a-f]+[0-9]+" | grep $ME | awk '{print $2}'`
for id in $IPCS_Q; do
  ipcrm -q $id;
done

# shared memory
IPCS_Q=`ipcs -m | egrep "[0-9a-f]+[0-9]+" | grep $ME | awk '{print $2}'`
for id in $IPCS_Q; do
  ipcrm -m $id;
done

# semaphores
IPCS_Q=`ipcs -s | egrep "[0-9a-f]+[0-9]+" | grep $ME | awk '{print $2}'`
for id in $IPCS_Q; do
  ipcrm -s $id;
done
