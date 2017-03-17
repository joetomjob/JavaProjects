package Threads;

public class Matrix extends Thread    {

    static int A[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
    static int B[][] = { { 1, 2, 3 }, { 4, 5, 6 }, {7, 8, 9 } };
    static int C[][] = new int[A.length][A[0].length];
    static Matrix theThreads[] = new Matrix[A.length * A[0].length];

    int rowC;		// for the target matrix C
    int colC;		// for the target matrix C

    public Matrix() {
    }
    public Matrix(int rowC, int colC) {
        this.rowC = rowC;
        this.colC = colC;
    }
    public static void print (int matrix[][]) {
        for ( int col = 0; col < matrix.length; col ++ )	{
            for ( int row = 0; row < matrix[0].length; row ++ )	{
                System.out.print( matrix[col][row] +
                        ( row + 1 ==  matrix[0].length ? "\n" : " " ) );
            }
        }

    }
    public void multiply (int C[][], int A[][], int B[][], int rowC, int colC) {
        C[rowC][colC] = 0;
        for ( int index = 0; index < A[0].length; index ++ )	{
            C[rowC][colC] += A[rowC][index] * B[index][colC];
        }

    }
    public void run() {
        multiply(C, A, B, rowC, 	colC );
    }

    public void startTheThreads (int A[][], int B[][]) {
        int counter = 0;
        for ( int row = 0; row < A.length; row ++ )	{
            for ( int col = 0; col < B[0].length; col ++ )	{
                theThreads[counter] = new Matrix(row, col);
                theThreads[counter].start();
                try{
                theThreads[counter].join();}
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                counter++;
            }
        }
    }

    public static void main (String args []) {

        Matrix theControler = new Matrix();

        theControler.startTheThreads(A, B);

        theControler.print(C);

    }
}

