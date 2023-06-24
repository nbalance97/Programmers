class Solution {
    fun solution(code: String): String {
        var mode = 0
        var result = ""
        code.forEachIndexed { idx, ch ->
            when (ch) {
                '1' -> if (mode == 0) mode = 1 else mode = 0
                else -> {
                    if (idx % 2 == 0 && mode % 2 == 0) {
                        result += ch
                    }
                    if (idx % 2 == 1 && mode % 2 == 1) {
                        result += ch
                    }
                }
            }
        }

        return if (result.isNullOrEmpty()) "EMPTY" else result
    }
}
