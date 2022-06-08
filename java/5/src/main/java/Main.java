import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws CloneNotSupportedException {
        System.out.println("\nEnter the number of task: 5, 6, 20 or 36");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        switch(num) {
            case (5):
                Task5 obj11 = new ex5("Max Hryshkevych", "Films", "The premiere of film will take place tomorrow", 18.16f, "02.11.2020");
                System.out.println(obj11);
                Task5 obj12 = new ex5("Max Hryshkevych", "Films", "The premiere of film will take place tomorrow", 18.16f, "02.11.2020");
                System.out.println(obj12);
                System.out.println("Equality of objects: "+obj11.equals(obj12)+"\nHashcodes: 1) "+obj11.hashCode()+" 2) "+obj12.hashCode());
                obj12.input("Max Hryshkevych","Cartoons","Walt Disney has released a new cartoon",18.30f,"02.11.2020");
                System.out.println(obj12);
                System.out.println("Equality of objects: "+obj11.equals(obj12)+"\nHashcodes: 1) "+obj11.hashCode()+" 2) "+obj12.hashCode());
                Task5 clone1 = (ex5) ((ex5) obj11).clone();
                System.out.println("Creating clone...");
                System.out.println(clone1);
                break;
            case (6):
                Task6 obj21 = new ex6(31, 12, 2020);
                System.out.println(obj21);
                Task6 obj22 = new ex6(1, 1, 2021);
                System.out.println(obj22);
                System.out.println("Equality of objects: "+obj21.equals(obj22)+"\nHashcodes: 1) "+obj21.hashCode()+" 2) "+obj22.hashCode());
                obj21.increment();
                System.out.println(obj21);
                obj22.decrement();
                System.out.println(obj22);
                Task6 clone2 = (ex6) ((ex6) obj21).clone();
                System.out.println("Creating clone...");
                System.out.println(clone2);
                break;
            case(20):
                Task20 obj31 = new ex20("Miyagi", "Miyagi", "Yamakasi", "Minor", "03.11.2020", "Max", 9, 37.00f);
                System.out.println(obj31);
                Task20 clone3 = (ex20) ((ex20) obj31).clone();
                System.out.println("Creating clone...");
                System.out.println(clone3);
                break;
            case(36):
                Task36 obj41 = new ex36_2(3, 11, 2020, 2, 0);
                System.out.println(obj41);
                ex36_2 clone4 = (ex36_2) ((ex36_2) obj41).clone();
                System.out.println("Creating clone...");
                System.out.println(clone4);
                break;
        }
    }
}