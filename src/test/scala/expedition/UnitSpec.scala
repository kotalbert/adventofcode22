package expedition

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

/**
 * Base class for FlatSpec style of testing using [[org.scalatest.flatspec.AnyFlatSpec]].
 * The example taken from [[https://www.scalatest.org/user_guide/selecting_a_style]].
 */
abstract class UnitSpec extends AnyFlatSpec with should.Matchers