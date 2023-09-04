import java.util.Scanner;

public class Zad2 {

    public static void main(String[] args) {
        System.out.println();
        collectArrayData(makeARequest("Podaj długość tablicy: "));
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

    public static void collectArrayData(int n) {
        int[] data = new int[n];
        System.out.print("Podaj kolejne elementy tablicy liczb całkowitych: ");
        String line = collectData();
        String[] numbers = line.split(" ");
        try {
            for(int i=0; i<n; i++)
                data[i] = Integer.parseInt(numbers[i]);
            System.out.println("Druga najmniejsza wartość w tablicy: "
                    + getSecondSmallest(data));
        } catch (NumberFormatException e) {
            System.out.println("Podano błędne dane!");
        } catch (NoAnswerException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int getSecondSmallest(int[] data) throws NoAnswerException {
        if (data.length < 2)
            throw new NoAnswerException("Nieprawidłowe dane! Długość tablicy jest mniejsza od 2!");
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int datum : data) {
            if (datum < smallest) {
                secondSmallest = smallest;
                smallest = datum;
            } else if (datum < secondSmallest && datum != smallest)
                secondSmallest = datum;
        }
        if (secondSmallest == Integer.MAX_VALUE)
            throw new NoAnswerException("Bład! Podano identyczne wartości!");
        return secondSmallest;
    }
}