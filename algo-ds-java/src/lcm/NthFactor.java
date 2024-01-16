package lcm;

public class NthFactor {

    public static void main (String []args) {

        int x=4, y=24, k=2;
        /*int smallest = x>y ? y : x;
        int nthFactor=-1, count = 0;
        for (int index=1 ; index<smallest ; index++) {
            if (x%index==0 && y%index==0) {
                System.out.println("index="+index);
                count++;
            }
            if (count == k) {
                nthFactor = index;
                break;
            }
        }
        System.out.println("nthFactor="+nthFactor);*/

        //System.out.println("nthFactor="+(12%1500));
        /*int lcm = (4*6) / gcd (4, 6);
        System.out.println("lcm = "+lcm);*/

        System.out.println("gcd="+gcd (new int [] {500,100,35}));
    }

    static int gcd (int x, int y) {
        if (y!=0) {
            return gcd (y, x%y);
        }
        return x;
    }
    static int gcd (int []arr) {
        int result = arr [0];
        for (int index=1 ; index<arr.length ; index++) {
            result = gcd (result, arr [index]);
        }
        return result;
    }

}
