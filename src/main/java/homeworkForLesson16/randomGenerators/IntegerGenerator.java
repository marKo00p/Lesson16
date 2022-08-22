package homeworkForLesson16.randomGenerators;

public class IntegerGenerator extends AbstractGenerator<Integer>{
    @Override
    public Integer nextRand() {
        return random.nextInt();
    }

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }
}
