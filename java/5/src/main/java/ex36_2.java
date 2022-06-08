//        Создать базовый класс – дата (год, месяц, день). Производный
//        класс – дата со временем (часы минуты).

public class ex36_2 extends ex36_1 implements Task36, Cloneable{
    public int hours;
    public int minutes;

    public ex36_2(int day, int month, int year, int hours, int minutes) {
        super(day, month, year);
        this.hours = hours;
        this.minutes = minutes;
    }

    public ex36_2() {
        super();
        hours = 0;
        minutes = 0;
    }

    @Override
    public String toString() {
        return "ex36_2{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ex36_2 ex36_2 = (ex36_2) o;

        if (hours != ex36_2.hours) return false;
        return minutes == ex36_2.minutes;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + hours;
        result = 31 * result + minutes;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
