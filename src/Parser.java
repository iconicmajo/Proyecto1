import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * AMADO GARCIA 181469
 * Maria Jose Castro 181202
 * Luis Pedro Cuellar 18220
 * LISP INTERPRETER - PROJECT 1 DATA STRUCTURES
 * ING. DOUGLAS BARRIOS
 */

public class Parser {

    private Stack<String> operator = new Stack<>();
    private LinkedList<Integer> operands = new LinkedList<>();
    private String tempFunction = "";
    private int numberA = 0, numberB = 0;

    public Integer arithmeticOperations(String function) {

        int result = 0;
        boolean inFunction = false;

        for (int i = 1; i < function.length(); i++) {
            if (function.charAt(i) == '+' || function.charAt(i) == '-' || function.charAt(i) == '*' || function.charAt(i) == '/') {
                operator.push(Character.toString(function.charAt(i)));
            }
            if (function.charAt(i) == '(') {
                inFunction = true;
                tempFunction+= function.charAt(i);
                i++;
                for (int j = function.charAt(i); function.charAt(i) != ')' && function.charAt(i) != '(' ; i++) {
                    tempFunction+= function.charAt(i);
                }
                if(function.charAt(i) == '(') {
                    operator.push(tempFunction);
                }else {
                    doFunction(tempFunction);

                }
            }else{
                if(Character.isDigit(function.charAt(i))){
                    operands.addLast(Integer.parseInt(Character.toString(function.charAt(i))));
                }
            }

            if(function.charAt(i) == ')'){
                int size = operands.size();
                while (operands.size() > 0) {
                    numberA = operands.removeFirst();
                    if(operands.size() > 0){
                        numberB = operands.removeFirst();
                    }else{
                        switch (operator.peek()){
                            case "+":  numberB = 0; result +=        Calculator.addition(numberA, numberB); return result;
                            case "-":  numberB = 0; result -=     Calculator.subtraction(numberA, numberB); return result;
                            case "*":  numberB = 1; result *= Calculator.multiplicaction(numberA, numberB); return result;
                            case "/":  numberB = 1; result /=        Calculator.division(numberA, numberB); return result;
                        }

                    }

                    switch (operator.peek()){
                        case "+": result +=        Calculator.addition(numberA, numberB); break;
                        case "-": result -=     Calculator.subtraction(numberA, numberB); break;
                        case "*": result *= Calculator.multiplicaction(numberA, numberB); break;
                        case "/": result /=        Calculator.division(numberA, numberB); break;
                    }
                }
            }
        }
            return result;
    }

    private Integer doFunction(String tempFunction){

        return 0;
    }
}



