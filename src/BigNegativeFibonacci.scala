import scala.annotation.tailrec

object BigNegativeFibonacci extends App {


  // >>> Testing negative fibo number
//  def fib(n: Int): BigInt = {
//    @tailrec
//    def loop(n: Int = math.abs(n), f1: BigInt = 0, f2: BigInt = 1): BigInt = {
//      n match {
//        case 0 => f1
//        case _ => loop(n-1, f2, f1+f2)
//      }
//    }
//    val result = loop()
//    if (n < 0 && n % 2 == 0) -1 * result else result
//  }

  // <<<


  def fibo(n: Int): BigInt = {
    val binary = math.abs(n).toBinaryString + 'X'
    val F0: BigInt = 0
    val F1: BigInt = 1
    @tailrec
    def loop(numIndex: Int = 0, binNum: String, firstTwo: List[BigInt] = List(F0, F1)): List[BigInt] = {
      val f2i1 = firstTwo(1) * firstTwo(1) + firstTwo.head * firstTwo.head
      val f2i = firstTwo.head * (2*firstTwo(1)-firstTwo.head)
      binNum(numIndex) match {
        case '0' => loop(numIndex + 1, binNum, List(f2i, f2i1))
        case '1' => loop(numIndex + 1, binNum, List(f2i1, f2i + f2i1))
        case 'X' => firstTwo
      }
    }
    val result = loop(0, binary, List(F0, F1))
    if (n < 0 && n % 2 == 0) result.head * -1 else result.head
  }

  println(fibo(-96))

  // https://www.codewars.com/kata/53d40c1e2f13e331fc000c26
}
