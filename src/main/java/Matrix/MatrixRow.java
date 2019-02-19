package Matrix;

public class MatrixRow extends SimpleMatrixRow implements Cloneable{

    public MatrixRow(int size) {
        super(size);
    }

    @Override
    protected MatrixRow clone() {
        MatrixRow clone = new MatrixRow(size);
        clone.elements = this.elements.clone();

        return clone;
    }

    public MatrixRow(double[] array) {
        super(array);
    }

    public void set(double elem, int i) {
        if(i < 0 || i >= size)
            throw new IndexOutOfBoundsException
                    ("Нельзя поместить элемент в строку: индекс " + i + " не попадает в диапазон " + "[" + 0 + ";" + (size - 1) + "]");

        elements[i] = elem;
    }

    public void sub(MatrixRow row) {
        row.mul(-1);
        add(row);
        row.mul(1);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj instanceof MatrixRow) {
            MatrixRow right = (MatrixRow) obj;
            if(size == right.size) {
                for(int i = 0; i < size; i ++) {
                    if(elements[i] != right.elements[i])
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var elem: elements) {
            sb.append(elem);
            sb.append(' ');
        }
        return sb.toString();
    }
}
