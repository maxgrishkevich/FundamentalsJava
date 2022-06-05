public class Main {
    public static void main(String[] args) {

        String []arr = ("I will have a good day " + "qwert".repeat(1000)).split(" ");

        String last = arr[arr.length - 1];
        System.out.println(last.length());
        RecursiveFunc recObj = new RecursiveFunc();
        IterativeFunc iterObj = new IterativeFunc();

        long time1 = System.nanoTime();
        System.out.println(recObj.recRevers(last));
        long time2 = System.nanoTime();
        System.out.println(iterObj.iterRevers(last));
        long time3 = System.nanoTime();
        System.out.println("Time of recursive func: " + (time2 - time1) +
                "\nTime of iterative func: " + (time3 - time2));
    }
}
