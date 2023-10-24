class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if( len == 1) {
            return false;
        }
        return isRepeatedPatternUsingKMP(s, len);
    }


    // KMP - O(n)
    // we start by creating LPS array, for a given string: abaadabaadabaad, LPS array would be
    // [0,0,1,1,0,1,2,3,4,5,6,7,8,9,10]
    // we see a pattern i.e. LPS array values are monotonically increasing from idx 5 ( patternLength ) in the above example
    // condition 2: so, the lps[n-1] = stringLength - patternLength
    // condition 1: we also know that (stringLength % patternLength == 0) for repetition

    boolean isRepeatedPatternUsingKMP(String s, int len){
        int[] lps = preprocessing(s, len);
        int lastElement = lps[len-1];

        // check condition for all valid pattern lengths
        for(int patLen=1; patLen <= len/2; patLen++){
            if(len % patLen == 0){
                // valid patternLength - condition 1
                if(lastElement == len - patLen){
                    // condition 2
                    return true;
                }
            }
        }
        return false;
    }

    //preprocessing - creating LPS array
    int[] preprocessing(String s, int len){
        int[] lps = new int[len];

        int i=0, j= 1;

        while(j < len){
            if(s.charAt(i) == s.charAt(j)){
                // matching
                lps[j] = i+1;
                i++;
                j++;
            }else{
                // not matching
                if(i != 0){
                    i = lps[i-1];
                }else{
                    // reached leftmost idx, couldn't find : put zero, let's move on
                    lps[j] =0;
                    j++;
                }
            }
        }
        return lps;
    }

}