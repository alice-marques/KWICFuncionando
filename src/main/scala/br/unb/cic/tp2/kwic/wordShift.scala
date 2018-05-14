package br.unb.cic.tp2.kwic

object wordShift {
  val target = 1
  val normalize = 15
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
}
