/* You are given an m x n grid... Each cell of grid represents a street... The street of grid[i][j] can be:
* 1 which means a street connecting the left cell and the right cell...
* 2 which means a street connecting the upper cell and the lower cell...
* 3 which means a street connecting the left cell and the lower cell...
* 4 which means a street connecting the right cell and the lower cell...
* 5 which means a street connecting the left cell and the upper cell...
* 6 which means a street connecting the right cell and the upper cell...
You will initially start at the street of the upper-left cell (0, 0)... A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1)... The path should only follow the streets... Notice that you are not allowed to change any street... Return true if there is a valid path in the grid or false otherwise...
* Eg 1:  grid = [[2,4,3], [6,5,2]]                                 Output = true 
* Eg 2:  grid = [[1,2,1], [1,2,1]]                                 Output = false 
* Eg 3:  grid = [[1,1,2]]                                          Output = false    */
import java.util.*;
public class Path
{
    public boolean TracePath(int grid[][])
    {
        int i = 0, j = 0, loop = 1;
        int row = grid.length-1;
        int col = grid[0].length-1;
        do
        {
            if(grid[i][j] == 1)
            {
                if(grid[i][j+1] == 2 || grid[i][j+1] == 4 || grid[i][j+1] == 6)
                    return false;
                j++;
            }
            else if(grid[i][j] == 2)
            {
                if(grid[i+1][j] == 3 || grid[i+1][j] == 1 || grid[i+1][j] == 4)
                    return false;
                i++;
            }
            else if(grid[i][j] == 3)
            {
                if(grid[i+1][j] == 1 || grid[i+1][j] == 4 || grid[i+1][j] == 5 || grid[i+1][j] == 3)
                    return false;
                i++;
            }
            else if(grid[i][j] == 4)
            {
                if(grid[i][j+1] == 2 || grid[i][j+1] == 6 || grid[i][j+1] == 4)
                    return false;
                j++;
            }
            else if(grid[i][j] == 5)
            {
                if(grid[i-1][j] == 1 || grid[i-1][j] == 3 || grid[i-1][j] == 6 || grid[i-1][j] == 5)
                    return false;
                i--;
            }
            else if(grid[i][j] == 6)
            {
                if(grid[i][j+1] == 2 || grid[i][j+1] == 4 || grid[i][j+1] == 6)
                    return false;
                j++;
            }
            if(i == row && j == col)
                loop = 0;
        }while(loop == 1);
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        System.out.print("Enter the row length (m) : ");
        m = sc.nextInt();
        System.out.print("Enter the column length (n) : ");
        n = sc.nextInt();
        int grid[][] = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print("Enter the street value of "+i+", "+j+" block : ");
                grid[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                System.out.print(grid[i][j]+", ");
            System.out.println();
        }
        Path path = new Path();
        System.out.println("The Path can be walked through the grid : "+path.TracePath(grid));
        sc.close();
    }
}
