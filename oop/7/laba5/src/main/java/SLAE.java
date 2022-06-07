public class SLAE extends Matrix implements Interface{
    private int[] matrix;
    private int[] freeMembers;
    private String method;

    public SLAE() {
        this.matrix = null;
        this.freeMembers = null;
        this.method = null;
        System.out.println("\tSLAE object was created");
    }

    public SLAE(int[] matrix, int[] determinant, int[] freeMembers, String method) {
        super(matrix, determinant);
        this.matrix = matrix;
        this.freeMembers = freeMembers;
        this.method = method;
        System.out.println("\tSLAE object was created");
    }

    @Override
    public int[] getMatrix() {
        return matrix;
    }

    @Override
    public void setMatrix(int[] matrix) {
        this.matrix = matrix;
    }

    public int[] getFreeMembers() {
        return freeMembers;
    }

    public void setFreeMembers(int[] freeMembers) {
        this.freeMembers = freeMembers;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Annotation(info = "The annotation in SLAE")
    public void annotationMethod(){
        System.out.println("The annotationMethod from extend class");
    }

    @Override
    public void print() {
        System.out.println("\tHello SLAE");
    }
}
