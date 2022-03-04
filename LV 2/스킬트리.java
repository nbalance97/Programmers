class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            String convert = convert(skillTree, skill);
            if (skill.indexOf(convert) == 0) {
                answer += 1;
            }
        }
        return answer;
    }

    private String convert(String skillTree, String skill) {
        StringBuilder sb = new StringBuilder();

        for (char ch : skillTree.toCharArray()) {
            if (isContain(skill, ch)) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private boolean isContain(String skill, char ch) {
        return skill.chars()
                .filter(c -> c == (int)ch)
                .findAny()
                .isPresent();
    }
}
