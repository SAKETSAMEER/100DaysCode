public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        //Step 1: Initialize the counter from 0
        //It will store the count of 1's in the number.
        int count = 0;

        //Step 2:
        //Run the for loop for 32 times.
        for(int i=0; i<32; i++)
        {

            //Step 3:
            //Check whether the last digit is 1 or Not.
            if((n & 1) == 1)
            {
                //Step 4:
                //Increase counter if it is 1.
                count++;
            }

            //Step 5:
            //RightShift the number by 1 place.
            n >>= 1;
        }

        //Step 6:
        //Finally, return the count value.
        return count;
        
    }
}