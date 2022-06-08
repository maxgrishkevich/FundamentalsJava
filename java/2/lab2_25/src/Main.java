import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean intercalary;
        System.out.println("Is it a leap year now?(enter 'true' or 'false'): ");
        intercalary = scanner.nextBoolean();
        int [] year = {1-366};
        System.out.println("Enter your number of the day: ");
        int number = scanner.nextInt();

        if(intercalary == true) {
            if(number>=0 && number<=31){
                System.out.println(number+".01.20XX");
            }else if(number>=32 && number<=59){
                number -=31;
                System.out.println(number+".02.20XX");
            }else if(number>=60 && number<=91){
                number-=59;
                System.out.println(number+".03.20XX");
            }else if(number>=92 && number<=121){
                number-=91;
                System.out.println(number+".04.20XX");
            }else if(number>=122 && number<=152){
                number-=121;
                System.out.println(number+".05.20XX");
            }else if(number>=153 && number<=182){
                number-=152;
                System.out.println(number+".06.20XX");
            }else if(number>=183 && number<=213){
                number-=182;
                System.out.println(number+".07.20XX");
            }else if(number>=214 && number<=244){
                number-=213;
                System.out.println(number+".08.20XX");
            }else if(number>=245 && number<=274){
                number-=244;
                System.out.println(number+".09.20XX");
            }else if(number>=275 && number<=305){
                number-=274;
                System.out.println(number+".10.20XX");
            }else if(number>=306 && number<=335){
                number-=305;
                System.out.println(number+".11.20XX");
            }else{
                number-=335;
                System.out.println(number+".12.20XX");
            }
        }else{
            if(number>=0 && number<=31){
                System.out.println(number+".01.20XX");
            }else if(number>=32 && number<=59){
                number -=31;
                System.out.println(number+".02.20XX");
            }else if(number>=60 && number<=91){
                number-=59;
                System.out.println(number+".03.20XX");
            }else if(number>=92 && number<=121){
                number-=90;
                System.out.println(number+".04.20XX");
            }else if(number>=122 && number<=152){
                number-=120;
                System.out.println(number+".05.20XX");
            }else if(number>=153 && number<=182){
                number-=151;
                System.out.println(number+".06.20XX");
            }else if(number>=183 && number<=213){
                number-=181;
                System.out.println(number+".07.20XX");
            }else if(number>=214 && number<=244){
                number-=212;
                System.out.println(number+".08.20XX");
            }else if(number>=245 && number<=274){
                number-=243;
                System.out.println(number+".09.20XX");
            }else if(number>=275 && number<=305){
                number-=273;
                System.out.println(number+".10.20XX");
            }else if(number>=306 && number<=335){
                number-=304;
                System.out.println(number+".11.20XX");
            }else{
                number-=334;
                System.out.println(number+".12.20XX");
            }
        }
    }
}
