package Roulette.controller.controllerComponent

import Roulette.core.{Bet, Player}
import State.*
import Roulette.utility.Observable

trait ControllerInterface extends Observable:
  var randomNumber: Int
  def setupPlayers(): Unit
  def updatePlayer(player_index: Int, money: Int): Unit
  def getPlayers(): Vector[Player]
  def changeMoney(player_index: Int, money: Int, add: Boolean): Unit
  def checkGameEnd(): Unit
  def undo(): Unit
  def redo(): Unit
  def save(): Unit
  def load(): Unit
  def quit(): Unit
  def createAndAddBet(playerIndex: Int, betType: String, value: Option[Int], oddOrEven: Option[String], color: Option[String], betAmount: Int): Boolean
  def addBet(bet: Bet): Boolean
  def calculateBets(): Vector[String]
  def generateRandomNumber(): Unit
  def winBet(playerIndex: Int, bet: Int, winRate: Int, randomNumber: Int): Either[String, String]
  def loseBet(playerIndex: Int, bet: Int, randomNumber: Int): Either[String, String]
  def changeState(state: State): Unit
  def getState: State
  def printState(): String
  def num(bet: Bet): String
  def evenOdd(bet: Bet): String
  def color(bet: Bet): String