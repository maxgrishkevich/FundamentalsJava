import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [] a = new int[4];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 4 elements of array: ");

        for(int i = 0; i < 4; i++){
            System.out.println(i+1+" element: ");
            a[i] = scanner.nextInt();
        }

        int positive = 0, negative = 0;
        for(int i = 0; i < 4; i++){
            if(a[i] >= 0){
                positive++;
            }else{
                negative++;
            }
        }

        if(positive == 4){
            System.out.println("All elements of array are positive");
        }else if(negative == 4){
            System.out.println("All elements of array are negative");
        }else{
            System.out.println("The array has positive and negative elements");
        }

    }
}
