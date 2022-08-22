package homeworkForLesson16.randomGenerators;


import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoDArray<T extends Number> {
    private T[][] matrix;

    public TwoDArray(NumberGenerator<T> generator, int rows, int columns) {
        this.matrix = (T[][]) Array.newInstance(generator.getType(), rows, columns);
        fillMatrix(generator);
    }
    public void fillMatrix(NumberGenerator<T> generator){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = generator.nextRand();
            }
        }
    }

        public static void main (String[]args) {
            TwoDArray<Float> tda = new TwoDArray<>(new FloatGenerator(), 3, 3);
            tda.print();
        }
        public void print(){
            Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
        }

    }

