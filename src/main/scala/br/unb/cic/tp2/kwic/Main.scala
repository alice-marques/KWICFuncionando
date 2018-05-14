package br.unb.cic.tp2.kwic

object Main {
  def main(args: Array[String]): Unit = {
    stopWordManager.readStopWord()
    titlesManager.openListTitles()
    titlesManager.cleanTitles()
    println("Please select 1 to see the results normalized or 2 to see them not normalized:")
    scala.io.StdIn.readInt() match{
      case 1 => wordShift.printTitlesNormalized()
      case 2 => wordShift.printTitles()
      case _=> println("Please select a valid option next time.")
    }
  }
}
