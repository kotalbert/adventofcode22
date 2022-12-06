package expedition

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object CalorieCounter {

  /**
   * A sum of calories carried by an individual elf.
   */
  type Load = Int


  /**
   * Calculates total calories carried per elf and puts it to list.
   *
   * Let sum of calories carried by an individual elf be called Load.
   *
   * @param elfInventory a list of dishes carried by each elf.
   * @return list of Load of each elf.
   */
  def makeLoadPerElfList(elfInventory: Seq[String]): Seq[Load] = {
    val lb = ListBuffer.empty[Load]

    @tailrec
    def collect(aSeq: Seq[String], acc: Load = 0): Seq[Load] = {
      val head :: tail = aSeq

      if (tail == Nil) {
        lb.addOne(Integer.parseInt(head) + acc)
        lb.toSeq
      }
      else {
        if (head == "") {
          lb.addOne(acc)
          collect(tail)
        }
        else collect(tail, acc + Integer.parseInt(head))
      }
    }

    collect(elfInventory)

  }

  /**
   * Find max Load by single elf.
   *
   * Day 1 puzzle, part 1
   *
   * @param loads list of total calories carried per elf.
   * @return a max of the list
   */
  def findMaxLoad(loads: Seq[Load]): Load = loads.max

  /**
   * Find sum of top three loads.
   *
   * Day 1 puzzle, part 2
   *
   * @param loads a list of Load per elf
   * @return sum of 3 highest loads
   */
  def findSumTopThreeLoads(loads: Seq[Load]): Load = {
    require(loads.size >= 3)
    loads.sorted.reverse.take(3).sum
  }

}
