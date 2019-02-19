package Matrix;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private int rowsNum;
    private int colsNum;

    private List<MatrixRow> rows;


    public Matrix(int rows, int cols) {
        rowsNum = rows;
        colsNum = cols;

        this.rows = new ArrayList<>(rowsNum);
        for(int i = 0 ; i < rowsNum ; i ++) {
            var row = new MatrixRow(colsNum);
            this.rows.add(row);
        }
    }
    public Matrix(double matrix[][]) {
        rowsNum = matrix.length;
        colsNum = matrix[0].length;
        rows = new ArrayList<>(rowsNum);

        for(int i = 0 ; i < matrix.length ; i++) {
            MatrixRow row = new MatrixRow(matrix[i]);
            rows.add(row);
        }
    }
    public Matrix(Matrix matrix) {
        rowsNum = matrix.rowsNum;
        colsNum = matrix.colsNum;

        rows = new ArrayList<>(rowsNum);

        for (var row: matrix.rows) {
            var rowClone = row.clone();
            rows.add(rowClone);
        }
    }






    public double[][] getCells() {
        double[][] cells = new double[rowsNum][colsNum];
        int i = 0;
        for (var row:rows ) {
            cells[i] = row.getElements();
        }
        return cells;
    }
    public int getColsNum() {
        return colsNum;
    }
    public int getRowsNum() {
        return rowsNum;
    }
    public double get(int i, int j) {
        return rows.get(i).get(j);
    }






    private double[] getRow(int i) {
        return rows.get(i).getElements();
    }
    private double[] getCol(int j) {
        double[] result = new double[rowsNum];
        for(int i = 0; i < rowsNum; i ++) {
            result[i] = get(i, j);
        }

        return result;
    }





    public Matrix AddMatrix(Matrix matrix) {
        if(!isAddable(this, matrix))
            return null;

        Matrix result = new Matrix(this);
        for (int i = 0; i < rowsNum; i ++) {
            result.rows.get(i).add(matrix.rows.get(i));
        }

        return result;
    }
    public Matrix SubMatrix(Matrix matrix) {
        if(!isAddable(this, matrix))
            return null;

        Matrix result = new Matrix(this);
        for (int i = 0; i < rowsNum; i ++) {
            result.rows.get(i).sub(matrix.rows.get(i));
        }

        return result;
    }
    //умножение на число
    public Matrix mul(double x) {
        Matrix result = new Matrix(this);
        for (int i = 0; i < rowsNum; i ++) {
            result.rows.get(i).mul(x);
        }

        return result;
    }
    //умножение на другую матрицу
    public Matrix mul(Matrix matrix) {
        if(!isMultable(this, matrix))
            return null;

        Matrix result = new Matrix(this.rowsNum, matrix.colsNum);
        for (int i = 0; i < result.rowsNum; i ++) {
            var row = this.getRow(i);
            for (int j = 0; j < result.colsNum; j ++) {
                var col = matrix.getCol(j);
                var value = mulRowOnCol(row, col);
                result.rows.get(i).set(value, j);
            }
        }
        return result;
    }
    //умножение двух векторов (строки на столбец)
    private double mulRowOnCol(double[] row, double[] col) {
        double result = 0;
        for(int i = 0 ; i < row.length ; i ++) {
            result += row[i] * col[i];
        }
        return result;
    }
    public Matrix transpos() {
        Matrix result = new Matrix(this.colsNum, this.rowsNum);

        for(int i = 0; i < colsNum; i ++) {
            var row = new MatrixRow(this.getCol(i));
            result.rows.set(i, row);
        }

        return result;
    }



    public static boolean isAddable(Matrix left, Matrix right) {
        return left.rowsNum == right.rowsNum
                && left.colsNum == right.colsNum;
    }
    public static boolean isMultable(Matrix left, Matrix right) {
        return left.colsNum == right.rowsNum;
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var row: rows) {
            sb.append(row);
            sb.append('\n');
        }
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj instanceof Matrix) {
            Matrix right = (Matrix) obj;
            if(rowsNum == right.rowsNum && colsNum == right.colsNum) {
                for(int i = 0; i < rowsNum; i ++) {
                    if(!rows.get(i).equals(right.rows.get(i)))
                        return false;
                }
                return true;
            }
        }
        return false;
    }
}
