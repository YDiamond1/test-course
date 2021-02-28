import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertIterableEquals

class DFSTest {

    @Test
    fun `graph with loop`(){

        val graph = Graph(arrayOf(intArrayOf(0,1,0,0), intArrayOf(0,0,1,0), intArrayOf(0,0,0,1), intArrayOf(1,0,0,0)))
        graph.dfs(0)

        assertIterableEquals(listOf(0,1,2,3),graph.tour)
    }

    @Test
    fun `graph with loop 2`(){

        val graph = Graph(arrayOf(intArrayOf(0,1,0,0), intArrayOf(0,0,1,0), intArrayOf(0,0,0,1), intArrayOf(1,0,0,0)))
        graph.dfs(2)
        assertIterableEquals(listOf(2,3,0,1),graph.tour)
    }

    @Test
    fun `graph with tree`(){

        val graph = Graph(arrayOf(intArrayOf(0,1,1,0), intArrayOf(0,0,1,1), intArrayOf(1,0,0,0), intArrayOf(0,0,1,0)))
        graph.dfs(0)
        assertIterableEquals(listOf(0,1,2,3),graph.tour)
    }

    @Test
    fun `graph with tree 2`(){

        val graph = Graph(arrayOf(intArrayOf(0,1,1,0), intArrayOf(0,0,1,1), intArrayOf(1,0,0,0), intArrayOf(0,0,1,0)))
        graph.dfs(2)
        assertIterableEquals(listOf(2,0,1,3),graph.tour)
    }

    @Test
    fun `graph with tree 3`(){

        val graph = Graph(arrayOf(intArrayOf(0,1,1,0), intArrayOf(0,0,1,1), intArrayOf(1,0,0,0), intArrayOf(0,0,1,0)))
        graph.dfs(3)
        assertIterableEquals(listOf(3,2,0,1),graph.tour)
    }

}
