package isolette.Monitor

import org.sireum._
import isolette.GumboXUtil.GumboXResult
import isolette.util.Container
import isolette.util.UnitTestConfiguration

// Do not edit this file as it will be overwritten if HAMR codegen is rerun

object Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_DSC_UnitTests extends App {
  def main(args: ISZ[String]): Z = {
    val instance = new Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_DSC_UnitTests()
    /*
    val c = instance.next()
    val r = instance.test(c)
    println(s"$c => $r")
    */
    println(instance.configsToJson)

    val p = Os.path(implicitly[sourcecode.File].value)
    val out = p.up / s".${p.name}.json"
    out.writeOver(instance.configsToJson)

    return 0
  }
}

class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_DSC_UnitTests extends Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_GumboX_UnitTests
  with Random.Gen.TestRunner[Container] {

  override def next(): Container = {
    return getConfig().profile.next
  }

  override def toCompactJson(o: Container): String = {
    return isolette.JSON.fromutilContainer(o, T)
  }

  override def fromJson(json: String): Container = {
    isolette.JSON.toutilContainer(json) match {
      case Either.Left(o) => return o.asInstanceOf[Container]
      case Either.Right(msg) => halt(msg.string)
    }
  }

  override def test(o: Container): B = {
    BeforeEntrypoint()
    val r: B = getConfig().test(o) match {
      case GumboXResult.Pre_Condition_Unsat =>
        isolette.DSC_RecordUnsatPre.report(toCompactJson(o))
        T
      case GumboXResult.Post_Condition_Fail => F
      case GumboXResult.Post_Condition_Pass => T
    }
    AfterEntrypoint()
    return r
  }

  def getConfig(): UnitTestConfiguration = {
    Os.env("DSC_CONFIG_NAME") match {
      case Some(n) =>
        return ops.MSZOps(this.configs).filter(p => p.name == n)(0)
      case _ =>
        Os.prop("DSC_CONFIG_NAME") match {
          case Some(n) => return ops.MSZOps(this.configs).filter(p => p.name == n)(0)
          case _ => halt("DSC_CONFIG_NAME environmental variable not set")
        }
    }
  }
}
