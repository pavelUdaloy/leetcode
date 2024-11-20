import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class M_Largest_Number_179 {

    public static void main(String[] args) {
        System.out.println(new M_Largest_Number_179().largestNumber(new int[]{0,0}));
        System.out.println(new M_Largest_Number_179().largestNumber(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println(new M_Largest_Number_179().largestNumber(new int[]{10, 2}));
        System.out.println(new M_Largest_Number_179().largestNumber(new int[]{3,30,34,5,9}));
    }

    public String largestNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        List<String> list = Arrays.stream(nums)
                .mapToObj(n -> n + "")
                .collect(Collectors.toList());

        list.sort((a, b) -> (b + a).compareTo(a + b));

        if (list.get(0).equals("0")) {
            return "0";
        }

        System.out.println(list);

        for (String i : list) {
            result.append(i);
        }

        return result.toString();
    }
}
