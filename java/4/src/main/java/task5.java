//Создайте программу для шифрования\расшифровки текста
//методом Цезаря. В нем ключом является целое число, а
//шифрование\расшифровка заключается в суммировании\
//вычитании кодов символов открытого текста\криптотекста с
//ключом.

import java.util.ArrayList;

public class task5 {
    int key;
    public void crypter(String text, int key){
        for(int i = 0; i < text.length(); i++){
             char a = text.charAt(i);
             a += key;
            System.out.printf("%c", a);
        }
    }
    public String crypt_decrypt(String [] args) {
        String new_str = "";
        ArrayList<String> cesar = new ArrayList<>(1);
        key = Integer.parseInt(args[0]);
        int ch = Integer.parseInt(args[2]);
        cesar.add(args[1]);
        switch(ch){
            case (1):
                System.out.println("Encrypted text: ");
                crypter(cesar.get(0), key);
                break;
            case (2):
                System.out.println("Decrypted text: ");
                crypter(cesar.get(0), -key);
                break;
        }
        return new_str;
    }
}
