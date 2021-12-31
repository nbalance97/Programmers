import java.util.Arrays;
import java.util.ArrayList;

class Stage {
    int stageNumber;
    double failRate;
    
    public Stage(int stageNumber, double failRate) {
        this.stageNumber = stageNumber;
        this.failRate = failRate;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        int[] succeed = new int[N+2];
        int[] progress = new int[N+2];
        
        for (int stage : stages) {
            succeed[stage-1] += 1;
            progress[stage] += 1;
        }
        
        for (int i = N; i>=1; i--) {
            succeed[i] += succeed[i+1];
        }
        
        ArrayList<Stage> stage = new ArrayList<Stage>();
        for (int i = 1; i<=N; i++) {
            if (succeed[i] + progress[i] == 0) {
                stage.add(new Stage(i, 0));
            } else {
                stage.add(new Stage(i, (double)(progress[i]) / (succeed[i] + progress[i])));
            }
        }
        
        stage.sort((item1, item2) -> {
            if (item1.failRate < item2.failRate) 
                return 1;
            else if (item1.failRate == item2.failRate)
                if (item1.stageNumber > item2.stageNumber)
                    return 1;
                else if (item1.stageNumber == item2.stageNumber)
                    return 0;
                else
                    return -1;
            else
                return -1;
        });
        
        answer = stage.stream()
            .mapToInt(element -> element.stageNumber)
            .toArray();
        
        return answer;
    }
}
