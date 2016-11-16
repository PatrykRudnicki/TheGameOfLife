package pl.prudnicki.gol

/**
  * Created by patry on 19.10.2016.
  */
case class Board(width: Int, height: Int, cells: Array[Array[Cell]]) {

  def nextGeneration: Board = {
    val newCells: Array[Array[Cell]] = cells.map { row =>
      row.map { cell =>
        cell.copy(isAlive = shouldBeAliveInNextGen(cell))
      }.toArray
    }
    copy(cells = newCells)
  }

  private def countLiveNeighbors(cell: Cell): Int =
    neighborsOf(cell).count(_.isAlive == true)


  // According to the Conway rule
  private def shouldBeAliveInNextGen(cell: Cell): Boolean = {
    countLiveNeighbors(cell) match{
      case 3 if !cell.isAlive => true
      case 2 | 3 if cell.isAlive => true
      case _ => false
    }
  }

  private def neighborsOf(cell: Cell): Seq[Cell] = {
    for {
      x <- (cell.x - 1) to (cell.x + 1)
      y <- (cell.y - 1) to (cell.y + 1)
      if x != cell.x || cell.y != y
    } yield cellAtPos(x, y)
  }.flatten

  private def boardContains(x: Int, y: Int): Boolean =
    x >= 0 && x < width && y >= 0 && y < height

  private def cellAtPos(x: Int, y: Int): Option[Cell] =
    if (boardContains(x, y)) Some(cells(y)(x))
    else None

}

object Board {
  def apply(w: Int, h: Int, matrix: Array[Array[Boolean]]): Board = {
    val board: Array[Array[Cell]] = matrix.zipWithIndex.map {
      case (row, y) => row.zipWithIndex.map {
        case (isAlive, x) => Cell(x, y, isAlive)
      }.toArray
    }.toArray

    Board(w, h, board)
  }

}

// [ ][ ][ ]
// [ ][X][ ]
// [ ][ ][ ]