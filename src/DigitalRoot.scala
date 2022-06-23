import scala.annotation.tailrec

object DigitalRoot {

  def digitalRoot(n: Int): Int = {
    @tailrec
    def loop(accum: Int): Int = {
      accum.toString.length match {
        case 1 => accum
        case _ => loop(accum.toString.map(_.asDigit).sum)
      }
    }
    loop(n)
  }


  //https://www.codewars.com/kata/541c8630095125aba6000c00

}
