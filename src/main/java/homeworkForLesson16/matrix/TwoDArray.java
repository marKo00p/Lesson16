package homeworkForLesson16.matrix;


import homeworkForLesson16.randomGenerators.FloatGenerator;
import homeworkForLesson16.randomGenerators.IntegerGenerator;
import homeworkForLesson16.randomGenerators.NumberGenerator;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TwoDArray<T extends Number> {

    T[][] matrix;
    int rows;
    int columns;
    private static Random random = new Random();
    public static final List<NumberGenerator<?>> numberList = new ArrayList<>();

    public TwoDArray(Class<?> item, int rows, int columns) {
        this.matrix = (T[][]) Array.newInstance(item, rows, columns);
    }

    public void fill2DArray(NumberGenerator<T> generator){

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Array.set(Array.get(matrix, i), j, generator.nextRand());
            }
        }
    }

        public static void main (String[]args){
            NumberGenerator<Number> generator = gGenerator();
            System.out.println("Class that fill the elements of the array is: " + generator.getClass().getSimpleName());


            TwoDArray twoDArray = new TwoDArray(generator.getClass(), 2,2);
            twoDArray.fill2DArray(gGenerator());
            print2DArray(twoDArray);
        }

        public static <T extends Number> NumberGenerator<T> gGenerator() {

            return (NumberGenerator<T>) numberList.get(random.nextInt(numberList.size()));
        }

        static void print2DArray (Object array){
            int rows = Array.getLength(array);
            int columns = Array.getLength(Array.get(array, 0));
            Class<?> c = array.getClass().getComponentType();
            for (int i = 0; i < rows; i++) {
                Object row = Array.get(array, i);
                for (int j = 0; j < columns; j++) {
                    if (c == IntegerGenerator[].class) {
                        int element = Array.getInt(row, j);
                        System.out.format("%d", element);
                    }
                    if (c == FloatGenerator[].class) {
                        float element = Array.getFloat(row, j);
                        System.out.format("%4.2f", element);
                    }
                }
                System.out.println();
            }
        }

        static {
            try {
                initialMethod();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static void initialMethod ()  throws Exception {
            Reflections reflections = new Reflections("homeworkForLesson16", Scanners.SubTypes);
            Class<? extends NumberGenerator>[] gArray = new Class[0];
            Class<? extends NumberGenerator>[] genClass = reflections.getSubTypesOf(NumberGenerator.class).toArray(gArray);
            for (Class<? extends NumberGenerator> gClass : genClass) {
                if (Modifier.isAbstract(gClass.getModifiers())) {
                    continue;
                }
                numberList.add(gClass.getDeclaredConstructor().newInstance());
            }
        }
    }

