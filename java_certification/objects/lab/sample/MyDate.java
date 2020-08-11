package sample;

public class MyDate {
    Integer day;
    Integer month;
    Integer year;

    MyDate(Integer m, Integer d, Integer y) {
        setDate(m, d, y);
    }

    MyDate() {

    }

    void setDate(Integer m, Integer d, Integer y) {
        day = d;
        month = m;
        year = y;
    }

    public String toString() {
        return String.valueOf(day) + " - " + String.valueOf(month) + " - " + String.valueOf(year);
    }
}