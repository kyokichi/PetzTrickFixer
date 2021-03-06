import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

/**
 *
 * @author Jefferson
 */
public class Main
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
    
    
    // make a method that reads a file and then returns the byte array
    public static byte[] readFile(String inputFile) throws FileNotFoundException, IOException 
    {
        File f = new File(inputFile);
        InputStream inputStream = new FileInputStream(f);

        long fileSize = f.length();
        byte[] allBytes = new byte[(int)fileSize];
        inputStream.read(allBytes);
        
        return allBytes;
    }
    
    // Above this are helper files I can use for all sorts of things
    
    
    public static void main(String[] args) throws IOException
    {
        /*String filename = "data/petz/Nibbles.pet";
        String version = "4";
        //String filename = args[0];
        //String version = args[1];
        fixAPet(filename, version);*/
        
        
        //String path = "data/petz/";
        String path = "."; 
        readsAllPetzFromDir(path);
    }
    
    
    public static void fixAPet(String filename, String version) throws IOException
    {
        TrickSection tricks = getTrickSectionFrom(filename);
        
        //System.out.println(tricks);
        trickSectionCSV(filename+"before", tricks);
        
        tricks.fixTricksBy(Trick.Version.valueOf("petz"+version));
        
        //System.out.println(tricks);
        trickSectionCSV(filename+"after", tricks);
    }
    
    
    private static void trickSectionCSV(String name, TrickSection tricks) throws IOException
    {
        //output to a file as comma delimited csv
        FileWriter fw = new FileWriter(name + ".csv");

        fw.write(tricks.toString());

        fw.close();
    }
    
    
    private static TrickSection getTrickSectionFrom(String filename) throws IOException
    {
        // later I should add something to choose this file maybe from args
        byte[] petData = readFile(filename);
        
        // pointer to the start of the trick data section
        int start = findTrickSection(petData);
        
        if(start != -1)
        {
            return new TrickSection(petData, start);
        }
        
        return null;
    }
    
    
    private static int findTrickSection(byte[] allBytes)
    {
        int start = 0;

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
            
            
            
            start = i;
        }
        else
        {
           System.out.println("Error: Did not find trick section");
           
           start = -1;
        }
        
        return start;
    }
    
    
    
    // could return some sort of list of files?
    private static void readsAllPetzFromDir(String path) throws IOException
    {
        // for each file in the directory
        // check the extension, should be .pet for now
        // then process the file
        
        File dir = new File(path);
        File[] dirList = dir.listFiles();
        
        if(dirList != null)
        {
            for(File f : dirList)
            {
                String name = f.getName();
                if(name.length() > 4 && name.substring(name.length()-4).equals(".pet"))
                {
                    TrickSection tricks = getTrickSectionFrom(name);
                    trickSectionCSV(name.substring(0, name.length()-4), tricks);
                }
            }
        }
    }
}