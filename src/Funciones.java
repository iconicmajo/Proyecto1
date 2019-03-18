import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 */

/**
 *UNIVERSIDAD DEL VALLE DE GUATEMALA
 * AMADO GARCIA 181469
 * Maria Jose Castro 181202
 * Luis Pedro Cuellar 18220
 * LISP INTERPRETER - PROJECT 1 DATA STRUCTURES
 * ING. DOUGLAS BARRIOS
 *
 */

public class Funciones {
	
	private String defun;
	private String cont;
	private Stack<String> stackFunction = new Stack<>();
    private String tempFunction = "";
    private Parser parser = new Parser();

	/**
	 * @param defun
	 * @param cont
	 */
	public Funciones(String defun, String cont) {
		super();
		this.defun = defun;
		this.cont = cont;
	}

	/**
	 * 
	 */
	public Funciones() {
		super();
		defun = "defun";
		cont = "cont";
		// TODO Auto-generated constructor stub
	}
	
	public String functions(String func) {
		
		
        
        String function = "";
        String function_name= "";
        String predicados="";
     
        //Incicia leyendo el tipo de funcion y nombre, los separa para ller
        for (int i = 1; i < func.length(); i++) {
        	int c = func.lastIndexOf(" ");
            function = func.substring(0,c).trim();
            //System.out.println(function);
            function_name =func.substring(c+1).trim();
           // predicados = func.substring(c+2).trim();
            
            
            //Revisa que la funcion ingresada este dentro del interprete
            if (function.equals("defun")) {
                stackFunction.push(Character.toString(function.charAt(i)));
                	
                	//Atom es un booleano que regresa true si es cadena de nums o char
                	if (predicate.equals("atom")) {
                		parser.PredicateVerification(String predicate);
                	}
                	
                	//Verifica si es lista, se manda a llamar a parser donde estan los predicados
                	if (predicados.equals("list")) {
                		
                		parser.PredicateVerification(String predicate);
                	}
                	
                	//Regresa un true or false si son iguales o no 
                	//Este se toma como un string aunque sean numeros, se usa lower case 
                	if (predicados.equals("equal")) {
                		
                		parser.PredicateVerification(String predicate);
                		
                	}
                	//Exclusivo para numeros,compara si es mayor
                	if (predicados.equals("<")) {
                		
                		parser.PredicateVerification(String predicate);
                	}
                	
                	//Numeros, compara si es mayor (boolean)
                	if (predicados.equals(">")) {
                		
                		parser.PredicateVerification(String predicate);
                	}
                	
                	//Numeros, compara si es mayor (boolean)
                	if (predicados.equals("cond")) {
                		System.out.println("condicionales ");
                		
                		
                	}
                	else {
                		System.out.println("Please insert a valid predicate");
                	}
               
            }
            else {
            	System.out.println("Please insert a valid function");
            }
            
                }
            
        return function_name;
	}

}
