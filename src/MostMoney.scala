object MostMoney extends App {

  case class Student(name: String, fives: Int, tens: Int, twenties: Int)

  val mostMoneyTestCase = List(Student("John", 5, 10, 20), Student("Doe", 1, 2, 3), Student("Alice", 3, 4, 5))

  def mostMoney(students: List[Student]): String = {
    val pairs = students.map(x => Tuple2(x.name, List(x.fives * 5, x.tens * 10, x.twenties * 20).sum))
    students.length match {
      case 1 => students.head.name
      case _ => if (pairs.forall(_._2 == pairs.head._2)) "all" else pairs.maxBy(_._2)._1
    }
  }

  println(mostMoney(mostMoneyTestCase))

  // https://www.codewars.com/kata/528d36d7cc451cd7e4000339
}
