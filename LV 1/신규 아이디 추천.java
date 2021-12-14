class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase();
        String temp = "";
        for (int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (('a' <= c && c <= 'z') || 
               ('0' <= c && c <= '9') ||
               (c == '.') || (c == '-') || (c == '_')) {
                temp = temp + c;
            }
        }
        
        while (true) {
            String eliminated = temp.replace("..", ".");
            if (temp.equals(eliminated)) {
                temp = eliminated;
                break;
            }
            temp = eliminated;
        }
        
        if (temp.length() > 0 && temp.charAt(0) == '.') {
            temp = temp.substring(1, temp.length());
        }
        
        if (temp.length() > 0 && temp.charAt(temp.length()-1) == '.') {
            temp = temp.substring(0, temp.length()-1);
        }
        
        if (temp.length() == 0) {
            temp = "a";
        }
        
        if (temp.length() >= 16) {
            temp = temp.substring(0, 15);
            if (temp.charAt(temp.length()-1) == '.') {
                temp = temp.substring(0, 14);
            }
        }
        
        if (temp.length() <= 2) {
            char addCharacter = temp.charAt(temp.length() - 1);
            while (temp.length() != 3) {
                temp = temp + addCharacter;
            }
        }
        
        answer = temp;
        return answer;
    }
}
