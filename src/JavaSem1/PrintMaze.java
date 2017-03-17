import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintMaze {

    public static char[][] x = new char[22][60];

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:/Users/Admin/Desktop/maze.txt");
        Scanner input = new Scanner(System.in);
        input = new Scanner(file);

        char[] y = new char[60];
        int row = 0;
        int cnt = 0;
        int rownum = 0;
        int colnum = 0;
        while (input.hasNextLine()) {
            int col = 0;
            String line = input.nextLine();
            y = line.toCharArray();
            for (int j = 0; j < 60; j++) {
                x[row][j] = y[j];
            }
            row++;
        }
        input.close();
        for(int i = 0;i<22;i++)
        {
            for(int j=0;j<60;j++)
            {
                System.out.print(x[i][j]);
            }
            System.out.print("\n");
        }
    }

}
