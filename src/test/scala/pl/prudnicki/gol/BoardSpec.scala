package pl.prudnicki.gol

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by patry on 09.11.2016.
  */
class BoardSpec extends WordSpec with Matchers {

  "Board with all dead cells" should {
    "not change in next generation" in {
      val board: Board = Board(4, 4, Array(
        Array(false, false, false,false),
        Array(false, false, false, false),
        Array(false, false, false, false),
        Array(false, false, false, false)
      ))

      val nextGen = board.nextGeneration

      nextGen.cells should equal(board.cells)
    }
  }

  "Board with all alive cells" should {
    "generate board with alive corners" in {
      val board: Board = Board(6, 4, Array(
        Array(true, true, true, true, true, true),
        Array(true, true, true, true, true, true),
        Array(true, true, true, true, true, true),
        Array(true, true, true, true, true, true)
      ))

      val nextGen = board.nextGeneration

      val correctBoard: Board = Board(6, 4, Array(
        Array(true, false, false, false, false, true),
        Array(false, false, false, false, false, false),
        Array(false, false, false, false, false, false),
        Array(true, false, false, false, false, true)
      ))

      nextGen.cells should equal(correctBoard.cells)
    }
  }

  "Board constructor" should {
    "generate correct board" in {
      val board: Board =  Board(4, 4, Array(
        Array(false, false, false, false),
        Array(false, false, false, false),
        Array(false, false, false, false),
        Array(false, false, false, false)
      ))

      val correctBoard:  Board = Board(4, 4, Array(
        Array(Cell(0, 0, isAlive = false), Cell(1, 0, isAlive = false), Cell(2, 0, isAlive = false), Cell(3, 0, isAlive = false)),
        Array(Cell(0, 1, isAlive = false), Cell(1, 1, isAlive = false), Cell(2, 1, isAlive = false), Cell(3, 1, isAlive = false)),
        Array(Cell(0, 2, isAlive = false), Cell(1, 2, isAlive = false), Cell(2, 2, isAlive = false), Cell(3, 2, isAlive = false)),
        Array(Cell(0, 3, isAlive = false), Cell(1, 3, isAlive = false), Cell(2, 3, isAlive = false), Cell(3, 3, isAlive = false))
      ))

      board.cells should equal(correctBoard.cells)
    }
  }

  "Board with alive corners" should {
    "generate board with all dead cells" in {
      val board: Board = Board(4, 4, Array(
        Array(true, false, false, true),
        Array(false, false, false, false),
        Array(false, false, false, false),
        Array(true, false, false, true)
      ))

      val nextGen = board.nextGeneration

      val correctBoard: Board = Board(4, 4, Array(
        Array(false, false, false,false),
        Array(false, false, false, false),
        Array(false, false, false, false),
        Array(false, false, false, false)
      ))

      nextGen.cells should equal(correctBoard.cells)
    }
  }

}
