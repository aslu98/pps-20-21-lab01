package lab01.tdd.strategy;

public class EqualsStrategy implements SelectStrategy{

    private final int num;

    public EqualsStrategy(final int num){
        this.num = num;
    }

    @Override
    public boolean apply(int element) {
        return element == num;
    }
}
