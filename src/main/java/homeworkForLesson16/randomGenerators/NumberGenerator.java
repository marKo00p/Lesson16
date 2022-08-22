package homeworkForLesson16.randomGenerators;

public interface NumberGenerator<T extends Number>{
    T nextRand();
    Class<T> getType();
}
