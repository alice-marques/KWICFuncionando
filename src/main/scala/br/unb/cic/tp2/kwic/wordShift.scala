package br.unb.cic.tp2.kwic
import java.io.PrintWriter
object wordShift {
  val target = 1
  val normalize = 20
  def printTitles(): Unit ={
    var aux:String = ""
    for(title <- titlesManager.cleanedTitles){
      for(word <- title){
        aux = title(0)
        for(num <- 0 to title.length-2){
          title.update(num, title(num+1))
        }
        title.update(title.size-1, aux)
        print(" | "+title(0).mkString.capitalize+" | ")
        for(j <- 1 until title.length){ print(title(j).mkString.toLowerCase+" ")}
        print("\n")
      }
    }
  }
  def printTitlesNormalized()={
      var aux:String = ""
      for(title <- titlesManager.cleanedTitles){
        for(word <- title){
          aux = title(0)
          for(num <- 0 to title.length-2){
            title.update(num, title(num+1))
          }
          title.update(title.size-1, aux)
          print(" | "+title(0).mkString.capitalize+" ")
          for(n <- 1 to (normalize - title(0).length)) print(" ")
          print("| ")
          for(j <- 1 until title.length){ print(title(j).mkString.toLowerCase+" ")}
          print("\n")
        }
      }
    }
  def printTitlesNormalizedToFile():Unit={
    println("Please select 1 to write to the default file or 2 to write to a file of your choice:")
    var writer = new PrintWriter("Saida.txt")
    scala.io.StdIn.readInt() match{
      case 1 =>
      case 2 => println("Please write the name of the file:");writer.close(); writer = new PrintWriter(scala.io.StdIn.readLine())
      case _ => println("Please choose a valid option."); printTitlesNormalizedToFile()
    }

    var aux:String = ""
    for(title <- titlesManager.cleanedTitles){
      for(word <- title){
        aux = title(0)
        for(num <- 0 to title.length-2){
          title.update(num, title(num+1))
        }
        title.update(title.size-1, aux)
        writer.write(" | "+title(0).mkString.capitalize+" ")
        for(n <- 1 to (normalize - title(0).length)) writer.append(" ")
        writer.append("| ")
        for(j <- 1 until title.length){ writer.append(title(j).mkString.toLowerCase+" ")}
        writer.append("\n")
      }
    }
    writer.close()
  }

}
