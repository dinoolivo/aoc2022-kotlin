package day9

import java.lang.Math.pow
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

data class Position(val x: Int, val y: Int) {

    final val SQRT2 = sqrt(2f)

    fun moveRight(): Position {
        return Position(this.x + 1, this.y)
    }

    fun moveLeft(): Position {
        return Position(this.x - 1, this.y)
    }

    fun moveTop(): Position {
        return Position(this.x, this.y - 1)
    }

    fun moveBottom(): Position {
        return Position(this.x, this.y + 1)
    }

    fun moveDiagonalTopRight(): Position {
        return Position(this.x + 1, this.y - 1)
    }

    fun moveDiagonalTopLeft(): Position {
        return Position(this.x - 1, this.y - 1)
    }

    fun moveDiagonalBottomRight(): Position {
        return Position(this.x + 1, this.y + 1)
    }

    fun moveDiagonalBottomLeft(): Position {
        return Position(this.x - 1, this.y + 1)
    }

    private fun areAdjacentOrOverlapping(other: Position):Boolean{
        return sqrt((other.x - this.x).toFloat().pow(2f) + (other.y - this.y).toFloat().pow(2f)) <= SQRT2
    }

    fun positionToBeAdjacent(other: Position):Position{
        return if(areAdjacentOrOverlapping(other)){
            this
        }else{
            if(other.x > this.x && other.y < this.y) this.moveDiagonalTopRight()
            else if(other.x < this.x && other.y > this.y) moveDiagonalBottomLeft()
            else if (other.x < this.x && other.y < this.y) moveDiagonalTopLeft()
            else if(other.x > this.x && other.y > this.y) moveDiagonalBottomRight()
            else Position(((other.x + this.x)/2f).roundToInt(), ((other.y + this.y)/2f).roundToInt())
        }
    }

    override fun  toString():String = "($x,$y)"



}