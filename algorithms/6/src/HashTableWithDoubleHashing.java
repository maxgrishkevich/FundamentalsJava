public class HashTableWithDoubleHashing {
    private final dataUnit[] array;

    private final int size;

    private final dataUnit bufUnit;

    HashTableWithDoubleHashing(int size) {
        this.size = size;
        array = new dataUnit[this.size];
        bufUnit = new dataUnit(-1);
    }

    public int hash1(int key) {
        return key % size;
    }

    public int hash2(int key) {
        return 5 - key % 5;
    }

    public void print() {
        System.out.print("Hash Table: ");
        for (int j = 0; j < size; j++) {
            if (array[j] != null)
                System.out.print(array[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println();
    }

    public void insert(int key, dataUnit item) {
        int value = hash1(key);
        int step = hash2(key);

        while (array[value] != null && array[value].getKey() != -1) {
            value += step;
            value %= size;
        }
        array[value] = item;
    }

    public dataUnit delete(int key) {
        int hashVal = hash1(key);
        int stepSize = hash2(key);

        while (array[hashVal] != null) {
            if (array[hashVal].getKey() == key) {
                dataUnit temp = array[hashVal];
                array[hashVal] = bufUnit;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= size;
        }
        return null;
    }

    public dataUnit find(int key) {
        int value = hash1(key);
        int step = hash2(key);

        while (array[value] != null) {
            if (array[value].getKey() == key)
                return array[value];
            value += step;
            value %= size;
        }
        return null;
    }

}

class dataUnit {
    private final int data;

    public dataUnit(int i) {
        data = i;
    }

    public int getKey() {
        return data;
    }

}
