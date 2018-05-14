package br.unb.cic.tp2.kwic
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer
object titlesManager {
  val file = "titulos.txt"
  var titles:List[String] = _
  val cleanedTitles = new ListBuffer[ArrayBuffer[String]]
  def openListTitles(): Unit ={
    println("Please select 1 to use the default file or 2 to input another:")
    scala.io.StdIn.readInt() match{
      case 1 => titles = scala.io.Source.fromFile(file).getLines().toList
      case 2 => titles = scala.io.Source.fromFile(scala.io.StdIn.readLine()).getLines().toList
      case _ => println("Please choose a valid option."); openListTitles()
    }

  }
  def cleanTitles(): Unit ={
    for(title <- titles) cleanedTitles += title.split(' ').to[ArrayBuffer]
    for(title <- cleanedTitles;word <- title ) if (stopWordManager.stopWord(word)) {title.remove(title.indexOf(word)) }
  }
}
