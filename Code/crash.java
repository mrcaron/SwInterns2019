import java.util.*;
public class crash 
{
    public static void main(String args[])
    {
        
        Object[] obj = null;
            while(true)                 //out of memory
            {
                Object[] obj1 = new Object[1];
                obj1[0] = obj;
                obj = obj1;
            }
        
        /*
        while(true)                                     //simple infinte loop
        {
            System.out.println("Infinite Loop");
        }
        */
        
        /*
        
        main(args); //Stack over flow error
        
        */
        
    }
}