package br.unb.cic.tp2.kwic

class printTitles extends wordShift {
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


}