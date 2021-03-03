import lab01.tdd.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lab01.tdd.strategy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class SelectStrategyTest {
    private CircularList list;
    private SelectStrategyFactory strategyFactory;

    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl();
        strategyFactory = new SelectStrategyFactory();
    }

    @Test
    void testStrategy(){
        final int firstOddNum = 3;
        final int secondOddNum = 11;
        list.add(firstOddNum);
        list.add(secondOddNum);
        assertEquals(list.next(strategyFactory.getStrategy(Strategies.EVEN, Optional.empty())), Optional.empty());
    }

    @Test
    void testEvenStrategy(){
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        SelectStrategy strategy = strategyFactory.getStrategy(Strategies.EVEN, Optional.empty());
        assertEquals(list.next(), Optional.of(2));
        assertEquals(list.next(strategy), Optional.of(4));
        assertEquals(list.next(strategy), Optional.of(2));
        assertEquals(list.next(), Optional.of(1));
    }

    @Test
    void testMultipleOfStrategy(){
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(4);
        SelectStrategy strategy = strategyFactory.getStrategy(Strategies.MULTIPLE_OF, Optional.of(3));
        assertEquals(list.next(), Optional.of(3));
        assertEquals(list.next(strategy), Optional.of(6));
        assertEquals(list.next(strategy), Optional.of(3));
        assertEquals(list.next(strategy), Optional.of(6));
        assertEquals(list.next(), Optional.of(4));
    }

    @Test
    void testEqualsStrategy(){
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(4);
        SelectStrategy strategy = strategyFactory.getStrategy(Strategies.EQUALS, Optional.of(6));
        assertEquals(list.next(), Optional.of(6));
        assertEquals(list.next(strategy), Optional.of(6));
        assertEquals(list.next(strategy), Optional.of(6));
        assertEquals(list.next(), Optional.of(1));
    }

    @Test
    void testEmptyListWithStrategy(){
        list.add(1);
        list.add(2);
        SelectStrategy strategy = strategyFactory.getStrategy(Strategies.EQUALS, Optional.of(6));
        assertEquals(list.next(strategy), Optional.empty());
    }

}
