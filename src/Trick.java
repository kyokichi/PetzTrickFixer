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
    
    int plan;
    int action;
    int direction;
    int angle;
    int association;
    
    Gesture gesture;
    Flavor flavor;
    
    String name;
    Version ver;
    
    
    public Trick(int planID, int actionID, int direction, int angle, int association, 
            Gesture gesture, Flavor flavor, String trickName, Version gameVersion)
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
    }
    
    public Trick(int planID, int actionID, int direction, int angle, int association, Gesture gesture, Flavor flavor)
    {
        this(planID, actionID, direction, angle, association, gesture, flavor, "Unknown", Version.unknown);
        
        Trick trick = TrickHelper.searchForTrickBy(planID, actionID);
        
        if(trick != null)
        {
            // set the name and game version
            this.name = trick.name;
            this.ver = trick.ver;
        }
    }
    
    public String toString()
    {
        //String d = "\t";
        String d = ",";
        
        return name + d +ver + d + flavor + d + gesture + d
                + plan + d + action + d 
                + direction + d + angle + d + association;
    }
    
    public void updateAction(int amount)
    {
        // actions with numbers lower than 100 should remain the same
        if(action > 100)
        {
            action += amount;
        }
    }
    
    public void updatePlan(int amount)
    {
        plan += amount;
    }
}