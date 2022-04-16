/**
 *
 * @author Alexis
 */
public class Treat
{
    /*
       1, 2, 3 -- toy
       4, 5, 6 -- up
       7, 8, 9 -- down
       10, 11, 12 -- left
       13, 14, 15 -- right
    */
    Trick[][] tricks;
    int rows = 5;
    int cols = 3;
    
    public Treat(byte[] allBytes, int start)
    {
        tricks = new Trick[rows][cols];
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                // reads 20 bytes into a Trick
                byte[] row = new byte[20];
                for(int b = 0; b < row.length; b++)
                {
                    row[b] = allBytes[start];
                    start++;
                }
                tricks[i][j] = new Trick(row);
            }
        }
    }
    
    public void putBack(byte[] allBytes, int start)
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                byte[] row = tricks[i][j].entireTrick;
                for(int b = 0; b < row.length; b++)
                {
                    allBytes[start] = row[b];
                    start++;
                }
            }
        }
    }
    
    // boolean to include whether I should have a prefix in front
    private String createString(int start, int end) //end isn't included
    {
        String s = "";
        for(int i = start; i < end; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                s += tricks[i][j] + "\n";
            }
        }
        return s;
    }
    
       
    public void modifyTreat(boolean isDog)
    {
        byte left, right;
        if(isDog)
        {
            left = 0x2b;
            right = 0x2a;
        }
        else
        {
            left = 0x34;
            right = 0x3e;
        }
        
        byte animation = left; 
        for(int r = 3; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                tricks[r][c].modifyTrick(animation, (byte)0x2);
            }
            animation = right; 
        }
    }
    
    public String leftRightTricks()
    {
        return createString(3, rows);
    }
    
    public String toString()
    {
        return createString(0, rows);
    }
}
