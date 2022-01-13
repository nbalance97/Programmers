class Solution {
    public int search(String[] list, String name) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
    
    public String solution(String[] seoul) {
        String answer = "";
        int index = search(seoul, "Kim");
        answer = "김서방은 " + index + "에 있다";
        return answer;
    }
}
