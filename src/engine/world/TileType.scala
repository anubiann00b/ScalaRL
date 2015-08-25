package engine.world

class TileType(val glyph: Char) {
//  def glyph
}

object TileType {
  val WALL = new TileType('#')
  val FLOOR = new TileType('.')
}