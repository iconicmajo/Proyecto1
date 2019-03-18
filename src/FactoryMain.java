public class FactoryMain {
    public static Defun FactoryMain(boolean isDefun, boolean isArithmetic, String op){
        if(isDefun == true){
           return new Functions(op);
        }else{
            if(isArithmetic == true){
                return new ArithmeticOperations(op);
            }else{
                return new Predicates(op);
            }

        }
    }
}
