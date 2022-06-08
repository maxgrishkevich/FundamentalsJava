//        Построить программу для работы с классом для хранения
//        данных о сообщении на форуме (автор, тема, текст, время,
//        дата создания и редактирование). Программа должна
//        обеспечивать простейшие функции: ввод значений,
//        редактирование, вывод значений.

public class ex5 implements Task5, Cloneable{
    public String author;
    public String theme;
    public String text;
    public float time;
    public String date;

    public ex5(String author, String theme, String text, float time, String date) {
        this.author = author;
        this.theme = theme;
        this.text = text;
        this.time = time;
        this.date = date;
    }

    public ex5() {
        author = "Null";
        theme = "Null";
        text = "Null";
        time = 0;
        date = "Null";
    }

    @Override
    public void input(String author, String theme, String text, float time, String date) {
        this.author = author;
        this.theme = theme;
        this.text = text;
        this.time = time;
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ex5{" +
                "author='" + author + '\'' +
                ", theme='" + theme + '\'' +
                ", text='" + text + '\'' +
                ", time=" + time +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ex5 ex5 = (ex5) o;

        if (Float.compare(ex5.time, time) != 0) return false;
        if (author != null ? !author.equals(ex5.author) : ex5.author != null) return false;
        if (theme != null ? !theme.equals(ex5.theme) : ex5.theme != null) return false;
        if (text != null ? !text.equals(ex5.text) : ex5.text != null) return false;
        return date != null ? date.equals(ex5.date) : ex5.date == null;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (theme != null ? theme.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (time != +0.0f ? Float.floatToIntBits(time) : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

}
