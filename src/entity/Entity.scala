package entity

import event.action.Action

import scala.concurrent.{Promise, Future}

abstract class Entity(private var _pos: Pos, val glyph: Char) {

  def pos = _pos
  def pos_= (value:Pos):Unit = _pos = value

  def update(): Action
  def getAction(): Future[Action] = {
    val promise = Promise[Action]()
    promise.success(update())
    promise.future
  }
}
