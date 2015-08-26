package ui

import asciiPanel.AsciiPanel
import engine.world.World
import entity.Entity

class Screen(val requestRedraw: (GameState) => Unit) {

  def repaint(world: World, entities: List[Entity]): Unit = {
    requestRedraw(new GameState(world, entities))
  }

  def paint(terminal: AsciiPanel, gameState: GameState): Unit = {
    println("paint")
    terminal.clear()
    for (i <- 1 to 80) {
      for (j <- 1 to 24) {
        terminal.write(gameState.world.tiles(i-1)(j-1).ttype.glyph, i-1, j-1)
      }
    }

    for (entity <- gameState.entities) {
      terminal.write(entity.glyph, entity.pos.x, entity.pos.y)
    }
  }
}
