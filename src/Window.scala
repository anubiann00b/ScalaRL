import java.awt.Color
import java.awt.event.{KeyEvent, KeyListener}
import javax.swing.JFrame

import asciiPanel.AsciiPanel
import engine.Engine
import ui.{GameState, Screen}

object Window extends JFrame() with KeyListener {

  def main (args: Array[String]): Unit = {
    Window.setVisible(true)
    engine.run()
  }

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  setBackground(Color.BLACK)
  setTitle("ScalaRL")

  val screen = new Screen(requestRepaint)
  val terminal = new AsciiPanel()
  add(terminal)
  pack()
  addKeyListener(this)

  val engine = new Engine(screen)

  private def requestRepaint(gameState: GameState): Unit = {
    screen.paint(terminal, gameState)
    repaint()
  }

  override protected def keyPressed(e: KeyEvent): Unit = {
    engine.keyPress(e)
  }

  override protected def keyTyped(e: KeyEvent): Unit = ()

  override protected def keyReleased(e: KeyEvent): Unit = ()
}
