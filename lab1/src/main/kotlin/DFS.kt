class Graph (
    val graph : Array<IntArray>,

){
    val visited : IntArray = IntArray(graph.size){0}
    val tour = mutableListOf<Int>()


    fun dfs(vertex: Int){
        if(visited[vertex] == 1)
            return

        visited[vertex] = 1
        tour.add(vertex)

        (0..graph[vertex].size-1).forEach{
            if(graph[vertex][it] == 1 && vertex != it) dfs(it)
        }
    }
}
