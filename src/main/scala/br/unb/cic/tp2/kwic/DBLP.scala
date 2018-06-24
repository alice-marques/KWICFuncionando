package br.unb.cic.tp2.kwic

import scala.collection.mutable.ListBuffer

trait DBLP {
  def returnTitles(): ListBuffer[String]
}
