package engine

import java.awt.event.KeyEvent

import asciiPanel.AsciiPanel
import engine.world.World
import entity.{Entity, Player, Pos}
import event.outcome.Outcome
import ui.GameState

import scala.collection.mutable
import scala.concurrent.Await
import scala.concurrent.duration.Duration

class Engine(terminal: AsciiPanel, paint: (GameState) => Unit) {

  val world = new World()
  val entities: mutable.MutableList[Entity] = mutable.MutableList()
  val player = new Player(new Pos(5,5), '@')

  def gameState: GameState = new GameState(world, entities.toList)

  val repaint = () => paint(gameState): Unit

  entities += player

  def run(): Unit = {
    repaint()

    while(true) {
      for (entity <- entities) {
        val action = Await.result(entity.getAction(), Duration.Inf)

        var nextOutcome: Outcome = Outcome.NONE
        for (outcome <- action.outcomes) {
          nextOutcome = outcome
          while (nextOutcome != Outcome.NONE) {
            for (anim <- nextOutcome.animations) {
              anim.draw(terminal, repaint)
            }
            nextOutcome = nextOutcome.resolve(repaint, gameState)
          }
        }
      }
    }
  }

  def keyPress(e: KeyEvent): Unit = {
    player.onKeyPress(e)
  }
}
