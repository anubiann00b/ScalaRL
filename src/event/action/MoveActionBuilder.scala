package event.action

import entity.{Pos, Entity}
import event.Outcome

object MoveActionBuilder {

  object Dir extends Enumeration {
    type Margin = Value
    val RIGHT, UP, LEFT, DOWN = Value
  }

  def create(dir: Dir.Value, entity: Entity): Action = {
    new Action(List(new Outcome(List()) {
      override def resolve(repaint: () => Unit): Unit = {
        val oldPos: Pos = entity.pos
        println(oldPos.x)
        dir match {
          case Dir.RIGHT => entity.pos = new Pos(oldPos.x+1, oldPos.y)
          case Dir.UP => entity.pos = new Pos(oldPos.x, oldPos.y-1)
          case Dir.LEFT => entity.pos = new Pos(oldPos.x-1, oldPos.y)
          case Dir.DOWN => entity.pos = new Pos(oldPos.x, oldPos.y+1)
          case default =>
        }
        repaint()
      }
    })) {}
  }
}
