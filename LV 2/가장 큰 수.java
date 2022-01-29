import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Element {
    int value;
    int realValue;

    public Element(int realValue, int value) {
        this.realValue = realValue;
        this.value = value;
    }
}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<Element> elementList = Arrays.stream(numbers)
                .mapToObj(n -> {
                    String numStr = Integer.toString(n);
                    int idx = 0;
                    int value = 0;
                    while (idx < 4) {
                        value *= 10;
                        value += (Character.digit(numStr.charAt((idx++) % numStr.length()), 10));
                    }
                    return new Element(n, value);
                })
                .collect(Collectors.toList());

        elementList.sort((p1, p2) -> {
            if (p1.value < p2.value) {
                return 1;
            } else if (p1.value == p2.value) {
                return Integer.compare(Integer.toString(p1.realValue).length(),
                        Integer.toString(p2.realValue).length());
            } else {
                return -1;
            }
        });

        for (Element e : elementList) {
            answer += e.realValue;
        }

        if (answer.charAt(0) == '0')
            return "0";
        return answer;
    }
}
