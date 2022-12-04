package expedition

import scala.io.Source
import scala.util.Using

class CalorieCounterTest extends UnitSpec {

  /**
   * Fixture defined as anonymous class, generates test list from file.
   */
  private val fixture = new {
    val testFile: String = "src/test/resources/elf-inventory.txt"
    val elfInventory: Seq[String] = Using.resource(Source.fromFile(testFile)) {
      reader => reader.getLines().toSeq
    }
  }

  /**
   * Anonymous class to hold expected values.
   */
  private val expected = new {
    val inventoryLinesNumber = 14
    val totalCarriedPerElf: Seq[Int] = Seq(6_000, 4_000, 11_000, 24_000, 10_000)
    val maxCarried = 24_000
  }

  "An Utils.makeElfInventory" should "produce correct sequence" in {
    Utils.makeElfInventory(fixture.testFile) should equal(fixture.elfInventory)
  }

  "A test file with elf inventory" should "have expected number of lines." in {
    fixture.elfInventory.length should equal(expected.inventoryLinesNumber)
  }

  "The CalorieCounter object" should "solve for test input."

  it should "Produce a list of total calories per elf." in {
    val totalCarriedPerElf: Seq[Int] = CalorieCounter.makeTotalCarriedPerElf(fixture.elfInventory)
    totalCarriedPerElf should equal(expected.totalCarriedPerElf)

  }

  it should "find a max of total calories carried per elf." in {
    CalorieCounter.findMaxCaloriesCarried(CalorieCounter.makeTotalCarriedPerElf(fixture.elfInventory)) should
      equal(expected.maxCarried)
  }

}
