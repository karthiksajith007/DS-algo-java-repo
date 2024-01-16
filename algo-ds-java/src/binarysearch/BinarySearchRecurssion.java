package binarysearch;

public class BinarySearchRecurssion {

    public int binarySearch (int []arr, int findValue, int left, int right) {
        System.out.println("\nleft="+left);
        System.out.println("right="+right);
        int index;
        if (left<=right) {
            int middle = (left + right) / 2;
            System.out.println("middle="+middle);
            if (arr[middle] == findValue) {
                return middle;
            } else if (arr[middle] > findValue) {
                System.out.println("To left");
                return binarySearch(arr, findValue, left, middle-1);
            } else if (arr[middle] < findValue) {
                System.out.println("To right");
                return binarySearch(arr, findValue, middle+1, right);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static void main (String []args) {
        int []arr = new int [] {12,15,25,33,52,65,91};
        BinarySearchRecurssion binarySearch = new BinarySearchRecurssion();
        int searchIndex = binarySearch.binarySearch (arr, 91, 0, arr.length-1);
        System.out.println ("searchIndex="+searchIndex);
    }
}
