import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;

class Op{
    private char from;
    private char to;
    private char operation;
    private int dist;

    public Op(String data) {
        this.from = data.charAt(0);
        this.to = data.charAt(2);
        this.operation = data.charAt(3);
        this.dist = data.charAt(4) - '0';
    }
    
    public void print() {
         System.out.println(this.from + "//" + this.to);
    }

    public boolean execute(HashMap<Character, Integer> pos) {
        int distance = Math.abs(pos.get(from) - pos.get(to)) - 1;
        if (operation == '=') {
            return distance == dist;
        }
        if (operation == '>') {
            return distance > dist;
        }
        if (operation == '<') {
            return distance < dist;
        }
        return false;
    }
}

class Solution {
    private HashMap<Character, Integer> characterPos = new HashMap<>();
    private HashSet<Character> character = new HashSet<>();
    private static final Character[] CHARACTER = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private int caseCount = 0;
    private Op[] operations;

    public void solve(int index) {
        if (index == 9) {
            if (check(characterPos)) {
                caseCount++;
            }
            return;
        }

        for (int i = 0; i < CHARACTER.length; i++) {
            if (!character.contains(CHARACTER[i])) {
                character.add(CHARACTER[i]);
                characterPos.put(CHARACTER[i], index);
                solve(index + 1);
                character.remove(CHARACTER[i]);
            }
        }
    }

    public boolean check(HashMap<Character, Integer> pos) {
        for (Op operation : operations) {
            if (!operation.execute(pos)) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, String[] data) {
        operations = Arrays.stream(data)
                .map(op -> new Op(op))
                .toArray(size -> new Op[size]);
        solve(1);
        return caseCount;
    }
}
