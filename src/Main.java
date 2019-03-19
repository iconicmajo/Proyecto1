import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*String operation = "(DEFUN FTOC (TEMP a b c d)\n" +
                "(/ (- TEMP 32) 1.8)\n" +
                "(Atom '(a b))\n" +
                "(+ c d)";*/
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (true) {
            System.out.println("[" + counter + "]> ");
            String operation = sc.nextLine();
            Parser.parse(operation);

            String function = sc.nextLine();
            String name = "";
            function = function.replaceAll("\\(", "");
            function = function.replaceAll("\\)", "");
            String[] divider = function.split(" ");
            String[] parameters = new String[divider.length];
            name = divider[0];

            int j = 0;
            for (int i = 1; i < divider.length; i++) {
                parameters[j] = divider[i];
                j++;
            }
            Functions.doFun(name, parameters);
            counter++;
        }
    }
}