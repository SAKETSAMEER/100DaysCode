class Solution {
    public int strStr(String haystack, String needle) {
        int n=0;
        if(haystack.contains(needle)){
            n=haystack.indexOf(needle);
        }else{
            n=-1;
        }
        return n;
    }
}