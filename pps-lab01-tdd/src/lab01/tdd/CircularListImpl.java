package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private enum Direction {
        FORWARD,
        BACKWARD;
    }

    private List<Integer> list = new LinkedList<Integer>();
    private int currentPos = 0;
    private Direction direction = Direction.FORWARD;

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (isEmpty()){
            return Optional.empty();
        } else {
            if (this.direction == Direction.BACKWARD){
                currentPos += 2;
                direction = Direction.FORWARD;
            }
            currentPos = (currentPos == list.size()) ? 0 : currentPos;
            return Optional.of(list.get(currentPos++));
        }
    }

    @Override
    public Optional<Integer> previous() {
        if (isEmpty()){
            return Optional.empty();
        } else {
            if (this.direction == Direction.FORWARD) {
                currentPos -= 2;
                direction = Direction.BACKWARD;
            }
            currentPos = (currentPos < 0) ? list.size() - 1 : currentPos;
            return Optional.of(list.get(currentPos--));
        }
    }

    @Override
    public void reset() {
        currentPos = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
