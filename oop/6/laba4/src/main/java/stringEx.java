//        Анализ типов аргументов, задаваемых при запуске программы.
//        Если аргумент является целым шестнадцатеричным числом
//        (шаблон: состоит из цифр от 0 до 9 и букв A(a), B(b),
//        C(c), D(d), E(e),F(f), перед числом должны стоять символы
//        "0X" или "0x"), то  тип аргумента "Hexadecimal", иначе "String".
//        Программа выводит количество заданных аргументов и, для
//        каждого аргумента, его тип и значение.

import java.util.regex.Pattern;

public class stringEx {

    public void analyzeArguments(String[] args) {
        System.out.println("Your entered " + args.length + " arguments");
        for(int i = 0; i < args.length; i++){
            String template = "^0[xX][0-9a-fA-F]+$";
            String type;
            if(Pattern.matches(template, args[i])) {
                type = "Hexadecimal";
            } else {
                type = "String";
            }
            showArg(args[i], (i+1), type);
        }
    }

    public static void showArg( String arg, int n, String type ) {
        System.out.printf("Argument # %d: '%s' has type - %s\n", n, arg, type);
    }

    public static void main(String[] args) {
        stringEx obj = new stringEx();
        System.out.println("Hello!)");
        obj.analyzeArguments(args);
        System.out.println("Good bye!)");
    }
}
