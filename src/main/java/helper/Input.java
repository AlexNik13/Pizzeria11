package helper;

import java.util.Scanner;

public class Input {
    private static Scanner in = new Scanner(System.in);
    public static int nextInt(){
        return in.nextInt();
    }

    public static String nextSting(){
        return in.nextLine();
    }

    public static double nextDouble(){
        return in.nextDouble();
    }
}
