import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String operation = "(DEFUN FTOC (TEMP a b)\n" +
                "(/ (- TEMP 32) 1.8)\n" +
                "(< a b)";
        Parser.parse(operation);
        Scanner sc = new Scanner(System.in);
        String function = sc.nextLine();
        String name = "";
        function = function.replaceAll("\\(", "");
        function = function.replaceAll("\\)", "");
        String[] divider = function.split(" ");
        String[] parameters = new String[divider.length];
        name = divider[0];

        int j= 0;
        for (int i = 1; i < divider.length; i++) {
            parameters[j] = divider[i];
            j++;
        }
        Functions.doFun(name, parameters);
        /*
        System.out.println("Lisp Interpreter");
        Scanner sc = new Scanner(System.in);
        boolean isArithmetic = true;
        boolean isDefun = false;
        String lisp = "";
        for (int i = 1; ; i++) {
            lisp = "[" + i + "]" + ">";
            System.out.print(lisp);
            String function = sc.nextLine();
            if (function.contains("Defun")) {
                isDefun = true;
            } else {
                if (function.contains("+") || function.contains("-") || function.contains("*") || function.contains("/")) {
                    isArithmetic = true;
                }else{
                    isArithmetic = false;
                }


            }
            FactoryMain.FactoryMain(isDefun, isArithmetic, function);
        }*/
    }
}