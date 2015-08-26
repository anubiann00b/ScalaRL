package event

abstract class Outcome(animations: List[Animation], val time: Int = Outcome.DEFAULT_ACTION_TIME) {

  def resolve(repaint: () => Unit): Unit
}

object Outcome {
  val DEFAULT_ACTION_TIME = 100
}
