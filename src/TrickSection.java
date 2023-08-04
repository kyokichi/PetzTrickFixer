public class TrickSection
{
    public static Trick[] getTrickSectionFrom(byte[] petData, int start)
    {
        //int start = findTrickSection(petData);
        //Trick.Species species = getPetSpecies(petData);
        
        if( start == -1)
        {
            return null;
        }
        
        int size = Trick.Gesture.values().length * Trick.Flavor.values().length * 3;
        // n should always be 120
        Trick[] tricks = new Trick[size];
        
        
        // set flavor to be 0
        // set gesture to be 0
        Trick.Flavor flavor = Trick.Flavor.chicken;
        Trick.Gesture gesture = Trick.Gesture.toy;
        
        int bi = start; // byte array index
        int ti = 0; // trick array index
        
        // for each set of 20 bytes
        while(bi < petData.length - 20 && ti < tricks.length)
        {
            // get the 5 integers from those 20 bytes
            int plan = convertByteArrayToInt32(petData, bi);
            int action = convertByteArrayToInt32(petData, bi+4);
            int direction = convertByteArrayToInt32(petData, bi+8);
            int angle = convertByteArrayToInt32(petData, bi+12);
            int association = convertByteArrayToInt32(petData, bi+16);
            
            // create a trick with those 5 integers and the flavor and gesture
            tricks[ti] = new Trick(plan, action, direction, angle, association, gesture, flavor);
            
            bi+=20;
            ti++;
            
            // update the flavor every 15
            flavor = Trick.Flavor.values()[ti / 15 % Trick.Flavor.values().length];
            
            // update the gesture every 3, resets after getting to end, % length
            gesture = Trick.Gesture.values()[ti / 3 % Trick.Gesture.values().length];
        }
        
        return tricks;
    }
    
    
    
    
    // this is useful because it decides if we should create a trick section or not
    // this is only for Petz 3 and 4 and might not work for Petz 5!
    public static int findTrickSection(byte[] allBytes)
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
    
    // this function should return a string
    // it gets the species from the petData
    // the trick constructor should handle if its a String?? that means I would have to rewrite the StupidHelperFile :(
    public static Trick.Species getPetSpecies(byte[] petData)
    {
        int i = 2 + 256 + 256 + 256 + 4 + 2 + 4 + 4;
        byte s = petData[i];
        
        if( s == 0 ) // cat
        {
            return Trick.Species.cat;
        }
        else if( s == 1 ) // dog
        {
            return Trick.Species.dog;
        }
        else
        {
            return Trick.Species.unknown;
        }
    }
    
    
    /**
     * Takes what is currently in the TrickSection file and just puts it into the byte data
     */
    public static byte[] updateTrickSectionBytes(byte[] petData, int start, Trick[] tricks)
    {
        /*// there are 5 integers and 4 bytes each
        int n = size * 5 * 4;
        byte[] bTricks = new byte[n];
        int i = 0;*/
        
        int i = start;
        
        for(Trick z : tricks)
        {
            putConvertInt32ToByte(petData, i, z.plan);
            putConvertInt32ToByte(petData, i+4, z.action);
            putConvertInt32ToByte(petData, i+8, z.direction);
            putConvertInt32ToByte(petData, i+12, z.angle);
            putConvertInt32ToByte(petData, i+16, z.association);
            
            i += 20;
        }
        
        return petData;
    }
    
    
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
    
    private static int convertByteArrayToInt32(byte[] bytes, int i)
    {
        return ((bytes[i+3] & 0xFF) << 24) |
                ((bytes[i+2] & 0xFF) << 16) |
                ((bytes[i+1] & 0xFF) << 8) |
                (bytes[i+0] & 0xFF);
    }
    
    private static void putConvertInt32ToByte(byte[] bytes, int i, int value)
    {
        bytes[i+3] = (byte) ((value >> 24) & 0xFF);
        bytes[i+2] = (byte) ((value >> 16) & 0xFF);
        bytes[i+1] = (byte) ((value >> 8) & 0xFF);
        bytes[i+0] = (byte) (value & 0xFF);
        
        /*System.out.printf("0x%x 0x%x 0x%x 0x%x \t",
                bytes[i], bytes[i+1], bytes[i+2], bytes[i+3]);*/
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
