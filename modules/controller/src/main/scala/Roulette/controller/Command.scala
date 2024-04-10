package Roulette.controller

trait Command:
  def doStep(): Unit
  def undoStep(): Unit
  def redoStep(): Unit

class UndoManager:
  private var undoStack: List[Command] = Nil
  private var redoStack: List[Command] = Nil

  def doStep(command: Command): Unit =
    undoStack = command :: undoStack
    command.doStep()

  def undoStep(): Unit =
    undoStack match {
      case Nil =>
      case head :: stack => {
        head.undoStep()
        undoStack = stack
        redoStack = head :: redoStack
      }
    }

  def redoStep(): Unit =
    redoStack match {
      case Nil =>
      case head :: stack => {
        head.redoStep()
        redoStack = stack
        undoStack = head :: undoStack
      }
    }