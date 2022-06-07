

public class Matrix implements Matrixable {

    private double[][] matrix;
    @MyAnnotation
    private double determinant;

    {
        this.determinant = 0;
    }

    public Matrix() {
        this.matrix = null;
    }

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    @MyAnnotation
    public double getDeterminant() {
        return determinant;
    }

    public void setDeterminant() {
        if (!canCalcDeterminant(matrix)) {
            System.out.println("Не можливо порахувати визначник не квадратної матриці!");
            return;
        }
        this.determinant = calcDeterminant(matrix);
    }

    private boolean canCalcDeterminant(double[][] matrix) {
        int len = matrix.length;
        for (double[] arr : matrix) {
            if (len != arr.length) return false;
        }
        return true;
    }

    @MyAnnotation
    static double calcDeterminant(double[][] mat) {
        int n = mat.length;
        if (n == 1) return mat[0][0];
        double result = 0;
        double[][] B = new double[n - 1][n - 1];
        int l = 1;
        for (int i = 0; i < n; i++) {

            int x = 0, y = 0;
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == k) continue;
                    B[x][y] = mat[j][k];
                    ++y;
                    if (y == n - 1) {
                        y = 0;
                        ++x;
                    }
                }
            }
            result += l * mat[0][i] * calcDeterminant(B);
            l *= (-1);
        }
        return result;
    }
}
