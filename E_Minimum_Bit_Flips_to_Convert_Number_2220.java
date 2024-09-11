public class E_Minimum_Bit_Flips_to_Convert_Number_2220 {

    public static void main(String[] args) {
//        35 22 4

//        System.out.println("5 / 2 = " + String.valueOf(5 / 2));
//        System.out.println("5 % 2 = " + String.valueOf(5 % 2));
//        System.out.println("4 / 2 = " + String.valueOf(4 / 2));
//        System.out.println("4 % 2 = " + String.valueOf(4 % 2));
//        System.out.println("1 / 2 = " + String.valueOf(1 / 2));
//        System.out.println("1 % 2 = " + String.valueOf(1 % 2));
//        System.out.println("2 / 2 = " + String.valueOf(2 / 2));
//        System.out.println("2 % 2 = " + String.valueOf(2 % 2));
//        System.out.println("0 / 2 = " + String.valueOf(0 / 2));
//        System.out.println("0 % 2 = " + String.valueOf(0 % 2));
//
//        System.out.println(new E_Minimum_Bit_Flips_to_Convert_Number_2220().convertTo2(5));
//        System.out.println(new E_Minimum_Bit_Flips_to_Convert_Number_2220().convertTo2(100));
//        System.out.println(new E_Minimum_Bit_Flips_to_Convert_Number_2220().convertTo2(0));
//        System.out.println(new E_Minimum_Bit_Flips_to_Convert_Number_2220().convertTo2(1));
//        System.out.println(new E_Minimum_Bit_Flips_to_Convert_Number_2220().convertTo2(2));
//        System.out.println(new E_Minimum_Bit_Flips_to_Convert_Number_2220().convertTo2(3));
//        System.out.println(new E_Minimum_Bit_Flips_to_Convert_Number_2220().convertTo2(4));

        int i = new E_Minimum_Bit_Flips_to_Convert_Number_2220().minBitFlips(35, 22);
        int i2 = new E_Minimum_Bit_Flips_to_Convert_Number_2220().minBitFlips(10, 7);
        int i3 = new E_Minimum_Bit_Flips_to_Convert_Number_2220().minBitFlips(3, 4);
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
    }

    public int minBitFlips(int start, int goal) {
        String startIn2 = convertTo2(start);
        String goalIn2 = convertTo2(goal);
        if (startIn2.length() > goalIn2.length()) {
            String adding0 = "";
            for (int i = 0; i < startIn2.length() - goalIn2.length(); i++) {
                adding0 = adding0 + "0";
            }
            String updatedGoalIn2 = adding0 + goalIn2;
            return compare(startIn2, updatedGoalIn2);
        } else if (startIn2.length() == goalIn2.length()) {
            return compare(startIn2, goalIn2);
        } else if (startIn2.length() < goalIn2.length()) {
            String adding0 = "";
            for (int i = 0; i < goalIn2.length() - startIn2.length(); i++) {
                adding0 = adding0 + "0";
            }
            String updatedStartIn2 = adding0 + startIn2;
            return compare(updatedStartIn2, goalIn2);
        } else {
            return -1111111111;
        }
    }

    private String convertTo2(int value) {
        if (value == 0) {
            return "0";
        }
        String result = "";
        while (value != 0) {
            int i = value % 2;
            result = i + result;
            value = value / 2;
        }
        return result;
    }

    private int compare(String start, String goal) {
        int actions = 0;
        // start and goal has the same length
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != goal.charAt(i)) {
                actions++;
            }
        }
        return actions;
    }
}
