class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int width = 0;
        int height = 0;
        for (int[] size : sizes) {
            int maxv = Math.max(size[0], size[1]);
            int minv = Math.min(size[0], size[1]);
            width = Math.max(width, maxv);
            height = Math.max(height, minv);
        }
        answer = width * height;
        return answer;
    }
}
