import java.util.Arrays;

public class ArrayStack {
    private int[] array;
    private int currentCapacity;
    private int size;

    public ArrayStack() {
        this.array = new int[0];
        this.size = -1;
    }

    public void push(int e) {
        if(currentCapacity == 0){
            int DEFAULT_INITIAL_CAPACITY = 10;
            this.array = new int[DEFAULT_INITIAL_CAPACITY];
            currentCapacity = array.length;
        }

        if(currentCapacity - size < 5){
            ensureIncreaseCapacity();
        }
        array[++size] = e;

    }

    public int pop() {
        if(size < 0){
            throw new NullPointerException();
        }

        return array[size--];
    }

    public int size() {
        return size + 1;
    }

    public boolean isEmpty() {
        return size < 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size+1; i++) {
            sb.append(array[i]).append(" ");
        }

        return sb.toString();
    }

    private void ensureIncreaseCapacity(){
        array = Arrays.copyOf(array, currentCapacity + 5);
        currentCapacity = array.length;
        System.out.println("Current capacity: " + currentCapacity);
    }

//    private void ensureDecreaseCapacity(){
//        array = Arrays.copyOfRange(array, 0, size);
//        currentCapacity = array.length;
//    }

    public int sumOfNumbers(){
        int sum = 0;
        for (int i = 0; i < size + 1; i++){
            if (array[i] < 10){
                sum += array[i];
            }
        }
        return sum;
    }
}
