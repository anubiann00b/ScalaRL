import java.awt.Color
import java.awt.event.{KeyEvent, KeyListener}
import javax.swing.JFrame

import asciiPanel.AsciiPanel

object Window extends JFrame() with KeyListener {

  def main (args: Array[String]) {
    Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    Window.setVisible(true)
    Window.setBackground(Color.BLACK)
    Window.setTitle("ScalaRL")
  }

  val terminal = new AsciiPanel()
  add(terminal)
  pack()
  addKeyListener(this)
  repaint()
  println("created")

  override def repaint(): Unit = {
    println("repaint")
    terminal.clear()
    terminal.writeCenter("HELLO!!!1", 10)
    super.repaint()
  }

  override def keyPressed(e: KeyEvent): Unit = {

  }

  override def keyTyped(e: KeyEvent): Unit = ???
  override def keyReleased(e: KeyEvent): Unit = ???
}
