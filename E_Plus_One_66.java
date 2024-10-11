import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E_Plus_One_66 {

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int[] test2 = {4,3,2,1};
        int[] test3 = {9};
        int[] test4 = {0};

        E_Plus_One_66 ePlusOne66 = new E_Plus_One_66();
        System.out.println(Arrays.toString(ePlusOne66.plusOne(test1)));
        System.out.println(Arrays.toString(ePlusOne66.plusOne(test2)));
        System.out.println(Arrays.toString(ePlusOne66.plusOne(test3)));
        System.out.println(Arrays.toString(ePlusOne66.plusOne(test4)));
    }

    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        for (int i : digits)
            result.add(i);

        boolean plusOne = true;
        for (int i = result.size() - 1; i >= 0; i--) {
            if (plusOne) {
                Integer value = result.get(i);
                if (value != 9) {
                    result.set(i, ++value);
                    return result.stream()
                            .mapToInt(t->t)
                            .toArray();
                } else {
                    result.set(i, 0);
                }
            }
        }
        result.add(0, 1);
        return result.stream()
                .mapToInt(t->t)
                .toArray();
    }
}

class Solution {
    public int[] plusOne(int[] digits) {

        if(digits[digits.length - 1] != 9){
            digits = changeLastElement(digits);
        } else if(digits[digits.length - 1] == 9 && digits.length == 1){
            digits = changeUniqueNine(digits);
        } else if(digits[digits.length - 1] == 9 && digits[digits.length - 2] == 9){
            digits = changeSeveralNines(digits);
        } else if(digits[digits.length - 1] == 9 && digits[digits.length - 2] != 9){
            digits = changeOneNine(digits);
        }

        return digits;
    }

    int[] changeOneNine(int[] digits){
        digits[digits.length - 2] = digits[digits.length - 2] + 1;
        digits[digits.length - 1] = 0;
        return digits;
    }

    int[] changeUniqueNine(int[] digits){
        int[] x = new int[digits.length + 1];
        for(int i = 0; i < x.length - 1; i++){
            x[i] = digits[i];
        }
        x[x.length - 2] = 1;
        x[x.length - 1] = 0;
        digits = x;

        return digits;
    }

    int[] changeSeveralNines(int[] digits){
        int count = 0;
        for(int i = digits.length - 1; i > 0; i--){
            if(digits[i] == 9 && digits[i - 1] == 9){
                count++;
            }
        }
        count = count + 1;

        int[] d = new int[count];
        for(int i = 0; i < d.length - 1; i++){
            d[i] = 0;
        }

        if(digits.length == count){
            digits = changeAllNines(digits, count);
            return digits;
        } else {
            digits[digits.length - 1 - count] = digits[digits.length - 1 - count] + 1;
        }


        for(int i = digits.length - count; i < digits.length; i++ ){
            int j = 0;
            digits[i] = d[j];
            j++;
        }
        return digits;
    }

    int[] changeAllNines(int[] digits, int count){
        int[] z = new int[count + 1];
        z[0] = 1;
        for(int i = 1; i < z.length - 1; i++){
            z[i] = 0;
        }
        digits = z;
        return digits;
    }

    int[] changeLastElement(int[] digits){
        String a = Integer.toString(digits[digits.length - 1]);
        Integer b = Integer.parseInt(a) + 1;

        a = b.toString();
        int[] result = new int[a.length()];
        for (int i = 0; i < a.length(); i++){
            result[i] = a.charAt(i) - '0';
        }

        int[] c = new int[digits.length];
        if(result.length == 1){
            for(int i = 0; i < c.length; i++){
                c[i] = digits[i];
            }
            c[c.length - 1] = result[0];
        }
        return c;
    }
}
