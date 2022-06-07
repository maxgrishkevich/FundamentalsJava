

public class EquationsSystem extends Matrix implements Systemable {
    @MyAnnotation
    private double[] freeMembers;
    private double[] response;

    public EquationsSystem() {
        this.freeMembers = null;
    }

    public EquationsSystem(double[][] matrix, double[] freeMembers) {
        super(matrix);
        this.freeMembers = freeMembers;
    }

    public void setFreeMembers(double[] freeMembers) {
        if (freeMembers.length != getMatrix().length) {
            System.out.println("Неправильно введені вільні члени");
            return;
        }
        this.freeMembers = freeMembers;
    }

    @MyAnnotation
    public void gaussMethod() {
        /* Метод Гауса */
        double[][] A = getMatrix();
        int N = getMatrix().length;

        for (int p = 0; p < N; p++) {

            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) { //порівнюємо 1 і 0 рядок
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            double t = freeMembers[p];
            freeMembers[p] = freeMembers[max];
            freeMembers[max] = t;

            if (Math.abs(A[p][p]) <= 1e-10) { //визначник дорівнюватиме нулю
                System.out.println("СЛАР не має розв'язків");
                return;
            }

            for (int i = p + 1; i < N; i++) {
                double alpha = A[i][p] / A[p][p];
                freeMembers[i] -= alpha * freeMembers[p];
                for (int j = p; j < N; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // Обратный проход
        response = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * response[j];
            }
            response[i] = (freeMembers[i] - sum) / A[i][i];
        }
    }

    private double generateDeter(double[][] matrix, int current) {
        int len = matrix.length;
        double[][] newMatrix = new double[len][len];

        for (int i = 0; i < len; i++) {
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, len);
            newMatrix[i][current] = freeMembers[i];
        }
        return calcDeterminant(newMatrix);
    }

    @MyAnnotation
    public void kramerMethod() {
        double generalDeter = getDeterminant();
        if (generalDeter == 0) return;
        int len = getMatrix().length;

        response = new double[len];

        for (int i = 0; i < len; i++) {
            response[i] = generateDeter(getMatrix(), i) / generalDeter;
        }
    }

    public void showResults() {
        for (double key : response) {
            System.out.println("( " + key + " )");
        }
    }
}

