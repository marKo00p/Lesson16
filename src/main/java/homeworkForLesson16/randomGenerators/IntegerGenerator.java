package homeworkForLesson16.randomGenerators;

public class IntegerGenerator extends AbstractGenerator<Integer>{
    @Override
    public Integer nextRand() {
        return random.nextInt();
    }
}
