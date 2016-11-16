package pl.prudnicki.gol.cli

import org.scalatest.{Matchers, WordSpec}
import pl.prudnicki.gol.Board

/**
  * Created by patry on 16.11.2016.
  */
class PrinterSpec extends WordSpec with Matchers {
  "Printer" should {
    "print correct board" in{
      val board = Board(3, 3, Array(
        Array(false, false, false),
        Array(true, true, false),
        Array(false, false, true)
      ))
      val printer = new AsciiBoardPrinter()

      val correctBoard: String = "[ ][ ][ ]\n[X][X][ ]\n[ ][ ][X]"

      printer.drawBoard(board) should equal(correctBoard)
    }
  }
}
