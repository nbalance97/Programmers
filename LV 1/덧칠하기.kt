class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        
        val area = (0..100000).map { false }.toMutableList()
        val sections = section.sorted()
        
        var count = 0
        for (section in sections) {
            if (area[section]) {
                continue
            }
            
            count++
            
            for (i in section until Math.min(section + m, 100001)) {
                area[i] = true
            }
        }
        
        return count
    }
}
