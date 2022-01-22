import java.util.*;

class Solution {


    public void setReportedUser(String[] reports, Map<String, Set<String>> reportedUser,
                                                    Map<String, Set<String>> reportUser) {
        for (String report : reports) {
            String[] log = report.split(" ");
            String from = log[0];
            String to = log[1];
            if (reportedUser.get(to) == null) {
                reportedUser.put(to, new HashSet<>());
            }
            if (reportUser.get(from) == null) {
                reportUser.put(from, new HashSet<>());
            }
            reportedUser.get(to).add(from);
            reportUser.get(from).add(to);
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedUser = new HashMap<>();
        Map<String, Set<String>> reportUser = new HashMap<>();
        setReportedUser(report, reportedUser, reportUser);

        int[] answer = Arrays.stream(id_list)
                .mapToInt(id -> {
                    int call = 0;
                    if (reportUser.get(id) == null)
                        return 0;
                    for (String target : reportUser.get(id)) {
                        if (reportedUser.get(target).size() >= k) {
                            call++;
                        }
                    }
                    return call;
                })
                .toArray();
        return answer;
    }
}
