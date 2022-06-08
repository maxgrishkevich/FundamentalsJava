//        Создать базовый класс – дата (год, месяц, день). Производный
//        класс – дата со временем (часы минуты).

public class ex36_1 implements Task36, Cloneable{
    public int day;
    public int month;
    public int year;

    public ex36_1(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public ex36_1() {
        day = 0;
        month = 0;
        year = 0;
    }

    @Override
    public String toString() {
        return "ex36_1{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ex36_1 ex36_1 = (ex36_1) o;

        if (day != ex36_1.day) return false;
        if (month != ex36_1.month) return false;
        return year == ex36_1.year;
    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

