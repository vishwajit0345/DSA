class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] visited=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i]){
                dfs(i,visited,isConnected);
                provinces++;
            }
        }
        return provinces;
        
    }
    public void dfs(int node,boolean[] visited,int[][] graph)
    {
visited[node]=true;
for(int neighbour=0;neighbour<graph.length;neighbour++){
    if(graph[node][neighbour]==1 && !visited[neighbour])
    {
        dfs(neighbour,visited,graph);
    }

}
}
}
