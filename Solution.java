import java.util.*;
import java.io.*;

public class Solution 
{
    public static void getFinalPosition(int col, int row, char direction, String path)
    {
        // Traverses the path of the robotic rover
        for (int i = 0; i < path.length(); i++)
        {
            // It moves foward on the grid if we see the foward command
            if (path.charAt(i) == 'M')
            {
                if (direction == 'N')
                    row++;
        
                else if (direction == 'E')
                    col++;
    
                else if (direction == 'S')
                    row--;
    
                else
                    col--;
            }

            // We update the direction based on the rotaion commands
            else
            {
                if (direction == 'N')
                {
                    if (path.charAt(i) == 'L')
                        direction = 'W';

                    else if (path.charAt(i) == 'R')
                        direction = 'E';
                }
        
                else if (direction == 'E')
                {
                    if (path.charAt(i) == 'L')
                        direction = 'N';

                    else if (path.charAt(i) == 'R')
                        direction = 'S';
                }
    
                else if (direction == 'S')
                {
                    if (path.charAt(i) == 'L')
                        direction = 'E';

                    else if (path.charAt(i) == 'R')
                        direction = 'W';
                }
    
                else
                {
                    if (path.charAt(i) == 'L')
                        direction = 'S';

                    else if (path.charAt(i) == 'R')
                        direction = 'N';
                }
            }
        }

        // Prints the result
        System.out.println(col + ", " + row + ", " + Character.toString(direction));

    }

    // Main function is in charge to parse the input into valid arguments to run the getFinalPosition() method.
    public static void main (String [] args) throws Exception
    {
        Scanner input = new Scanner(new File("testcase.txt"));
        input.nextLine();

        List<String> initialPositions = new ArrayList<>();
        List<String> paths = new ArrayList<>();

        while (input.hasNextLine())
        {
            initialPositions.add(input.nextLine());
            paths.add(input.nextLine());
        }

        input.close();

        for (int i = 0; i < paths.size(); i++)
        {
            String str = initialPositions.get(i);

            getFinalPosition(str.charAt(0) - 48, str.charAt(2) - 48, str.charAt(4), paths.get(i));
        }

    }
}