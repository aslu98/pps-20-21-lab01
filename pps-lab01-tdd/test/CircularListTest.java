import lab01.tdd.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public static final int ADD_ATTEMPTS= 100;
    public static final int FIRST_ELEMENT= 6;
    public static final int SECOND_ELEMENT= 1;
    public static final int THIRD_ELEMENT= 3;
    private CircularList list;

    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl();
    }

    @Test
    void testInitiallyEmpty(){
        assertTrue(list.isEmpty());
    }

    @Test
    void testSize(){
        assertEquals(list.size(), 0);
    }

    @Test
    void testAdd(){
        list.add(FIRST_ELEMENT);
        assertFalse(list.isEmpty());
        assertEquals(list.size(), 1);
    }

    @Test
    void testMultipleAdds(){
        for (int i = 0; i < ADD_ATTEMPTS; i++){
            list.add(i);
        }
        assertEquals(list.size(), ADD_ATTEMPTS);
    }

    @Test
    void testClassicNext(){
        this.addElements();
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(), Optional.of(SECOND_ELEMENT));
        assertEquals(list.next(), Optional.of(THIRD_ELEMENT));
    }

    @Test
    void testCircularNext(){
        this.addElements();
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(), Optional.of(SECOND_ELEMENT));
        assertEquals(list.next(), Optional.of(THIRD_ELEMENT));
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
    }

    @Test
    void testClassicPrevious(){
        this.addElements();
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(), Optional.of(SECOND_ELEMENT));
        assertEquals(list.previous(), Optional.of(FIRST_ELEMENT));
    }

    @Test
    void testCircularPrevious(){
        this.addElements();
        assertEquals(list.previous(), Optional.of(THIRD_ELEMENT));
        assertEquals(list.previous(), Optional.of(SECOND_ELEMENT));
        assertEquals(list.previous(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.previous(), Optional.of(THIRD_ELEMENT));
    }

    @Test
    void testReset(){
        this.addElements();
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(), Optional.of(SECOND_ELEMENT));
        list.reset();
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
    }

    @Test
    void testDirectionChange(){
        this.addElements();
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.previous(), Optional.of(THIRD_ELEMENT));
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(), Optional.of(SECOND_ELEMENT));
        assertEquals(list.next(), Optional.of(THIRD_ELEMENT));
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.previous(), Optional.of(THIRD_ELEMENT));
        assertEquals(list.previous(), Optional.of(SECOND_ELEMENT));
        assertEquals(list.previous(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(), Optional.of(SECOND_ELEMENT));
    }

    @Test
    void testStrategy(){
        list.add(SECOND_ELEMENT);
        list.add(THIRD_ELEMENT);
        SelectStrategy strategy = new EvenStrategy();
        assertEquals(list.next(strategy), Optional.empty());
    }

    @Test
    void testEvenStrategy(){
        this.addElements();
        SelectStrategy strategy = new EvenStrategy();
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(), Optional.of(SECOND_ELEMENT));
        assertEquals(list.next(strategy), Optional.of(FIRST_ELEMENT));
    }

    @Test
    void testMultipleOfStrategy(){
        this.addElements();
        SelectStrategy strategy = new MultipleOfStrategy(3);
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(strategy), Optional.of(THIRD_ELEMENT));
    }

    @Test
    void testEqualsStrategy(){
        this.addElements();
        SelectStrategy strategy = new EqualsStrategy(6);
        assertEquals(list.next(), Optional.of(FIRST_ELEMENT));
        assertEquals(list.next(strategy), Optional.of(FIRST_ELEMENT));
    }

    @Test
    void testEmptyList(){
        assertEquals(list.previous(), Optional.empty());
        assertEquals(list.next(), Optional.empty());
        SelectStrategy strategy = new EvenStrategy();
        assertEquals(list.next(strategy), Optional.empty());
    }

    void addElements(){
        list.add(FIRST_ELEMENT);
        list.add(SECOND_ELEMENT);
        list.add(THIRD_ELEMENT);
    }
}
