//        Дано послідовність, що містить від 2 до 50 слів, у кожному з яких від 1
//        до 8 рядкових латинських букв; між сусідніми словами - не менш одного
//        пробілу, за останнім словом - крапка. Надрукувати ті слова послідовності, які
//        відмінні від першого слова й задовольняють наступній властивості:
//        у слові є повторювані букви

import java.util.regex.Pattern;

public class Ex4 {

    public void wordFunction(String words){
        if(words.charAt(words.length()-1) == '.') {
            words = words.substring(0, words.length() - 1);
        }
        System.out.println("This is string with words: " + "'" + words + "'");
        String[] str = words.split(" ");
        String first = str[0];
        System.out.print("There are needed words: ");
        String template = "[a-zA-Z]+$";

        for(int i = 1; i < str.length; i++){
            String nextWord = str[i];
            if(!first.equals(nextWord) && Pattern.matches(template, nextWord)){
                char[] array = nextWord.toCharArray();
                for (int j = 0; j < array.length - 1; j++) {
                    for (int k = j + 1; k < array.length; k++) {
                        if (array[j] == array[k]) {
                            System.out.print(nextWord + " ");
                        }
                    }
                }
            }
        }
        System.out.print("\n\n");
    }

}
