import java.util.LinkedList;
import java.util.Stack;

public class ArithmeticOperations {

    private Stack<String> operator = new Stack<>();
    private LinkedList<Integer> operands = new LinkedList<>();
    private LinkedList<Integer> result = new LinkedList<>();
   // private String tempFunction = "";
    /*
    private int bracketsComparatorRight= 0;
    private int bracketsComparatorLeft = 0;
    private int numberA = 0, numberB = 0;*/

    int total; //important

    public ArithmeticOperations(String function){
        int functionSize = function.length();
        int functionCounter = 0;
        int total = 0;
        while (true){

            if(Character.isDigit(function.charAt(functionCounter))){
                operands.addFirst((int) function.charAt(functionCounter));
            }

            switch (function.charAt(functionCounter)){
                case '(': break;
                case ')': doOperation(""); break;
                case '+': operator.push("+");break;
                case '*': operator.push("*");break;
                case '-': operator.push("-");break;
                case '/': operator.push("/");break;
            }
            if(functionCounter == functionSize){
                return;
            }
        }
    }

    private int doOperation(String operation){
        return  0;
    }
}
