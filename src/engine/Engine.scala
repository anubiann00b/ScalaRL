package engine

import java.awt.event.KeyEvent

import engine.world.World
import entity.{Entity, Player, Pos}

import scala.collection.mutable
import scala.concurrent.Await
import scala.concurrent.duration.Duration

class Engine(paint: (World, List[Entity]) => Unit) {

  val world = new World()
  val entities: mutable.MutableList[Entity] = mutable.MutableList()
  val player = new Player(new Pos(5,5), '@')

  val repaint = () => paint(world, entities.toList): Unit

  entities += player

  def run(): Unit = {
    repaint()

    while(true) {
      for (entity <- entities) {
        val action = Await.result(entity.getAction(), Duration.Inf)

        for (outcome <- action.outcomes) {
          outcome.resolve(repaint)
        }
      }
    }
  }

  def keyPress(e: KeyEvent): Unit = {
    player.onKeyPress(e)
  }
}
