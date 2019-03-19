import java.util.LinkedList;

//E-Reference https://beginnersbook.com/2013/12/java-string-substring-method-example/

public class Functions {
    private static LinkedList<Defun> functionLists = new LinkedList<>(); //Linked list usted to store the instances of Defun Class
    private static LinkedList<String> runtimeFunctions; //Linked list used to store the Runtime functions
    private static boolean isCond = true; //Evaluates Cond
    private static boolean result = true; //Stores a true or false result

    /**
     * Static method used to define the function
     *
     * @param defun
     */
    public static void defFun(Defun defun) {
        functionLists.add(defun); //inserts the instances into a List
    }

    /**
     * Static function, it executes the function
     *
     * @param name
     * @param parameters
     * @Pre Parameters must not be null
     */
    public static void doFun(String name, String[] parameters) {

        boolean exist = false; //Verifies if the function exists or not
        int token = 0; //token used to save the current functionlist position
        //verifies if the function exists or not
        for (int i = 0; i < functionLists.size(); i++) {
            if (functionLists.get(i).getName().equals(name)) {
                token = i;
                System.out.println("Function exists!");
                exist = true;
            }
        }
        // if it does not exist, shows a message
        if (exist == false) {
            System.out.println("Function does not exist");
        } else {
            runtimeFunctions = functionLists.get(token).getNewfunctions(parameters); //gets the instance of the function
            Functions.isCond = functionLists.get(token).isCond; //verifies if is cond
            runtimeFunctions(); //Executes the function

        }
    }

    /**
     * Static method used to execute the function
     */
    public static void runtimeFunctions() {

        if (isCond == true) {
            if(result == true){
                if (runtimeFunctions.size() != 0) {
                    //if(isCond == true && result == true) { //USED TO DO THE COND, BUT GENERATES A BUG
                    String run = runtimeFunctions.removeFirst();
                    if (run.contains("+") || run.contains("-") || run.contains("*") || run.contains("/")) {
                        new ArithmeticOperations(run); //new instance of ArithmeticOperations, just to do the operation
                    } else if (run.contains("<") || run.contains(">") || run.contains("Equal") || run.contains("Atom") || run.contains("List")
                            || run.contains("=")) {
                        new Predicates(run); //new instance of predicates, just to get the result
                        result = Predicates.result;
                    }
                    Functions.runtimeFunctions(); //Recursion
                    // }else{
                    //     return;
                    //}

                } else {
                    return;
                }
            }
        } else {
            if (runtimeFunctions.size() != 0) {
                //if(isCond == true && result == true) { //USED TO DO THE COND, BUT GENERATES A BUG
                String run = runtimeFunctions.removeFirst();
                if (run.contains("+") || run.contains("-") || run.contains("*") || run.contains("/")) {
                    new ArithmeticOperations(run); //new instance of ArithmeticOperations, just to do the operation
                } else if (run.contains("<") || run.contains(">") || run.contains("Equal") || run.contains("Atom") || run.contains("List")
                        || run.contains("=")) {
                    new Predicates(run); //new instance of predicates, just to get the result
                    result = Predicates.result;
                }
                Functions.runtimeFunctions(); //Recursion
                // }else{
                //     return;
                //}

            } else {
                return;
            }
        }
    }
}
