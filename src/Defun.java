import java.util.HashMap;
import java.util.LinkedList;

public class Defun {
    private LinkedList<String> parameters = new LinkedList<>();
    private LinkedList<String> tasks = new LinkedList<>();
    private String name;
    public boolean isCond = false;

    public Defun(String name, LinkedList<String> parameters, LinkedList<String> tasks) {
        this.name = name;
        this.parameters = parameters;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void getTasks() {
        String temp = "";
        for (int i = 0; i < tasks.size(); i++) {
            temp += tasks.get(i);
        }

    }

    public LinkedList<String> getNewfunctions(String[] parameterSustitucion) {
        LinkedList<String> newFunction = new LinkedList<>();
        String temp = "";


        for (int i = 0; i < tasks.size(); i++) {
            temp = tasks.get(i);
            for (int j = 0; j < parameters.size(); j++) {
                try {
                    if (temp.contains(parameters.get(j))) {
                        temp = temp.replaceAll(parameters.get(j), parameterSustitucion[j]);
                    }
                } catch (Exception e) {
                }
                if(temp.contains("COND")){
                    temp = temp.replaceAll("COND", "");
                    isCond = true;
                }

                newFunction.addLast(temp);
            }

        }
        return newFunction;
    }
}
