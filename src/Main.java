import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args) {
        //Operation MUST have this structure. Must define the DEFUN NAME (PARAMETERS)\n +
        //and in the second line must define a function
        //in the third line must define another function etc etc etc
        String operation = "(DEFUN suma ()\n" +
                "(COND ((< 1( 2)\n" +
                "(+ 3 2)"; //function
        Scanner sc = new Scanner(System.in); // Scanner used to read execute the function
        int counter = 0; //counter used for GUI reasons
        while (true) {
            System.out.println("[" + counter + "]> "); //GUI
            //String operation = sc.nextLine(); //We could read the defun here
            Parser.parse(operation); //DEFINES THE DEFUN

            String function = sc.nextLine(); //This is the defun reader, used to call a function
            String name = ""; //name of the function
            function = function.replaceAll("\\(", "");
            function = function.replaceAll("\\)", "");
            String[] divider = function.split(" "); //Divides the function
            String[] parameters = new String[divider.length]; //Parameters
            name = divider[0]; //name of the funcion

            //Parameters cycle
            int j = 0;
            for (int i = 1; i < divider.length; i++) {
                parameters[j] = divider[i];
                j++;
            }

            Functions.doFun(name, parameters); //EXECUTES THE FUNCTION
            counter++;
        }
    }
}