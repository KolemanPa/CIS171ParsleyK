import java.util.Scanner;
public class Calendar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the year you want (Ex: 2057):  ");
        int year = sc.nextInt();
        int month= 0;
        
        // Ensures month is a valid number
            boolean valid = false;
            while (valid == false){
            System.out.println("Please enter a number from 1-12");
            month = sc.nextInt();
            if (month > 0 && month <= 12)
                valid = true;
            else
                valid = false;
            }
        

        
        
        printCalendar(year, month);
    }
    
    public static void printCalendar(int year, int month){
        
}
    public static void printMonthTitle(int year, int month) {
        System.out.println("        "+ getMonthName(month) +"   "+year);
        border();
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }
    public static void border(){
        for (int i = 0; i > 27; i ++){
        System.out.print("-");
        }
    }
    public static String getMonthName(int month) {
        String[] monthArray = new String[]{"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
        String monthName = "";
        monthArray[month] = monthName;
        return monthName;
    }
    public static void printMonthBody(int year,int month){
        int startDay = getStartDay(year, month);
    }
    
    
    public static int getStartDay(int year, int month){
        final int START_DAY_JAN_1_1800 = 3;
        int totalNumDays = getTotalNumdays(year, month);
        
        return (totalNumDays + START_DAY_JAN_1_1800) % 7;
    }
    
    public static int getTotalNumDays(int year, int month){
        int total= 0;
        
        for (int i = 1800; i<year; i++)
            if (isLeapYear(i))
                total = total + 366
    }
    }
    

    
    
    

