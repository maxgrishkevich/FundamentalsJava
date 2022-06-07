import java.io.Serializable;

public class Sweater extends Wardrobe implements Serializable {
    protected int sleeveLength; //cm
    protected int sleeveWidth; //cm
    protected int bodyLength; //cm
    protected int bodyWidth; //cm
    private final int status;

    public Sweater(int status){
        this.status = status;
    }

    public Sweater(int size, String color, String typeOfMaterial, int sleeveLength, int sleeveWidth,
                   int bodyLength, int bodyWidth, int status) {
        super(size, color, typeOfMaterial);
        this.sleeveLength = sleeveLength;
        this.sleeveWidth = sleeveWidth;
        this.bodyLength = bodyLength;
        this.bodyWidth = bodyWidth;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
