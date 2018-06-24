package br.unb.cic.tp2.kwic


object stopWordManager {
  var words : List[String] = List()

  def readStopWord(): Unit ={
    println("Press 1 to use the default stopword file or 2 to use a new one:")
    scala.io.StdIn.readInt() match{
      case 1 => words = scala.io.Source.fromFile("stopWords.txt").getLines().toList
      case 2 => words = scala.io.Source.fromFile(scala.io.StdIn.readLine()).getLines().toList
      case _ => println("Please choose a valid option")
    }
  }

  /**
    * return true in the case of a stop word.
    */
  def stopWord(word : String) = words.contains(word) }