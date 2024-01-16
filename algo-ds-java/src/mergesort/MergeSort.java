package mergesort;

public class MergeSort {

    void merge (int []arr, int left, int right) {
        if (left < right) {
            int middle = (left+right) / 2 ;
            merge (arr, left, middle);
            merge (arr,middle+1, right);
            sort (arr, left, right);
        }
    }

    void sort (int []arr, int left, int right) {
        int middle = (left+right) / 2 ;
        int leftN = middle-left+1;
        int []leftArr = new int [leftN];
        int rightN = right-middle;
        int []rightArr = new int [rightN];

        for (int i=0 ; i<leftN ; i++) {
            leftArr[i] = arr[i+left];
        }
        for (int j=0 ; j<rightN ; j++) {
            rightArr[j] = arr[j+middle+1];
        }
        System.out.println("left="+left);
        System.out.println("middle="+middle);
        System.out.println("right="+right);
        printArray (leftArr, "LeftArray");
        printArray (rightArr, "RightArray");
        System.out.println("");

        int i=0 , j=0, k=left;
        while (i<leftN && j<rightN) {
            if (leftArr[i] < rightArr[j]) {
                arr [k] = leftArr [i];
                i++;
            } else {
                arr [k] = rightArr [j];
                j++;
            }
            k++;
        }

        while (i<leftN) {
            arr [k] = leftArr [i];
            k++;
            i++;
        }
        while (j<rightN) {
            arr [k] = rightArr [j];
            k++;
            j++;
        }
    }

    public static void main (String []args) {
        int []arr = new int []{50,20,80,10,90,30};
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(arr, 0, arr.length-1);

        printArray (arr, "outputArray");
    }
    static void printArray (int []arr, String arrayName) {
        System.out.print (arrayName+"={");
        for (int i=0 ; i<arr.length ; i++) {
            System.out.print (arr[i]+",");
        }
        System.out.println ("}");
    }
}
