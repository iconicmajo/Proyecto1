import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String operation = "(DEFUN suma ()\n" +
                "(COND ((< 1( 2)\n" +
                "(+ 3 2)";
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (true) {
            System.out.println("[" + counter + "]> ");
            //String operation = sc.nextLine();
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
            boolean isCond = false;

            if(function.contains("COND")){
                isCond = true;
            }
            Functions.doFun(name, parameters, isCond);
            counter++;
        }
    }
}