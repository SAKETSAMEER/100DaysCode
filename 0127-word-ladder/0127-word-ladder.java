import java.util.*;
class Solution {
    private boolean isEdge(String s1, String s2){
        int cnt = 0;
        for(int i=0; i< s1.length(); i++){
            cnt += (s1.charAt(i) != s2.charAt(i) ? 1 : 0);
        }
        return cnt == 1;
    }

    private int bfs(List<String> candidates, HashMap<String, Boolean> visited,  HashMap<String, HashSet<String>> graph, String target, int length) {
        length++;
        if(candidates.size() == 0){
            return 0;
        }
        Set<String> new_candidates = new HashSet<String>();
        for(int i=0; i<candidates.size(); i++){
            if(visited.get(candidates.get(i)) == true){
                continue;
            }
            visited.put(candidates.get(i), true);
            HashSet<String> next = graph.get(candidates.get(i));
            new_candidates.addAll(next);
        }
        if(new_candidates.contains(target)){
            return length + 1;
        }
        return bfs(new ArrayList<String>(new_candidates), visited, graph, target, length);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        HashMap<String, HashSet<String>> graph = new HashMap<String, HashSet<String>>();
        wordList.add(beginWord);
        for(int i=0; i< wordList.size(); i++){
            graph.put(wordList.get(i), new HashSet<String>());
            visited.put(wordList.get(i), false);
        }

        for(int i=0; i<wordList.size(); i++){
            for(int j=i; j<wordList.size(); j++){
                if(isEdge(wordList.get(i), wordList.get(j))){
                    HashSet<String> list_i = graph.get(wordList.get(i));
                    list_i.add(wordList.get(j));
                    HashSet<String> list_j = graph.get(wordList.get(j));
                    list_j.add(wordList.get(i));
                    graph.put(wordList.get(i), list_i);
                    graph.put(wordList.get(j), list_j);
                }
            }
        }
       List<String> candidates = new ArrayList<String>();
       candidates.add(beginWord);
       int length = bfs(candidates, visited, graph, endWord, 0);
       return length;
    }
}