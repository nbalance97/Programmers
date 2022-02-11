import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int[][] totalCase = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '*', '+'},
            {'-', '+', '*'},
            {'*', '+', '-'},
            {'*', '-', '+'},
    };

    public void copyArray(List<Long> targetList, int[] array) {
        targetList.clear();
        for (int element : array) {
            targetList.add((long)element);
        }
    }

    public long solution(String expression) {
        long answer = 0;
        int[] elements = toInt(expression.split("[\\*\\+-]"));
        int[] operators = extractOperators(expression);
        List<Long> elementList = new ArrayList<Long>();
        List<Long> operatorsList = new ArrayList<Long>();

        for (int[] eachCase : totalCase) {
            copyArray(elementList, elements);
            copyArray(operatorsList, operators);
            answer = Math.max(answer, Math.abs(calculate(elementList, operatorsList, eachCase)));
        }

        return answer;
    }

    private long calculate(List<Long> elementList, List<Long> operatorsList, int[] eachCase) {
        int result = 0;

        for (int op : eachCase) {
            while (operatorsList.indexOf((long)op) != -1) {
                int pos = operatorsList.indexOf((long)op);
                long e1 = elementList.remove(pos);
                long e2 = elementList.remove(pos);
                if (op == '+') {
                    elementList.add(pos, e1 + e2);
                }
                if (op == '-') {
                    elementList.add(pos, e1 - e2);
                }
                if (op == '*') {
                    elementList.add(pos, e1 * e2);
                }
                operatorsList.remove(pos);
            }
        }

        return elementList.get(0);
    }

    private int[] toInt(String[] split) {
        int[] convertIntArray = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            convertIntArray[i] = Integer.parseInt(split[i]);
        }
        return convertIntArray;
    }

    private int[] extractOperators(String expression) {
       return expression.chars()
               .filter(ch -> ch == '+' || ch == '-' || ch == '*')
               .toArray();
    }
}
