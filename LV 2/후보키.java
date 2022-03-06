import java.util.*;
import java.util.stream.Collectors;

class Solution {

    List<List<Integer>> sequences = new ArrayList<>();

    public void getListCombination(List<List<Integer>> saved, List<Integer> target, List<Integer> current, int i) {
        if (i == target.size()) {
            saved.add(List.copyOf(current));
            return;
        }

        current.add(target.get(i));
        getListCombination(saved, target, current, i + 1);
        current.remove(current.size() - 1);

        getListCombination(saved, target, current, i + 1);
    }

    public void getSequences(List<Integer> list, int max, int i) {
        if (i == max) {
            sequences.add(List.copyOf(list));
            return;
        }
        list.add(i);
        getSequences(list, max, i + 1);
        list.remove(list.size() - 1);

        getSequences(list, max, i + 1);
    }

    public int solution(String[][] relation) {
        int answer = 0;
        Set<List<Integer>> visited = new HashSet<>();
        getSequences(new ArrayList<>(), relation[0].length, 0);
        sequences.sort((p1, p2) -> Integer.compare(p1.size(), p2.size()));
        sequences.remove(0);

        for (List<Integer> sequence : sequences) {
            if (isContain(visited, sequence)) {
                continue;
            }

            Set<Column> set = new HashSet<>();
            for (String[] eachRelation : relation) {
                set.add(new Column(eachRelation, sequence));
            }


            if (relation.length == set.size()) {
                visited.add(List.copyOf(sequence));
                System.out.println(sequence);
                answer += 1;
            }
        }

        return answer;
    }

    private boolean isContain(Set<List<Integer>> visited, List<Integer> sequence) {
        List<List<Integer>> combinations = new ArrayList<>();
        getListCombination(combinations, sequence, new ArrayList<>(), 0);
        combinations.sort((p1, p2) -> Integer.compare(p1.size(), p2.size()));
        combinations.remove(0);

        for (List<Integer> list : combinations) {
            if (visited.contains(list)) {
                return true;
            }
        }

        return false;
    }
}

class Column {

    private List<String> datas;

    public Column(String[] relation, List<Integer> sequence) {
        datas = sequence.stream()
                .map(i -> relation[i])
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return Objects.equals(datas, column.datas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datas);
    }
}
