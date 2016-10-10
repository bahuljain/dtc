package dtc.tests

import java.time.ZonedDateTime

import dtc.instances.zonedDateTime._
import dtc.laws.{DateTimeTCTests, OrderLaws}
import org.scalacheck.{Arbitrary, Cogen}

// todo: Add Order laws when cats-kernel-laws are released against scalacheck 1.13.*
class ZonedDateTimeTests extends ExtendedSyntaxTests[ZonedDateTime] {

  implicit val arbT: Arbitrary[ZonedDateTime] = com.fortysevendeg.scalacheck.datetime.jdk8.ArbitraryJdk8.arbJdk8
  implicit val cogenT: Cogen[ZonedDateTime] = Cogen(_.toEpochSecond)

  checkAll("java.time.ZonedDateTime", DateTimeTCTests[ZonedDateTime].dateTime)
  checkAll("java.time.ZonedDateTime", OrderLaws[ZonedDateTime].order)
  checkAll("java.time.ZonedDateTime", OrderLaws[ZonedDateTime].partialOrder)
  checkAll("java.time.ZonedDateTime", OrderLaws[ZonedDateTime].eqv)
}

