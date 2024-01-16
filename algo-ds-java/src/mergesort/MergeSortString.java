package mergesort;

import java.util.Arrays;

public class MergeSortString {

    public void sort (String []array, int left, int right) {
        int middle = (right + left) / 2;
        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        String []leftArr = new String [leftSize];
        String []rightArr= new String [rightSize];
        for (int i=0 ; i<leftSize ; i++) {
            leftArr [i] = array [i + left];
        }
        for (int i=0 ; i<rightSize ; i++) {
            rightArr [i] = array [middle + i + 1];
        }
        int i=0, j=0, k=left;
        while (i<leftSize && j<rightSize) {
            if (leftArr[i].compareTo(rightArr[j]) < 0) {
                array[k] = leftArr[i];
                i++;
            } else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            array[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }
    public void mergeSort (String []array, int left, int right) {
        int middle = (left + right) / 2;
        if (left < right) {
            mergeSort (array, left, middle);
            mergeSort (array, middle+1, right);
            sort (array, left, right);
        }
    }
    public static void main (String []args) {
        String []arrayString = new String [] {"foo", "bar", "alice", "bob", "zzz", "celine", "david"};
        MergeSortString mergeSortString = new MergeSortString();
        mergeSortString.mergeSort(arrayString, 0, arrayString.length-1);
        System.out.println("arrayString="+ Arrays.toString(arrayString));
    }
}
