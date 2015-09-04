package event.outcome

import asciiPanel.AsciiPanel
import event.anim.Animation

object MessageActionBuilder {

  def create(msg: String): Outcome = {
    val anim = new Animation(1000) {
      override def draw(terminal: AsciiPanel, repaint: () => Unit): Unit = {
        terminal.writeCenter(msg, 2)
        repaint()
      }
    }
    new EmptyOutcome(List(anim))
  }
}
