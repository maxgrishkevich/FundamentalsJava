// Создайте приложение для просмотра списка файлов
// и добавления файла в список.  Список (для 5 текстовых
// файлов с расширением .txt) создается в программе и
// является объектом класса HashMap, где ключом является
// имя файла (типа String), а значением – объект типа TextFile,
// содержащий два элемента String – абсолютный путь к файлу
// (без имени файла) и краткое описание содержимого файла

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task44 {
    class TextFile{
        private String way, description;
        public TextFile(String w, String desc){
            way = w;
            description = desc;
        }
        public TextFile(){}
        String getWay(){return way;}
        String getDescription(){return description;}
        void showList(HashMap<String, TextFile> list){
            for (Map.Entry<String, task44.TextFile> item : list.entrySet()) {
                System.out.printf("Key(Name): %s.txt, Way: %s, Description: %s\n", item.getKey(), item.getValue().getWay(), item.getValue().getDescription());
            }
        }
    }
    public int fileList(){
        HashMap<String, TextFile> files = new HashMap<>(5);
        files.put("poem", new TextFile("C:/Program Files/myBook", "There is my first poem"));
        files.put("plan", new TextFile("C:/Program Files/Goals/myGoals", "There is my goals at summer"));

        System.out.println("Hello!");
        Scanner in = new Scanner(System.in);
//        return files.size();
        while(true) {
            System.out.println("Enter what you would to do:\n1.)Watch the list of file\n2.)Add file to list\n3.)Delete file from list\n4.)Exit the program");
            int choice = in.nextInt();
            if(choice>4 || choice<1){
                System.out.println("Input error!");
                System.exit(0);
            }
            switch (choice){
                case (1):
                    TextFile obj = new TextFile();
                    obj.showList(files);
                    break;
                case(2):
                    System.out.println("Enter the key(name) of the file: ");
                    in.nextLine();
                    String key = in.nextLine();
                    System.out.println("Enter the way to the file: ");
                    String way = in.nextLine();
                    System.out.println("Enter the description of the file: ");
                    String description = in.nextLine();
                    files.put(key, new TextFile(way, description));
                    break;
                case (3):
                    TextFile obj1 = new TextFile();
                    obj1.showList(files);
                    System.out.println("Enter the key(name) of the file which you would delete: ");
                    in.nextLine();
                    String del = in.nextLine();
                    files.remove(del);
                    System.out.println("File is deleted");
                    break;
                case (4):
                    System.out.println("Good luck)");
                    System.exit(0);
                    break;
            }
        }
    }
}

