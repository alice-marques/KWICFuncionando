package br.unb.cic.tp2.kwic

import play.api.libs.json._
import scala.collection.mutable.ListBuffer


class DBLPManager extends DBLP {
  def returnTitles(): ListBuffer[String] = {
    print("Please enter your search criteria: ")
    val criteria = scala.io.StdIn.readLine()
    val url = "http://dblp.org/search/publ/api?q="+criteria+"&format=json"
    getTitles(url)
  }
  private def getTitles(url: String): ListBuffer[String] = {
    val json = Json.parse(scala.io.Source.fromURL(url).mkString) \\ "title"
    val titles = new ListBuffer[String]
    for(title <- json) titles += title.toString()
    titles
  }

}
