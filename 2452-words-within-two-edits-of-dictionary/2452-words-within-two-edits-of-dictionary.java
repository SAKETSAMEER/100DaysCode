class Solution {
    public List<String> twoEditWords(String[] q, String[] d) {
        int k=q.length;
        List<String> nm=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<d.length;j++)
            {
                int c=0;
                for(int p=0;p<Math.min(d[j].length(),q[i].length());p++)
                {
                    if(d[j].charAt(p)!=q[i].charAt(p))
                        c++;
                }
                if(c<=2)
                {
                    nm.add(q[i]);
                    break;
                }
                //System.out.println(c+" "+q[i]+" "+d[j]);
            }
        }
        return nm;
    }
}