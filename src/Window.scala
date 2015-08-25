import java.awt.Color
import java.awt.event.{KeyEvent, KeyListener}
import javax.swing.JFrame

import asciiPanel.AsciiPanel

object Window extends JFrame() with KeyListener {

  def main (args: Array[String]): Unit = {
    Window.setVisible(true)
  }

  val terminal = new AsciiPanel()
  add(terminal)
  pack()
  addKeyListener(this)
  repaint()

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  setBackground(Color.BLACK)
  setTitle("ScalaRL")

  override protected def repaint(): Unit = {
    terminal.clear()
    terminal.writeCenter("HELLO!!!1", 10)
    super.repaint()
  }

  override protected def keyPressed(e: KeyEvent): Unit = {

  }

  override protected def keyTyped(e: KeyEvent): Unit = ()

  override protected def keyReleased(e: KeyEvent): Unit = ()
}
