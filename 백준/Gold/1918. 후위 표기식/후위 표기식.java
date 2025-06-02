
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String trimString = br.readLine().trim();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : trimString.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            } else { 
                while (!stack.isEmpty() && rank(stack.peek()) >= rank(ch)) {
                    // 얘는 위에 ')'에서 처리
                    if (stack.peek() == '(') {
                        break;
                    }
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        System.out.println(result.toString());
    }

    private static int rank(char op) {
        if (op == '(') {
            return 0;
        }
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return -1;
    }
}