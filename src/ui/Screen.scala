package ui

import asciiPanel.AsciiPanel
import engine.world.World
import entity.Entity

class Screen(terminal: AsciiPanel, repaint: () => Unit) {

  def paint(world: World, entities: List[Entity]): Unit = {
    repaint()
    terminal.clear()
    for (i <- 1 to 80) {
      for (j <- 1 to 24) {
        terminal.write(world.tiles(i-1)(j-1).ttype.glyph, i-1, j-1)
      }
    }

    for (entity <- entities) {
      terminal.write(entity.glyph, entity.pos.x, entity.pos.y)
    }
  }
}
