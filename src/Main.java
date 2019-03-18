import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        }
    }
}