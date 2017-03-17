import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    public static char[][] x = new char[22][60];
    public static void main(String[] args)  throws FileNotFoundException{
        File file = new File("C:/Users/Admin/Desktop/maze.txt");
        Scanner input = new Scanner(System.in);
        input = new Scanner(file);//scan the file to input

        char[] y = new char[60];
        int row  = 0;
        int cnt  = 0;
        int rownum  = 0;
        int colnum  = 0;
        int pos = 0;
        int d = 0;
        while (input.hasNextLine()) {//store each line in the file to character array
            int col = 0;
            String line = input.nextLine();
            y = line.toCharArray();
            for(int j =0;j<60;j++)
            {
                x[row][j] =y[j];
            }
            row++;
        }
        input.close();
        for(int i = 0;i<x.length;i++)
        {
            for(int j=0;j<x[i].length;j++)
            {
                if((x[i][j]==' ' && i==0) || (x[i][j]==' ' && j==0))
                {
                    x[i][j]='.';
                    //x[8][14]='#';

                    while(j+1<x[i].length && i+1<x.length)
                    {
                        rownum  = i;
                        colnum = j;

                        d = FillMaze(i, j);
                        if(d==1) {//down
                            x[i + 1][j] = '.';
                            i = i+1;
                            pos = d;
                        }
                        else if(d==2) {//up
                            x[i-1][j] = '.';
                            if(i>0)
                            {
                                i = i-1;
                                if(i-1==-1)
                                {
                                    break;
                                }
                            }
                        }
                        else if(d==3) {//left
                            x[i][j - 1] = '.';
                            if(j>0)
                            {
                                j=j-1;
                                if(j-1==-1)
                                {
                                    break;
                                }
                            }
                        }
                        else if(d==4) {//right
                            x[i][j + 1] = '.';
                            j = j+1;
                            pos = d;
                        }
                        else if(d==5){//right
                            x[i][j] = '+';
                            j=j+1;
                        }
                        else if(d==6){//down
                            x[i][j]='+';
                            i=i+1;
                        }
                        else if(d==7){//left
                            x[i][j]='+';
                            if(j>0)
                            {
                                j=j-1;
                                if(j-1==-1)
                                {
                                    break;
                                }
                            }
                        }
                        else if(d==8){//up
                            x[i][j]='+';
                            if(i>0)
                            {
                                i = i-1;
                                if(i-1==-1)
                                {
                                    break;
                                }
                            }
                        }
                        else if(d==0)
                        {
                            x[rownum][colnum] = '+';
                            if(pos==1){i=i-1;}//down
                            if(pos==2){i=i+1;}//up
                            if(pos==3){j=j+1;}//left
                            if(pos==4){j=j-1;}//right

                        }
                    }
                }
            }
        }

        for(int i = 0;i<x.length;i++)
        {
            for(int j=0;j<x[i].length;j++)
            {
                if(x[i][j] == '+')
                {
                    x[i][j]=' ';
                }
                System.out.print(x[i][j]);
            }
            System.out.print("\n");
        }


    }
    public static int FillMaze(int i, int j)
    {
        int k = 0;

        //Check down
        if (x[i + 1][j] == ' ') {
        k = 1;
        }
        //check right
        else if(x[i][j+1]==' '){
            k=4;
        }
        //check left
        if ((j-1)>=0 && k==0){
            if(x[i][j-1]==' '){
                k =3;
            }
        }
        //check up
        if ((i-1)>=0 && k==0){
            if(x[i-1][j]==' '){
                k =2;
            }
        }

        //backtracking
        //check right
        if(x[i][j+1]=='.' && k==0){
            k=5;
        }
        //Check down
        else if (x[i + 1][j] == '.'&& k==0) {
            k = 6;
        }

        //check left
        if ((j-1)>=0 && k==0){
            if((x[i][j-1]=='.')){
                k =7;
            }
        }
        //check up
        if ((i-1)>=0&& k==0){
            if(x[i-1][j]=='.'){
                k =8;
            }
        }

        return k;
    }
}
