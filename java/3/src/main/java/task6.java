//Создайте программу для определения кода введенного
//символа в стандарте Юникод. Обеспечьте цикличность
//выполнения программы до ввода знака равенства (что
//приводит к выходу из программы).
import java.util.Scanner;

public class task6 {
    char ch;
    public int convert_to_unicode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!");
        int code;
        do{
            System.out.println("Enter your symbol to convert to Unicode or '=' to exit: ");
            String str = scanner.next();//

//            String str = "=";//

            char [] array = str.toCharArray();
            ch = array[0];
            if(ch == '=') System.exit(0);//
            code = (int)ch;
            System.out.format("Your symbol converted to Unicode: %04X \n", code);
        }while(ch != '=');
        return code;

    }
}











//        for (char ch : str.toCharArray()) {
//            int code = (int)ch;
//            System.out.format("%04X ", code);
//        }