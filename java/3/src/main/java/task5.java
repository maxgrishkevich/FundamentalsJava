//Создайте программу для шифрования\расшифровки текста
//методом Цезаря. В нем ключом является целое число, а
//шифрование\расшифровка заключается в суммировании\
//вычитании кодов символов открытого текста\криптотекста с
//ключом.
import java.util.Scanner;

public class task5 {
    int key;
//    char [] text;
    public String crypt_decrypt() {

        Scanner scanner = new Scanner(System.in);

        System.out.println ("Hello!\nEnter the positive key(number):");
        key = scanner.nextInt();

//        key = 3;//

//        if(key <= 0){
//            System.out.println("Input error!");
//            System.exit(0);
//        }

        System.out.println ("Enter '1' to crypt or '2' to decrypt:");
        int a = scanner.nextInt();

//        int a = 1;//

        String new_str = "";

        if(a == 1){
            System.out.println("Enter text to crypt:");
            scanner.nextLine();//
            String str = scanner.nextLine();//

//            String str = "hello";//

            int len = str.length();
            char[] text = str.toCharArray();
            System.out.println("Encrypted text: ");
            for(int i = 0; i < len; i++){
                if(text[i] == ' '){
                    System.out.printf("%c", text[i]);
                }else{
                    text[i] += key;
                    System.out.printf("%c", text[i]);
                }
            }
            new_str = new String(text);

        }else if(a == 2){
            System.out.println("Enter text to decrypt: ");
            scanner.nextLine();
            String str = scanner.nextLine();
            int len = str.length();
            char [] text = str.toCharArray();
            System.out.println("Decrypted text: ");
            for(int i = 0; i < len; i++){
                if(text[i] == ' '){
                    System.out.printf("%c", text[i]);
                }else{
                    text[i] -= key;
                    System.out.printf("%c", text[i]);
                }
            }
            new_str = new String(text);

        }else{
            System.out.println("Input error!");
            System.exit(0);
        }

        return new_str;
    }
}
