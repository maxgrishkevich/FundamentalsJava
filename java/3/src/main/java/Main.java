import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        System.out.println("Enter the number of task: 5, 6, 20 or 44");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
//        if(num != 5 || num != 6 || num != 20 || num != 44){
//            System.out.println("Does not have this task!");
//            System.exit(0);
//        }
        switch(num){
            case(5):
                task5 obj5 = new task5();
                obj5.crypt_decrypt();
                break;
            case(6):
                task6 obj6 = new task6();
                obj6.convert_to_unicode();
                break;
            case(20):
                task20 obj20 = new task20();
                obj20.type_analiser1();
                break;
            case(44):
                task44 obj44 = new task44();
                obj44.type_analizer2();
                break;
        }
    }
}
