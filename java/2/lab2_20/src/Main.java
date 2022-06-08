import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] a = new int [10];
        int sum = 0;

        System.out.println("Enter 10 elements of first array: ");
        for(int i = 0; i < 10; i++){
            System.out.println(i+1 + " element: ");
            a[i] = scanner.nextInt();
            sum += a[i];
        }

        int average = sum/10;

        float more = 0;
        float less = 0;
        float exactly = 0;
        for(int i = 0; i < 10; i++){
            if(average < a[i]){
                more++;
            }else if(average > a[i]){
                less++;
            }else{
                exactly++;
            }
        }

        System.out.println(more/10*100 + "% elements of array have more value than average value");
        System.out.println(exactly/10*100 + "% elements of array have equal value with average value");
        System.out.println(less/10*100 + "% elements of array have less value than average value");
    }
}
