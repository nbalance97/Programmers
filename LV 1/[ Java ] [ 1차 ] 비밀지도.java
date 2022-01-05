class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        String[] map = new String[arr1.length];
        
        for (int i = 0; i < n; i++) {
            map[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            while (map[i].length() < n)
                map[i] = "0" + map[i];
            map[i] = map[i].replace("1", "#");
            map[i] = map[i].replace("0", " ");
        }
        return map;
    }
}
