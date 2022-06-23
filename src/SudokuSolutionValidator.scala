object SudokuSolutionValidator extends App {

  def isValid(board: Array[Array[Int]]): Boolean = {
    // Example for comparing with
    val example: Set[Int] = (1 to 9).toSet

    // First two traversing - horizontal and vertical lines
    val firstTrav = board.map(_.toSet == example).forall(_ == true)
    val secondTrav = board.transpose.map(_.toSet == example).forall(_ == true)

    // Traversing via 3x3 squares grouped by 3x9 blocks
    val thirdTrav = board
      .grouped(3)
      .map(_.flatMap(_.take(3)))
      .map(_.toSet == example)
      .forall(_ == true)
    val fourthTrav = board
      .grouped(3)
      .map(_.flatMap(_.slice(3, 6)))
      .map(_.toSet == example)
      .forall(_ == true)
    val fifthTrav = board
      .grouped(3)
      .map(_.flatMap(_.takeRight(3)))
      .map(_.toSet == example)
      .forall(_ == true)

    firstTrav && secondTrav && thirdTrav && fourthTrav && fifthTrav

  }

  val validBoard = Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 0, 3, 4, 8),
    Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
    Array(8, 5, 9, 7, 6, 1, 4, 2, 3),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 4, 5, 2, 8, 6, 1, 7, 9)
  )

  val invalidBoard = Array(
    Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
    Array(6, 7, 2, 1, 9, 0, 3, 4, 8),
    Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
    Array(8, 5, 9, 7, 6, 1, 4, 2, 3),
    Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
    Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
    Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
    Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
    Array(3, 4, 5, 2, 8, 6, 1, 7, 9)
  )

  println(isValid(validBoard))
  println(isValid(invalidBoard))

  // https://www.codewars.com/kata/529bf0e9bdf7657179000008

}
