package event.action

import entity.{Pos, Entity}
import event.outcome.{MessageActionBuilder, Outcome}
import ui.GameState

object MoveActionBuilder {

  case class Dir(x: Int, y: Int)
  object NW extends Dir(-1, -1)
  object N extends Dir(0, -1)
  object NE extends Dir(1, -1)
  object W extends Dir(-1, 0)
  object NONE extends Dir(0, 0)
  object E extends Dir(1, 0)
  object SW extends Dir(-1, 1)
  object S extends Dir(0, 1)
  object SE extends Dir(1, 1)

  def create(dir: Dir, entity: Entity): Action = {
    new Action(List(new Outcome(List()) {
      override def resolve(repaint: () => Unit, gameState: GameState): Outcome = {
        val destPos = new Pos(entity.pos.x+dir.x, entity.pos.y+dir.y)
        if (gameState.world.getTile(destPos).passable) {
          entity.pos = destPos
          repaint()
          Outcome.NONE
        } else {
          MessageActionBuilder.create("Can't move there!")
        }
      }
    }))
  }
}
