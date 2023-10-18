class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accountss) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> accounts : accountss) {
            String name = accounts.get(0);
            String prevAccount = null;
            for (int i = 1;i < accounts.size();i++) {
                String account = accounts.get(i);
                emailToName.put(account, name);
                if (prevAccount == null) {
                    adj.putIfAbsent(account, new ArrayList<>());
                    prevAccount = account;
                    continue;
                }
                adj.get(prevAccount).add(account);
                adj.computeIfAbsent(account, (v) -> new ArrayList<>()).add(prevAccount);
                prevAccount = account;
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : adj.keySet()) {
            if (visited.contains(email)) {
                continue;
            }
            List<String> path = new ArrayList<>();
            getAllConnectedEmails(email, adj, path, visited);
            Collections.sort(path);
            List<String> pathResult = new ArrayList<>(Arrays.asList(emailToName.get(email)));
            pathResult.addAll(path);
            result.add(pathResult);
        }

        return result;
    }


    public void getAllConnectedEmails(String key, 
                Map<String, List<String>> adj, 
                List<String> result, 
                Set<String> visited) {

        if (visited.contains(key)) {
            return;
        }

        visited.add(key);
        result.add(key);

        for (String newKey : adj.get(key)) {
            getAllConnectedEmails(newKey, adj, result, visited);
        }

    }
}