import java.util.*;
class leetcode
{
    /* Function checks if passed strings (str1 and str2)
       are rotations of each other */
    static boolean areRotations(String str1, String str2)
    {
        // There lengths must be same and str2 must be 
        // a substring of str1 concatenated with str1.  
        return (str1.length() == str2.length()) &&
               ((str1 + str1).indexOf(str2) != -1);
    }
      
    // Driver method
    public static void main (String[] args)
    {
        Scanner scn = new Scanner(System.in);
        String str1 = scn.nextLine();
        String str2 = scn.nextLine();
  
        if (areRotations(str1, str2))
            System.out.println("true");
        else
            System.out.printf("false");
    }
}