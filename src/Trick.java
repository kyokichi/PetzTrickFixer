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
    
    String notes;
    
    
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
        
        this.notes = "";
    }
    
    public Trick(int planID, int actionID, int direction, int angle, int association, Gesture gesture, Flavor flavor)
    {
        this(planID, actionID, direction, angle, association, gesture, flavor, "Unknown", Version.unknown, Species.unknown);
        
        Trick trick = TrickHelper.getTrickBy(planID, actionID, gesture);
        
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
                + direction + d + angle + d + association + d + notes;
    }
    
    public void fixTrickBy(Species checkSpecies, Version checkVersion)
    {
        // if the association number is messed up at all
        if(!( 10 <= association && association <= 100))
        {
            association = 10;
        }
        
        Trick goodTrick;
        
        // check wrong species, will need to get a new trick
        if( species != Trick.Species.both && species != checkSpecies )
        {
            goodTrick = TrickHelper.getTrickBy(checkVersion, gesture, checkSpecies);
            notes = "fixed species";
        }
        else
        {
            goodTrick = TrickHelper.getTrickBy(name, checkVersion, checkSpecies);
        }

        // as long as the trick isn't null from this...
        if(goodTrick != null)
        {
            // change the entire trick data, except association
            plan = goodTrick.plan;
            action = goodTrick.action;
            direction = goodTrick.direction;
            angle = goodTrick.angle;
            name = goodTrick.name;
            ver = goodTrick.ver;
            species = goodTrick.species;
        }
        else
        {
            notes = "unknown trick";
        }  
    }
}