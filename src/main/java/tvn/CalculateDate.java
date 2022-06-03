package tvn;

import java.time.LocalDate;

public class CalculateDate {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalDate DateBefore100day = currentDate.plusDays(100);
        System.out.println(DateBefore100day);
    }
}
