package lesson36HomeWork;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int[] formNewArrayAfterPastFour(int[] array) throws RuntimeException {
        int a = 0;
        int b = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                a = i;
            }
        }
        if (a == 0) {
            throw new RuntimeException("Not Four Find");
        }

        int[] arr = new int[array.length - a - 1];
        for (int i = a + 1; i < array.length; i++) {
            arr[b] = array[i];
            b++;
        }
        return arr;
    }


    public static boolean foundFourInArray(int[] array) {
        int findFourInArrayConstant = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                findFourInArrayConstant++;
            }
        }
        return findFourInArrayConstant != 0;
    }

}
