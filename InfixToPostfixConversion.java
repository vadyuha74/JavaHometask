import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InfixToPostfixConversion {
    static int precedence(Character ch) {

        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }

    static boolean associativityForEqualPrecedence(char ch1, char ch2) {

        List<Character> charList = Arrays.asList('+', '-', '*', '/');
        return charList.contains(ch1) || charList.contains(ch2);
    }

    private static String infixToPostfix(String exp) {

        if (exp == null || exp.isEmpty())
            return exp;
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < exp.length(); index++) {
            char ch = exp.charAt(index);
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);     
            } else if (ch == '(') { 
                stack.push(ch);
            } else if (ch == ')') {   
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty())
                    stack.pop();
                else {
                    System.out.println("Несовпадающая скобка....");
                    return null;
                }
            } else if (!stack.isEmpty()) {
                if (precedence(ch) > precedence(stack.peek())) { 
                } else if (precedence(ch) < precedence(stack.peek())) {
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                } else {
                    if (associativityForEqualPrecedence(ch, stack.peek())) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            } else if (stack.isEmpty() || stack.peek() == '(') { 
            }
        }
        if (!stack.isEmpty() && stack.search('(') != -1) {
            System.out.println("Несовпадающая скобка...");
            return null;
        }
        if (!stack.isEmpty()) {     //Rule 10
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String[] exprArray = {
                "K+L-M*N+(O^P)*W/U/V*T+Q^J^A",
                "a+b*(c^d-e)^(f+g*h)-i",
                "((a+b-c)*d^e^f)/g",
                "1+2+3*5+(6+7)+8",
                "((a-b)/c)",
                "a*b-a*b+a*b",
                "(a*b"};

        for (int index = 0; index < exprArray.length; index++) {
            System.out.println("Infix Expression: " + exprArray[index]);
            System.out.println("Postfix Expression: " + infixToPostfix(exprArray[index]));
        }
    } 
}
