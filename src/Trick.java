/**
 *
 * @author Alexis
 */
public class Trick
{
    enum Gesture {
        toy, up, down, left, right
    }
    
    enum Flavor {
        chicken, beef, fish, turkey, milk, sweets, catnip, cheese
    }
    
    enum Version {
        petz2, petz3, petz4, petz5, unknown
    }
    
    enum Species {
        dog, cat, both, unknown
    }
    
    int plan;
    int action;
    int direction;
    int angle;
    int association;
    
    Gesture gesture;
    Flavor flavor;
    
    String name;
    Version ver;
    Species species;
    
    
    public Trick(int planID, int actionID, int direction, int angle, int association, 
            Gesture gesture, Flavor flavor, String trickName, Version gameVersion, Species species)
    {
        this.plan = planID;
        this.action = actionID;
        this.direction = direction;
        this.angle = angle;
        this.association = association;
        
        this.gesture = gesture;
        this.flavor = flavor;
        
        this.name = trickName;
        this.ver = gameVersion;
        this.species = species;
    }
    
    public Trick(int planID, int actionID, int direction, int angle, int association, Gesture gesture, Flavor flavor)
    {
        this(planID, actionID, direction, angle, association, gesture, flavor, "Unknown", Version.unknown, Species.unknown);
        
        Trick trick = TrickHelper.searchForTrickBy(planID, actionID, gesture);
        
        if(trick != null)
        {
            // set the name and game version and species
            this.name = trick.name;
            this.ver = trick.ver;
            this.species = trick.species;
        }
    }
    
    public String toString()
    {
        //String d = "\t";
        String d = ",";
        
        return name + d + species + d +ver + d + flavor + d + gesture + d
                + plan + d + action + d 
                + direction + d + angle + d + association;
    }
    
    public void fixTrickBy(Version version)
    {
        Trick goodTrick = TrickHelper.searchForTrickBy(name, version);
        
        if(goodTrick != null)
        {
            // change plan ID, action ID, and version
            plan = goodTrick.plan;
            action = goodTrick.action;
            ver = version;

            // check if the direction and angle are different and print something
            if(goodTrick.direction != direction || goodTrick.angle != angle
                    || !( 10 <= association && association <= 100) )
            {
                System.out.println("Expected Trick: " + goodTrick);
                System.out.println("Recieved Trick: " + this);
            }
        }
        else
        {
            System.out.println("Unknown Trick: " + this);
        }
    }
}