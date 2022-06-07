import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Trousers extends Wardrobe implements Clothes, Serializable {
    private final int galoshesLength; //cm
    private final int galoshesWidth; //cm
    private final int waistWidth; //cm
    transient Sweater sweater;
    transient Sneakers sneakers;

    public Trousers(int size, String color, String typeOfMaterial, int galoshesLength,
                    int galoshesWidth, int waistWidth, Sweater sweater, Sneakers sneakers) {
        super(size, color, typeOfMaterial);
        this.galoshesLength = galoshesLength;
        this.galoshesWidth = galoshesWidth;
        this.waistWidth = waistWidth;
        this.sweater = sweater;
        this.sneakers = sneakers;
    }

    public String getInformation (Trousers obj) {
        return "Trousers{" +
                "size=" + obj.size +
                ", color=" + obj.color +
                ", typeOfMaterial=" + obj.typeOfMaterial +
                ", galoshesLength=" + galoshesLength +
                ", galoshesWidth=" + galoshesWidth +
                ", waistWidth=" + waistWidth +
                "}\n"+
                "Sweater{" +
                "size=" + obj.sweater.size +
                ", color=" + obj.sweater.color +
                ", typeOfMaterial=" + obj.sweater.typeOfMaterial +
                ", sleeveLength=" + sweater.sleeveLength +
                ", sleeveWidth=" + sweater.sleeveWidth +
                ", bodyLength=" + sweater.bodyLength +
                ", bodyWidth=" + sweater.bodyWidth +
                "}\n"+
                "Sneakers{" +
                "size=" + obj.sneakers.size +
                ", color=" + obj.sneakers.color +
                ", typeOfMaterial=" + obj.sneakers.typeOfMaterial +
                ", soleHeight=" + sneakers.soleHeight +
                '}';
    }

    public void equalsColor(Trousers obj){
        if(obj.color.equals(sweater.color) && obj.color.equals(sneakers.color)){
            System.out.println("It`s a very good choice of looking;)");
        }else if(obj.color.equals(sweater.color) || obj.color.equals(sneakers.color) || sweater.color.equals(sneakers.color)){
            System.out.println("It`s not bad variant of looking;)");
        }else{
            System.out.println("You will be looking as traffic light)");
        }
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeObject(sweater.getStatus());
        os.writeObject(sneakers.getStatus());
    }

    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
        is.defaultReadObject();
        int status = (int) is.readObject();
        sweater = new Sweater(status);
        sneakers = new Sneakers(status);
    }

    public int getGaloshesLength() {
        return galoshesLength;
    }

    public int getGaloshesWidth() {
        return galoshesWidth;
    }

    public int getWaistWidth() {
        return waistWidth;
    }

    public Sweater getSweater() {
        return sweater;
    }

    public Sneakers getSneakers() {
        return sneakers;
    }

}
