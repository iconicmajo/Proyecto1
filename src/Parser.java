import java.util.ArrayList;

/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * AMADO GARCIA 181469
 * LISP INTERPRETER - PROJECT 1 DATA STRUCTURES
 * ING. DOUGLAS BARRIOS
 */

public class Parser {

    public String arithmeticOperations(String function){
        String tempFunction = "+ 5 6";
        String[] splitted = tempFunction.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < splitted.length; i++) {
            list.add(splitted[i]);
        }

        for (int i = 0; i < list.size() ; i++) {
            switch (list.get(i)){
                case "(": break;
                case ")": break;

            }
        }

        return  "";
    }
}
