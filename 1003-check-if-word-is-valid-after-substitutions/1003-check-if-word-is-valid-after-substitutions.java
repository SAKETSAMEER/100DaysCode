class Solution {
    public boolean isValid(String str) {

        StringBuilder s = new StringBuilder(str);

        while(s.length()!=0){
            int a = s.indexOf("abc");
            if(a==-1) return false;
            else{
                s.delete(a,a+3);
            }
        }

        if(s.length()==0) return true;
        else return false;
    }
}