import expedition.CalorieCounter._
import expedition.Utils._

object Main {
  def main(args: Array[String]): Unit = {
    val puzzleInputFile = "src/main/resources/elf-inventory.txt"
    val loads = makeLoadPerElfList(makeElfInventory(puzzleInputFile))
    val maxLoad = findMaxLoad(loads)
    val sumTopThree = findSumTopThreeLoads(loads)


    println(
      s"""
         |Puzzle solutions:
         |
         |* Day 1, part 1:\tMax load carried by a single single elf is $maxLoad.
         |* Day 1, part 2:\tSum of top three loads is $sumTopThree.
         |""".stripMargin)
  }
}