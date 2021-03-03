package lab01.tdd.strategy;

import java.util.Optional;

public abstract class SelectStrategyAbstractFactory {
    public abstract SelectStrategy getStrategy(Strategies strategy, Optional<Integer> num) ;
}
