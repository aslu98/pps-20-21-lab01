package lab01.tdd.strategy;

public class MultipleOfStrategy implements SelectStrategy {

    private final int num;

    public MultipleOfStrategy(final int num){
        this.num = num;
    }

    @Override
    public boolean apply(int element) {
        return element % num == 0;
    }
}
