package ChiPractice.GS;

import java.util.*;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */

class Vertex {
    String vertexId;

    Vertex(String vertexId) {
        this.vertexId = vertexId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(vertexId, vertex.vertexId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexId);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "vertexId='" + vertexId + '\'' +
                '}';
    }
}

class Graph {

    private Map<Vertex, List<Vertex>> vertexToAdjVertices;

    Graph() {
        this.vertexToAdjVertices = new HashMap<>();
    }

    private void addVertex(String vertexId) {
        vertexToAdjVertices.putIfAbsent(new Vertex(vertexId), new ArrayList<>());
    }

    private void addEdge(String vertexId1, String vertexId2) {
        Vertex vertex1 = new Vertex(vertexId1);
        Vertex vertex2 = new Vertex(vertexId2);

        edgify(vertex1, vertex2);
    }

    private void edgify(Vertex vertex1, Vertex vertex2) {

        if (!vertexToAdjVertices.containsKey(vertex1))
            vertexToAdjVertices.put(vertex1, new ArrayList<>());

        if (!vertexToAdjVertices.containsKey(vertex2))
            vertexToAdjVertices.put(vertex2, new ArrayList<>());

        vertexToAdjVertices.get(vertex1).add(vertex2);
        vertexToAdjVertices.get(vertex2).add(vertex1);
    }

    private void depthFirstTraversal(Graph graph, String root){

        if(!vertexToAdjVertices.containsKey(new Vertex(root)))
            throw new NoSuchElementException("No Such Root");

        /**
         * Depth first. Visit a root, add its children nodes to a stack. visit them and repeat. Store visited nodes in a set
         */
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> unvisited = new Stack<>();

        unvisited.push(root);

        while(!unvisited.empty()){
            String currentVertex = unvisited.pop();

            if(!visited.contains(visited))
                visited.add(currentVertex);

            for(Vertex vertex : vertexToAdjVertices.get(new Vertex(root))){
                unvisited.push(vertex.vertexId);
            }
        }

    }
}

public class DepthFirstTraversal {
}
