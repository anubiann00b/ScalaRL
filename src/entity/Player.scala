package entity

import java.awt.event.KeyEvent

import event.action.{MoveActionBuilder, Action}

import scala.concurrent.{Promise, Future}

class Player(_pos: Pos, glyph: Char) extends Entity(_pos, glyph) {

  var currentPromise = None: Option[Promise[Action]]

  override def getAction(): Future[Action] = {
    currentPromise = Some(Promise[Action]())
    currentPromise.get.future
  }

  override def update(): Action = null

  def onKeyPress(e: KeyEvent): Unit = {
    if (e.getKeyCode == KeyEvent.VK_A) {
      println(currentPromise.get.isCompleted)
      currentPromise.get.success(MoveActionBuilder.create(MoveActionBuilder.Dir.LEFT, this))
      println(currentPromise.get.isCompleted)
    }
  }
}
