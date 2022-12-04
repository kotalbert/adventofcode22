package expedition

import scala.io.Source
import scala.util.Using

/**
 * Helper functions for the project.
 */
object Utils {
  /**
   * Read input file.
   *
   * @param filename input file
   * @return list of lines read
   */
  def makeElfInventory(filename: String): Seq[String] = {
    Using.resource(Source.fromFile(filename)) {
      reader => reader.getLines().toSeq
    }
  }


}
