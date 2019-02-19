import Matrix.Matrix;
import Matrix.MatrixRow;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Matrix matrix1 = new Matrix(getRandomArray(5, 5));
        MatrixRow row = new MatrixRow(5);
        row.set(5,5);
        Matrix matrix2 = new Matrix(matrix1);


        System.out.println(matrix1);
        System.out.println(matrix2);

        System.out.println(matrix1.equals(matrix2));


    }

    public static double[][] getRandomArray(int rows, int cols) {
        double[][] array = new double[rows][cols];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0 ; i < rows ; i ++) {
            for (int j = 0 ; j < cols ; j ++) {
                double x = random.nextInt(10);
                array[i][j] = x;
            }
        }
        return array;
    }

}
