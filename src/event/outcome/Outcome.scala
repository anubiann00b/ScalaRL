package event.outcome

import event.anim.Animation
import ui.GameState

abstract class Outcome(val animations: List[Animation]) {

  def resolve(repaint: () => Unit, gameState: GameState): Outcome
}

class EmptyOutcome(animations: List[Animation]) extends Outcome(animations) {
  override def resolve(repaint: () => Unit, gameState: GameState): Outcome = Outcome.NONE
}

object Outcome {
  val NONE = new EmptyOutcome(List())
}
