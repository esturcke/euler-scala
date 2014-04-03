package euler.util

import org.scalatest._

class TemplateSpec extends FlatSpec with Matchers {

  "A template" should "process with an empty map" in {
    val template = "A foo bar\nbaz\nbar"
    Template.process(template, Map()) should be (template)
  }

  it should "process with an empty map even with vars in the template" in {
    val template = "A foo {bar}\nbaz\nbar"
    Template.process(template, Map()) should be (template)
  }

  it should "process with an a map with unused vars" in {
    val template = "A foo {bar}\nbaz\nbar"
    val result = "A foo baz\nbaz\nbar"
    Template.process(template, Map( "bar" -> "baz", "boo" -> "bar")) should be (result)
  }

  it should "process with an a map with only some vars" in {
    val template = "A foo {bar}\n{baz}\nbar"
    val result = "A foo {bar}\nbee\nbar"
    Template.process(template, Map( "baz" -> "bee", "boo" -> "bar")) should be (result)
  }
}
