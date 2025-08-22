public class Rec {

    public static void main(String[] args) {
        System.out.println(reverseString("ABCDEFG"));
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sumArray(arr1, 0, 0));
    }

    public static int sumArray(int[] numbers, int index, int sum) {
        if (index == numbers.length) {
            return sum;
        }
        return sumArray(numbers, index + 1, sum + numbers[index]);
    }

    public static String reverseString(String string) {
        if (string.isEmpty()) {
            return string;
        }
        return reverseString(string.substring(1)) + string.charAt(0);
    }
}
