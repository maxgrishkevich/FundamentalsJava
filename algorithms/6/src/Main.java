public class Main {
    public static void main(String[] args){
        int key;
        HashTableWithDoubleHashing table = new HashTableWithDoubleHashing(100);

        for (int i = 0; i < 50 ; i++) {
            key = (int) (java.lang.Math.random() * 2 * 100);
            dataUnit data = new dataUnit(key);
            table.insert(key, data);
        }

        table.print();
        key = 100;
        dataUnit data = table.find(key);
        if (data != null)
            System.out.println("Found " + key);
        else
            System.out.println("Could not find " + key);
    }
}
