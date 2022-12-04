package expedition

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object CalorieCounter {

  /**
   * Find total calories carried per elf.
   * @param elfInventory a list of dishes carried by each elf.
   * @return list of calorie sums per each elf.
   */
  def makeTotalCarriedPerElf(elfInventory: Seq[String]): Seq[Int] = {
    val lb = ListBuffer.empty[Int]

    @tailrec
    def collect(aSeq: Seq[String], acc: Int = 0): Seq[Int] = {
      val head :: tail = aSeq

      if (tail == Nil) {
        lb.addOne(head.toInt + acc)
        lb.toSeq
      }
      else {
        if (head == "") {
          lb.addOne(acc)
          collect(tail)
        }
        else collect(tail, acc + head.toInt)
      }
    }

    collect(elfInventory)

  }

  /**
   * Find max calorie carried by single elf.
   *
   * @param elfTotals list of total calories carried per elf.
   * @return a max of the list
   */
  def findMaxCaloriesCarried(elfTotals: Seq[Int]): Int = elfTotals.max
}
