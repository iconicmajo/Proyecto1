import java.util.Stack;

public class Predicates extends Defun {
    private Stack<String> type = new Stack<>();
    private Stack<String> predicates = new Stack<>();


    public Predicates(String predicate){
        boolean lista = false;
        String predicado = predicate.replace("(", " ");
        predicado = predicado.replace(")", " ");

        if (predicado.contains("'")) {
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
        for (int i = 1; i < tipos.length; i++) {
            if (!tipos[i].equals("")) {
                predicates.push(tipos[i]);
            }

        }

        // Verificar si el tipo de predicado es atom, equal, list, <, > y luego hacer las comparaciones
        int numA;
        int numB;
        boolean result = true;

        try{
            if (predicates.get(1).equals("List") || predicates.get(2).equals("List")) {
                lista = true;
            }
        }catch (Exception e){
            // if we only use (Atom number)
        }

        switch (predicates.get(1)) {
            case "Atom":
                if (lista == true) {
                    result = false;
                } else {
                    result = true;
                }
                System.out.println(result);
                break;

            case "Equal":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA == numB) result = true;

                else {
                    result = false;
                }
                System.out.println(result);
                break;

            case "List":
                if (lista == true) {
                    result = true;
                } else {
                    result = false;
                }
                System.out.println(result);
                break;

            case "<":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA < numB) result = true;

                else {
                    result = false;
                }
                System.out.println(result);
                break;

            case ">":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA > numB) result = true;


                else {
                    result = false;
                }
                System.out.println(result);
                break;
        }

        switch (predicates.get(0)) {
            case "Atom":
                if (lista == true) {
                    result = false;
                } else {
                    result = true;
                }
                System.out.println(result);
                break;

            case "Equal":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA == numB) result = true;

                else {
                    result = false;
                }
                System.out.println(result);
                break;

            case "List":
                if (lista == true) {
                    result = true;
                } else {
                    result = false;
                }
                System.out.println(result);
                break;

            case "<":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA < numB) result = true;

                else {
                    result = false;
                }
                System.out.println(result);
                break;

            case ">":
                numB = Integer.parseInt(predicates.pop());
                numA = Integer.parseInt(predicates.pop());

                if (numA > numB) result = true;


                else {
                    result = false;
                }
                System.out.println(result);
                break;
        }
    }
}

