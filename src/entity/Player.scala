package entity

import java.awt.event.KeyEvent

import event.action.{MoveActionBuilder, Action}

import scala.collection.immutable.HashMap
import scala.concurrent.{Promise, Future}

class Player(_pos: Pos, glyph: Char) extends Entity(_pos, glyph) {

  var currentPromise = None: Option[Promise[Action]]

  override def getAction(): Future[Action] = {
    currentPromise = Some(Promise[Action]())
    currentPromise.get.future
  }

  override def update(): Action = null

  def onKeyPress(e: KeyEvent): Unit = {
    def getAction(): Action = {
      val key = e.getKeyCode
      if (Player.MOVEMENT_MAP.contains(key)) {
        MoveActionBuilder.create(Player.MOVEMENT_MAP.get(key).get, this)
      } else {
        null
      }
    }

    val action = getAction()
    if (action != null) {
      currentPromise.get.success(action)
    }
  }
}

object Player {
  val MOVEMENT_MAP = HashMap[Int, MoveActionBuilder.Dir](
    KeyEvent.VK_RIGHT -> MoveActionBuilder.E,
    KeyEvent.VK_UP -> MoveActionBuilder.N,
    KeyEvent.VK_LEFT -> MoveActionBuilder.W,
    KeyEvent.VK_DOWN -> MoveActionBuilder.S,
    KeyEvent.VK_Y -> MoveActionBuilder.NW,
    KeyEvent.VK_U -> MoveActionBuilder.NE,
    KeyEvent.VK_B -> MoveActionBuilder.SW,
    KeyEvent.VK_N -> MoveActionBuilder.SE,
    KeyEvent.VK_H -> MoveActionBuilder.W,
    KeyEvent.VK_L -> MoveActionBuilder.E,
    KeyEvent.VK_K -> MoveActionBuilder.N,
    KeyEvent.VK_J -> MoveActionBuilder.S
  )
}