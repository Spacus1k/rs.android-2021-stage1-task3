package subtask3

class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        val listOfNeighboringNumbers = mutableListOf<String>()
        if (number.toLong() < 0) return null

        for (index in number.indices) {
            val neighboringDigits = when (number[index]) {
                '1' -> arrayOf('2', '4')
                '2' -> arrayOf('1', '3', '5')
                '3' -> arrayOf('2', '6')
                '4' -> arrayOf('1', '5', '7')
                '5' -> arrayOf('2', '4', '6', '8')
                '6' -> arrayOf('3', '5', '9')
                '7' -> arrayOf('4', '8')
                '8' -> arrayOf('0', '5', '7', '9')
                '9' -> arrayOf('6', '8')
                else -> arrayOf('8')
            }
            for (neighborDigit in neighboringDigits) {
                listOfNeighboringNumbers.add(
                    number.substring(0, index) + neighborDigit + number.substring(index + 1, number.length)
                )
            }
        }
        return listOfNeighboringNumbers.toTypedArray()
    }
}
