import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.IntStream;

class Solution {
  public int[] solution(String[] name, int[] yearning, String[][] photo) {

    final var score = IntStream.rangeClosed(0, name.length-1)
        .collect(
            HashMap<String, Integer>::new,
            (map, index) -> map.put(name[index], yearning[index]),
            HashMap::putAll
        );

    return Arrays.stream(photo)
        .mapToInt(eachPhoto -> Arrays.stream(eachPhoto)
            .map(it -> Optional.ofNullable(score.get(it)).orElse(0))
            .reduce(0, Integer::sum)
        )
        .toArray();
  }
}
