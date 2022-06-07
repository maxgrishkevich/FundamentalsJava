//        Розробити програму - консольний додакок, з визначенням класу для
//        конкретної предметної області (відповідно до варіанту). Визначення класу має
//        містити лише поля і методи, що властиві для об’єктів цього класу.
//        Для класу визначити декілька конструкторів — з параметрами і без.
//        Визначити геттери і сеттери для полів, для яких це є доречним.
//        Передбачити щонайменше 3 методи для створених класів (не ураховуючи
//        геттери і сеттери). Передбачити щонайменше 1 перевантажений метод.
//        У середені конструкторів, сеттерів і (за наявності) інших методів, що
//        модифікують значення полів, передбачити перевірку коректності введених
//        значень. Поля, для яких слід перевіряти коректність і критерії коректності
//        обирайте самі для свого варіанту. В разі невиконання критеріїв коректності
//        виводьте у консоль попередження і завершуйте роботу програми (можете
//        використовувати, наприклад, System.exit()).
//        Використати об'єкти визначених класів і їх методи у програмі, за межами
//        визначеного класу (наприклад у main і методах, що викликаються з main).

//        Об’єкт Музичний файл – назва альбому, ім’я файлу, тип
//        аудіокодека (перерахування: wav, mp3, ogg, flac),
//        місцезнаходження (каталог), тривалість запису (хвилини, секунди),
//        розмір файлу, дата створення файлу.


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Music {
  private String nameOfAlbum;
  private String nameOfSong;
  private AudioType type;
  private String location;
  private String during;
  private float size;
  private String date;

    public Music(String nameOfAlbum, String nameOfSong, AudioType type, String location, String during, float size, String date) {
        this.nameOfAlbum = nameOfAlbum;
        this.nameOfSong = nameOfSong;
        this.type = type;
        this.location = location;

        if(!during.contains("[a-zA-Z]+")){
            this.during = during;
        }else{
            System.out.println("Input error!\nEnter during in format: 'mm:ss'");
            System.exit(0);
        }

        if(size < 0){
            System.out.println("Input error!");
            System.exit(0);
        }else{
            this.size = size;
        }

        if(!date.contains("[a-zA-Z]+")){
            this.date = date;
        }else{
            System.out.println("Input error!\nEnter date in format: 'day-month-year'");
            System.exit(0);
        }
    }

    public Music() {
      nameOfAlbum = "Null";
      nameOfSong = "Null";
      type = AudioType.no;
      location = "Null";
      during = "Null";
      size = 0f;
      date = "Null";
    }

    public String getNameOfAlbum() { return nameOfAlbum; }
    public void setNameOfAlbum(String nameOfAlbum) { this.nameOfAlbum = nameOfAlbum; }
    public String getNameOfSong() { return nameOfSong; }
    public void setNameOfSong(String nameOfSong) { this.nameOfSong = nameOfSong; }
    public AudioType getType() { return type; }
    public void setType(AudioType type) { this.type = type; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getDuring() { return during; }
    public void setDuring(String during) { this.during = during; }
    public float getSize() { return size; }
    public void setSize(float size) { this.size = size; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public void showList(HashMap<Integer, Music> list){
        for (Map.Entry<Integer, Music> item : list.entrySet()) {
            System.out.printf("Key: %d,  Name of album: %s, Name of song: %s, Type: %s, " +
                    "Location: %s, During: %s., Size: %.2f, Date: %s \n", item.getKey(),
                    item.getValue().getNameOfAlbum(), item.getValue().getNameOfSong(),
                    item.getValue().getType(), item.getValue().getLocation(), item.getValue().getDuring(),
                    item.getValue().getSize(), item. getValue().getDate());
        }
    }

    public HashMap deleteFromList(HashMap<Integer, Music> list){
        Scanner in = new Scanner(System.in);
        showList(list);
        System.out.println("Enter the key of track which you would delete: ");
        int del = in.nextInt();
        list.remove(del);
        System.out.println("Track is deleted(");
        return list;
    }

    public HashMap addToList(HashMap<Integer, Music> list){
        Music track5 = new Music();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the key: ");
        int key = in.nextInt();
        System.out.println("Enter the name of album: ");
        in.nextLine();
        String nameOfAlbum = in.nextLine();
        track5.setNameOfAlbum(nameOfAlbum);
        System.out.println("Enter the name of song: ");
        String nameOfSong = in.nextLine();
        track5.setNameOfSong(nameOfSong);
        System.out.println("Enter the location: ");
        String location = in.nextLine();
        track5.setLocation(location);
        System.out.println("Enter the during: ");
        String during = in.nextLine();
        track5.setDuring(during);
        System.out.println("Enter the size: ");
        float size = in.nextFloat();
        track5.setSize(size);;
        System.out.println("Enter the date: ");
        in.nextLine();
        String date = in.nextLine();
        track5.setDate(date);
        track5.setType(AudioType.mp3);

        System.out.println("You enter this element: ");
        System.out.println(track5);
        System.out.println("Adding...");
        list.put(key, track5);
        return list;
    }

    @Override
    public String toString() {
        return "Music{" +
                "nameOfAlbum='" + nameOfAlbum + '\'' +
                ", nameOfSong='" + nameOfSong + '\'' +
                ", type=" + type +
                ", location='" + location + '\'' +
                ", during='" + during + '\'' +
                ", size=" + size +
                ", date='" + date + '\'' +
                '}';
    }
}
