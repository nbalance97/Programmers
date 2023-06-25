class Solution {

    fun toDay(dateString: String) = (dateString.substring(0, 4).toInt() * 28 * 12) +
            (dateString.substring(5, 7).toInt() * 28) +
            (dateString.substring(8, 10).toInt())

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val todaysDay = toDay(today)

        val termMatrix = terms.associateBy(
            { it.split(" ")[0] },
            { it.split(" ")[1].toInt() * 28 }
        )

        return privacies.withIndex()
            .filter { (idx, privacy) ->
                val command = privacy.split(" ")
                val endDate = toDay(command[0]) + (termMatrix[command[1]] ?: 0)

                println("${idx}, ${privacy}, ${endDate >= todaysDay}, ${endDate}")
                endDate <= todaysDay
            }
            .map { (idx, _) -> idx + 1 }
            .toIntArray()
    }
}
