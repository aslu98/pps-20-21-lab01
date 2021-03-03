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
        final int oddNumSecond = 1;
        final int oddNumFourth = 3;
        final int evenNumFirst = 2;
        final int evenNumThird = 4;
        list.add(evenNumFirst);
        list.add(oddNumSecond);
        list.add(evenNumThird);
        list.add(oddNumFourth);
        SelectStrategy strategy = strategyFactory.getStrategy(Strategies.EVEN, Optional.empty());
        assertEquals(list.next(), Optional.of(evenNumFirst));
        assertEquals(list.next(strategy), Optional.of(evenNumThird));
        assertEquals(list.next(strategy), Optional.of(evenNumFirst));
        assertEquals(list.next(), Optional.of(oddNumSecond));
    }

    @Test
    void testMultipleOfStrategy(){
        final int multipleNumFirst = 3;
        final int multipleNumFourth = 6;
        final int notMultipleNumSecond = 1;
        final int notMultipleNumThird = 2;
        final int notMultipleNumFifth = 4;
        list.add(multipleNumFirst);
        list.add(notMultipleNumSecond);
        list.add(notMultipleNumThird);
        list.add(multipleNumFourth);
        list.add(notMultipleNumFifth);
        SelectStrategy strategy = strategyFactory.getStrategy(Strategies.MULTIPLE_OF, Optional.of(3));
        assertEquals(list.next(), Optional.of(multipleNumFirst));
        assertEquals(list.next(strategy), Optional.of(multipleNumFourth));
        assertEquals(list.next(strategy), Optional.of(multipleNumFirst));
        assertEquals(list.next(strategy), Optional.of(multipleNumFourth));
        assertEquals(list.next(), Optional.of(notMultipleNumFifth));
    }

    @Test
    void testEqualsStrategy(){
        final int equalsNum = 6;
        final int equalsNumFirst = equalsNum;
        final int equalsNumFourth = equalsNum;
        final int notEqualsNumSecond = 1;
        final int notEqualsNumThird = 2;
        final int notEqualsNumFifth = 4;
        list.add(equalsNumFirst);
        list.add(notEqualsNumSecond);
        list.add(notEqualsNumThird);
        list.add(equalsNumFourth);
        list.add(notEqualsNumFifth);
        SelectStrategy strategy = strategyFactory.getStrategy(Strategies.EQUALS, Optional.of(equalsNum));
        assertEquals(list.next(), Optional.of(equalsNumFirst));
        assertEquals(list.next(strategy), Optional.of(equalsNumFourth));
        assertEquals(list.next(strategy), Optional.of(equalsNumFirst));
        assertEquals(list.next(), Optional.of(notEqualsNumSecond));
    }

    @Test
    void testEmptyListWithStrategy(){
        final int notEqualsNum = 1;
        final int equalsNum = 6;
        list.add(notEqualsNum);
        SelectStrategy strategy = strategyFactory.getStrategy(Strategies.EQUALS, Optional.of(equalsNum));
        assertEquals(list.next(strategy), Optional.empty());
    }

}
