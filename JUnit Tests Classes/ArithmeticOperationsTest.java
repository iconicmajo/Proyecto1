import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationsTest {

    @Test
    void doAddition(){
        String statement = "(+ 2 3)";
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations((statement));
        float result = arithmeticOperations.resultTest;

        assertEquals(4, result);

    }

    @Test
    void doSubtraction(){
        String statement = "(- 3 2)";
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations((statement));
        float result = arithmeticOperations.resultTest;

        assertEquals(1, result);

    }

    @Test
    void doMult(){
        String statement = "(* 2 3)";
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations((statement));
        float result = arithmeticOperations.resultTest;

        assertEquals(6, result);

    }

    @Test
    void doDiv(){
        String statement = "(/ 6 3)";
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations((statement));
        float result = arithmeticOperations.resultTest;

        assertEquals(2, result);

    }

    @Test
    void doMany(){
        String statement = "(+ (+ 12 3) (/ 14 2) 3)";
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations((statement));
        float result = arithmeticOperations.resultTest;

        assertEquals(25, result);

    }
}