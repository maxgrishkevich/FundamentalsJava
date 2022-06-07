

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        OtherClass obj = new OtherClass(5, "This OtherClass object has status 5");
        SubClass s = new SubClass(1, 2.0, "custom string", obj);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.bin");
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(s);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) { }

        SubClass readObj = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("file.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readObj = (SubClass) objectInputStream.readObject();
            objectInputStream.close();

        } catch (Exception e) { }

        System.out.println(s);
        System.out.println(readObj);

        if(s.getA() == readObj.getA() && s.getB() == readObj.getB() &&
        s.getC().equals(readObj.getC()) && s.getObj().getStatus() == readObj.getObj().getStatus() &&
        s.getObj().getDescription().equals(readObj.getObj().getDescription())){
            System.out.println("Success!");
        }
        else{
            System.out.println("Fail!");
        }
    }
}
