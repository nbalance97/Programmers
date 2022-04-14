import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Job implements Comparable<Job> {

    int arriveTime;
    int duration;

    public Job(int arriveTime, int duration) {
        this.arriveTime = arriveTime;
        this.duration = duration;
    }

    @Override
    public int compareTo(Job o) {
        if (this.duration > o.duration) {
            return 1;
        }
        if (this.duration == o.duration) {
            return -Integer.compare(this.arriveTime, o.arriveTime);
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Job{" +
                "arriveTime=" + arriveTime +
                ", duration=" + duration +
                '}';
    }
}

class Solution {

    public int solution(int[][] jobs) {
        int jobIndex = 0;
        int totalTime = 0;
        int endTime = 0;

        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Job> heap = new PriorityQueue<>();

        for (int time = 0; time <= 1000001; time++) {
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                heap.offer(new Job(jobs[jobIndex][0], jobs[jobIndex][1]));
                jobIndex++;
            }
            if (time >= endTime && !heap.isEmpty()) {
                Job job = heap.poll();
                endTime = time + job.duration;
                totalTime += (time + job.duration) - job.arriveTime;
            }
        }

        return totalTime / jobs.length;
    }
}
