package br.unb.cic.tp2.kwic
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
object titlesManager {
  val chars = """,.:"<>';-&""".toSet
  val file = "titulos.txt"
  var titles = new ListBuffer[String]
  val noSpecialCharTitles = new ListBuffer[String]
  val separatedTitles = new ListBuffer[ArrayBuffer[String]]
  val cleanedTitles = new ListBuffer[ArrayBuffer[String]]
  val dBLP = new DBLPManager
  def openListTitles(): Unit ={
    println("Please select 1 to use the default file, 2 to input another or 3 to get the titles from DBLP:")
    scala.io.StdIn.readInt() match{
      case 1 => titles = scala.io.Source.fromFile(file).getLines().to[ListBuffer]
      case 2 => titles = scala.io.Source.fromFile(scala.io.StdIn.readLine()).getLines().to[ListBuffer]
      case 3 => titles = dBLP.returnTitles()
      case _ => println("Please choose a valid option."); openListTitles()
    }

  }
  def cleanTitles(): Unit ={
    for(title <- titles) noSpecialCharTitles += title.filterNot(chars)
    for(title <- noSpecialCharTitles) separatedTitles += title.split(' ').to[ArrayBuffer]
    for(title <- separatedTitles) {
      val individualTitles = new ArrayBuffer[String]
      for(word <- title) if(!stopWordManager.stopWord(word.toLowerCase())) individualTitles += word
      cleanedTitles += individualTitles
    }
  }

}
