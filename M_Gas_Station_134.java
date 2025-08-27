public class M_Gas_Station_134 {

    public static void main(String[] args) {
        int[] arr11 = {1,2,3,4,5};
        int[] arr12 = {3,4,5,1,2};
        System.out.println(new M_Gas_Station_134().canCompleteCircuit(arr11, arr12));

        int[] arr21 = {2,3,4};
        int[] arr22 = {3,4,3};
        System.out.println(new M_Gas_Station_134().canCompleteCircuit(arr21, arr22));

        int[] arr31 = {3,1,1};
        int[] arr32 = {1,2,2};
        System.out.println(new M_Gas_Station_134().canCompleteCircuit(arr31, arr32));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                minIndex = i + 1;
            }
        }

        return sum >= 0 ? minIndex == gas.length ? 0 : minIndex : -1;
    }
}
