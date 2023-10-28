class Solution {

    
    public int countVowelPermutation(int n) {
        long a=1;
        long e=1;
        long i=1;
        long o=1;
        long u=1;
        long mod = 1000000007;

        for(int j=1; j<n; j++){
            long anext = e;
            long enext = (a+i)%mod;
            long inext = (a+e+o+u)%mod;
            long onext = (i+u)%mod;
            long unext = a;

            a=anext;
            e=enext;
            i=inext;
            o=onext;
            u=unext;
        }

        return (int)((a+e+i+o+u)%mod);


    }
}