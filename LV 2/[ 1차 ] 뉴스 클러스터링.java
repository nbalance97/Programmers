
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public static final String BLANK = " ";

    private List<String> makeSet(String str) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            pushSubString(str, list, i);
        }

        return list;
    }

    private void pushSubString(String str, List<String> list, int index) {
        if (Character.isAlphabetic(str.charAt(index)) && Character.isAlphabetic(str.charAt(index + 1))) {
            list.add(str.substring(index, index + 2));
        }
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> str1Set = makeSet(str1.toLowerCase());
        List<String> str2Set = makeSet(str2.toLowerCase());

        double jaccard = calculateJaccard(str1Set, str2Set);
        return (int)(jaccard * 65536);
    }

    private double calculateJaccard(final List<String> str1Set, final List<String> str2Set) {
        int unionCount = getUnionCount(str1Set, str2Set);
        int interSectionCount = getIntersectionCount(str1Set, str2Set);

        if (unionCount == 0) {
            return 1;
        }
        
        return (double)interSectionCount / unionCount;
    }

    private int getIntersectionCount(List<String> str1Set, List<String> str2Set) {
        int intersectCount = 0;
        Set<String> visitCandidate = makeVisitCandidate(str1Set, str2Set);

        for (String candidate : visitCandidate) {
            intersectCount += Math.min(
                    str1Set.stream().filter(e -> e.equals(candidate)).count(),
                    str2Set.stream().filter(e -> e.equals(candidate)).count()
            );
        }

        return intersectCount;
    }

    private Set<String> makeVisitCandidate(List<String> str1Set, List<String> str2Set) {
        Set<String> visit = new HashSet<>();
        visit.addAll(str1Set);
        visit.addAll(str2Set);
        return visit;
    }

    private int getUnionCount(List<String> str1Set, List<String> str2Set) {
        int unionCount = 0;
        Set<String> visitCandidate = makeVisitCandidate(str1Set, str2Set);
        for (String element : visitCandidate) {
            unionCount += Math.max(
                    str1Set.stream().filter(e -> e.equals(element)).count(),
                    str2Set.stream().filter(e -> e.equals(element)).count()
                    );
        }
        return unionCount;
    }
}
