public class FactoryFunction {
    public static Defun FactoryFunction(boolean isAritmethic, String op){
        if(isAritmethic == true){
            return new ArithmeticOperations(op);
        }else{
            return new Predicates(op);
        }
    }
}
