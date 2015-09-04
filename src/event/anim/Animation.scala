package event.anim

import asciiPanel.AsciiPanel

abstract class Animation(val duration: Int) {
  def draw(terminal: AsciiPanel, repaint: () => Unit)
}
