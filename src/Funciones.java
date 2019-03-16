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
    private int numberA = 0, numberB = 0;
	
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
	
	public String functions(String function, String function_name) {
		
		//int result = 0;
        //boolean inFunction = false;
		  int functionCounter = 0;
        //String function_name = "";
        String line = "";
     
        //Incicia leyendo el tipo de funcion y nombre, los separa
        for (int i = 1; i < function.length(); i++) {
        	int c = line.lastIndexOf(" ");
            function = line.substring(0,c).trim();
            function_name =line.substring(c+1).trim();
            
            //Revisa que la funcion ingresada este dentro del interprete
            if (function.equals("defun")  || function.equals("cont") ) {
                stackFunction.push(Character.toString(function.charAt(i)));
                
                if (function.charAt(functionCounter + 2) == '(' || function.charAt(functionCounter + 1) == '(') {
                   // operands.addFirst(Integer.parseInt(Character.toString(function.charAt(functionCounter))));
                }
                
            }
            else {
            	System.out.println("Please insert a valid function");
            }
            
                }
            
        return function_name;
		
	}


}
