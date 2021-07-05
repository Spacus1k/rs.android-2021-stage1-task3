package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {

        val numberOfPosters = array[0]
        val numberOfColors = array[1]
        if (numberOfPosters == numberOfColors) return 1
        if (numberOfPosters == 0) return null
        val ratioColorToPosters = factorial(numberOfColors) / numberOfPosters
        for (numberOfCombinations in 1..numberOfColors) {
            if (ratioColorToPosters ==
                factorial(numberOfColors - numberOfCombinations) * factorial(numberOfCombinations)
            ) {
                return numberOfCombinations
            }
        }
        return null
    }

    private fun factorial(number: Int): Long {
        var result = 1L
        for (i in 1..number) {
            result *= i
        }
        return result
    }
}
