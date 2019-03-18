import java.util.LinkedList;

//E-Reference https://beginnersbook.com/2013/12/java-string-substring-method-example/

public class Functions<E> {

    private LinkedList<String> functionStorage;
    private LinkedList<Defun> functions;
    private LinkedList<Integer> valuesForParameters;
    private int dividerCounter = 0;
    private Defun newFunction;
    private String[] functionParameters;
    private int parametersQuantity;
    private boolean operationExists;
    private String currentFunction;

    public  Functions(String currentFunction){
        parametersQuantity = 0;
        operationExists = false;
        functionStorage = new LinkedList<>();
        functions = new LinkedList<>();
        valuesForParameters = new LinkedList<>();
        this.currentFunction = currentFunction;
        divideFunctions();
        setFunction();

    }


    public void setFunction(){
        functionParameters = functionStorage.get(1).split(",");
        parametersQuantity = functionParameters.length;
        newFunction = new Defun();
        newFunction.defineFunction(functionStorage.removeLast(), functionStorage.removeLast()
                , functionStorage.removeLast(), parametersQuantity);
        this.functions.addFirst(newFunction);
       newFunction.doFunction();
    }

    private void divideFunctions(){
        if(dividerCounter < 2 ) {
            functionStorage.addFirst(this.currentFunction.substring(0, this.currentFunction.indexOf(" ") + 1));
            this.currentFunction = this.currentFunction.substring(this.currentFunction.indexOf(" ") + 1);
            dividerCounter++;
            divideFunctions();
        }else if(dividerCounter >= 2 && dividerCounter < 4){
            functionStorage.addFirst(this.currentFunction.substring(0, this.currentFunction.indexOf(")") +1));
            this.currentFunction = this.currentFunction.substring(this.currentFunction.indexOf(")") + 1);
            dividerCounter++;
            divideFunctions();
        }else{
            functionStorage.removeLast();
            return;
        }

    }
}
