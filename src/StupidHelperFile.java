
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Alexis
 */
public class StupidHelperFile
{
    public static void notMain(String[] args) throws FileNotFoundException
    {
        File f = new File("data/All Version Tricks.csv");
        
        Scanner in = new Scanner(f);
        
        while(in.hasNextLine())
        {
            Scanner sc = new Scanner(in.nextLine());
            sc.useDelimiter(",");
            System.out.printf("new Trick(%s, %s, %s, %s, 0, Trick.Gesture.%s, Trick.Flavor.chicken, \"%s\", Trick.Version.petz%s, Trick.Species.%s),\n",
                    sc.next(), sc.next(), sc.next(), sc.next(), sc.next().toLowerCase(), sc.next(), sc.next(), sc.next().toLowerCase());
        }
    }
}
