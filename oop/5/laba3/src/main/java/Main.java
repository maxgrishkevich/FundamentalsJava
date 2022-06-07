import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!)");
        System.out.println("Let`s check your variant of looking");


        Sweater hoody = new Sweater(52, "red", "cotton", 140,
                8, 70, 92, 1);
        Sneakers cross = new Sneakers(42, "blue", "suede", 4, 1);
        Trousers jeans = new Trousers(53, "blue", "jeans", 134,
                15, 35, hoody, cross);

        System.out.println(jeans.getInformation(jeans));

        jeans.equalsColor(jeans);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.bin");
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(jeans);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Trousers readObj = null;

        try {
            FileInputStream fileInputStream = new FileInputStream("file.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readObj = (Trousers) objectInputStream.readObject();
            objectInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if(jeans.getSize() == Objects.requireNonNull(readObj).getSize() &&
                jeans.getColor().equals(readObj.getColor()) &&
                jeans.getTypeOfMaterial().equals(readObj.getTypeOfMaterial()) &&
                jeans.getGaloshesLength() == readObj.getGaloshesLength() &&
                jeans.getGaloshesWidth() == readObj.getGaloshesWidth() &&
                jeans.getWaistWidth() == readObj.getWaistWidth() &&
                jeans.getSweater().getStatus() == readObj.getSweater().getStatus()
                && jeans.getSneakers().getStatus() == readObj.getSneakers().getStatus()
        ){
            System.out.println("Success!");
        }
        else{
            System.out.println("Fail!");
        }

    }
}
