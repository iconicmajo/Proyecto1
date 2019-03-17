import java.util.LinkedList;
import java.util.Stack;

public class ArithmeticOperations {

    LinkedList<String> operations = new LinkedList<>();

    public ArithmeticOperations(String function) {
        for (int i = 0; i < function.length(); i++) {
            if(function.charAt(i) == '+' || function.charAt(i) == '-' ||
                    function.charAt(i) == '*' || function.charAt(i) == '/'){
                operations.addFirst(String.valueOf(function.charAt(i)));
            }else if(Character.isDigit(function.charAt(i))){
                operations.addFirst(String.valueOf(function.charAt(i)));
            }else if(function.charAt(i) == ')'){
                getOperations();
                break;
            }
        }

       // operations.forEach(s -> System.out.println(s));
        //System.out.println(getOperations());
    }

    public int getOperations() {
        System.out.println(operations.peekFirst());

        return 0;
    }
}
