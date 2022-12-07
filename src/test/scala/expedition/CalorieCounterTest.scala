package expedition

import expedition.CalorieCounter.Load

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
    val loadPerElfList: Seq[Load] = Seq(6_000, 4_000, 11_000, 24_000, 10_000)
    val maxLoad: Load = 24_000
    val topThreeLoadsSum: Load = 45_000
  }

  "An Utils.makeElfInventory" should "produce correct sequence of items carried by elves." in {
    Utils.makeElfInventory(fixture.testFile) should equal(fixture.elfInventory)
  }

  "A test file with elf inventory" should "have expected number of lines." in {
    fixture.elfInventory.length should equal(expected.inventoryLinesNumber)
  }

  "The CalorieCounter object" should "solve puzzles for test input."

  it should "Produce a list of Load carried per elf." in {
    val loadPerElfList: Seq[Load] = CalorieCounter.makeLoadPerElfList(fixture.elfInventory)
    loadPerElfList should equal(expected.loadPerElfList)
  }

  it should "find a max Load carried by an elf." in {
    CalorieCounter.findMaxLoad(CalorieCounter.makeLoadPerElfList(fixture.elfInventory)) should
      equal(expected.maxLoad)
  }

  it should "find a sum of top 3 Loads." in {
    CalorieCounter.findSumTopThreeLoads(expected.loadPerElfList) should equal(expected.topThreeLoadsSum)
  }

}
