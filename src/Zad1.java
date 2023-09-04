import java.util.Scanner;

public class Zad1 {

    public static void main(String[] args) {
        System.out.println();
        drawPascalTriangle(makeARequest("Podaj liczbę linii: "));
    }

    public static int makeARequest(String order) {
        boolean flag = true;
        int result = 0;
        while (flag) {
            System.out.print(order);
            result = tryCollectData();
            if (result > 0)
                flag = false;
        }
        return result;
    }
    public static int tryCollectData() {
        try {
            int result = Integer.parseInt(collectData());
            if (!(result > 0))
                throw new IllegalArgumentException();
            return result;
        }
        catch (NumberFormatException e) {
            System.out.println("Podano błędne dane!");
            return 0;
        }
        catch (IllegalArgumentException e) {
            System.out.println("Podano wartość niedodatnią!");
            return 0;
        }
    }
    public static String collectData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void drawPascalTriangle(int depth) {
        int[] prevLine = {1};
        for (int i=0; i<depth; i++) {
            int[] currLine = NextPascalLine(prevLine);
            prevLine = currLine;
            for(int j=depth-i; j>0; j--)
                System.out.print(" ");
            for (int j : currLine)
                System.out.print(j + " ");
            System.out.println();
        }
    }
    public static int[] NextPascalLine(int[] prevLine) {
        int n = prevLine.length;
        int[] currLine = new int[n+1];
        currLine[0] = 1;
        currLine[n] = 1;
        for (int i=1; i<n; i++)
            currLine[i] = prevLine[i-1] + prevLine[i];
        return currLine;
    }
}
