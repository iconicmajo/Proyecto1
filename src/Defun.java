import java.util.LinkedList;

public class Defun {

    private String funName;
    private String funParameters;
    private String funFunctions;
    private int parameterQuantity;
    private LinkedList<String> parameters;
    private LinkedList<String> funFunctionsList;
    private ArithmeticOperations arithmeticOperations;

    public void defineFunction(String funName, String funParameters, String funFunctions, int parameterQuantity){
        this.funName = funName;
        this.funParameters = funParameters;
        this.funFunctions = funFunctions;
        this.parameterQuantity = parameterQuantity;
        System.out.println("Defun " + funName + funParameters + funFunctions);
        parameters = new LinkedList<>();
        funFunctionsList = new LinkedList<>();
        parameters.addFirst("3");
        parameters.addFirst("2");
    }

    public void doFunction() {
        int counter = 0;
        while (counter < funFunctions.length()) {
            if (funFunctions.charAt(counter) != '(' && funFunctions.charAt(counter) != ')' && funFunctions.charAt(counter) != '<'
                    && funFunctions.charAt(counter) != '>' && funFunctions.charAt(counter) != '=' && !funFunctions.contains("Atom")
                    && !funFunctions.contains("List") && !funFunctions.contains("Cond") && funFunctions.charAt(counter) != ' '
                    && funFunctions.charAt(counter) != '+' && funFunctions.charAt(counter) != '-' && funFunctions.charAt(counter) != '*'
                    && funFunctions.charAt(counter) != '/'){
                funFunctions = funFunctions.replace(String.valueOf(funFunctions.charAt(counter)), parameters.removeFirst().toString());
            }
            counter++;
        }
        System.out.println(funFunctions);
        funFunctionsList.addFirst(funFunctions);

         String operation = String.valueOf(funFunctionsList.peek().charAt(2));
         switch (operation){
             case "+": arithmeticOperations = new ArithmeticOperations(funFunctions); break;
             case "-": arithmeticOperations = new ArithmeticOperations(funFunctions); break;
             case "*": arithmeticOperations = new ArithmeticOperations(funFunctions); break;
             case "/": arithmeticOperations = new ArithmeticOperations(funFunctions); break;
         }
    }

    public void sendParameters(LinkedList parameters){
        this.parameters = parameters;

    }
}
