//Анализ типов аргументов, задаваемых при запуске программы.
//Если аргумент является целым шестнадцатеричным числом
//(шаблон: состоит из цифр от 0 до 9 и букв A(a), B(b), C(c),
//D(d), E(e),F(f), перед числом должны стоять символы "0X" или
//"0x"), то тип аргумента "Hexadecimal", иначе "String".
//Программа выводит количество заданных аргументов и, для
//каждого аргумента, его тип и значение
import java.util.Scanner;

public class task20 {
    public String type_analiser1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!\nEnter the number of arguments which you would enter: ");
        int num = scanner.nextInt();//

//        int num = 1;//

        if (num <= 0) {
            System.out.println("Input error!");
            System.exit(0);
        }
        String arg_type = "";
        System.out.println("There are " + num + " arguments.\nEnter your arguments: ");
        for (int i = 1; i <= num; i++) {
            System.out.print("arg" + i + " = ");
            String arg = scanner.next();//

//            String arg = "etrbty45t46h";//

            int len = arg.length();
            char[] arr = arg.toCharArray();
            if (arr[0] == '0' && (arr[1] == 'x' || arr[1] == 'X')) {
                for (int j = 2; j < len; j++) {
                    if ((arr[j] >= 'a' && arr[j] <= 'f') || (arr[j] >= 'A' && arr[j] <= 'F') || (arr[j] >= '0' && arr[j] <= '9')) {
                        ;
                    } else {
                        arg_type = "String";
                    }
                }
                if (arg_type != "String") {
                    arg_type = "Hexadecimal";
                    System.out.println("The type of arg" + i + " = " + arg + " is: " + arg_type);
                } else {
                    System.out.println("The type of arg" + i + " = " + arg + " is: " + arg_type);
                }
            } else {
                arg_type = "String";
                System.out.println("The type of arg" + i + " = " + arg + " is: " + arg_type);
            }
        }
        return arg_type;
    }
}