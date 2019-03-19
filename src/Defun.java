import java.util.HashMap;
import java.util.LinkedList;

public class Defun {
    private LinkedList<String> parameters = new LinkedList<>(); //Linked list used to store the parameters of the function
    private LinkedList<String> tasks = new LinkedList<>(); //Linked list used to store the tasks of the function
    private String name; //Name of the Defun
    public boolean isCond = false; //verifies if the expresion contains cond or not

    /**
     * Defun class Constructor
     * @param name String
     * @param parameters Linked list
     * @param tasks Linked list
     */
    public Defun(String name, LinkedList<String> parameters, LinkedList<String> tasks) {
        this.name = name;
        this.parameters = parameters;
        this.tasks = tasks;
    }

    /**
     * Gets the name
     * @return The name of the function
     * @Pre The name must not be null or " "
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the tasks and assign them to a temp String
     */
    public void getTasks() {
        String temp = "";
        for (int i = 0; i < tasks.size(); i++) {
            temp += tasks.get(i);
        }

    }

    /**
     * Method used to Pass the Parameters and create a new expresion, it creats a "new" function
     * @param parameterSustitucion
     * @return Linked list with the parsed functions
     * @pre Parameters Quantity must be the same as defined
     */
    public LinkedList<String> getNewfunctions(String[] parameterSustitucion) {
        LinkedList<String> newFunction = new LinkedList<>(); //List to store the "new" Function
        String temp = ""; //temp variable used to store the new expression
        isCond = false; //assigns is cond to false

        //used to get the new expressions
        for (int i = 0; i < tasks.size(); i++) {
            temp = tasks.get(i);
            for (int j = 0; j < parameters.size(); j++) {
                try {
                    if (temp.contains(parameters.get(j))) {
                        temp = temp.replaceAll(parameters.get(j), parameterSustitucion[j]);
                    }
                } catch (Exception e) {
                }
                if(temp.contains("COND")){ //evaluates cond statements
                    temp = temp.replaceAll("COND", "");
                    isCond = true;
                }

                newFunction.addLast(temp); //inserts the new expression into the list
            }

        }
        return newFunction;
    }
}
