package br.unb.cic.tp2.kwic
import org.scalatest._
class stopWordManagerTest extends FlatSpec with Matchers {
  behavior of "Stop Word Manager using the default file"
  it should "Return true when stopWord is called with a valid stop word" in {
    stopWordManager.stopWord("as")      should be(true)
    stopWordManager.stopWord("at")      should be(true)
    stopWordManager.stopWord("be")      should be(true)
    stopWordManager.stopWord("because") should be(true)
    stopWordManager.stopWord("been")    should be(true)
    stopWordManager.stopWord("before")  should be(true)
    stopWordManager.stopWord("being")   should be(true)
    stopWordManager.stopWord("below")   should be(true)
    stopWordManager.stopWord("between") should be(true)
    stopWordManager.stopWord("both")    should be(true)
    stopWordManager.stopWord("but")     should be(true)
  }

  it should "Return false when stopWord is calle with a invalid stop word" in {
    stopWordManager.stopWord("network")   should be(false)
    stopWordManager.stopWord("scala")     should be(false)
    stopWordManager.stopWord("elixir")    should be(false)
  }





}
