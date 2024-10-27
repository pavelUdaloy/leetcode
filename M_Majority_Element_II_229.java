import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class M_Majority_Element_II_229 {

    public static void main(String[] args) {
        M_Majority_Element_II_229 mMajorityElementIi229 = new M_Majority_Element_II_229();

        System.out.println(mMajorityElementIi229.majorityElement(new int[]{3, 2, 3}));
        System.out.println(mMajorityElementIi229.majorityElement(new int[]{1}));
        System.out.println(mMajorityElementIi229.majorityElement(new int[]{1, 2}));
        System.out.println(mMajorityElementIi229.majorityElement(new int[]{2, 2}));
    }

    public List<Integer> majorityElement(int[] nums) {
        int value = nums.length / 3 + 1;

        Map<Integer, Integer> result = new HashMap<>();

        for (int num : nums) {
            if (result.containsKey(num)) {
                result.put(num, result.get(num) + 1);
            } else {
                result.put(num, 1);
            }
        }

        return result.entrySet().stream()
                .filter(e -> e.getValue() >= value)
                .map(Map.Entry::getKey)
                .toList();
    }
}
