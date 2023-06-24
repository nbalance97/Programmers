class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0
        var f: (Int) -> Int = { i -> a + (i - 1) * d }
        for ((idx, include) in included.withIndex()) {
            if (include) {
                answer += f(idx + 1)
            }
        }

        return answer
    }
}
