/*Algorytm działa w czasie O(n), gdzie n to długość permutacji. Jeśli permutacja jest
posortowana malejąco, to żadna następna permutacja nie istnieje i procedura zwraca
fałsz. W przeciwnym przypadku procedura generuje następną permutację leksykograficzną
i zwraca prawdę. Na początku procedury znajdujemy najdłuższy sufiks permutacji, który
jest posortowany malejąco. Następnie znajdujemy pierwszy element przed tym sufiksem
(permutation[i]) oraz największy element w sufiksie permutacji, który jest większy od
permutation[i] (permutation[j]). Wymieniamy elementy permutation[i] i permutation[j],
a następnie odwracamy sufiks permutacji. */

import java.util.Scanner;

public class Zad3 {

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
        System.out.print("Podaj kolejne elementy tablicy: ");
        String line = collectData();
        String[] numbers = line.split(" ");

        try {
            for(int i=0; i<n; i++)
                data[i] = Integer.parseInt(numbers[i]);
        } catch (NumberFormatException e) {
            System.out.println("Podano błędne dane!");
        }

        if(nextPermutation(data))
            System.out.println("Nastepna leksykograficznie permutacja istnieje.");
        else
            System.out.println("Nastepna leksykograficznie permutacja nie istnieje.");
    }

    public static boolean nextPermutation(int[] permutation) {

        int n = permutation.length;
        int i = n-2;

        while (i >= 0 && permutation[i] >= permutation[i+1])
            i--;

        if (i < 0)
            return false;

        int j = n-1;

        while (permutation[j] <= permutation[i])
            j--;

        swap(permutation, i, j);
        reverse(permutation, i+1, n-1);
        writePermutation(permutation);
        return true;
    }

    private static void writePermutation(int[] permutation) {
        for (int value : permutation)
            System.out.print(value + " ");
    }

    private static void swap(int[] permutation, int i, int j) {
        int temp = permutation[i];
        permutation[i] = permutation[j];
        permutation[j] = temp;
    }
    private static void reverse(int[] permutation, int i, int j) {
        while (i < j)
            swap(permutation, i++ j++);
    }

}
