import java.util.LinkedList;
import java.util.Stack;

public class ArithmeticOperations {

    private Stack<String> operator = new Stack<>();
    private LinkedList<Integer> operands = new LinkedList<>();
    private LinkedList<Integer> result = new LinkedList<>();
    private String tempFunction = "";
    private Stack<String> tempFunctionStack = new Stack<>();
    private int tempFunctionSize;
    private String currentOperator;
    private boolean assignationNotActive = false;
    private int total;
    private boolean consecutiveOperation = false;

    public ArithmeticOperations(String function) {
        int functionSize = function.length();
        int functionCounter = 0;
        String number = "";
        while (true) {

            if (Character.isDigit(function.charAt(functionCounter))) {
                if (Character.isDigit(function.charAt(functionCounter + 1))) {
                    String twoDigits = Character.toString(function.charAt(functionCounter)) + Character.toString(function.charAt(functionCounter + 1));
                    if (function.charAt(functionCounter + 2) == '(') {
                        operands.addFirst(Integer.parseInt(twoDigits));
                    } else {
                        operands.addLast(Integer.parseInt(twoDigits));
                    }

                    functionCounter++;
                } else {
                    try {
                        if (function.charAt(functionCounter + 2) == '(' || function.charAt(functionCounter + 1) == '(') {
                            operands.addFirst(Integer.parseInt(Character.toString(function.charAt(functionCounter))));
                        } else {
                            operands.addLast(Integer.parseInt(Character.toString(function.charAt(functionCounter))));

                        }
                        tempFunction += function.charAt(functionCounter) + " ";

                    } catch (Exception e) {
                        operands.addLast(Integer.parseInt(Character.toString(function.charAt(functionCounter))));
                        tempFunction += function.charAt(functionCounter) + " ";
                    }

                }
                functionCounter++;
            }


            switch (function.charAt(functionCounter)) {
                case ' ':
                    try{
                        if (function.charAt(functionCounter + 1) == '(') {
                            consecutiveOperation = true;
                        }else{
                            consecutiveOperation = false;
                        }
                    }catch (Exception e){

                    } break;
                case '(':
                    if (tempFunction != "") {
                        tempFunctionStack.push(tempFunction);
                    }
                    tempFunction = "";
                    tempFunctionSize = 0;
                    break;
                case ')':
                    if (tempFunction != "") {
                        tempFunctionStack.push(tempFunction);
                    }

                    if (consecutiveOperation == false) {
                        doOperation(tempFunction);
                    } else {
                        doConsecutiveOperation(tempFunction);
                    }
                    tempFunction = "";
                    tempFunctionSize = 0;
                    break;
                case '+':
                    operator.push("+");
                    break;
                case '*':
                    operator.push("*");
                    break;
                case '-':
                    operator.push("-");
                    break;
                case '/':
                    operator.push("/");
                    break;
            }
            if (functionCounter == functionSize - 1) {
                try {
                    doOperation(tempFunction);
                } catch (Exception e) {
                    return;
                }
                return;
            }
            functionCounter++;
        }
    }

    private void doConsecutiveOperation(String operation) {
        int result = 0;
        try {
            operation = tempFunctionStack.pop();
        } catch (Exception e) {

        }

        String aux = "";
        for (int i = 0; i < operation.length(); i++) {
            if (Character.isDigit(operation.charAt(i))) {
                tempFunctionSize++;
            }
        }
        aux = currentOperator;
        try {
            currentOperator = this.operator.pop();
        } catch (Exception e) {

        }


        if(currentOperator == "+" || currentOperator == "-"){
            result = 0;
        }else {
            result = 1;
        }

        if(assignationNotActive == false){
            if(operator.peek() == "+" || operator.peek() == "-"){
                total = 0;
            }else{
                total = 1;
            }
            assignationNotActive = true;
        }

        while (tempFunctionSize > 0) {
            if (currentOperator == "+") {
                if (this.tempFunctionSize > 1) {
                    result += operands.removeLast() + operands.removeLast();
                    tempFunctionSize -= 2;
                } else {
                    result += operands.removeLast();
                    tempFunctionSize--;
                }
            } else if (currentOperator == "-") {
                if (tempFunctionSize > 1) {
                    result -= operands.removeLast() - operands.removeLast();
                    tempFunctionSize -= 2;
                } else {
                    result -= operands.removeLast();
                    tempFunctionSize--;
                }
            } else if (currentOperator == "*") {
                if (tempFunctionSize > 1) {
                    result *= operands.removeLast() * operands.removeLast();
                    tempFunctionSize -= 2;
                } else {
                    result *= operands.removeLast();
                    tempFunctionSize--;
                }
            } else if (currentOperator == "/") {
                if (tempFunctionSize > 1) {
                    result = operands.removeLast() / operands.removeLast() / total;
                    tempFunctionSize -= 2;
                } else {
                    result /= operands.removeLast();
                    tempFunctionSize--;
                }
            }
        }

        try{
            switch (operator.peek()){
                case "+": total += result; break;
                case "-": total -= result; break;
                case "*": total *= result; break;
                case "/": total /= result; break;
            }

        }catch (Exception e){

        }

    }





    private void doOperation(String operation){
        LinkedList<Integer> ordered = new LinkedList<>();
        boolean firstRun = true;
        try{
            operation = tempFunctionStack.pop();
        }catch (Exception e){

        }

        String aux = "";
        for (int i = 0; i <operation.length() ; i++) {
            if(Character.isDigit(operation.charAt(i))){
                tempFunctionSize++;
                ordered.addFirst(operands.removeLast());
            }
        }



        aux = currentOperator;
        try{
            currentOperator = this.operator.pop();
        }catch (Exception e){

        }


        if(assignationNotActive == false){
            if(currentOperator == "+" || currentOperator == "-"){
                total = 0;
            }else{
                total = 1;
            }
            assignationNotActive = true;
        }

        while (tempFunctionSize> 0){
            if(currentOperator == "+"){
                if(this.tempFunctionSize > 1){
                    total += ordered.pop() + ordered.pop(); tempFunctionSize -=2;
                }else{
                    total += ordered.pop(); tempFunctionSize--;
                }
            }else if(currentOperator == "-"){
                total -= 0;
                if(tempFunctionSize > 1){
                    total = ordered.pop() - ordered.pop(); tempFunctionSize -=2;
                }else{
                    total -= ordered.pop(); tempFunctionSize--;
                }
            }else if(currentOperator == "*"){
                if(tempFunctionSize> 1){
                    total *= operands.removeLast() * operands.removeLast(); tempFunctionSize -=2;
                }else{
                    total *= operands.removeLast(); tempFunctionSize --;
                }
            }else if(currentOperator == "/"){
                total /=1;
                if(tempFunctionSize > 1){
                    if(firstRun == true){
                        total = ordered.pop(); tempFunctionSize -=2; //CHECK THIS
                        firstRun = false;
                    }else{
                        total /= ordered.pop(); tempFunctionSize -=2; //CHECK THIS
                    }

                }else{
                    total /= ordered.pop(); tempFunctionSize--; //CHECK THIS
                }
            }
        }

    }

    public int getTotal() {
        return total;
    }
}
