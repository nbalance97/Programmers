import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public ArrayList<String> extractSetList(String s) {
        String regex = "\\{[0-9|,]+\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        String target = s.substring(1, s.length()-1);
        ArrayList<String> setList = new ArrayList<String>();
        while (matcher.find()) {
            setList.add(matcher.group());
        }
        return setList;
    }

    public Set<String>[] extract(String s) {
        ArrayList<String> setList = extractSetList(s);
        return setList.stream()
                .map(p -> {
                    p = p.substring(1, p.length()-1);
                    String[] setInformation = p.split(",");
                    return new HashSet(Arrays.asList(setInformation));
                })
                .toArray(i -> new HashSet[i]);
    }

    public int[] solution(String s) {
        List<String> answer = new ArrayList<String>();
        Set<String> currentSet = new HashSet<>();

        Set<String>[] sets = extract(s);

        Arrays.sort(sets, (p1, p2) -> {
           return Integer.compare(p1.size(), p2.size());
        });

        for (Set<String> targetSet : sets) {
            targetSet.removeAll(currentSet);
            String targetElement = targetSet.iterator().next();
            answer.add(targetElement);
            currentSet.addAll(targetSet);
        }

        return answer.stream()
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();
    }


}
