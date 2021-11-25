package helper;

import java.util.Scanner;

public class Input {
    private static Scanner in = new Scanner(System.in);

    public static int nextInt() {
        return in.nextInt();
    }

    public static String nextSting() {
        return in.nextLine();
    }

    public static String phoneNumber() {
        String phone = nextSting();
        String phoneNumber = "";
        for (char ch : phone.toCharArray()){
            if(ch >= '0' && ch <= '9'){
                phoneNumber += ch;
            }
        }
        if(phoneNumber.length() < 10){
            System.out.println("Не провальный номер.  ");
            System.out.print("Введите корректный номер :");
            phoneNumber = phoneNumber();
        }

        return phoneNumber;
    }

    public static double nextDouble() {
        return in.nextDouble();
    }
}
