object RGB extends App {


  def rgb(r: Int, g: Int, b: Int): String = {
    val convertToRange = List(r, g, b).map{
      case x if x < 0 => 0
      case x if x > 255 => 255
      case x => x
    }
    f"${convertToRange.head}%02X${convertToRange(1)}%02X${convertToRange(2)}%02X"
  }
  println(rgb(-2, 300, 500))

  // https://www.codewars.com/kata/513e08acc600c94f01000001
}
