import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
<<<<<<< HEAD
        Functions functions = new Functions("(Defun sumar (a,b) (+ a b))");
=======
        Parser parser = new Parser();
        Scanner readLine = new Scanner(System.in);
        Funciones funciones = new Funciones();
        
        System.out.println(">>: ");
        String func  = readLine.nextLine();
        funciones.functions(func);

        //String arithmethicOperation = readLine.nextLine();
        //System.out.println(parser.arithmeticOperations(arithmethicOperation));
        //int a = Integer.parseInt("3 + 3");
       // System.out.println(3 + 3);
        //ArithmeticOperations a = new ArithmeticOperations("(+ (/ (+ 1 2 3) 2) (+ 40 5 6) 7)");
       //ArithmeticOperations a = new ArithmeticOperations("(+ 2 (+ 3 4 5) (+ 1 2 3) 4)");
        //ArithmeticOperations a = new ArithmeticOperations("(/ 6 2 3)"); CHECK THIS, DOES NOT WORK YET

        //System.out.println(a.getTotal());

        Predicates p = new Predicates();
        System.out.println(p.PredicateVerification("(Listp 1 2 3)"));

      //  System.out.println(a.getTotal());


>>>>>>> 492bd310c30be0f18cb9375648ef7cbfeeefc4cf
    }
}
