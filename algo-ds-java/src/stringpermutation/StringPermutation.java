package stringpermutation;

public class StringPermutation {

    boolean isPermutation (String str1, String str2) {
        boolean isPermutation = true;
        if (str1.length() != str2.length()) {
            return false;
        }
        int []asciiArray = new int [256];
        for (int index=0; index<256 ; index++) {
            asciiArray[index] = 0;
        }
        for (int index=0 ; index< str1.length() ; index++) {
            asciiArray [str1.charAt(index)]++;
            asciiArray [str2.charAt(index)]--;
        }
        for (int index=0; index<256 ; index++) {
            if (asciiArray[index] != 0) {
                isPermutation=false;
                break;
            }
        }
        return isPermutation;
    }
    public static void main (String []args) {
        StringPermutation stringPermutation = new StringPermutation();
        System.out.println("is="+stringPermutation.isPermutation("12345", "53214"));
    }
}
