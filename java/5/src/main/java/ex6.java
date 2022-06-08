//        Построить программу для работы с классом Дата. Программа
//        должна обеспечивать простейшие функции:
//        увеличение/уменьшение на 1 день, ввод значений, вывод
//        значений.

public class ex6 implements Task6, Cloneable{
    public int number;
    public int month;
    public int year;

    public ex6(int number, int month, int year) {
        if(number > 31 || number < 0 || month > 12 || month < 0){
            System.out.println("Input error!\nCheck your date;)");
            System.exit(0);
        }
        this.number = number;
        this.month = month;
        this.year = year;
    }

    public ex6() {
        number = 0;
        month = 0;
        year = 0;
    }

    @Override
    public void increment() {
        if(number == 28 && month == 2){
            number = 1;
            month++;
        }else if(number == 30 && (month == 4 || month == 6 || month == 9 || month == 10)){
            number = 1;
            month++;
        }else if(number == 31 && month == 12){
            number = 1;
            month = 1;
            year++;
        }else if(number == 31){
            number = 1;
            month++;
        }else{
            number++;
        }
    }

    @Override
    public void decrement() {
        if(number == 1 && month == 3){
            number = 28;
            month--;
        }else if(number == 1 && (month == 5 || month == 7 || month == 10 || month == 11)){
            number = 30;
            month--;
        }else if(number == 1 && month == 1){
            number = 31;
            month = 12;
            year--;
        }else if(number == 1){
            number = 31;
            month--;
        }else{
            number--;
        }
    }

    @Override
    public String toString() {
        return "ex6{" +
                "number=" + number +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ex6 ex6 = (ex6) o;

        if (number != ex6.number) return false;
        if (month != ex6.month) return false;
        return year == ex6.year;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
