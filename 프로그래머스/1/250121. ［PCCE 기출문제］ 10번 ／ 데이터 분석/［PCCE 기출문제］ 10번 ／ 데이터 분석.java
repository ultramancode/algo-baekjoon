import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int j = 0;

        if (ext.equals("code")) {
            j = 0;
        } else if (ext.equals("date")) {
            j = 1;
        } else if (ext.equals("maximum")) {
            j = 2;
        } else if (ext.equals("remain")) {
            j = 3;
        }

        ArrayList<int[]> answer = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            if (data[i][j] < val_ext) {
                answer.add(data[i]);
            }
        }

        // 정렬
        if (sort_by.equals("code")) {
            Collections.sort(answer, Comparator.comparingInt(a -> a[0]));
        } else if (sort_by.equals("date")) {
            Collections.sort(answer, Comparator.comparingInt(a -> a[1]));
        } else if (sort_by.equals("maximum")) {
            Collections.sort(answer, Comparator.comparingInt(a -> a[2]));
        } else if (sort_by.equals("remain")) {
            Collections.sort(answer, Comparator.comparingInt(a -> a[3]));
        }

        int[][] result = new int[answer.size()][];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
