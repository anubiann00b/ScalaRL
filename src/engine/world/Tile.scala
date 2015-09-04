package engine.world

class Tile(val ttype: TileType) {

  def passable: Boolean = ttype.passable
}
