/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i=n/2;
        if(guess(n)==0)
        {
            return n;
        }
        while(true)
        {
            if(guess(i)==0)
            {
                break;
            }
            else if(guess(i)==1)
            {
                i+=10;
                if(guess(i)==-1)
                {
                for(int j=0;j<10;j++)
                {
                    i--;
                 if(guess(i)==0)
                 {
                    break;
                 }
                }
                }
            }
            else
            {                
                i-=10;           
                if(guess(i)==1)
                {     
                for(int j=0;j<10;j++)
                {
                    i--;
                if(guess(i)==0)
                {
                    break;
                }
                
                }
                }
            }
        }
    return i;
    }
}