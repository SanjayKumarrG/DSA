package algorithms;

//Floyd Warshall Algorithm in Java
/*
class FloydWarshall {
final static int INF = 9999, nV = 4;

// Implementing floyd warshall algorithm
void floydWarshall(int graph[][]) {
 int matrix[][] = new int[nV][nV];
 int i, j, k;

 for (i = 0; i < nV; i++)
   for (j = 0; j < nV; j++)
     matrix[i][j] = graph[i][j];

 // Adding vertices individually
 for (k = 0; k < nV; k++) {
   for (i = 0; i < nV; i++) {
     for (j = 0; j < nV; j++) {
       if (matrix[i][k] + matrix[k][j] < matrix[i][j])
         matrix[i][j] = matrix[i][k] + matrix[k][j];
     }
   }
 }
 printMatrix(matrix);
}

void printMatrix(int matrix[][]) {
 for (int i = 0; i < nV; ++i) {
   for (int j = 0; j < nV; ++j) {
     if (matrix[i][j] == INF)
       System.out.print("INF ");
     else
       System.out.print(matrix[i][j] + "  ");
   }
   System.out.println();
 }
}

public static void main(String[] args) {
 int graph[][] = { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
 FloydWarshall a = new FloydWarshall();
 a.floydWarshall(graph);
}*/
import java.util.ArrayList;
import java.util.List;
 
class FloydWarshall
{
    // Recursive function to print path of given vertex `u` from source vertex `v`
    private static void printPath(int[][] path, int v, int u, List<Integer> route)
    {
        if (path[v][u] == v) {
            return;
        }
        printPath(path, v, path[v][u], route);
        route.add(path[v][u]);
    }
 
    // Function to print the shortest cost with path information between
    // all pairs of vertices
    private static void printSolution(int[][] path, int n)
    {
        for (int v = 0; v < n; v++)
        {
            for (int u = 0; u < n; u++)
            {
                if (u != v && path[v][u] != -1)
                {
                    List<Integer> route = new ArrayList<>();
                    route.add(v);
                    printPath(path, v, u, route);
                    route.add(u);
                    System.out.printf("The shortest path from %d —> %d is %s\n",
                        v, u, route);
                }
            }
        }
    }
 
    // Function to run the Floyd–Warshall algorithm
    public static void floydWarshall(int[][] adjMatrix)
    {
        // base case
        if (adjMatrix ==null || adjMatrix.length == 0) {
            return;
        }
 
        // total number of vertices in the `adjMatrix`
        int n = adjMatrix.length;
 
        // cost[] and path[] stores shortest path
        // (shortest cost/shortest route) information
        int[][] cost = new int[n][n];
        int[][] path = new int[n][n];
 
        // initialize cost[] and path[]
        for (int v = 0; v < n; v++)
        {
            for (int u = 0; u < n; u++)
            {
                // initially, cost would be the same as the weight of the edge
                cost[v][u] = adjMatrix[v][u];
 
                if (v == u) {
                    path[v][u] = 0;
                }
                else if (cost[v][u] != Integer.MAX_VALUE) {
                    path[v][u] = v;
                }
                else {
                    path[v][u] = -1;
                }
            }
        }
 
        // run Floyd–Warshall
        for (int k = 0; k < n; k++)
        {
            for (int v = 0; v < n; v++)
            {
                for (int u = 0; u < n; u++)
                {
                    // If vertex `k` is on the shortest path from `v` to `u`,
                    // then update the value of cost[v][u] and path[v][u]
 
                    if (cost[v][k] != Integer.MAX_VALUE
                            && cost[k][u] != Integer.MAX_VALUE
                            && (cost[v][k] + cost[k][u] < cost[v][u]))
                    {
                        cost[v][u] = cost[v][k] + cost[k][u];
                        path[v][u] = path[k][u];
                    }
                }
 
                // if diagonal elements become negative, the
                // graph contains a negative-weight cycle
                if (cost[v][v] < 0)
                {
                    System.out.println("Negative-weight cycle found!!");
                    return;
                }
            }
        }
 
        // Print the shortest path between all pairs of vertices
        printSolution(path, n);
    }
 
    public static void main(String[] args)
    {
        // define infinity
        int I = Integer.MAX_VALUE;
 
        // given adjacency representation of the matrix
        int[][] adjMatrix = new int[][]
        {
            { 0, I, -2, I },
            { 4, 0, 3, I },
            { I, I, 0, 2 },
            { I, -1, I, 0 }
        };
 
        // Run Floyd–Warshall algorithm
        floydWarshall(adjMatrix);
    }
}
