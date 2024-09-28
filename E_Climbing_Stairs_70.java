public class E_Climbing_Stairs_70 {

    public static void main(String[] args) {
        int n = 2;

        E_Climbing_Stairs_70 eClimbingStairs70 = new E_Climbing_Stairs_70();

        System.out.println(eClimbingStairs70.climbStairs(1));
        System.out.println(eClimbingStairs70.climbStairs(2));
        System.out.println(eClimbingStairs70.climbStairs(3));
        System.out.println(eClimbingStairs70.climbStairs(4));
        System.out.println(eClimbingStairs70.climbStairs(5));
        System.out.println(eClimbingStairs70.climbStairs(6));
        System.out.println(eClimbingStairs70.climbStairs(7));
        System.out.println(eClimbingStairs70.climbStairs(8));
    }

    public int climbStairs(int n) {
        int first = 1;
        int second = 2;

        if (n == 1) return first;
        if (n == 2) return second;

        return fibo(first, second, 3, n);
    }

    public int fibo(int first, int second, int index, int endIndex) {
        int sum = first + second;
        if (index == endIndex) {
            return sum;
        }
        return fibo(second, sum, index + 1, endIndex);
    }
}
