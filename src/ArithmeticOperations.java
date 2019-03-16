import java.util.LinkedList;
import java.util.Stack;

public class ArithmeticOperations {

    private Stack<String> operator = new Stack<>();
    private LinkedList<Integer> operands = new LinkedList<>();
    private LinkedList<Integer> result = new LinkedList<>();
    private String tempFunction = "";
    private int tempFunctionSize;
    private String currentOperator;
    private boolean assignationNotActive = false;
    private int total;

    public ArithmeticOperations(String function){
        int functionSize = function.length();
        int functionCounter = 0;
        String number = "";
        while (true){

            if(operator.size() > 0 && assignationNotActive == false){
                if(operator.get(0) == "+" || operator.get(0) == "-"){
                    total = 0;
                }else{
                    total = 1;
                }
                assignationNotActive = true;
            }
            if(Character.isDigit(function.charAt(functionCounter))){
                if(Character.isDigit(function.charAt(functionCounter + 1))){
                    String twoDigits = Character.toString(function.charAt(functionCounter)) + Character.toString(function.charAt(functionCounter+1));
                    operands.addLast(Integer.parseInt(twoDigits));
                    functionCounter++;
                    tempFunctionSize++;
                }
                else{
                    operands.addLast(Integer.parseInt(Character.toString(function.charAt(functionCounter))));
                    tempFunction+=function.charAt(functionCounter) +" ";
                    tempFunctionSize++;
                }

                tempFunctionSize++;
                functionCounter++;
            }

            switch (function.charAt(functionCounter)){
                case '(': tempFunction = ""; tempFunctionSize = 0; break;
                case ')': doOperation(tempFunction); break;
                case '+': operator.push("+"); tempFunction+= "+"; break;
                case '*': operator.push("*"); tempFunction+= "*"; break;
                case '-': operator.push("-"); tempFunction+= "-"; break;
                case '/': operator.push("/"); tempFunction+= "/"; break;
            }
            if(functionCounter == functionSize - 1){
                return;
            }
            functionCounter++;
        }
    }

    private void doOperation(String operation){
        currentOperator = this.operator.pop();

        int i = 0;

        while (this.tempFunctionSize > 0){
            if(currentOperator == "+"){
                if(this.tempFunctionSize > 1){
                    total += operands.removeFirst() + operands.removeFirst(); tempFunctionSize -=2;
                }else{
                    total += operands.removeFirst(); tempFunctionSize--;
                }
            }else if(currentOperator == "-"){
                if(tempFunctionSize > 1){
                    total -= operands.removeLast() - operands.removeLast(); tempFunctionSize -=2;
                }else{
                    total -= operands.removeLast(); tempFunctionSize--;
                }
            }else if(currentOperator == "*"){
                if(tempFunctionSize> 1){
                    total *= operands.removeLast() * operands.removeLast(); tempFunctionSize -=2;
                }else{
                    total *= operands.removeLast(); tempFunctionSize --;
                }
            }else if(currentOperator == "/"){
                if(tempFunctionSize > 1){
                    total = operands.removeLast() / operands.removeLast() / total; tempFunctionSize -=2;
                }else{
                    total /= operands.removeLast(); tempFunctionSize--;
                }
            }
        }

    }

    public int getTotal() {
        return total;
    }
}
