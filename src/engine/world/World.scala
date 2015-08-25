package engine.world

import scala.util.Random

class World {
  def shuffle(): Unit = {
    for (i <- 1 to 80) {
      for (j <- 1 to 24) {
        tiles(i-1)(j-1) = new Tile(if (Random.nextBoolean()) TileType.FLOOR else TileType.WALL)
      }
    }
  }


  val tiles = Array.ofDim[Tile](80,24)
  shuffle()
}
