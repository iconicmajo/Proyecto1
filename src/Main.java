import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Parser parser = new Parser();
        Scanner readLine = new Scanner(System.in);

        //String arithmethicOperation = readLine.nextLine();
        //System.out.println(parser.arithmeticOperations(arithmethicOperation));
        //int a = Integer.parseInt("3 + 3");
       // System.out.println(3 + 3);
        ArithmeticOperations a = new ArithmeticOperations("(+ (* (+ 1 2 3) 2) (+ 4 5 6) 7)");
        System.out.println(a.getTotal());

    }
}
