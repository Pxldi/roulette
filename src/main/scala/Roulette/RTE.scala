package Roulette

import Roulette.aview.guiComponent.guiBaseImpl.GUI
import Roulette.aview.tuiComponent.tuiBaseImpl.TUI
import Roulette.controller.controllerComponent.ControllerInterface
import Roulette.controller.controllerComponent.controllerBaseImpl.Controller
import Roulette.model.fileIOComponent.FileIOInterface
import Roulette.model.fileIOComponent.xmlImpl.FileIO
//import Roulette.model.fileIOComponent.jsonImpl.FileIO

@main
def main(): Unit =

  val fIO = new FileIO
  given FileIOInterface = fIO
  val controller = new Controller
  given ControllerInterface = controller
  controller.generateRandomNumber()
  controller.setupPlayers()
  val tui = TUI()
  val gui = GUI()

  val cliThread = new Thread(() =>
    tui.start()
    System.exit(0)
  )
  cliThread.setDaemon(true)
  cliThread.start()
