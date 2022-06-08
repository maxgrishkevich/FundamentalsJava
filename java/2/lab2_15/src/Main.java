import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [] a = new int[5];
        int [] b = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 elements of first array " +
                "(it is necessary that the elements are not repeated): ");
        for(int i = 0; i < 5; i++){
            System.out.println(i+1 + " element: ");
            a[i] = scanner.nextInt();
        }

        System.out.println("Enter 5 elements of second array" +
                "(it is necessary that the elements are not repeated): ");
        for(int i = 0; i < 5; i++){
            System.out.println(i+1 + " element: ");
            b[i] = scanner.nextInt();
        }

        System.out.println("The common elements: ");
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(a[i] == b[j]){
                    System.out.println(a[i]);
                }
            }
        }
    }
}
