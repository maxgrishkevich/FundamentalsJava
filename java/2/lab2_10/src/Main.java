import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [] a = new int[10];
        int [] b = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 10 elements of array: ");

        for(int i = 0; i < 10; i++){
            System.out.println(i+1 + " element: ");
            a[i] = scanner.nextInt();
        }

        System.out.println("Array b: ");
        for(int i = 0; i < 10; i++){
            int k = 0;
            for(int j = 0; j < 10; j++){
                if(a[i] == a[j]){
                    k++;
                }
            }
            b[i] = k;
            System.out.println(b[i] + " ");
        }
    }
}
