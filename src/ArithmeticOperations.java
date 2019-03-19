import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ArithmeticOperations {

    LinkedList<String> operations = new LinkedList<>();
    String numero = "";

       public ArithmeticOperations(String function) {
        for (int i = 0; i < function.length(); i++) {
            if(function.charAt(i) == '+' || function.charAt(i) == '-' ||
                    function.charAt(i) == '*' || function.charAt(i) == '/'){
                operations.addFirst(String.valueOf(function.charAt(i)));
            }else if(Character.isDigit(function.charAt(i))){
                if(function.charAt(i + 1)  == '.'){
                    numero+= Character.toString(function.charAt(i))  + Character.toString(function.charAt(i + 1))
                            + Character.toString(function.charAt(i + 2));
                    i+=3;
                }
                while (Character.isDigit(function.charAt(i))){
                    numero+= function.charAt(i);
                    i++;
                }

                operations.addFirst(numero);
                numero = "";

            }if(function.charAt(i) == ')'){
                getOperations();
            }
        }

    }

    public void getOperations() {
           try {
               LinkedList<String> orderedOperation = new LinkedList<>();
               // pasar el int result a float result = 0;
               float result = 0;
               String operator;
               while (!operations.peekFirst().equals("+") && !operations.peekFirst().equals("-") && !operations.peekFirst().equals("*")
                       && !operations.peekFirst().equals("/")) {
                   orderedOperation.addFirst(operations.removeFirst());
               }
               operator = operations.removeFirst();
               result = Float.parseFloat(String.valueOf(orderedOperation.removeFirst()));
               //result = Integer.parseFloat(String.valueOf(orderedOperation.removeFirst()));

               while (orderedOperation.size() > 0) {
                   switch (operator) {
                       //parar todos los .pparseInt a .parseFloat
                       case "+":
                           result += Float.parseFloat(orderedOperation.removeFirst());
                           break;
                       case "-":
                           result -= Float.parseFloat(orderedOperation.removeFirst());
                           break;
                       case "*":
                           result *= Float.parseFloat(orderedOperation.removeFirst());
                           break;
                       case "/":
                           result /= Float.parseFloat(orderedOperation.removeFirst());
                           break;
                   }
               }

               operations.addFirst(String.valueOf(result));

               if (operations.size() == 1) {
                   System.out.println(result);
               }


           }catch (Exception e){

           }

    }
}
