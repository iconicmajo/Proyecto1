import java.util.LinkedList;

//E-Reference https://beginnersbook.com/2013/12/java-string-substring-method-example/

public class Functions{
    private static LinkedList<Defun> functionLists = new LinkedList<>();
    private static LinkedList<String> runtimeFunctions;
    private static boolean isCond = false;
    private static boolean result = true;
    public static void defFun(Defun defun){
        functionLists.add(defun);
    }

    public  static void doFun(String name, String[] parameters, boolean isCond){

        boolean exist = false;
        int token = 0;
        for (int i = 0; i < functionLists.size() ; i++) {
            if(functionLists.get(i).getName().equals(name)){
                token = i;
                System.out.println("Function exists!");
                exist = true;
            }
        }
        if (exist == false){
            System.out.println("Function does not exist");
        }else{

            runtimeFunctions = functionLists.get(token).getNewfunctions(parameters);
            Functions.isCond = functionLists.get(token).isCond;
            runtimeFunctions();

        }
    }

    public static void runtimeFunctions(){
        if(runtimeFunctions.size() != 0){
            if(isCond == true && result == true) {
                String run = runtimeFunctions.removeFirst();
                if (run.contains("+") || run.contains("-") || run.contains("*") || run.contains("/")) {
                    new ArithmeticOperations(run);
                } else if (run.contains("<") || run.contains(">") || run.contains("Equal") || run.contains("Atom") || run.contains("List")
                        || run.contains("=")) {
                    new Predicates(run);
                    result = Predicates.result;
                }
                Functions.runtimeFunctions();
            }else{
                return;
            }

        }else{
            return;
        }
    }
}
