package stringpermutation;

public class StringEditDistanceAlternative {

    int getDistance (String str1, String str2) {
        int []asciiArr1 = new int[256];
        int []asciiArr2 = new int[256];
        for (int i=0 ; i<256 ; i++) {
            asciiArr1[i] = 0;
        }
        for (int i=0 ; i<256 ; i++) {
            asciiArr2[i] = 0;
        }
        int largest = str1.length()>str2.length() ? str1.length() : str2.length();
        for (int i=0 ; i<largest ; i++) {
            if (i < str1.length()) {
                asciiArr1 [str1.charAt(i)]++;
            }
            if (i < str2.length()) {
                asciiArr2 [str2.charAt(i)]++;
            }
        }
        int totalDistance = 0;
        for (int i=0 ; i<256 ; i++) {
            //Condition for, if char in str1 is missing in str2, never mind
            //if (asciiArr1 [i] < asciiArr2 [i]) {
                totalDistance += (Math.abs(asciiArr1 [i] - asciiArr2 [i]));
            //}
        }
        return totalDistance;
    }

    public static void main (String []args) {
        StringEditDistanceAlternative permutationTest = new StringEditDistanceAlternative();
        System.out.println("getDistance="+permutationTest.getDistance("voldemort", "dumbledore"));
    }
}
