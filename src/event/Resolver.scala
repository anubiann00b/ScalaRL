package event

abstract class Resolver(animations: List[Animation]) {

  def resolve(): Unit
}
