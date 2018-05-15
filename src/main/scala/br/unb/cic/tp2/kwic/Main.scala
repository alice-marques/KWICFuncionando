package br.unb.cic.tp2.kwic

object Main {
  def main(args: Array[String]): Unit = {
    val title = new printTitles()
    val titleNormalized = new printTitlesNormalized()
    val titleFile = new printTitlesNormalizeToFile()
    stopWordManager.readStopWord()
    titlesManager.openListTitles()
    titlesManager.cleanTitles()
    println("Please select 1 to see the results normalized, 2 to see them not normalized or 3 to print the normalized result to file:")
    scala.io.StdIn.readInt() match{
      case 1 => title.printTitles()
      case 2 => titleNormalized.printTitles()
      case 3 => titleFile.printTitles()
      case _=> println("Please select a valid option next time.")
    }
  }
}
