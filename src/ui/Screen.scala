package ui

import asciiPanel.AsciiPanel

class Screen(terminal: AsciiPanel, repaint: () => Unit) {

  def paint(gameState: GameState): Unit = {
    repaint()
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
