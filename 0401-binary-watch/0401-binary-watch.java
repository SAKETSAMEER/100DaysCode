class Solution {
    List<String> res;
    int[] clock;
    public List<String> readBinaryWatch(int turnedOn) {
         res = new ArrayList<>();
         clock = new int[2];
         backtrack(turnedOn, 0);
         return res;
    }

    private void backtrack(int on, int p){
        //the stop condition for backtracking
        if(on == 0){
            String time = getString(clock);
            res.add(time);
            return;
        }
        for(int i = p; i < 10; i++){
            int num = 1 << (i % 6);
            if(i < 6){
                clock[1] += num;
                if(isValid()){
                    backtrack(on - 1, i + 1);
                }
                clock[1] -= num;
            }else{
                clock[0] += num;
                if(isValid()){
                    backtrack(on - 1, i + 1);
                }
                clock[0] -= num;
            }
        }
    }

    //check if the clock has a valid time
    private boolean isValid(){
        if(clock[1] < 60 && clock[0] < 12){
            return true;
        }
        return false;
    }

    private String getString(int[] mark){
        StringBuilder sb = new StringBuilder();
        sb.append(mark[0]);
        sb.append(":");
        if(mark[1] < 10){
            sb.append(0);
        }
        sb.append(mark[1]);
        return sb.toString();
    }
}