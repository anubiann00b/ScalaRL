package engine.world

class TileType(val glyph: Char, val passable: Boolean)

object TileType {
  val WALL = new TileType('#', false)
  val FLOOR = new TileType('.', true)
}