import java.util.HashMap;
import java.util.LinkedList;

public class Parser {

    private static String functionName;
    private static String functionParameters;
    private static String functionTasks;
    private static LinkedList<String> parameters;
    private static LinkedList<String> tasks;

    public static void parse(String function){
        functionName = "";
        functionParameters = "";
        functionTasks = "";
        parameters =new LinkedList<>();
        tasks = new LinkedList<>();

        //=======================================================================================
        function = function.substring(function.indexOf(" ") + 1);
        functionName = function.substring(0, (function.indexOf(" ")));
        function = function.substring(function.indexOf(" ") + 1);
        functionParameters = function.substring(0, (function.indexOf(")") + 1));
        functionTasks = function.trim().substring(function.indexOf("\n"));
        System.out.println("DEFUN " + functionName + " " +  functionParameters + functionTasks);



        functionParameters = functionParameters.substring(1, functionParameters.indexOf(")"));
        System.out.println(functionParameters);
        String[] parametersArray = functionParameters.split(" ");
        String[] functionsArray = functionTasks.split("\n");

        for (int i = 0; i < parametersArray.length ; i++) {
            parameters.addLast(parametersArray[i]);
        }

        for (int i = 0; i < functionsArray.length ; i++) {
            if(!functionsArray[i].equals("")){
                tasks.addLast(functionsArray[i]);
            }
        }

        Functions.defFun(new Defun(functionName, parameters, tasks));
    }
}
