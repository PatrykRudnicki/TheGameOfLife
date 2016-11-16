package pl.prudnicki.gol.cli

import pl.prudnicki.gol.{Board, BoardPrinter, Cell}
import AsciiBoardPrinter._

/**
  * Created by patry on 26.10.2016.
  */
class AsciiBoardPrinter extends BoardPrinter {



  override def print(board: Board): Unit = {
   // board.cells.foreach { row =>
     // row.foreach { cell =>
     //   Predef.print(drawCell(cell))
    //  }
    //  Predef.println()
    //}

    Predef.println(drawBoard(board))
  }

  protected[cli] def drawBoard(board: Board): String = board.cells.map { row =>
    row.map(drawCell).mkString
  }.mkString("\n")

  protected[cli] def drawCell(cell: Cell): String =
    s"[${if (cell.isAlive) AliveSymbol else DeadSymbol}]"


}

object AsciiBoardPrinter {
  val AliveSymbol = "X"
  val DeadSymbol = " "
}

object TestPrinter {
  def main(args: Array[String]) {
//    val board = Board(4, 4, Array(
//      Array(Cell(0, 0, isAlive = false), Cell(0, 1, isAlive = false), Cell(0, 2, isAlive = false), Cell(0, 3, isAlive = false)),
//      Array(Cell(1, 0, isAlive = true), Cell(1, 1, isAlive = true), Cell(1, 2, isAlive = true), Cell(1, 3, isAlive = false)),
//      Array(Cell(2, 0, isAlive = false), Cell(2, 1, isAlive = false), Cell(2, 2, isAlive = false), Cell(2, 3, isAlive = false)),
//      Array(Cell(3, 0, isAlive = false), Cell(3, 1, isAlive = false), Cell(3, 2, isAlive = false), Cell(3, 3, isAlive = true))
//    ))

    val board = Board(4, 4, Array(
      Array(false, false, false,false),
      Array(true, true, true, false),
      Array(false, false, false, false),
      Array(false, false, false, true)
    ))

    val printer = new AsciiBoardPrinter()

    printer.print(board)
    Predef.println()

    val board2 = board.nextGeneration
    printer.print(board2)
  }
}

/*
  [ ][X][ ]
 */