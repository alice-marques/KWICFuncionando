package br.unb.cic.tp2.kwic

object TEstes {
  def main(args: Array[String]): Unit = {
    val titleFilePdf = new printTitlesNormalizeToPdf()
    val title = new printTitles()
    stopWordManager.readStopWord()
    titlesManager.openListTitles()
    titlesManager.cleanTitles()
    titleFilePdf.escreve()
  }
}
