fun main() {
    val graph: Array<IntArray> = Array(10){IntArray(10){(0 until 2).random()}};

    println("arrayOf(")
    for (g in graph){
        print("intArrayOf(")
        for(v in g.indices){
            if(v != 0) print(", ")
            print(g[v])
        }
        println("),")
    }
    println(")")

    val dfs = Graph(graph)
    dfs.dfs(1);
    print(dfs.tour)
}
