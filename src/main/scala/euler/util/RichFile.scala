package euler.util

import scala.language.implicitConversions

import java.io._
import scala.io._

/**
 * Simple File io convenience wrapper taken from: http://stackoverflow.com/a/6881792/1991333
 */
class RichFile(file: File) {
  def text = Source.fromFile(file)(Codec.UTF8).mkString
  def text_=(s: String) {
    val out = new PrintWriter(file, "UTF-8")
    try { out.print( s ) } finally { out.close }
  }
}

object RichFile {
  implicit def enrichFile(file: File) = new RichFile(file)
}
