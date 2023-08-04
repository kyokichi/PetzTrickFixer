import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

/**
 *
 * @author Jefferson
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        // for each file in this directory,
        // check the extension, should be .pet for now
        // then process the file
        
        //Trick.Version.valueOf("petz"+version)
        
        Trick.Version version = Trick.Version.petz4;
        String source = ".";
        
        File dir = new File(source);
        File[] dirList = dir.listFiles();
        
        if(dirList != null)
        {
            for(File f : dirList)
            {
                String name = f.getName();
                if(name.length() > 4 && name.substring(name.length()-4).equals(".pet"))
                {
                    InputStream inputStream = new FileInputStream(f);

                    long fileSize = f.length();
                    byte[] petData = new byte[(int)fileSize];
                    inputStream.read(petData);
        
                    int start = TrickSection.findTrickSection(petData);
                    Trick[] tricks = TrickSection.getTrickSectionFrom(petData, start);
                    
                    Trick.Species species = TrickSection.getPetSpecies(petData);
                    
                    if(tricks != null && !species.equals(Trick.Species.unknown))
                    {
                        // print the CSV of the current known tricks as PETNAME.csv
                        trickSectionToCSV(name.substring(0, name.length()-4), tricks);
                        
                        // fix the trick section by the version
                        for(Trick trick : tricks)
                        {
                            trick.fixTrickBy(species, version);
                        }
                        
                        // create a new folder for Petz VERSION Fixed Petz
                        String dest = version + "_fixed_tricks";
                        File folder = new File(source, dest);
                        folder.mkdir();
                        
                        byte[] newPetData = TrickSection.updateTrickSectionBytes(petData, start, tricks);
                        writeToPetFile(dest+File.separator+name, newPetData);
                        trickSectionToCSV(dest+File.separator+name.substring(0, name.length()-4)+"fixed", tricks);
                        
                    }
                    else
                    {
                        // some txt file with an error where they could not find the trick section?
                        // name.substring(0, name.length()-4
                    }
                }
            }
        }
        
        
        /*if(args.length > 0)
        {
            String filename = args[0];
            String version = args[1];
            fixAPet(filename, version);
        }*/
    }
    
    
    public static void trickSectionToCSV(String name, Trick[] tricks) throws IOException
    {
        //output to a file as comma delimited csv
        FileWriter fw = new FileWriter(name + ".csv");
        
        for(Trick z : tricks)
        {
            fw.write(z + "\n"); //does write add new lines?
        }
        
        fw.close();
    }
    
    public static void writeToPetFile(String name, byte[] petData) throws FileNotFoundException, IOException
    {
        File f = new File(name);
        OutputStream outputStream = new FileOutputStream(f);
        outputStream.write(petData);
        outputStream.close();
    }
    
}