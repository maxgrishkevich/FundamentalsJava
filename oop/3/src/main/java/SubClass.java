

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SubClass extends BaseClass {
    String c;
    transient OtherClass obj;

    public SubClass(int a, double b, String c, OtherClass obj){
        super(a, b);
        this.c = c;
        this.obj = obj;
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeObject(obj.getStatus());
    }

    private void readObject(ObjectInputStream is) throws ClassNotFoundException, IOException {
        is.defaultReadObject();
        int status = (int) is.readObject();
        obj = new OtherClass(status);
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public OtherClass getObj() {
        return obj;
    }

    public void setObj(OtherClass obj) {
        this.obj = obj;
    }
}
