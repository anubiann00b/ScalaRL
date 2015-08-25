package entity

import event.Action

abstract class Entity {

  def update(): Action
}
