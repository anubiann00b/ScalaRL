package engine

import engine.world.World
import entity.Entity
import ui.Screen

import scala.collection.mutable

class Engine(screen: Screen) {

  val world = new World()
  val list: mutable.MutableList[Entity] = mutable.MutableList()

  def run(): Unit = {
    while(true) {
      val startTime = System.currentTimeMillis()

      screen.repaint(world)
      world.shuffle()

      val elapsedTime = System.currentTimeMillis() - startTime
      println(elapsedTime)
      Thread.sleep(Engine.FRAME_MS - elapsedTime)
    }
  }
}

object Engine {
  val FRAME_MS = 1000
}