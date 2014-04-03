package euler.util

import RichFile.enrichFile
import java.io.File
import scala.collection.immutable.Map

/**
 */

object Template {

  def process(template: String, vars: Map[String, String]) = {
    vars.foldLeft(template) {
      case (s:String, (from:String, to:String)) => s.replaceAll(s"\\{$from\\}", to)
    }
  }

  def process(in: String, out: String, vars: Map[String, String]) {
    new File(out).text = process((new File(in)).text, vars)
  }


}
