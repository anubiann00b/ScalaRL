package event

abstract class Action {

  def commit(): Outcome
}