package stringpermutation;

public class StringPermutationLengthDiff {

    boolean isPermutation (String str1, String str2) {
        boolean isPermutation = true;
        int []asciiArray1 = new int [256];
        int []asciiArray2 = new int [256];
        for (int index=0; index<256 ; index++) {
            asciiArray1[index] = 0;
        }
        for (int index=0; index<256 ; index++) {
            asciiArray2[index] = 0;
        }
        int length = str1.length()>str2.length() ? str1.length() : str2.length();
        for (int index=0 ; index< length ; index++) {
            if (index<str1.length()) {
                asciiArray1[str1.charAt(index)]++;
            }
            if (index<str2.length()) {
                asciiArray2[str2.charAt(index)]++;
            }
        }
        for (int index=0; index<256 ; index++) {
            //If first array is 0 and second array is non-zero then not anagram.
            //If both non-zero then multiple repeat, so normal
            if ((asciiArray1[index]!=0 && asciiArray2[index]==0) ||
                    (asciiArray1[index]==0 && asciiArray2[index]!=0)) {
                isPermutation=false;
                break;
            }
        }
        return isPermutation;
    }
    public static void main (String []args) {
        StringPermutationLengthDiff stringPermutation = new StringPermutationLengthDiff();
        System.out.println("is="+stringPermutation.isPermutation("12345", "5321411111111111111111"));
    }
}
