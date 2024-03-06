package isolette.Regulate

import org.sireum._
import isolette.GumboXUtil.GumboXResult
import isolette.Container
import isolette.util.UnitTestConfiguration

object MHS_DSC_Tests extends App {
  def main(args: ISZ[String]): Z = {
    val instance = new MHS_DSC_Tests()
    /*
    val c = instance.next()
    val r = instance.test(c)
    println(s"$c => $r")
    */
    println(instance.configsToJson)
    return 0
  }
}

class MHS_DSC_Tests extends MHS_GumboX_Tests
  with Random.Gen.TestRunner[Container]{

  override def next(): Container = {
    return getConfig().profile.next
  }

  override def toCompactJson(o: Container): String = {
    return isolette.JSON.from_artDataContent(o, T)
  }

  override def fromJson(json: String): Container = {
    isolette.JSON.to_artDataContent(json) match {
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
