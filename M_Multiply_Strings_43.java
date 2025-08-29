public class M_Multiply_Strings_43 {

    public static void main(String[] args) {
        System.out.println(new M_Multiply_Strings_43().multiply("65539", "83314"));
        System.out.println(new M_Multiply_Strings_43().multiply("237", "284"));
        System.out.println(new M_Multiply_Strings_43().multiply("242", "187"));
        System.out.println(new M_Multiply_Strings_43().multiply("2", "3"));
        System.out.println(new M_Multiply_Strings_43().multiply("123", "456"));
        System.out.println(new M_Multiply_Strings_43().multiply("9133", "0"));
    }

    public String multiply(String num1, String num2) {
        StringBuilder result = null;
        for (int i = num2.toCharArray().length - 1; i >= 0; i--) {
            int num2I = Integer.parseInt(String.valueOf(num2.toCharArray()[i]));
            int buffer = 0;

            StringBuilder str = new StringBuilder();
            for (int j = num1.toCharArray().length - 1; j >= 0; j--) {
                int num1I = Integer.parseInt(String.valueOf(num1.toCharArray()[j]));
                int multiplication = num1I * num2I + buffer;
                str.insert(0, multiplication % 10);
                buffer = multiplication / 10;
            }
            if (buffer != 0) {
                str.insert(0, buffer);
            }

            for (int j = 0; j < (num2.toCharArray().length - 1) - (i); j++) {
                str.append('0');
            }

            if (result == null) {
                result = str;
            } else {
                char[] arr1 = str.toString().toCharArray();
                char[] arr2 = result.toString().toCharArray();
                result = new StringBuilder();
                int buff = 0;
                int maxLen = Math.max(arr1.length, arr2.length);
                for (int j = 0; j < maxLen; j++) {
                    int index1 = arr1.length - 1 - j;
                    int index2 = arr2.length - 1 - j;
                    int d1 = index1 >= 0 ? arr1[index1] - '0' : 0;
                    int d2 = index2 >= 0 ? arr2[index2] - '0' : 0;

                    int sum = buff + d1 + d2;
                    result.insert(0, sum % 10);
                    buff = sum / 10;
                }
                if (buff != 0) {
                    result.insert(0, buff);
                }
            }

        }

        boolean kl = true;
        String string = result.toString();
        for (int i = 0; i < string.toCharArray().length; i++) {
            if (string.toCharArray()[i] != '0') {
                kl = false;
                break;
            }
        }
        if (kl) {
            return "0";
        }
        return string;
    }
}
