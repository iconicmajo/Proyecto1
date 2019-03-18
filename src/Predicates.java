import java.util.Stack;

public class Predicates {
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
        if (predicado.toLowerCase().contains("Atom") || predicado.toLowerCase().contains("Equal") || predicado.toLowerCase().contains("list")
                || predicado.toLowerCase().contains("<") || predicado.toLowerCase().contains(">")) {
            type.push(tipos[1]);
        }

        // Ir metiendo los numeros o signos que hayan metido en el HashMap
        for(int i  = 1; i < tipos.length; i ++) {
            if(!tipos[i].equals("")){
                predicates.push(tipos[i]);
            }

        }

        // Verificar si el tipo de predicado es atom, equal, list, <, > y luego hacer las comparaciones
        int numA;
        int numB;
        boolean result = true;

        if(predicates.get(1).equals("list")){
            lista = true;
        }
        switch(type.peek().toLowerCase()) {
            case "atom":
                if (lista == true){
                    result = false;
                }

                else {
                    result = true;
                }
                break;

            case "Equal":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA == numB) result = true;

                else {
                    result = false;
                }
                break;

            case "list":
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
