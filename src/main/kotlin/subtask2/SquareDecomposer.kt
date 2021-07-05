package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 5) return null
        return secondaryDecompose(number * number, number - 1)
    }

    private fun secondaryDecompose(square: Int, reducedNumber: Int): Array<Int>? {
        for (i in reducedNumber downTo 1) {
            val residue = square - i * i
            when {
                residue == 0 -> return arrayOf(i)
                residue < 0 -> return null
            }
            val possibleNext = sqrt(residue.toDouble()).toInt()
            val nextVal = if (possibleNext >= i) {
                secondaryDecompose(residue, i - 1)
            } else {
                secondaryDecompose(residue, possibleNext)
            }
            if (!nextVal.isNullOrEmpty()) return nextVal + arrayOf(i)
        }
        return null
    }
}
