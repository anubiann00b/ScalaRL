package ui

import asciiPanel.AsciiPanel
import engine.world.World

class Screen(requestRedraw: (GameState) => Unit) {

  def repaint(world: World): Unit ={
    requestRedraw(new GameState(world))
  }

  def paint(terminal: AsciiPanel, gameState: GameState): Unit = {
    terminal.clear()
    for (i <- 1 to 80) {
      for (j <- 1 to 24) {
        terminal.write(gameState.world.tiles(i-1)(j-1).ttype.glyph, i-1, j-1)
      }
    }
  }
}
