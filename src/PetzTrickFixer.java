import java.io.*;
import java.nio.file.Files;

/**
 *
 * @author Jefferson
 */
public class PetzTrickFixer
{
    /**
     * Checks if a is contained in b using the specified starting point in b
     * only checks as many bytes as a.length
     * @param a what I'm searching for in b
     * @param b where I'm searching
     * @param start starting index in b to search for a
     * @return true if a is contained in b at the starting point, false otherwise
     */
    private static boolean checkEqual(byte[] a, byte[] b, int start)
    {
        if(b.length - start < a.length)
        {
            return false;
        }
        
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] != b[i + start])
            {
                return false;
            }
        }
        
        return true;
    }
    
    
    
    public static void main(String[] args) throws IOException
    {
        // for each file in the directory
        // check the extension, should be .pet for now
        // then process the file
        
        String path = ".";
        File dir = new File(path);
        File[] dirList = dir.listFiles();
        
        //output to a file as tab delimited txt
        if(dirList != null)
        {
            for(File f : dirList)
            {
                String name = f.getName();
                if(name.length() > 4 && name.substring(name.length()-4).equals(".pet"))
                {
                    OutputStream os = new FileOutputStream("f"+name);
                    os.write(processFile(name));
                    os.close();
                }
            }
        }
    }
    
    
    public static byte[] processFile(String inputFile) throws FileNotFoundException, IOException 
    {        
        File f = new File(inputFile);
        InputStream inputStream = new FileInputStream(f);

        long fileSize = f.length();
        byte[] allBytes = new byte[(int)fileSize];
        inputStream.read(allBytes);

        // searched for the byte which should be p.f.magicpetzIII
        byte[] searched = {0x70, 0x2E, 0x66, 0x2E, 0x6D, 0x61, 0x67, 0x69, 0x63, //p.f.magic
            0x70, 0x65, 0x74, 0x7A, 0x49, 0x49, 0x49}; //petzIII
        
        
        // find the first instance        
        int i = 0;
        boolean found = false;
        while(i < allBytes.length && !found)
        {
            if(allBytes[i] == searched[0])
            {
                if(checkEqual(searched, allBytes, i))
                {
                    found = true;
                }
            }
            if(!found)
            {
                i++;
            }
        }

        
        if(found)
        {
            i += searched.length; // set i to the next point after the string
            i += 7;
            i += 20 * 3;
            
            // skip to the left and right stuff
            //i += 20 * 9;
            
            Treat[] treatz = new Treat[7];
            
            // do a check to make sure there's enough bytes left-- 120 x 20
            
            int start = i; // keeps track of current start
            
            for(int t = 0; t < treatz.length; t++) // for each treat
            {
                treatz[t] = new Treat(allBytes, i);
                //System.out.println(treatz[t]);
                treatz[t].modifyTreat(true);
                //System.out.println(treatz[t]);
                // maybe make a method that reads the file and returns the number that was read to add to i
                i += 15 * 20;
            }
            
            //going back to write everything
            
            i = start;
            for(int t = 0; t < treatz.length; t++)
            {
                treatz[t].putBack(allBytes, i);
                i += 15 * 20;
            }
            
            // should do some check to see if it was read properly
            // set i back to the start to read back into the file
        }
        else
        {
           System.out.println("Error");
        }
        
        inputStream.close();
        
        return allBytes;
    }
}