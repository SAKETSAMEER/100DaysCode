class Solution {
    public int minMutation(String start, String end, String[] ban) {
        List<String> bank = new ArrayList<String>();
        bank.add(start);
        for(String b : ban) bank.add(b);
        HashSet<String> hs = new HashSet<String>();
        hs.add(start);
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : bank){
            for(String str : bank){
                if(difference(s,str) == 1){
                    List<String> lis = map.getOrDefault(s,new ArrayList<String>());
                    lis.add(str);           
                    map.put(s,lis);
                }
            }
        }
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        int mutations = 0;
        while(!q.isEmpty()){
            Queue<String> t = new LinkedList<String>();
            while(!q.isEmpty()){
                String s = q.poll();
                List<String> lis = map.getOrDefault(s,new ArrayList<String>());
                for(String str : lis)
                    if(!hs.contains(str)){
                        t.add(str);
                        hs.add(str);
                        if(str.equals(end)) return mutations + 1;
                    }
            }
            mutations++;
            q=t;
        }
        return -1;
    }
    
    int difference(String s, String str){
        char[] a = s.toCharArray(), b = str.toCharArray();
        int diff=0;
        for(int i=0;i<8;i++)
            if(a[i]!=b[i]) diff++;
        return diff;
    }
}