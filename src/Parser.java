import java.util.LinkedList;
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
    private Stack<String> type = new Stack<>();
    private Stack<String> predicates = new Stack<>();
    private String tempFunction = "";
    private int numberA = 0, numberB = 0;
    private int bracketsComparatorRight= 0;
    private int bracketsComparatorLeft = 0;
    private LinkedList<Integer> result = new LinkedList<>();

    public Integer arithmeticOperations(String function) {

        boolean inFunction = false;
        int total = 0;
        for (int i = 1; i < function.length(); i++) {
            if (function.charAt(i) == '+' || function.charAt(i) == '-' || function.charAt(i) == '*' || function.charAt(i) == '/') {
                operator.push(Character.toString(function.charAt(i)));
            }
            if (function.charAt(i) == '(') {
                bracketsComparatorRight++;
                inFunction = true;

                for (int j = function.charAt(i); function.charAt(i) != ')' ; i++) { //AKI ESTA EL BUG
                    if(function.charAt(i) == '+' || function.charAt(i) == '*') {
                        operator.push(Character.toString(function.charAt(i)));
                    }

                    if(Character.isDigit(function.charAt(i))){
                        operands.addLast(Integer.parseInt(Character.toString(function.charAt(i))));
                    }
                    tempFunction += function.charAt(i);
                }


            } else if (function.charAt(i) == ')') {
                bracketsComparatorLeft++;
                if(bracketsComparatorRight == bracketsComparatorLeft) {
                    int tempSize = result.size();
                    while (result.size() != 0) {
                        switch (operator.peek()) {
                            case "+":
                                total += Calculator.addition(result.pop(), result.pop());
                                break;
                            case "-":
                                total -= Calculator.addition(result.pop(), result.pop());
                                break;
                            case "/":
                                total /= Calculator.addition(result.pop(), result.pop());
                                break;
                            case "*":
                                total += Calculator.addition(result.pop(), result.pop());
                                break;
                        }
                    }
                }else {
                    result.addFirst(doFunction(tempFunction)); //verify
                    operator.pop();
                    tempFunction = "";

                }
            }else if(Character.isDigit(function.charAt(i))){
                operands.addLast(Integer.parseInt(Character.toString(function.charAt(i))));
            }
        }
        return total;
    }

    private Integer doFunction(String tempFunction) {
        int result = 0;
        int size = operands.size();
        while (operands.size() > 0) {
            numberA = operands.removeFirst();
            if (operands.size() > 0) {
                numberB = operands.removeFirst();
            } else {
                numberB = 1;
            }

            switch (operator.peek()) {
                case "+":
                    numberB = 0;
                    result += Calculator.addition(numberA, numberB);
                    return result;
                case "-":
                    numberB = 0;
                    result -= Calculator.subtraction(numberA, numberB);
                    return result;
                case "*":
                    if(size - 2 == operands.size()){
                        result = 1;
                    }

                    result *= Calculator.multiplicaction(numberA, numberB);
                    break;
                case "/":
                    numberB = 1;
                    result /= Calculator.division(numberA, numberB);
                    return result;
            }


        }
        return result;
    }

    public boolean PredicateVerification(String predicate){

        boolean lista = false;
       String predicado = predicate.replace("(", " ");
       predicado = predicado.replace(")", " ");

       if (predicado.contains("'")){
           predicado = predicado.replace("'", " ");
           lista = true;
       }

       String tipos[] = predicado.split(" ");

        // Verificar si el primer signo de lo que se quiera verificar sea uno de los predicado disponibles
        if (predicado.contains("atom") || predicado.contains("equal") || predicado.contains("listp") || predicado.contains("<") || predicado.contains(">")) {
            type.push(tipos[0]);
        }

        // Ir metiendo los numeros o signos que hayan metido en el HashMap
        for(int i  = 1; i < tipos.length; i ++) {
            predicates.push(tipos[i]);
        }

        // Verificar si el tipo de predicado es atom, equal, list, <, > y luego hacer las comparaciones
        int numA;
        int numB;
        boolean result = true;

        switch(type.peek()) {
            case "atom":
                if (tipos.length < 1){
                    result = false;
                }

                else {
                    result = true;
                }
                break;

            case "equal":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA == numB) result = true;

                else {
                    result = false;
                }
                break;

            case "listp":
                if (lista == true) {
                    result = true;
                }

                else {
                    result = false;
                }
                break;

            case "<":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA < numB) result = true;

                else {
                    result = false;
                }
                break;

            case ">":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA > numB) result = true;


                else {
                    result = false;
                }
                break;
        }
        return result;
    }
}



