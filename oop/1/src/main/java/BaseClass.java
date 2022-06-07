
public class BaseClass implements ExampleInterface{
    private int i;
    private int j;

    public BaseClass(){
        System.out.println("Base class object was created");
        i = 0;
        j = 0;
    }

    public BaseClass (int i, int j){
        this.i = i;
        this.j = j;
        System.out.println("Base class object was created");
    }

    private void somePrivateMethod(){
        System.out.println("Some private method was executed");
    }

    @AnnotationExample(info = "Changed value in Base Class", version = 2)
    public void someOtherMethod(int i, int j){
        this.i = i;
        this.j = j;
        System.out.println("Some other method was executed, i = " + i + ", j = " + j);
    }

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }

    public void setI(int i){
        this.i = i;
    }

    public void setJ(int j){
        this.j = j;
    }

    @Override
    public void show() {
        System.out.print("i = " + i + ", j = " + j);
    }
}
