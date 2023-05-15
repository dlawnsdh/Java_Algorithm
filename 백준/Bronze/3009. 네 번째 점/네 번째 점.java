import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arrX = new int[3];
        int[] arrY = new int[3];
        int X = 0;
        int Y = 0;
        for (int i = 0; i < 3; i++) {
            arrX[i] = s.nextInt();
            arrY[i] = s.nextInt();
        }
        if (arrX[0] == arrX[1])
            X = arrX[2];
        else if (arrX[0] == arrX[2])
            X = arrX[1];
        else
            X = arrX[0];
        if (arrY[0] == arrY[1])
            Y = arrY[2];
        else if (arrY[0] == arrY[2])
            Y = arrY[1];
        else
            Y = arrY[0];
        System.out.println(X + " " + Y);
    }
}