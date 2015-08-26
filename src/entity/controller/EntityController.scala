package entity.controller

import engine.world.World
import entity.Entity

abstract class EntityController() {

  def update(entity: Entity, world: World): Unit
}
