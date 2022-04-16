/**
 *
 * @author Alexis
 */
public class Trick
{
    byte[] entireTrick;
    // would like to add other variables later but
    
    public Trick(byte[] trickData)
    {
        entireTrick = trickData;
    }
    
    public void modifyTrick(byte animation1, byte animation2)
    {
        entireTrick[0] = (byte)0x66;
        entireTrick[4] = animation1;
        entireTrick[5] = animation2;
    }
    
    public String toString()
    {
        String s = "";
        for(int i = 0; i < entireTrick.length; i++)
        {
            s += String.format("0x%x \t",entireTrick[i]);
        }
        return s;
    }
}
