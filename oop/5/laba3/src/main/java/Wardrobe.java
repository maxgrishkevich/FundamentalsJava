import java.io.Serializable;

abstract class Wardrobe implements Serializable {
    protected int size;
    protected String color;
    protected String typeOfMaterial;

    public Wardrobe(){

    }

    public Wardrobe(int size, String color, String typeOfMaterial) {
        this.size = size;
        this.color = color;
        this.typeOfMaterial = typeOfMaterial;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

}
