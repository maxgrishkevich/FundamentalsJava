//        Создать класс для элемента каталога музыкальных компакт
//        дисков (поля: исполнитель, композитор, название диска,
//        любимый трек, дата покупки, кому дан диск, количество
//        треков, продолжительность).

public class ex20 implements Task20, Cloneable {
    public String performer;
    public String composer;
    public String disc;
    public String favouriteSong;
    public String dateOfBuying;
    public String whomDiscGiven;
    public int numberOfSongs;
    public float duration;

    public ex20(String performer, String composer, String disc, String favouriteSong, String dateOfBuying, String whomDiscGiven, int numberOfSongs, float duration) {
        this.performer = performer;
        this.composer = composer;
        this.disc = disc;
        this.favouriteSong = favouriteSong;
        this.dateOfBuying = dateOfBuying;
        this.whomDiscGiven = whomDiscGiven;
        this.numberOfSongs = numberOfSongs;
        this.duration = duration;
    }

    public ex20() {
        performer = "Null";
        composer = "Null";
        disc = "Null";
        favouriteSong = Розробити програму - консольний додакок, з визначенням класу для
        конкретної предметної області (відповідно до варіанту). Визначення класу має
        містити лише поля і методи, що властиві для об’єктів цього класу.
                Для класу визначити декілька конструкторів — з параметрами і без.
        Визначити геттери і сеттери для полів, для яких це є доречним.
        Передбачити щонайменше 3 методи для створених класів (не ураховуючи
        геттери і сеттери). Передбачити щонайменше 1 перевантажений метод.
        У середені конструкторів, сеттерів і (за наявності) інших методів, що
        модифікують значення полів, передбачити перевірку коректності введених
        значень. Поля, для яких слід перевіряти коректність і критерії коректності
        обирайте самі для свого варіанту. В разі невиконання критеріїв коректності
        виводьте у консоль попередження і завершуйте роботу програми (можете
        використовувати, наприклад, System.exit()).
        Використати об'єкти визначених класів і їх методи у програмі, за межами
        визначеного класу (наприклад у main і методах, що викликаються з main).
        Об’єкт Музичний файл – назва альбому, ім’я файлу, тип
        аудіокодека (перерахування: wav, mp3, ogg, flac),
        місцезнаходження (каталог), тривалість запису (хвилини, секунди),
                розмір файлу, дата створення файлу.;
        dateOfBuying = "Null";
        whomDiscGiven = "Null";
        numberOfSongs = 0;
        duration = 0;
    }

    @Override
    public String toString() {
        return "ex20{" +
                "performer='" + performer + '\'' +
                ", composer='" + composer + '\'' +
                ", disc='" + disc + '\'' +
                ", favouriteSong='" + favouriteSong + '\'' +
                ", dateOfBuying='" + dateOfBuying + '\'' +
                ", whomDiscGiven='" + whomDiscGiven + '\'' +
                ", numberOfSongs=" + numberOfSongs +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ex20 ex20 = (ex20) o;

        if (numberOfSongs != ex20.numberOfSongs) return false;
        if (Float.compare(ex20.duration, duration) != 0) return false;
        if (performer != null ? !performer.equals(ex20.performer) : ex20.performer != null) return false;
        if (composer != null ? !composer.equals(ex20.composer) : ex20.composer != null) return false;
        if (disc != null ? !disc.equals(ex20.disc) : ex20.disc != null) return false;
        if (favouriteSong != null ? !favouriteSong.equals(ex20.favouriteSong) : ex20.favouriteSong != null)
            return false;
        if (dateOfBuying != null ? !dateOfBuying.equals(ex20.dateOfBuying) : ex20.dateOfBuying != null) return false;
        return whomDiscGiven != null ? whomDiscGiven.equals(ex20.whomDiscGiven) : ex20.whomDiscGiven == null;
    }

    @Override
    public int hashCode() {
        int result = performer != null ? performer.hashCode() : 0;
        result = 31 * result + (composer != null ? composer.hashCode() : 0);
        result = 31 * result + (disc != null ? disc.hashCode() : 0);
        result = 31 * result + (favouriteSong != null ? favouriteSong.hashCode() : 0);
        result = 31 * result + (dateOfBuying != null ? dateOfBuying.hashCode() : 0);
        result = 31 * result + (whomDiscGiven != null ? whomDiscGiven.hashCode() : 0);
        result = 31 * result + numberOfSongs;
        result = 31 * result + (duration != +0.0f ? Float.floatToIntBits(duration) : 0);
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
