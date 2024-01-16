package matrix.rotate;

public class Rotate {

    static int[][] rotate (int[][] matrix) {
        int[][] rotateMat = new int [matrix[0].length][matrix.length];
        for (int x=0 ; x<matrix.length ; x++) {
            for (int y=0 ; y<matrix[x].length ; y++) {
                rotateMat [y][x] = matrix [x][y];
            }
        }
        return rotateMat;
    }
    static void printMatrix (int [][] matrix) {
        for (int x=0 ; x<matrix.length ; x++) {
            for (int y=0 ; y<matrix[x].length ; y++) {
                System.out.print(matrix[x][y]+" ");
            }
            System.out.println ();
        }
    }
    public static void main (String []args) {
        int [][] matrix = new int[][] {{1,2,3},
                                        {4,5,6}};

        int[][] rotateMat = rotate(matrix);
        printMatrix(rotateMat);
    }
}
