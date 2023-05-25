// #Sireum

package RTS.Instrumentation

import org.sireum._
import art.{Art, ArtNative, Empty}
import RTS._

// This file was auto-generated.  Do not edit
@msig trait InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread_TestApi {

  def BeforeEntrypoint(): Unit = {
    Art.initTest(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread)
  }

  def AfterEntrypoint(): Unit = {
    Art.finalizeTest(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread)
  }

  def testCompute(): Unit = {
    Art.manuallyClearOutput()
    Art.testCompute(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread)
  }

  def testInitialise(): Unit = {
    Art.manuallyClearOutput()
    Art.testInitialise(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread)
  }

  /** helper function to check InstrumentationMockThread_i_instrumentationMock_instrumentationMockThread's
   * output ports.  Use named arguments to check subsets of the output ports.
   * @param unit1_temperatureLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'unit1_temperatureLogic_channel1'.
   * @param unit1_temperatureLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'unit1_temperatureLogic_channel2'.
   * @param unit1_temperatureLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'unit1_temperatureLogic_channel3'.
   * @param unit1_temperatureLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'unit1_temperatureLogic_channel4'.
   * @param unit1_pressureLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'unit1_pressureLogic_channel1'.
   * @param unit1_pressureLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'unit1_pressureLogic_channel2'.
   * @param unit1_pressureLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'unit1_pressureLogic_channel3'.
   * @param unit1_pressureLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'unit1_pressureLogic_channel4'.
   * @param unit1_saturationLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'unit1_saturationLogic_channel1'.
   * @param unit1_saturationLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'unit1_saturationLogic_channel2'.
   * @param unit1_saturationLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'unit1_saturationLogic_channel3'.
   * @param unit1_saturationLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'unit1_saturationLogic_channel4'.
   * @param unit2_temperatureLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'unit2_temperatureLogic_channel1'.
   * @param unit2_temperatureLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'unit2_temperatureLogic_channel2'.
   * @param unit2_temperatureLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'unit2_temperatureLogic_channel3'.
   * @param unit2_temperatureLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'unit2_temperatureLogic_channel4'.
   * @param unit2_pressureLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'unit2_pressureLogic_channel1'.
   * @param unit2_pressureLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'unit2_pressureLogic_channel2'.
   * @param unit2_pressureLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'unit2_pressureLogic_channel3'.
   * @param unit2_pressureLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'unit2_pressureLogic_channel4'.
   * @param unit2_saturationLogic_channel1 method that will be called with the value of the outgoing data
   *        port 'unit2_saturationLogic_channel1'.
   * @param unit2_saturationLogic_channel2 method that will be called with the value of the outgoing data
   *        port 'unit2_saturationLogic_channel2'.
   * @param unit2_saturationLogic_channel3 method that will be called with the value of the outgoing data
   *        port 'unit2_saturationLogic_channel3'.
   * @param unit2_saturationLogic_channel4 method that will be called with the value of the outgoing data
   *        port 'unit2_saturationLogic_channel4'.
   */
  def check_concrete_output(unit1_temperatureLogic_channel1: Base_Types.Boolean => B,
                            unit1_temperatureLogic_channel2: Base_Types.Boolean => B,
                            unit1_temperatureLogic_channel3: Base_Types.Boolean => B,
                            unit1_temperatureLogic_channel4: Base_Types.Boolean => B,
                            unit1_pressureLogic_channel1: Base_Types.Boolean => B,
                            unit1_pressureLogic_channel2: Base_Types.Boolean => B,
                            unit1_pressureLogic_channel3: Base_Types.Boolean => B,
                            unit1_pressureLogic_channel4: Base_Types.Boolean => B,
                            unit1_saturationLogic_channel1: Base_Types.Boolean => B,
                            unit1_saturationLogic_channel2: Base_Types.Boolean => B,
                            unit1_saturationLogic_channel3: Base_Types.Boolean => B,
                            unit1_saturationLogic_channel4: Base_Types.Boolean => B,
                            unit2_temperatureLogic_channel1: Base_Types.Boolean => B,
                            unit2_temperatureLogic_channel2: Base_Types.Boolean => B,
                            unit2_temperatureLogic_channel3: Base_Types.Boolean => B,
                            unit2_temperatureLogic_channel4: Base_Types.Boolean => B,
                            unit2_pressureLogic_channel1: Base_Types.Boolean => B,
                            unit2_pressureLogic_channel2: Base_Types.Boolean => B,
                            unit2_pressureLogic_channel3: Base_Types.Boolean => B,
                            unit2_pressureLogic_channel4: Base_Types.Boolean => B,
                            unit2_saturationLogic_channel1: Base_Types.Boolean => B,
                            unit2_saturationLogic_channel2: Base_Types.Boolean => B,
                            unit2_saturationLogic_channel3: Base_Types.Boolean => B,
                            unit2_saturationLogic_channel4: Base_Types.Boolean => B): Unit = {
    var testFailures: ISZ[ST] = ISZ()

    val unit1_temperatureLogic_channel1Value: Base_Types.Boolean = get_unit1_temperatureLogic_channel1().get
    if(!unit1_temperatureLogic_channel1(unit1_temperatureLogic_channel1Value)) {
      testFailures = testFailures :+ st"'unit1_temperatureLogic_channel1' did not match expected: value of the outgoing data port is ${unit1_temperatureLogic_channel1Value}"
    }
    val unit1_temperatureLogic_channel2Value: Base_Types.Boolean = get_unit1_temperatureLogic_channel2().get
    if(!unit1_temperatureLogic_channel2(unit1_temperatureLogic_channel2Value)) {
      testFailures = testFailures :+ st"'unit1_temperatureLogic_channel2' did not match expected: value of the outgoing data port is ${unit1_temperatureLogic_channel2Value}"
    }
    val unit1_temperatureLogic_channel3Value: Base_Types.Boolean = get_unit1_temperatureLogic_channel3().get
    if(!unit1_temperatureLogic_channel3(unit1_temperatureLogic_channel3Value)) {
      testFailures = testFailures :+ st"'unit1_temperatureLogic_channel3' did not match expected: value of the outgoing data port is ${unit1_temperatureLogic_channel3Value}"
    }
    val unit1_temperatureLogic_channel4Value: Base_Types.Boolean = get_unit1_temperatureLogic_channel4().get
    if(!unit1_temperatureLogic_channel4(unit1_temperatureLogic_channel4Value)) {
      testFailures = testFailures :+ st"'unit1_temperatureLogic_channel4' did not match expected: value of the outgoing data port is ${unit1_temperatureLogic_channel4Value}"
    }
    val unit1_pressureLogic_channel1Value: Base_Types.Boolean = get_unit1_pressureLogic_channel1().get
    if(!unit1_pressureLogic_channel1(unit1_pressureLogic_channel1Value)) {
      testFailures = testFailures :+ st"'unit1_pressureLogic_channel1' did not match expected: value of the outgoing data port is ${unit1_pressureLogic_channel1Value}"
    }
    val unit1_pressureLogic_channel2Value: Base_Types.Boolean = get_unit1_pressureLogic_channel2().get
    if(!unit1_pressureLogic_channel2(unit1_pressureLogic_channel2Value)) {
      testFailures = testFailures :+ st"'unit1_pressureLogic_channel2' did not match expected: value of the outgoing data port is ${unit1_pressureLogic_channel2Value}"
    }
    val unit1_pressureLogic_channel3Value: Base_Types.Boolean = get_unit1_pressureLogic_channel3().get
    if(!unit1_pressureLogic_channel3(unit1_pressureLogic_channel3Value)) {
      testFailures = testFailures :+ st"'unit1_pressureLogic_channel3' did not match expected: value of the outgoing data port is ${unit1_pressureLogic_channel3Value}"
    }
    val unit1_pressureLogic_channel4Value: Base_Types.Boolean = get_unit1_pressureLogic_channel4().get
    if(!unit1_pressureLogic_channel4(unit1_pressureLogic_channel4Value)) {
      testFailures = testFailures :+ st"'unit1_pressureLogic_channel4' did not match expected: value of the outgoing data port is ${unit1_pressureLogic_channel4Value}"
    }
    val unit1_saturationLogic_channel1Value: Base_Types.Boolean = get_unit1_saturationLogic_channel1().get
    if(!unit1_saturationLogic_channel1(unit1_saturationLogic_channel1Value)) {
      testFailures = testFailures :+ st"'unit1_saturationLogic_channel1' did not match expected: value of the outgoing data port is ${unit1_saturationLogic_channel1Value}"
    }
    val unit1_saturationLogic_channel2Value: Base_Types.Boolean = get_unit1_saturationLogic_channel2().get
    if(!unit1_saturationLogic_channel2(unit1_saturationLogic_channel2Value)) {
      testFailures = testFailures :+ st"'unit1_saturationLogic_channel2' did not match expected: value of the outgoing data port is ${unit1_saturationLogic_channel2Value}"
    }
    val unit1_saturationLogic_channel3Value: Base_Types.Boolean = get_unit1_saturationLogic_channel3().get
    if(!unit1_saturationLogic_channel3(unit1_saturationLogic_channel3Value)) {
      testFailures = testFailures :+ st"'unit1_saturationLogic_channel3' did not match expected: value of the outgoing data port is ${unit1_saturationLogic_channel3Value}"
    }
    val unit1_saturationLogic_channel4Value: Base_Types.Boolean = get_unit1_saturationLogic_channel4().get
    if(!unit1_saturationLogic_channel4(unit1_saturationLogic_channel4Value)) {
      testFailures = testFailures :+ st"'unit1_saturationLogic_channel4' did not match expected: value of the outgoing data port is ${unit1_saturationLogic_channel4Value}"
    }
    val unit2_temperatureLogic_channel1Value: Base_Types.Boolean = get_unit2_temperatureLogic_channel1().get
    if(!unit2_temperatureLogic_channel1(unit2_temperatureLogic_channel1Value)) {
      testFailures = testFailures :+ st"'unit2_temperatureLogic_channel1' did not match expected: value of the outgoing data port is ${unit2_temperatureLogic_channel1Value}"
    }
    val unit2_temperatureLogic_channel2Value: Base_Types.Boolean = get_unit2_temperatureLogic_channel2().get
    if(!unit2_temperatureLogic_channel2(unit2_temperatureLogic_channel2Value)) {
      testFailures = testFailures :+ st"'unit2_temperatureLogic_channel2' did not match expected: value of the outgoing data port is ${unit2_temperatureLogic_channel2Value}"
    }
    val unit2_temperatureLogic_channel3Value: Base_Types.Boolean = get_unit2_temperatureLogic_channel3().get
    if(!unit2_temperatureLogic_channel3(unit2_temperatureLogic_channel3Value)) {
      testFailures = testFailures :+ st"'unit2_temperatureLogic_channel3' did not match expected: value of the outgoing data port is ${unit2_temperatureLogic_channel3Value}"
    }
    val unit2_temperatureLogic_channel4Value: Base_Types.Boolean = get_unit2_temperatureLogic_channel4().get
    if(!unit2_temperatureLogic_channel4(unit2_temperatureLogic_channel4Value)) {
      testFailures = testFailures :+ st"'unit2_temperatureLogic_channel4' did not match expected: value of the outgoing data port is ${unit2_temperatureLogic_channel4Value}"
    }
    val unit2_pressureLogic_channel1Value: Base_Types.Boolean = get_unit2_pressureLogic_channel1().get
    if(!unit2_pressureLogic_channel1(unit2_pressureLogic_channel1Value)) {
      testFailures = testFailures :+ st"'unit2_pressureLogic_channel1' did not match expected: value of the outgoing data port is ${unit2_pressureLogic_channel1Value}"
    }
    val unit2_pressureLogic_channel2Value: Base_Types.Boolean = get_unit2_pressureLogic_channel2().get
    if(!unit2_pressureLogic_channel2(unit2_pressureLogic_channel2Value)) {
      testFailures = testFailures :+ st"'unit2_pressureLogic_channel2' did not match expected: value of the outgoing data port is ${unit2_pressureLogic_channel2Value}"
    }
    val unit2_pressureLogic_channel3Value: Base_Types.Boolean = get_unit2_pressureLogic_channel3().get
    if(!unit2_pressureLogic_channel3(unit2_pressureLogic_channel3Value)) {
      testFailures = testFailures :+ st"'unit2_pressureLogic_channel3' did not match expected: value of the outgoing data port is ${unit2_pressureLogic_channel3Value}"
    }
    val unit2_pressureLogic_channel4Value: Base_Types.Boolean = get_unit2_pressureLogic_channel4().get
    if(!unit2_pressureLogic_channel4(unit2_pressureLogic_channel4Value)) {
      testFailures = testFailures :+ st"'unit2_pressureLogic_channel4' did not match expected: value of the outgoing data port is ${unit2_pressureLogic_channel4Value}"
    }
    val unit2_saturationLogic_channel1Value: Base_Types.Boolean = get_unit2_saturationLogic_channel1().get
    if(!unit2_saturationLogic_channel1(unit2_saturationLogic_channel1Value)) {
      testFailures = testFailures :+ st"'unit2_saturationLogic_channel1' did not match expected: value of the outgoing data port is ${unit2_saturationLogic_channel1Value}"
    }
    val unit2_saturationLogic_channel2Value: Base_Types.Boolean = get_unit2_saturationLogic_channel2().get
    if(!unit2_saturationLogic_channel2(unit2_saturationLogic_channel2Value)) {
      testFailures = testFailures :+ st"'unit2_saturationLogic_channel2' did not match expected: value of the outgoing data port is ${unit2_saturationLogic_channel2Value}"
    }
    val unit2_saturationLogic_channel3Value: Base_Types.Boolean = get_unit2_saturationLogic_channel3().get
    if(!unit2_saturationLogic_channel3(unit2_saturationLogic_channel3Value)) {
      testFailures = testFailures :+ st"'unit2_saturationLogic_channel3' did not match expected: value of the outgoing data port is ${unit2_saturationLogic_channel3Value}"
    }
    val unit2_saturationLogic_channel4Value: Base_Types.Boolean = get_unit2_saturationLogic_channel4().get
    if(!unit2_saturationLogic_channel4(unit2_saturationLogic_channel4Value)) {
      testFailures = testFailures :+ st"'unit2_saturationLogic_channel4' did not match expected: value of the outgoing data port is ${unit2_saturationLogic_channel4Value}"
    }

    assert(testFailures.isEmpty, st"${(testFailures, "\n")}".render)
  }


  // getter for out DataPort
  def get_unit1_temperatureLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_temperatureLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_temperatureLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_temperatureLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_temperatureLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_temperatureLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_temperatureLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_temperatureLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_temperatureLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_temperatureLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_temperatureLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_temperatureLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_temperatureLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_temperatureLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_temperatureLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_temperatureLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_temperatureLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_temperatureLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_temperatureLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_temperatureLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_pressureLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_pressureLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_pressureLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_pressureLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_pressureLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_pressureLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_pressureLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_pressureLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_pressureLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_pressureLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_pressureLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_pressureLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_pressureLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_pressureLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_pressureLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_pressureLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_pressureLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_pressureLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_pressureLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_pressureLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_saturationLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_saturationLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_saturationLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_saturationLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_saturationLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_saturationLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_saturationLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_saturationLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_saturationLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_saturationLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_saturationLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_saturationLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_saturationLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_saturationLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_saturationLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit1_saturationLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit1_saturationLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit1_saturationLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit1_saturationLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit1_saturationLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_temperatureLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_temperatureLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_temperatureLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_temperatureLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_temperatureLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_temperatureLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_temperatureLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_temperatureLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_temperatureLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_temperatureLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_temperatureLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_temperatureLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_temperatureLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_temperatureLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_temperatureLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_temperatureLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_temperatureLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_temperatureLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_temperatureLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_temperatureLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_pressureLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_pressureLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_pressureLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_pressureLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_pressureLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_pressureLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_pressureLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_pressureLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_pressureLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_pressureLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_pressureLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_pressureLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_pressureLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_pressureLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_pressureLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_pressureLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_pressureLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_pressureLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_pressureLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_pressureLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_saturationLogic_channel1(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_saturationLogic_channel1_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_saturationLogic_channel1.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_saturationLogic_channel1_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_saturationLogic_channel1_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_saturationLogic_channel2(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_saturationLogic_channel2_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_saturationLogic_channel2.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_saturationLogic_channel2_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_saturationLogic_channel2_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_saturationLogic_channel3(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_saturationLogic_channel3_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_saturationLogic_channel3.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_saturationLogic_channel3_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_saturationLogic_channel3_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_unit2_saturationLogic_channel4(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_unit2_saturationLogic_channel4_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => halt(s"Unexpected payload on port unit2_saturationLogic_channel4.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_unit2_saturationLogic_channel4_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative.observeOutPortValue(Arch.RTS_i_Instance_instrumentationMock_instrumentationMockThread.initialization_api.unit2_saturationLogic_channel4_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

}
