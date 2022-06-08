// Создайте приложение для просмотра списка книг
// и удаления книг в  библиотечном каталоге.
// Записи в списке (5 записей) являются объектами
// класса HashMap, где ключом является индекс ISBN
// книги (типа Integer), а значением – объект Book,
// содержащий наименование книги, фамилию, имя и отчество
// (ФИО) автора, издательство (все поля типа String), год
// издания (типа int) и цену книги (типа float).
// Предусмотреть возможность сортировки книг по 2-3 полям,
// для чего использовать ArrayList.

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class task20 {
    public static class Library {
        private String name;
        private String author;
        private String edition;
        private int year;
        private float price;
        public Library(String n, String a, String e, int y, float p){
            name = n;
            author = a;
            edition = e;
            year = y;
            price = p;
        }
        public Library(){}
        String getName(){return name;}
        String getAuthor(){return author;}
        String getEdition(){return edition;}
        int getYear(){return year;}
        float  getPrice(){return price;}
        void showList(HashMap<Integer, Library> list){
            for (Map.Entry<Integer, Library> item : list.entrySet()) {
                System.out.printf("Key: %s,  Name: %s, Author: %s, Edition: %s, Year: %d, Price: %.2f. \n", item.getKey(), item.getValue().getName(), item.getValue().getAuthor(), item.getValue().getEdition(), item.getValue().getYear(), item.getValue().getPrice());
            }
        }
        void showSortedList(ArrayList<Library> list){
            for(int i=0; i<list.size(); i++){
                System.out.printf("Name: "+list.get(i).getName()+", Author: "+list.get(i).getAuthor()+", Edition: "+list.get(i).getEdition()+", Year: "+list.get(i).getYear()+", Price: "+list.get(i).getPrice()+"\n");
            }
        }
    }

    public int hash_book_map(){
        HashMap<Integer, Library> books = new HashMap<>(5);
        books.put(1, new Library("Tom Soyer", "Mark Twen",  "London Times", 1732, 25));
        books.put(2, new Library("Harry Potterr", "Joan Roaling", "Every Day", 1882, 45));
        books.put(3, new Library("Kobzar", "Taras Shevchenko", "Prosvita", 1852, 30));
        books.put(4, new Library("Baron Munhauzen", "Rudolf Raspe", "Cup of tea", 1772, 40));
        books.put(5, new Library("Charlie and chocolate factory", "Charlz Dickens", "Good morning", 1825, 40));

        ArrayList<Library> sortingList = sort_list(books);
//        ArrayList<Library> sortingList2 = sort_list_byauthor(books);

        System.out.println("Hello!");
        Scanner in = new Scanner(System.in);
//        return sortingList.size();
        while(true) {
            System.out.println("Enter what you would to do:\n1.)Watch the book list\n2.)Sort list\n3.)Delete books\n4.)Exit the program");
            int choice = in.nextInt();
            if(choice>4 || choice<1){
                System.out.println("Input error!");
                System.exit(0);
            }
            switch (choice) {
                case (1):
                    Library obj1 = new Library();
                    obj1.showList(books);
                    break;
                case (2):
                    sort_list(books);
                    System.out.println("Sorted list:");
                    Library obj2 = new Library();
                    obj2.showSortedList(sortingList);
                    break;
                case (3):
                    Library obj5 = new Library();
                    obj5.showList(books);
                    System.out.println("Enter the key of book which you would delete: ");
                    int del = in.nextInt();
                    books.remove(del);
                    System.out.println("Book is deleted(");
                    break;

                case (4):
                    System.out.println("Good luck)");
                    System.exit(0);
                    break;
            }
        }
    }

    static ArrayList<Library> sort_list(HashMap<Integer,Library> books){
        ArrayList<Library> sortingList = new ArrayList<>(books.values());
        Collections.sort(sortingList, new Comparator<Library>() {
            @Override
            public int compare(Library o1, Library o2) {
                int valueName = o1.getName().compareTo(o2.getName());
                if(valueName!=0){
                    return valueName;
                }
                int valueAuthor = o1.getAuthor().compareTo(o2.getAuthor());
                if(valueAuthor!=0){
                    return valueAuthor;
                }
                return o1.getEdition().compareTo(o2.getEdition());
            }
        });
        return sortingList;
    }



















    
//    static ArrayList<Library> sort_list_byauthor(HashMap<Integer,Library> books){
//        ArrayList<Library> sortingList = new ArrayList<>(books.values());
//        Collections.sort(sortingList, new Comparator<Library>() {
//            @Override
//            public int compare(Library o1, Library o2) {
//                int valueAuthor = o1.getAuthor().compareTo(o2.getAuthor());
//                return valueAuthor;
////                if(valueName!=0){
////                    return valueName;
////                }
////                int valueAuthor = o1.getAuthor().compareTo(o2.getAuthor());
////                if(valueAuthor!=0){
////                    return valueAuthor;
////                }
////                return o1.getEdition().compareTo(o2.getEdition());
//            }
//        });
//        return sortingList;
//    }
}

