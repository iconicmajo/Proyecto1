import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Parser parser = new Parser();
        Scanner readLine = new Scanner(System.in);

        String arithmethicOperation = readLine.nextLine();
        System.out.println(parser.arithmeticOperations(arithmethicOperation));

    }
}
