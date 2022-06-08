//.Анализ типов аргументов, задаваемых при запуске программы.
//Если аргумент является числовым литералом, т.е. начинается с
//цифры, то определяется его тип ("Integer" или "Real"), если
//аргумент заключен в одиночные апострофы и содержит один
//символ, то его тип – "Character", если аргумент заключен в
//двойные апострофы, то его тип – "String". Если не одно из
//условий не выполняется, то тип аргумента – "Identifier".
//Программа выводит количество заданных аргументов и, для
//каждого аргумента, его тип и значение.
import java.util.Scanner;

public class task44 {
    public String type_analizer2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello!\nEnter the number of arguments which you would enter: ");
//        int num = scanner.nextInt();//

        int num = 1;//

        if (num <= 0) {
            System.out.println("Input error!");
            System.exit(0);
        }
        String arg_type = "";
        System.out.println("There are " + num + " arguments.\nEnter your arguments: ");
        for (int i = 1; i <= num; i++) {
            System.out.print("arg" + i + " = ");
//            String arg = scanner.next();//

            String arg = "384948";//

            int len = arg.length();
            char[] arr = arg.toCharArray();
            if(arr[0] == '"' && arr[len-1] == '"'){
                arg_type = "String";
                System.out.println("The type of arg" + i + " = " + arg + " is: " + arg_type);
            }else if(Character.isDigit(arr[0]) || arr[0] == '-'){
                for(int j = 1; j < len; j++){
                    if(Character.isDigit(arr[j])){
                        ;
                    }else{
                        arg_type = "Identifier";
                    }
                }
                if(arg_type != "Identifier"){
                    arg_type = "Integer";
                    System.out.println("The type of arg" + i + " = " + arg + " is: " + arg_type);
                }else{
                    System.out.println("The type of arg" + i + " = " + arg + " is: " + arg_type);
                }
            }else if(arr[0] == 39 && arr[2] == 39 && len == 3){
                arg_type = "Character";
                System.out.println("The type of arg" + i + " = " + arg + " is: " + arg_type);
            }else{
                arg_type = "Identifier";
                System.out.println("The type of arg" + i + " = " + arg + " is: " + arg_type);
            }
        }
        return arg_type;
    }
}
