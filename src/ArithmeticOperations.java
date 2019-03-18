import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ArithmeticOperations extends Defun {

    LinkedList<String> operations = new LinkedList<>();

    public ArithmeticOperations(String function) {
        for (int i = 0; i < function.length(); i++) {
            if(function.charAt(i) == '+' || function.charAt(i) == '-' ||
                    function.charAt(i) == '*' || function.charAt(i) == '/'){
                operations.addFirst(String.valueOf(function.charAt(i)));
            }else if(Character.isDigit(function.charAt(i))){
                if(Character.isDigit(function.charAt(i + 1))){
                    operations.addFirst(Character.toString(function.charAt(i)) + function.charAt(i + 1));
                    i++;
                }else{
                    operations.addFirst(String.valueOf(function.charAt(i)));
                }

            }else if(function.charAt(i) == ')'){
                getOperations();
            }
        }

    }

    public void getOperations() {
        LinkedList<String> orderedOperation = new LinkedList<>();
        int result = 0;
        String operator;
        while (!operations.peekFirst().equals("+") && !operations.peekFirst().equals("-") && !operations.peekFirst().equals("*")
        && !operations.peekFirst().equals("/")){
            orderedOperation.addFirst(operations.removeFirst());
        }
        operator = operations.removeFirst();
        result = Integer.parseInt(String.valueOf(orderedOperation.removeFirst()));

        while (orderedOperation.size() > 0){
            switch (operator){
                case "+":  result += Integer.parseInt(orderedOperation.removeFirst()); break;
                case "-":  result -= Integer.parseInt(orderedOperation.removeFirst()); break;
                case "*":  result *= Integer.parseInt(orderedOperation.removeFirst()); break;
                case "/":  result /= Integer.parseInt(orderedOperation.removeFirst()); break;
            }
        }

        operations.addFirst(String.valueOf(result));

        if(operations.size() == 1){
            System.out.println(result);
        }




    }
}
