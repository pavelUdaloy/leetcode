public class E_First_Bad_Version_278 {


    public static void main(String[] args) {
        E_First_Bad_Version_278 eFirstBadVersion278 = new E_First_Bad_Version_278();
        System.out.println(eFirstBadVersion278.firstBadVersion(3));
    }

    private static boolean isBadVersion(int version) {
        if (version == 3 || version == 3) {
            return true;
        } else return false;
    }

    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        int fbv = -1; //store first bad version
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isBadVersion(mid)){
                fbv = mid;
                end = mid-1;
            }else if(!isBadVersion(mid)){
                start = mid+1;
            }
        }
        return fbv;
    }
}
