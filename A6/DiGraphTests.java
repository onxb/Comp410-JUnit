@Test
public void algorithm1() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");

    graph.addEdge(0, "a", "b", 1, null);

    ShortestPathInfo[] results = graph.shortestPath("a");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("a", results[0].getDest());

    assertEquals(1, results[1].getTotalWeight());
    assertEquals("b", results[1].getDest());
}

@Test
public void algorithm2() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");

    graph.addEdge(0, "a", "b", 1, null);
    graph.addEdge(1, "b", "c", 1, null);

    ShortestPathInfo[] results = graph.shortestPath("a");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("a", results[0].getDest());

    assertEquals(1, results[1].getTotalWeight());
    assertEquals("b", results[1].getDest());

    assertEquals(2, results[2].getTotalWeight());
    assertEquals("c", results[2].getDest());
}

@Test
public void algorithm3() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");
    graph.addNode(4, "d");

    graph.addEdge(0, "a", "b", 1, null);
    graph.addEdge(1, "b", "c", 1, null);
    graph.addEdge(2, "a", "d", 2, null);

    ShortestPathInfo[] results = graph.shortestPath("a");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("a", results[0].getDest());

    assertEquals(1, results[1].getTotalWeight());
    assertEquals("b", results[1].getDest());

    assertEquals(2, results[2].getTotalWeight());
    assertEquals("c", results[2].getDest());

    assertEquals(2, results[3].getTotalWeight());
    assertEquals("d", results[3].getDest());
}

@Test
public void algorithm7() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");
    graph.addNode(4, "d");

    graph.addEdge(0, "a", "b", 1, null);
    graph.addEdge(1, "b", "c", 1, null);
    graph.addEdge(2, "a", "d", 2, null);

    ShortestPathInfo[] results = graph.shortestPath("b");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("b", results[0].getDest());

    assertEquals(1, results[1].getTotalWeight());
    assertEquals("c", results[1].getDest());

    // Order for weights of -1 doesn't matter
    assertEquals(-1, results[2].getTotalWeight());
    assertTrue(results[2].getDest().equals("a") || results[2].getDest().equals("d"));

    assertEquals(-1, results[3].getTotalWeight());
    assertTrue(results[3].getDest().equals("a") || results[3].getDest().equals("d"));
    assertFalse(results[2].getDest().equals(results[3].getDest()));
}

@Test
public void algorithm4LectureExample() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");
    graph.addNode(4, "d");
    graph.addNode(5, "e");
    graph.addNode(6, "f");
    graph.addNode(7, "g");

    graph.addEdge(0, "a", "b", 2, null);
    graph.addEdge(1, "a", "d", 1, null);
    graph.addEdge(2, "b", "d", 3, null);
    graph.addEdge(3, "b", "e", 1, null);
    graph.addEdge(4, "d", "e", 3, null);
    graph.addEdge(5, "d", "g", 4, null);
    graph.addEdge(6, "d", "f", 8, null);
    graph.addEdge(7, "e", "g", 6, null);
    graph.addEdge(8, "g", "f", 1, null);
    graph.addEdge(9, "c", "f", 5, null);
    graph.addEdge(10, "c", "a", 4, null);
    graph.addEdge(11, "d", "c", 2, null);

    ShortestPathInfo[] results = graph.shortestPath("a");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("a", results[0].getDest());

    assertEquals(1, results[1].getTotalWeight());
    assertEquals("d", results[1].getDest());

    assertEquals(2, results[2].getTotalWeight());
    assertEquals("b", results[2].getDest());

    assertEquals(3, results[3].getTotalWeight());
    assertEquals("c", results[3].getDest());

    assertEquals(3, results[4].getTotalWeight());
    assertEquals("e", results[4].getDest());

    assertEquals(5, results[5].getTotalWeight());
    assertEquals("g", results[5].getDest());

    assertEquals(6, results[6].getTotalWeight());
    assertEquals("f", results[6].getDest());
}

@Test
public void algorithm5() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");
    graph.addNode(4, "d");
    graph.addNode(5, "e");
    graph.addNode(6, "f");
    graph.addNode(7, "g");

    graph.addEdge(0, "a", "b", 2, null);
    graph.addEdge(1, "a", "d", 1, null);

    ShortestPathInfo[] results = graph.shortestPath("a");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("a", results[0].getDest());

    assertEquals(1, results[1].getTotalWeight());
    assertEquals("d", results[1].getDest());

    assertEquals(2, results[2].getTotalWeight());
    assertEquals("b", results[2].getDest());

    // Can comment these out if failing due to different order of destination nodes. algorithm7 
    // should check if you are handling non-existent edges correctly
    assertEquals(-1, results[3].getTotalWeight());
    assertEquals("c", results[3].getDest());

    assertEquals(-1, results[4].getTotalWeight());
    assertEquals("e", results[4].getDest());

    assertEquals(-1, results[5].getTotalWeight());
    assertEquals("f", results[5].getDest());

    assertEquals(-1, results[6].getTotalWeight());
    assertEquals("g", results[6].getDest());

    assertEquals(graph.numOfNodes, results.length);
}

@Test
public void algorithm6() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");
    graph.addNode(4, "d");
    graph.addNode(5, "e");
    graph.addNode(6, "f");
    graph.addNode(7, "g");

    graph.addEdge(0, "a", "b", 2, null);
    graph.addEdge(1, "a", "d", 1, null);

    ShortestPathInfo[] results = graph.shortestPath("c");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("c", results[0].getDest());

    // Can comment these out if failing due to different order of destination nodes. algorithm7 
    // should check if you are handling non-existent edges correctly
    assertEquals(-1, results[1].getTotalWeight());
    assertEquals("a", results[1].getDest());

    assertEquals(-1, results[2].getTotalWeight());
    assertEquals("b", results[2].getDest());

    assertEquals(-1, results[3].getTotalWeight());
    assertEquals("d", results[3].getDest());

    assertEquals(-1, results[4].getTotalWeight());
    assertEquals("e", results[4].getDest());

    assertEquals(-1, results[5].getTotalWeight());
    assertEquals("f", results[5].getDest());

    assertEquals(-1, results[6].getTotalWeight());
    assertEquals("g", results[6].getDest());

    assertEquals(graph.numOfNodes, results.length);
}

@Test
public void algorithmStressTest() {
    DiGraph d = new DiGraph();
    for (int i = 0; i < 100; i++) {
        d.addNode(i, Integer.toString(i));
        if (i > 2) {
            d.addEdge((int) (i * Math.random() * Math.random() * 100000), Integer.toString(i), Integer.toString(i-1), 0, null);
            d.addEdge((int) (i * Math.random() * Math.random() * 100000), Integer.toString(i), Integer.toString(i-2), 0, null);
        }
    }

    ShortestPathInfo[] results = d.shortestPath("3");

    // Not quite sure how to test. Mainly to test algorithm is efficient
    assertEquals(d.numOfNodes, results.length);
}

@Test
public void integration1() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");
    graph.addNode(4, "d");
    graph.addNode(5, "e");
    graph.addNode(6, "f");
    graph.addNode(7, "g");

    graph.addEdge(0, "a", "b", 2, null);
    graph.addEdge(1, "a", "d", 1, null);
    graph.addEdge(2, "b", "d", 3, null);
    graph.addEdge(3, "b", "e", 1, null);
    graph.addEdge(4, "d", "e", 3, null);
    graph.addEdge(5, "d", "g", 4, null);
    graph.addEdge(6, "d", "f", 8, null);
    graph.addEdge(7, "e", "g", 6, null);
    graph.addEdge(8, "g", "f", 1, null);
    graph.addEdge(9, "c", "f", 5, null);
    graph.addEdge(10, "c", "a", 4, null);
    graph.addEdge(11, "d", "c", 2, null);

    graph.delEdge("d", "f");
    graph.delNode("b");

    ShortestPathInfo[] results = graph.shortestPath("a");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("a", results[0].getDest());

    assertEquals(1, results[1].getTotalWeight());
    assertEquals("d", results[1].getDest());

    assertEquals(3, results[2].getTotalWeight());
    assertEquals("c", results[2].getDest());

    assertEquals(4, results[3].getTotalWeight());
    assertEquals("e", results[3].getDest());

    assertEquals(5, results[4].getTotalWeight());
    assertEquals("g", results[4].getDest());

    assertEquals(6, results[5].getTotalWeight());
    assertEquals("f", results[5].getDest());
}

@Test
public void integration2() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");
    graph.addNode(4, "d");
    graph.addNode(5, "e");
    graph.addNode(6, "f");
    graph.addNode(7, "g");

    graph.addEdge(0, "a", "b", 2, null);
    graph.addEdge(1, "a", "d", 1, null);
    graph.addEdge(2, "b", "d", 3, null);
    graph.addEdge(3, "b", "e", 1, null);
    graph.addEdge(4, "d", "e", 3, null);
    graph.addEdge(5, "d", "g", 4, null);
    graph.addEdge(6, "d", "f", 8, null);
    graph.addEdge(7, "e", "g", 6, null);
    graph.addEdge(8, "g", "f", 1, null);
    graph.addEdge(9, "c", "f", 5, null);
    graph.addEdge(10, "c", "a", 4, null);
    graph.addEdge(11, "d", "c", 2, null);

    graph.delNode("d");

    ShortestPathInfo[] results = graph.shortestPath("a");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("a", results[0].getDest());

    assertEquals(2, results[1].getTotalWeight());
    assertEquals("b", results[1].getDest());

    assertEquals(3, results[2].getTotalWeight());
    assertEquals("e", results[2].getDest());

    assertEquals(9, results[3].getTotalWeight());
    assertEquals("g", results[3].getDest());

    assertEquals(10, results[4].getTotalWeight());
    assertEquals("f", results[4].getDest());

    assertEquals(-1, results[5].getTotalWeight());
    assertEquals("c", results[5].getDest());
}

@Test
public void integration3() {
    DiGraph graph = new DiGraph();
    graph.addNode(1, "a");
    graph.addNode(2, "b");
    graph.addNode(3, "c");
    graph.addNode(4, "d");
    graph.addNode(5, "e");
    graph.addNode(6, "f");
    graph.addNode(7, "g");

    graph.addEdge(0, "a", "b", 2, null);
    graph.addEdge(1, "a", "d", 1, null);
    graph.addEdge(2, "b", "d", 3, null);
    graph.addEdge(3, "b", "e", 1, null);
    graph.addEdge(4, "d", "e", 3, null);
    graph.addEdge(5, "d", "g", 4, null);
    graph.addEdge(6, "d", "f", 8, null);
    graph.addEdge(7, "e", "g", 6, null);
    graph.addEdge(8, "g", "f", 1, null);
    graph.addEdge(9, "c", "f", 5, null);
    graph.addEdge(10, "c", "a", 4, null);
    graph.addEdge(11, "d", "c", 2, null);

    graph.delNode("g");

    ShortestPathInfo[] results = graph.shortestPath("b");

    assertEquals(0, results[0].getTotalWeight());
    assertEquals("b", results[0].getDest());

    assertEquals(1, results[1].getTotalWeight());
    assertEquals("e", results[1].getDest());

    assertEquals(3, results[2].getTotalWeight());
    assertEquals("d", results[2].getDest());

    assertEquals(5, results[3].getTotalWeight());
    assertEquals("c", results[3].getDest());

    assertEquals(9, results[4].getTotalWeight());
    assertEquals("a", results[4].getDest());

    assertEquals(10, results[5].getTotalWeight());
    assertEquals("f", results[5].getDest());
}
