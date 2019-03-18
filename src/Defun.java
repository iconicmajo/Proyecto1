import java.util.LinkedList;

public class Defun {

    private String funName;
    private String funParameters;
    private String funFunctions;
    private int parameterQuantity;
    private LinkedList<String> parameters;
    private LinkedList<String> funFunctionsList;
    private ArithmeticOperations arithmeticOperations;
    private boolean isArithmetic;

    public void defineFunction(String funName, String funParameters, String funFunctions, int parameterQuantity){
        isArithmetic = true;
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
                isArithmetic = true;
                funFunctions = funFunctions.replace(String.valueOf(funFunctions.charAt(counter)), parameters.removeFirst().toString());
            }else if(funFunctions.contains("Cond") && !funFunctions.contains("Atom") && !funFunctions.contains("List")) {
                isArithmetic = false;
                if (counter == 0) {
                    counter = 6;
                }
                if (funFunctions.charAt(counter) != '(' && funFunctions.charAt(counter) != ')' && funFunctions.charAt(counter) != '<'
                        && funFunctions.charAt(counter) != '>' && funFunctions.charAt(counter) != '=' && funFunctions.charAt(counter) != ' '
                        && funFunctions.charAt(counter) != '+' && funFunctions.charAt(counter) != '-' && funFunctions.charAt(counter) != '*'
                        && funFunctions.charAt(counter) != '/')
                    funFunctions = funFunctions.replace(String.valueOf(funFunctions.charAt(counter)), parameters.removeFirst().toString());

            }else if((funFunctions.contains("Atom") && funFunctions.contains("Cond") && !funFunctions.contains("List")) || funFunctions.contains("List") && funFunctions.contains("Cond") && !funFunctions.contains("Atom")){
                if(counter == 0){
                    counter =13;
                }
                if (funFunctions.charAt(counter) != '(' && funFunctions.charAt(counter) != ')' && funFunctions.charAt(counter) != '<'
                        && funFunctions.charAt(counter) != '>' && funFunctions.charAt(counter) != '=' && funFunctions.charAt(counter) != ' '
                        && funFunctions.charAt(counter) != '+' && funFunctions.charAt(counter) != '-' && funFunctions.charAt(counter) != '*'
                        && funFunctions.charAt(counter) != '/' && funFunctions.charAt(counter) != '\'')
                    funFunctions = funFunctions.replace(String.valueOf(funFunctions.charAt(counter)), parameters.removeFirst().toString());
                isArithmetic = false;
            }else if(funFunctions.contains("Atom") && funFunctions.contains("List")){
                if(counter == 0){
                    counter = 18;
                }
                if (funFunctions.charAt(counter) != '(' && funFunctions.charAt(counter) != ')' && funFunctions.charAt(counter) != '<'
                        && funFunctions.charAt(counter) != '>' && funFunctions.charAt(counter) != '=' && funFunctions.charAt(counter) != ' '
                        && funFunctions.charAt(counter) != '+' && funFunctions.charAt(counter) != '-' && funFunctions.charAt(counter) != '*'
                        && funFunctions.charAt(counter) != '/' && funFunctions.charAt(counter) != '\''){
                    funFunctions = funFunctions.replace(String.valueOf(funFunctions.charAt(counter)), parameters.removeFirst().toString());
                    isArithmetic = false;
                }

            }

            counter++;
        }
        System.out.println(funFunctions);
        funFunctionsList.addFirst(funFunctions);
        FactoryFunction.FactoryFunction(isArithmetic, funFunctionsList.peekFirst());

    }

    public void sendParameters(LinkedList parameters){
        this.parameters = parameters;

    }
}
