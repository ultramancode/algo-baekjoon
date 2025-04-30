import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] original = new int[N];
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            original[i] = sc.nextInt();
            list.add(original[i]);
        }

        Set<Integer> set = new HashSet<>(list);
        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            map.put(sorted.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(original[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
