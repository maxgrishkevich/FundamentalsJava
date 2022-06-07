public class Matrix implements Interface {

    private int[] matrix;
    private int[] determinant;

    private void calcDeterminant() {
        System.out.println("Determinant is calculated");
    }
    public Matrix() {

        this.matrix = null;
        this.determinant = null;
        System.out.println("\tMatrix object was created");
    }

    public Matrix(int[] matrix, int[] determinant) {
        this.matrix = matrix;
        this.determinant = determinant;
        System.out.println("\tMatrix object was created");
    }

    public int[] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[] matrix) {
        this.matrix = matrix;
    }

    public int[] getDeterminant() {
        return determinant;
    }

    public void setDeterminant(int[] determinant) {
        this.determinant = determinant;
    }

    @Annotation(info = "The annotation in Matrix")
    public void annotationMethod(){
        System.out.println("The annotationMethod from base class");
    }

    @Override
    public void print() {
        System.out.println("\tHello Matrix");
    }
}
