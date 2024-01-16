package binarysearch;

public class BinarySearch {

    int binarySearch (int[] arr, int findN) {
        int index=-1;
        int left=0, right=arr.length-1;
        while (left<=right) {
            int middle = (left+right) / 2;
            if (findN == arr[middle]) {
                index = middle;
                break;
            } else if (findN < arr[middle]) {
                right = middle -1;
            } else {
                left = middle+1;
            }
        }
        return index;
    }
    public static void main (String []args) {
        int []arr = new int [] {2,5,6,10,15,19,20, 21,22};
        BinarySearch binarySearchRecTest = new BinarySearch();
        System.out.println("index="+binarySearchRecTest.binarySearch(arr, 22));
    }
}
