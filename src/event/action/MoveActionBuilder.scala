package event.action

import entity.{Pos, Entity}
import event.Outcome

object MoveActionBuilder {

  sealed abstract class DirBase
  case class Dir(x: Int, y: Int)
  object N extends Dir(0, -1)
  object NE extends Dir(1, -1)
  object E extends Dir(1, 0)
  object SE extends Dir(1, 1)
  object S extends Dir(0, 1)
  object SW extends Dir(-1, 1)
  object W extends Dir(-1, 0)
  object NW extends Dir(-1, -1)

  def create(dir: Dir, entity: Entity): Action = {
    new Action(List(new Outcome(List()) {
      override def resolve(repaint: () => Unit): Unit = {
        val destPos = new Pos(entity.pos.x+dir.x, entity.pos.y+dir.y)
        entity.pos = destPos
        repaint()
      }
    }))
  }
}
