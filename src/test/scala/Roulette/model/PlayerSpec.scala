package Roulette.controller

import Roulette.controller.controllerComponent.State.{IDLE, State}
import Roulette.controller.controllerComponent.controllerBaseImpl.Controller

import Roulette.model.Bet
import Roulette.model.Player

import scala.io.StdIn.readLine
import scala.collection.immutable.VectorBuilder
import org.scalactic.Equality
import org.scalactic.TolerantNumerics
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.matchers.should
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.EitherValues
import org.scalactic.TripleEquals.unconstrainedEquality

import scala.Console.in

class PlayerSpec extends AnyWordSpec with should.Matchers with TypeCheckedTripleEquals {

}
