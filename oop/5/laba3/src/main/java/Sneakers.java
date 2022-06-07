import java.io.Serializable;

public class Sneakers extends Wardrobe implements Serializable {
    protected int soleHeight; //cm
    private final int status;

    public Sneakers(int status){
        this.status = status;
    }

    public Sneakers(int size, String color, String typeOfMaterial, int soleHeight, int status) {
        super(size, color, typeOfMaterial);
        this.soleHeight = soleHeight;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
