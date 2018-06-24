package br.unb.cic.tp2.kwic

import sys.process._

object Main {
  def main(args: Array[String]): Unit = {
    val title = new printTitles()
    val titleNormalized = new printTitlesNormalized()
    val titleFile = new printTitlesNormalizeToFile()
    val titleFilePdf = new printTitlesNormalizeToPdf()
    stopWordManager.readStopWord()
    titlesManager.openListTitles()
    titlesManager.cleanTitles()
    println("Please select 1 to see the results normalized, 2 to see them not normalized, 3 to print the normalized result to file or 4 to print to PDF:")
    scala.io.StdIn.readInt() match{
      case 2 => title.printTitles()
      case 1 => titleNormalized.printTitles()
      case 3 => titleFile.printTitles()
      case 4 => titleFilePdf.escreve()
      case _=> println("Please select a valid option next time.")
    }
  }
}
