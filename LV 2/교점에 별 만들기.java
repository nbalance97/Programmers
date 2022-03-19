class Solution {

    public String[] solution(int[][] line) {
        long[] xSize = new long[]{10000000001L, -10000000001L};
        long[] ySize = new long[]{10000000001L, -10000000001L};

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                calculate(xSize, ySize, line[i], line[j]);
            }
        }

        if (xSize[1] - xSize[0] < 0 || ySize[1] - ySize[0] < 0) {
            return new String[]{};
        }


        String[] answer = new String[(int)(ySize[1] - ySize[0] + 1)];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < xSize[1] - xSize[0] + 1; i++)
            sb.append(".");

        for (int i = 0; i < ySize[1] - ySize[0] + 1; i++) {
            answer[i] = sb.toString();
        }

        for (int i = 0; i < line.length; i++) {
            for (int j = 0; j < line.length; j++) {
                fill(answer, xSize[0], ySize[1], line[i], line[j]);
            }
        }

        return answer;
    }

    private void fill(String[] answer, long minX, long maxY, int[] line1, int[] line2) {
        long denominator = getDenominator(line1, line2);
        long x = ((long)line1[1] * (long)line2[2] - (long)line1[2] * (long)line2[1]);
        long y = ((long)line1[2] * (long)line2[0] - (long)line1[0] * (long)line2[2]);

        if (denominator == 0) {
            return;
        }

        if (x % denominator == 0 && y % denominator == 0) {
            int cx = (int)(x / denominator - minX);
            int cy = (int)(maxY - y / denominator);
            answer[cy] = answer[cy].substring(0, cx) + "*"
                    + answer[cy].substring(cx + 1);
        }
    }

    private long getDenominator(int[] line1, int[] line2) {
        return (long)line1[0] * (long)line2[1] - (long)line1[1] * (long)line2[0];
    }

    private void calculate(long[] xSize, long[] ySize, int[] line1, int[] line2) {
        long denominator = getDenominator(line1, line2);
        long x = ((long)line1[1] * line2[2] - (long)line1[2] * line2[1]);
        long y = ((long)line1[2] * line2[0] - (long)line1[0] * line2[2]);

        if (denominator == 0) {
            return;
        }

        if (x % denominator == 0 && y % denominator == 0) {
            long px = x / denominator;
            long py = y / denominator;
            xSize[1] = Math.max(xSize[1], px);
            xSize[0] = Math.min(xSize[0], px);
            ySize[0] = Math.min(ySize[0], py);
            ySize[1] = Math.max(ySize[1], py);
        }
    }
}
