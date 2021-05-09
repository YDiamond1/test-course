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

    @Test
    fun `big graph 1`(){

        val graph = Graph(arrayOf(
            intArrayOf(0, 0, 0, 0, 1, 1, 1, 0, 1, 0),
            intArrayOf(0, 0, 1, 1, 0, 1, 0, 1, 0, 0),
            intArrayOf(0, 1, 1, 1, 1, 0, 1, 0, 0, 1),
            intArrayOf(0, 1, 0, 0, 0, 1, 1, 1, 1, 1),
            intArrayOf(0, 0, 1, 0, 0, 1, 0, 1, 1, 1),
            intArrayOf(0, 0, 0, 1, 0, 1, 1, 1, 0, 0),
            intArrayOf(0, 1, 1, 1, 1, 0, 0, 1, 0, 1),
            intArrayOf(0, 0, 0, 0, 1, 1, 1, 0, 1, 0),
            intArrayOf(1, 1, 1, 0, 1, 1, 1, 1, 1, 1),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 1, 0, 0),
        ))
        graph.dfs(0)
        assertIterableEquals(listOf(0, 4, 2, 1, 3, 5, 6, 7, 8, 9),graph.tour)
    }


    @Test
    fun `big graph 2`(){

        val graph = Graph(arrayOf(
            intArrayOf(1, 0, 0, 0, 0, 0, 0, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 1, 1, 0, 0, 1),
            intArrayOf(0, 1, 1, 1, 1, 1, 0, 0, 1, 1),
            intArrayOf(0, 0, 0, 0, 0, 0, 1, 1, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 1, 0, 0, 1),
            intArrayOf(1, 0, 1, 1, 1, 0, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
            intArrayOf(0, 1, 1, 0, 1, 0, 1, 0, 1, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 1, 0, 1),
            intArrayOf(0, 0, 0, 1, 0, 1, 0, 1, 1, 0),
        ))
        graph.dfs(5)
        assertIterableEquals(listOf(5, 0, 7, 1, 6, 9, 3, 8, 4, 2),graph.tour)
    }
    @Test
    fun `big graph 3`(){

        val graph = Graph(arrayOf(
            intArrayOf(0, 0, 0, 1, 0, 0, 0, 0, 0, 1),
            intArrayOf(1, 1, 1, 0, 0, 1, 1, 0, 1, 0),
            intArrayOf(1, 0, 0, 0, 0, 0, 1, 1, 0, 0),
            intArrayOf(1, 0, 1, 1, 1, 1, 0, 1, 0, 0),
            intArrayOf(1, 1, 0, 1, 1, 1, 0, 1, 1, 0),
            intArrayOf(1, 1, 1, 1, 0, 0, 0, 1, 0, 0),
            intArrayOf(1, 0, 1, 1, 1, 1, 0, 0, 0, 0),
            intArrayOf(0, 1, 0, 0, 0, 0, 1, 0, 1, 1),
            intArrayOf(1, 0, 0, 1, 1, 0, 0, 0, 0, 1),
            intArrayOf(1, 1, 0, 0, 1, 1, 0, 0, 0, 1),
        ))
        graph.dfs(1)
        assertIterableEquals(listOf(1, 0, 3, 2, 6, 4, 5, 7, 8, 9),graph.tour)
    }
}
