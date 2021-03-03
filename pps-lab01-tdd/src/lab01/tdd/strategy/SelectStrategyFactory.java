package lab01.tdd.strategy;

import java.util.Optional;

public class SelectStrategyFactory extends SelectStrategyAbstractFactory {
    @Override
    public SelectStrategy getStrategy(Strategies strategy, Optional<Integer> num) {
       switch (strategy){
           case EVEN:
               return new EvenStrategy();
           case MULTIPLE_OF:
               return num.isEmpty() ? null : new MultipleOfStrategy(num.get());
           case EQUALS:
               return num.isEmpty() ? null : new EqualsStrategy(num.get());
           default:
               return null;
       }
    }
}
