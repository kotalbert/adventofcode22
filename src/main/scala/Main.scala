import expedition.CalorieCounter._
import expedition.Utils._

object Main {
  def main(args: Array[String]): Unit = {
    val puzzleInputFile = "src/main/resources/elf-inventory.txt"
    val maxCaloriesCarried = findMaxCaloriesCarried(makeTotalCarriedPerElf(makeElfInventory(puzzleInputFile)))
    println(
      s"""
         |Puzzle solutions:
         |
         |* Day 1: Max total calories carried by a single single elf is $maxCaloriesCarried.
         |* Day 2: ???
         |""".stripMargin)
  }
}