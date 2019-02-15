import Matrix.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MatrixTest {

    @Test
    void Get_0_0_Is_0() {
        double[][] array = {{0.0}, {1.0}};
        Matrix matrix = new Matrix(array);

        double val = matrix.get(0, 0);

        Assertions.assertEquals(0, val);
    }

    @Test
    void Matrix1_Add_Matrix2_Equals_Matrix3() {
        double[][] array1 = {{0.0}, {1.0}};
        Matrix matrix1 = new Matrix(array1);

        double[][] array2 = {{2.0}, {3.0}};
        Matrix matrix2 = new Matrix(array2);

        double[][] array3 = {{2.0}, {4.0}};
        Matrix matrix3 = new Matrix(array3);

        Matrix val = matrix1.AddMatrix(matrix2);

        Assertions.assertEquals(matrix3, val);
    }

    @Test
    void Matrix1_Sub_Matrix2_Equals_Matrix3() {
        double[][] array1 = {{0.0}, {1.0}};
        Matrix matrix1 = new Matrix(array1);

        double[][] array2 = {{2.0}, {3.0}};
        Matrix matrix2 = new Matrix(array2);

        double[][] array3 = {{-2.0}, {-2.0}};
        Matrix matrix3 = new Matrix(array3);

        Matrix val = matrix1.SubMatrix(matrix2);

        Assertions.assertEquals(matrix3, val);
    }

    @Test
    void mulValue() {

        double[][] array1 = {{10.0}, {15.0}};
        Matrix matrix1 = new Matrix(array1);

        double[][] array2 = {{2.0}, {3.0}};
        Matrix matrix2 = new Matrix(array2);

        var matrix3 = matrix2.mul(5);
        Assertions.assertEquals(matrix1, matrix3);
    }

    @Test
    void mulMatrix() {
        double[][] array1 = {{10.0, 15.0}};
        Matrix matrix1 = new Matrix(array1);

        double[][] array2 = {{2.0}, {3.0}};
        Matrix matrix2 = new Matrix(array2);

        var actual = matrix1.mul(matrix2);
        double[][] array3 = {{65.0}};
        var expected = new Matrix(array3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void transpos() {
        double[][] array1 = {{10.0, 15.0}};
        Matrix expected = new Matrix(array1);

        double[][] array2 = {{10.0}, {15.0}};
        Matrix matrix2 = new Matrix(array2);

        var actual = matrix2.transpos();

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void cloneTest() {
        double[][] array1 = {{0.0}, {1.0}};
        Matrix unexpected = new Matrix(array1);
        Matrix matrix2 = new Matrix(unexpected);
        var actual = matrix2.mul(3);


        Assertions.assertNotEquals(unexpected, actual);
    }
}