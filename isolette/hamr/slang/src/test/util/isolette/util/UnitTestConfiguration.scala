// #Sireum
package isolette.util

import org.sireum._
import isolette.Container
import isolette.GumboXUtil.GumboXResult

@msig trait UnitTestConfiguration {
  def name: String
  def description: String
  def profile: Profile
  def test(c: Container): GumboXResult.Type
  def genReplay: (Container, GumboXResult.Type) => Option[String]
  def verbose: B
}

@msig trait UnitTestConfigurationBatch extends UnitTestConfiguration {
  def numTests: Z
  def numTestVectorGenRetries: Z
  def failOnUnsatPreconditions: B
}

@msig trait Profile {
  def next: Container
}
