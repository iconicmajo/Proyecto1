import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredicatesTest {

    @Test
    void predicatesMinor(){
        String statement = "(< 3 2)";
        Predicates predicates = new Predicates(statement);
        boolean result = Predicates.result;

        assertEquals(false, result);
    }

    @Test
    void predicatesMajor(){
        String statement = "(> 3 2)";
        Predicates predicates = new Predicates(statement);
        boolean result = Predicates.result;

        assertEquals(true, result);
    }


    @Test
    void predicatesEqual(){
        String statement = "(Equal 3 3)";
        Predicates predicates = new Predicates(statement);
        boolean result = Predicates.result;

        assertEquals(true, result);
    }


    @Test
    void predicatesAtom(){
        String statement = "(Atom '(1))";
        Predicates predicates = new Predicates(statement);
        boolean result = Predicates.result;

        assertEquals(false, result);
    }

    @Test
    void predicatesList(){
        String statement = "(List (List 1 2 3))";
        Predicates predicates = new Predicates(statement);
        boolean result = Predicates.result;

        assertEquals(true, result);
    }
}