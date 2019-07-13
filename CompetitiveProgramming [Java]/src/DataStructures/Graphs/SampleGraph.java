package DataStructures.Graphs;

import java.util.*;

public class SampleGraph {

    private Map<Vertex, List<Vertex>> adjacentVertices;

    private SampleGraph() {
        adjacentVertices = new HashMap<>();
    }

    public static void main(String[] args) {

        SampleGraph graph = new SampleGraph();

        graph.addVertex("Ayo");
        graph.addVertex("Okpe");
        graph.addVertex("John");
        graph.addVertex("Sanmi");

        graph.addEdge("Ayo", "Okpe");
        graph.addEdge("Ayo", "John");

        graph.addEdge("Okpe", "Ayo");
        graph.addEdge("Okpe", "Sanmi");

        graph.addEdge("John", "Ayo");
        graph.addEdge("John", "Sanmi");

        graph.addEdge("Sanmi", "Okpe");
        graph.addEdge("Sanmi", "John");

        System.out.println(graph.toString());

        Vertex vertex = new Vertex("Ayo");
        Vertex vertex1 = new Vertex("Okpe");
        Vertex vertex2 = new Vertex("Sanmi");

        graph.addVertexObj(vertex);
        graph.addVertexObj(vertex1);

        graph.addEdgeObj(vertex, vertex1);
        graph.addEdgeObj(vertex1, vertex2);

        System.out.println(graph.getAdjacentVertices().entrySet());
    }

    /**
     * @param graph
     * @param arbRoot
     * @return Visiting vertices as deep as possible along each branch before exploring vertices at the same level
     */
    Set<String> depthFirstTraversal(SampleGraph graph, String arbRoot) {

        Set<String> visitedVertices = new LinkedHashSet<>();
        Stack<String> verticesToVisit = new Stack<>();

        verticesToVisit.push(arbRoot);

        while (!verticesToVisit.empty()) {
            String currVertex = verticesToVisit.pop();

            if (!visitedVertices.contains(currVertex)) {
                visitedVertices.add(currVertex);

                for (Vertex vertex : graph.getAdjVertices(currVertex)) {
                    verticesToVisit.push(vertex.getVertexId());
                }
            }
        }

        return visitedVertices;
    }

    /**
     *
     * @param graph
     * @param arbRoot
     * @return Visiting vertices level by level, before going deep
     */
    Set<String> breadthFirstTraversal(SampleGraph graph, String arbRoot) {

        Set<String> visitedSet = new LinkedHashSet<>();
        Queue<String> toVisitQueue = new LinkedList<>();

        toVisitQueue.add(arbRoot);

        while (!toVisitQueue.isEmpty()) {
            String currVertex = toVisitQueue.poll();

            visitedSet.add(currVertex);

            for (Vertex vertex : graph.getAdjVertices(currVertex)) {
                toVisitQueue.add(vertex.getVertexId());
            }


        }
        return visitedSet;
    }


    private void addVertex(String vertexId) {
        adjacentVertices.putIfAbsent(new Vertex(vertexId), new ArrayList<>());
    }

    private void addVertexObj(Vertex vertex) {
        adjacentVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    void removeVertex(String vertexId) {
        Vertex v = new Vertex(vertexId);
        adjacentVertices.values().forEach(entry -> entry.remove(v));
        adjacentVertices.remove(v);
    }

    private void addEdge(String vId1, String vId2) {
        Vertex vertex1 = new Vertex(vId1);
        Vertex vertex2 = new Vertex(vId2);

        edgify(vertex1, vertex2);
    }

    private void addEdgeObj(Vertex vertex1, Vertex vertex2) {
        edgify(vertex1, vertex2);
    }

    private void edgify(Vertex vertex1, Vertex vertex2) {

        if (!adjacentVertices.containsKey(vertex1))
            adjacentVertices.put(vertex1, new ArrayList<>());

        if (!adjacentVertices.containsKey(vertex2))
            adjacentVertices.put(vertex2, new ArrayList<>());

        adjacentVertices.get(vertex1).add(vertex2);
        adjacentVertices.get(vertex2).add(vertex1);
    }

    private void removeEdge(String vId1, String vId2) {
        Vertex vertex1 = new Vertex(vId1);
        Vertex vertex2 = new Vertex(vId2);

        if (!adjacentVertices.containsKey(vertex1) || !adjacentVertices.containsKey(vertex2))
            throw new IllegalArgumentException("One of these vertices does not exist");

        adjacentVertices.get(vertex1).remove(vertex2);
        adjacentVertices.get(vertex2).remove(vertex1);
    }

    private List<Vertex> getAdjVertices(String vertexId) {
        return adjacentVertices.get(new Vertex(vertexId));
    }

    private Map<Vertex, List<Vertex>> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public String toString() {
        return adjacentVertices.entrySet().toString();
    }
}

class Vertex {
    private String vertexId;

    Vertex(String id) {
        this.vertexId = id;
    }

    String getVertexId() {
        return vertexId;
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