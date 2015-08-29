import java.awt.Color
import java.awt.event.{KeyEvent, KeyListener}
import javax.swing.JFrame

import asciiPanel.AsciiPanel
import engine.Engine
import ui.Screen

object Window extends JFrame() with KeyListener {

  def main (args: Array[String]): Unit = {
    Window.setVisible(true)
    engine.run()
  }

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  setBackground(Color.BLACK)
  setTitle("ScalaRL")

  val terminal = new AsciiPanel()
  add(terminal)
  pack()
  addKeyListener(this)

  val screen = new Screen(terminal, repaint)
  val engine = new Engine(screen.paint)

  override protected def keyPressed(e: KeyEvent): Unit = {
    engine.keyPress(e)
  }

  override protected def keyTyped(e: KeyEvent): Unit = ()

  override protected def keyReleased(e: KeyEvent): Unit = ()
}
