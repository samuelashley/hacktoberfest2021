class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        dfs(0, graph, vis, ans, new ArrayList<>());
        
        return ans;
    }
    
    private void dfs(int node, int[][] graph, boolean[] vis, List<List<Integer>> ans, List<Integer> curr) {
        if (node == graph.length - 1) {    
            curr.add(node);
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        
        vis[node] = true;
        curr.add(node);
        for (int it : graph[node]) {
            if (!vis[it]) {
                dfs(it, graph, vis, ans, curr);
            }
        }
        vis[node] = false;
        curr.remove(curr.size() - 1);
    }
}
