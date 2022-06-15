public class TrickSection
{
    Trick[] tricks;
    int size = Trick.Gesture.values().length * Trick.Flavor.values().length * 3;
    // n should always be 120
    
    
    public TrickSection(byte[] trickBytes, int start)
    {
        tricks = new Trick[size];
        
        // set flavor to be 0
        // set gesture to be 0
        Trick.Flavor flavor = Trick.Flavor.chicken;
        Trick.Gesture gesture = Trick.Gesture.toy;
        
        int bi = start; // byte array index
        int ti = 0; // trick array index
        
        // for each set of 20 bytes
        while(bi < trickBytes.length - 20 && ti < tricks.length)
        {
            // get the 5 integers from those 20 bytes
            int plan = convertByteArrayToInt32(trickBytes, bi);
            int action = convertByteArrayToInt32(trickBytes, bi+4);
            int direction = convertByteArrayToInt32(trickBytes, bi+8);
            int angle = convertByteArrayToInt32(trickBytes, bi+12);
            int association = convertByteArrayToInt32(trickBytes, bi+16);
            
            // create a trick with those 5 integers and the flavor and gesture
            tricks[ti] = new Trick(plan, action, direction, angle, association, gesture, flavor);
            
            bi+=20;
            ti++;
            
            // update the flavor every 15
            flavor = Trick.Flavor.values()[ti / 15 % Trick.Flavor.values().length];
            
            // update the gesture every 3, resets after getting to end, % length
            gesture = Trick.Gesture.values()[ti / 3 % Trick.Gesture.values().length];
        }
    }
    
    private static int convertByteArrayToInt32(byte[] bytes, int i)
    {
        return ((bytes[i+3] & 0xFF) << 24) |
                ((bytes[i+2] & 0xFF) << 16) |
                ((bytes[i+1] & 0xFF) << 8) |
                (bytes[i+0] & 0xFF);
    }
    
    
    
    public String toString()
    {
        String s = "";
        
        // maybe every 15 tricks, I could put an extra space somehow
        // meaning I have to rewrite this using a regular for loop
        
        for(Trick z : tricks)
        {
            s += z + "\n";
        }
        
        return s;
    }
    
    public void updateEachTrickPlanBy(int amount)
    {
        for(Trick z : tricks)
        {
            z.updatePlan(amount);
        }
    }
    
    public void updateEachTrickActionBy(int amount)
    {
        for(Trick z : tricks)
        {
            z.updateAction(amount);
        }
    }
    
    
    public byte[] getTrickSectionBytes()
    {
        // there are 5 integers and 4 bytes each
        int n = size * 5 * 4;
        byte[] bTricks = new byte[n];
        int i = 0;
        
        for(Trick z : tricks)
        {
            putConvertInt32ToByte(bTricks, i, z.plan);
            putConvertInt32ToByte(bTricks, i+4, z.action);
            putConvertInt32ToByte(bTricks, i+8, z.direction);
            putConvertInt32ToByte(bTricks, i+12, z.angle);
            putConvertInt32ToByte(bTricks, i+16, z.association);
            
            i += 20;
        }
        
        return bTricks;
    }
    
    private static void putConvertInt32ToByte(byte[] bytes, int i, int value)
    {
        bytes[i+3] = (byte) ((value >> 24) & 0xFF);
        bytes[i+2] = (byte) ((value >> 16) & 0xFF);
        bytes[i+1] = (byte) ((value >> 8) & 0xFF);
        bytes[i+0] = (byte) (value & 0xFF);
    }
    
    
    
    
    
    
    private static byte[] convertInt32ToByteArray(int value)
    {
        byte[] bytes = new byte[4];
        bytes[3] = (byte) ((value >> 24) & 0xFF);
        bytes[2] = (byte) ((value >> 16) & 0xFF);
        bytes[1] = (byte) ((value >> 8) & 0xFF);
        bytes[0] = (byte) (value & 0xFF);
        return bytes;
    }
}
