import java.util.LinkedList;
import java.util.Stack;

/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * AMADO GARCIA 181469
 * Maria Jose Castro 181202
 * Luis Pedro Cuellar 18220
 * LISP INTERPRETER - PROJECT 1 DATA STRUCTURES
 * ING. DOUGLAS BARRIOS
 */

public class Parser {


    private Stack<String> type = new Stack<>();
    private Stack<String> predicates = new Stack<>();

    
    public boolean PredicateVerification(String predicate){

        boolean lista = false;
       String predicado = predicate.replace("(", " ");
       predicado = predicado.replace(")", " ");

       if (predicado.contains("'")){
           predicado = predicado.replace("'", " ");
           lista = true;
       }

       String tipos[] = predicado.split(" ");

        // Verificar si el primer signo de lo que se quiera verificar sea uno de los predicado disponibles
        if (predicado.contains("atom") || predicado.contains("equal") || predicado.contains("listp") || predicado.contains("<") || predicado.contains(">")) {
            type.push(tipos[0]);
        }

        // Ir metiendo los numeros o signos que hayan metido en el HashMap
        for(int i  = 1; i < tipos.length; i ++) {
            predicates.push(tipos[i]);
        }

        // Verificar si el tipo de predicado es atom, equal, list, <, > y luego hacer las comparaciones
        int numA;
        int numB;
        boolean result = true;

        switch(type.peek()) {
            case "atom":
                if (tipos.length < 1){
                    result = false;
                }

                else {
                    result = true;
                }
                break;

            case "equal":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA == numB) result = true;

                else {
                    result = false;
                }
                break;

            case "listp":
                if (lista == true) {
                    result = true;
                }

                else {
                    result = false;
                }
                break;

            case "<":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA < numB) result = true;

                else {
                    result = false;
                }
                break;

            case ">":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA > numB) result = true;


                else {
                    result = false;
                }
                break;
        }
        return result;
    }
}



