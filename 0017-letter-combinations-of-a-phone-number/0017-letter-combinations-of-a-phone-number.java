class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Integer,String> map = new HashMap<Integer, String>();//to store data(s)
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        String s1 = "",s2 = "",s3 = "",s4 = "";
        if(digits.length() > 0)
            s1 = map.get(Character.getNumericValue(digits.charAt(0)));
        if(digits.length() > 1)
            s2 = map.get(Character.getNumericValue(digits.charAt(1)));
        if(digits.length() > 2)
            s3 = map.get(Character.getNumericValue(digits.charAt(2)));
        if(digits.length() > 3)
            s4 = map.get(Character.getNumericValue(digits.charAt(3)));
        StringBuilder sb = new StringBuilder("a");
        for(int i = 0; i < s1.length(); i++) {
            sb.delete(0,sb.length());
            sb.append(s1.charAt(i));
            for(int j = 0; j < s2.length(); j++) {
                sb.delete(1,sb.length());
                sb.append(s2.charAt(j));
                for(int k = 0; k < s3.length(); k++) {
                    sb.delete(2,sb.length());
                    sb.append(s3.charAt(k));
                    for(int l = 0; l < s4.length(); l++) {
                        sb.delete(3,sb.length());
                        sb.append(s4.charAt(l));
                        result.add(sb.toString());
                    }
                    if(digits.length() == 3) {
                        result.add(sb.toString());
                    }
                }
                if(digits.length() == 2) {
                    result.add(sb.toString());
                }
            }
            if(digits.length() == 1) {
                result.add(sb.toString());
            }
        }
        return result;
    }
}