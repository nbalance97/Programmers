class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        val count = setOf(a, b, c).size
        var answer = when (count) {
            3 -> a + b + c
            2 -> (a + b + c) * (a * a + b * b + c * c)
            1 -> (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c)
            else -> 0
        }
        return answer
    }
}
