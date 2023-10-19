class Solution {
	public boolean isValid(String x) {
		// Your code goes here
        HashMap<Character , Character> map = new HashMap<>();

        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack <Character> stk = new Stack<>();

        for(int i=0 ; i<x.length();i++){
            char ch =x.charAt(i);
            if(ch=='(' ||ch=='{' || ch=='['){
                stk.push(ch);
            }else {
                if(!stk.isEmpty()&&stk.peek()==map.get(ch)){
                    stk.pop();
                }else{
                    return false;
                }
            }
            }
             if(stk.size()==0){
                    return true;
                }
                return false;
        
   }
}      