
public class SubClass extends BaseClass {
    private int k;

    public SubClass(int i, int j, int k){
        super(i, j);
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public void show(){
        super.show();
        System.out.print(", k = " + k);
    }
}
