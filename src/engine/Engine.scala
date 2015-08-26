package engine

import java.awt.event.KeyEvent

import engine.world.World
import entity.{Entity, Player, Pos}
import ui.{GameState, Screen}

import scala.collection.mutable
import scala.concurrent.Await
import scala.concurrent.duration.Duration

class Engine(screen: Screen) {

  val world = new World()
  val entities: mutable.MutableList[Entity] = mutable.MutableList()
  val player = new Player(new Pos(5,5), '@')

  entities += player

  def run(): Unit = {
    repaint()

    while(true) {
      for (entity <- entities) {
        println("awaiting")
        val action = Await.result(entity.getAction(), Duration.Inf)
        println("done")

        for (outcome <- action.outcomes) {
          outcome.resolve(repaint)
        }
      }
    }
  }

  def repaint(): Unit = {
    screen.requestRedraw(new GameState(world, entities.toList))
  }

  def keyPress(e: KeyEvent): Unit = {
    player.onKeyPress(e)
  }
}

object Engine {
}