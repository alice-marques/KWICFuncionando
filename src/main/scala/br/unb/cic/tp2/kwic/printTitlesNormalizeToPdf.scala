package br.unb.cic.tp2.kwic

import java.io.PrintWriter
import sys.process._

class printTitlesNormalizeToPdf {

  def escreve(): Unit = {
    val normalize = 20
    val writer = new PrintWriter("Saida.tex")
    val Documento = List("""\documentclass{article}""","""\title{KWIC}""","""\begin{document}""","""\end{document}""")
    val cleanDir = List("Saida.tex","Saida.aux","Saida.pdf","Saida.log")
    writer.write(Documento(0)+'\n'+Documento(1)+'\n'+Documento(2)+'\n')
    var aux:String = ""
    for(title <- titlesManager.cleanedTitles){
      for(word <- title){
        aux = title(0)
        for(num <- 0 to title.length-2){
          title.update(num, title(num+1))
        }
        title.update(title.size-1, aux)
        writer.write( """$\mid$"""+title(0).mkString.capitalize+" ")
        for(n <- 1 to (normalize - title(0).length)) writer.append(""" """)
        writer.append("""$\mid$ """)
        for(j <- 1 until title.length){ writer.append(title(j).mkString.toLowerCase+" ")}
        writer.append("""\\"""+"\n"+"""\\"""+'\n')
      }
    }
    writer.append("""\\"""+'\n'+Documento(3))
    writer.close()
    "pdflatex Saida.tex".!
    for(file <- cleanDir) ("rm "+file).!

  }
}
