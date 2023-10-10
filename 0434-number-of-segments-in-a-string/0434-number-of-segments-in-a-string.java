import java.util.*;
class Solution {

    public int countSegments(String s) {
        StringTokenizer st=new StringTokenizer(s," ");
        int count=0;
        while(st.hasMoreTokens())
        {
            count++;
            st.nextToken();
        }

        return count;
    }
}