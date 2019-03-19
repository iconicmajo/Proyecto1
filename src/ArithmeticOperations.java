import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ArithmeticOperations {

    private LinkedList<String> operations = new LinkedList<>(); //Linked list used to store the Arithmetic operations
    private String numero = ""; //stores a number (when is 2 digit or longer)

    /**
     * Constructor of the class used to evaluate numbers and show a result
     * @param function
     * @pre Must be a valid function
     * @post Prints the result
     */
       public ArithmeticOperations(String function) {
        for (int i = 0; i < function.length(); i++) {
            if(function.charAt(i) == '+' || function.charAt(i) == '-' ||
                    function.charAt(i) == '*' || function.charAt(i) == '/'){
                operations.addFirst(String.valueOf(function.charAt(i))); //VERIFIES IF IT IS A MATH SYMBOL OR NOT
            }else if(Character.isDigit(function.charAt(i))){ //ENTERS ONLY IF IT IS A NUMBER
                if(function.charAt(i + 1)  == '.'){ //DECIMAL NUMBER
                    numero+= Character.toString(function.charAt(i))  + Character.toString(function.charAt(i + 1))
                            + Character.toString(function.charAt(i + 2));
                    i+=3;
                }
                while (Character.isDigit(function.charAt(i))){ //WHILE THERE IS A DIGIT NEXT TO THE CURRENT POSITION
                    numero+= function.charAt(i);
                    i++;
                }

                operations.addFirst(numero); //STORES THE SUB OPERATION INTO THE LIST
                numero = ""; //REASIGNS THE VALUE OF NUMERO

            }if(function.charAt(i) == ')'){ //IF IT IS A CLOSING BRACKET, GOES TO getOperations() method to get the result
                getOperations();
            }
        }

    }

    /**
     * Method used to obtain the result of the operation, returns nothing
     */
    private void getOperations() {
           try {
               LinkedList<String> orderedOperation = new LinkedList<>(); //List the order the numbers

               float result = 0; //Operations result
               String operator; //Operator
               while (!operations.peekFirst().equals("+") && !operations.peekFirst().equals("-") && !operations.peekFirst().equals("*")
                       && !operations.peekFirst().equals("/")) {
                   orderedOperation.addFirst(operations.removeFirst()); //Verifies if its not a operand, if it is a number it stores it into the list
               }
               operator = operations.removeFirst(); //takes off from the list the operator
               result = Float.parseFloat(String.valueOf(orderedOperation.removeFirst())); //asigns the first number to result

               //loop used to verify the operators
               while (orderedOperation.size() > 0) {
                   switch (operator) {
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

               //stores the result into the operations list
               operations.addFirst(String.valueOf(result));

               if (operations.size() == 1) {
                   System.out.println(result); //prints out the result
               }


           }catch (Exception e){

           }

    }
}
