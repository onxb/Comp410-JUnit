package DiGraph_A5;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiGraphTest {

    private static final int NUM_NODES = 100;

    @Test
    public void DiGraphConstructorTest() {
        try {
            DiGraph d = new DiGraph();
            assertEquals("Constructor did not establish the required semantics", 0, d.numNodes());
            assertEquals("Constructor did not establish the required semantics", 0, d.numEdges());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddFirstNodeTest() {
        try {
            DiGraph d = new DiGraph();
            assertTrue("Adding node to emptry graph failed", d.addNode(0, "first"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddManyNodesTest() {
        try {
            DiGraph d = new DiGraph();
            String s = "";
            for (int i = 0; i < NUM_NODES; i++) {
                assertTrue("Adding node " + i + " failed", d.addNode(i, (s += "a")));
            }
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddInvalidIDNodeTest() {
        try {
            DiGraph d = new DiGraph();
            assertFalse("Adding node with negative id succeeded", d.addNode(-1, "first"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddNonUniqueIDNodeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            assertFalse("Adding node with non-unique id succeeded", d.addNode(0, "second"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddNullLabelNodeTest() {
        try {
            DiGraph d = new DiGraph();
            assertFalse("Adding node with null label succeeded", d.addNode(0, null));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddNonUniqueLabelNodeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            assertFalse("Adding node with non-unique label succeeded", d.addNode(1, "first"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteSingleNodeTest() {
        try {
            DiGraph d = new DiGraph();
            String s;
            d.addNode(0, s = "first");
            assertTrue("Deleting node failed", d.delNode(s));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteManyNodesTest() {
        try {
            DiGraph d = new DiGraph();
            String[] s = new String[NUM_NODES];
            String insert = "";
            for (int i = 0; i < s.length; i++) {
                d.addNode(i, s[i] = (insert += "a"));
            }
            for (String label : s) {
                assertTrue("Removing node labelled " + label + " failed", d.delNode(label));
            }
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteNonExistentNode() {
        try {
            DiGraph d = new DiGraph();
            assertFalse("Removing non-existent node succeeded", d.delNode("anything"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteNullLabelledNode() {
        try {
            DiGraph d = new DiGraph();
            assertFalse("Removeing null-labelled node succeeded", d.delNode(null));
            // Technically, this case is unspecified by the docs,
            // and while I'm tempted to make it an exception I think it would be
            // better as simply returning false
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddSingleEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            assertTrue("Adding edge between two nodes failed", d.addEdge(0, "first", "second", 1, "some edge"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddDoubleEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            d.addEdge(0, "first", "second", 1, "some edge");
            assertTrue("Adding second edge in opposite direction between two nodes failed",
                    d.addEdge(1, "second", "first", 1, "label"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddManyEdgesTest() {
        try {
            DiGraph d = new DiGraph();
            String s1, s2, s3;
            d.addNode(0, s1 = "a");
            d.addNode(1, s2 = "b");
            d.addNode(2, s3 = "c");
            assertTrue("Adding edge between two nodes failed", d.addEdge(0, s1, s2, 1, "a"));
            assertTrue("Adding edge between two nodes failed", d.addEdge(1, s1, s3, 1, "a"));
            assertTrue("Adding edge between two nodes failed", d.addEdge(2, s2, s3, 1, "a"));
            for (int i = 3; i < NUM_NODES; i++) {
                d.addNode(i, s1 += s1);
                assertTrue("Adding edge between two nodes failed at " + i, d.addEdge(i, s2, s1, 1, "a"));
                assertTrue("Adding edge between two nodes failed at " + i * 2, d.addEdge(i * 2, s3, s1, 1, "a"));
                s2 = s3;
                s3 = s1;
            }
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddNonUniqueIDEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            d.addNode(2, "third");
            d.addEdge(0, "first", "second", 1, "some edge");
            assertFalse("Adding edge with non unique id succeeded", d.addEdge(0, "second", "third", 1, "a"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddInvalidIDEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            assertFalse("Adding edge with negative id succeeded", d.addEdge(-1, "first", "second", 1, "a"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddNoSourceEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(1, "second");
            assertFalse("Adding edge with no source succeeded", d.addEdge(0, "first", "second", 1, "a"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddNoDestinationEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            assertFalse("Adding edge with no destination succeeded", d.addEdge(0, "first", "second", 1, "a"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddPreExistingEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            d.addEdge(0, "first", "second", 1, "a");
            assertFalse("Adding pre-existing edge succeeded", d.addEdge(1, "first", "second", 1, "a"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddNullLabelledEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            assertTrue("Adding null-labelled edge failed", d.addEdge(0, "first", "second", 1, null));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddEdgeToSelfTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            assertTrue("Adding edge from node to self failed", d.addEdge(0, "a", "a", 1, null));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void AddSecondEdgeToSelfTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.addEdge(0, "a", "a", 1, null);
            assertTrue("Adding second edge from node to self succeeded", d.addEdge(1, "a", "a", 1, null));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteSingleEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            d.addEdge(0, "first", "second", 1, "a");
            assertFalse("Deleting edge failed", d.delEdge("first", "second"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteManyEdgesTest() {
        try {
            DiGraph d = new DiGraph();
            String s1, s2, s3;
            String[] source = new String[2 * NUM_NODES], dest = new String[2 * NUM_NODES];
            d.addNode(0, s1 = "a");
            d.addNode(1, s2 = "b");
            d.addNode(2, s3 = "c");
            d.addEdge(0, s1, s2, 1, "a");
            source[0] = s1;
            dest[0] = s2;
            d.addEdge(1, s1, s3, 1, "a");
            source[1] = s1;
            dest[1] = s3;
            d.addEdge(2, s2, s3, 1, "a");
            source[2] = s2;
            dest[2] = s3;
            for (int i = 3; i < NUM_NODES; i++) {
                d.addNode(i, s1 += "a");
                d.addEdge(i, s2, s1, 1, "a");
                source[i] = s2;
                dest[i] = s1;
                d.addEdge(i * 2, s3, s1, 1, "a");
                source[i * 2] = s3;
                dest[i * 2] = s1;

                s2 = s3;
                s3 = s1;
            }
            for (int i = 0; i < source.length; i++) {
                if (source[i] != null && dest[i] != null)
                    assertTrue("Deleting edge between two nodes failed at " + i, d.delEdge(source[i], dest[i]));
            }
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteNoSourceEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            d.addEdge(0, "first", "second", 1, "a");
            assertFalse("Deleting edge with no source succeeded", d.delEdge("third", "second"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteNoDestinationEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            d.addEdge(0, "first", "second", 1, "a");
            assertFalse("Deleting edge with no destination succeeded", d.delEdge("first", "third"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteInvalidEdgeTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "first");
            d.addNode(1, "second");
            d.addEdge(0, "first", "second", 1, "a");
            assertFalse("Deleting non-existent edge failed", d.delEdge("third", "fourth"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void DeleteEdgeToSelfTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.addEdge(0, "a", "a", 1, null);
            assertTrue("Deleting edge from node to self failed", d.delEdge("a", "a"));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumEdgesNoneTest() {
        try {
            DiGraph d = new DiGraph();
            assertEquals("New Graph has edges", 0, d.numEdges());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumEdgesSingleTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.addNode(1, "b");
            d.addEdge(0, "a", "b", 1, null);
            assertEquals("Graph of 1 edge has the wrong number of edges", 1, d.numEdges());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumEdgesManyTest() {
        try {
            DiGraph d = new DiGraph();
            String s1, s2, s3;
            d.addNode(0, s1 = "a");
            d.addNode(1, s2 = "b");
            d.addNode(2, s3 = "c");
            int edges = 3;
            for (int i = 3; i < NUM_NODES; i++) {
                d.addNode(i, s1 += "a");
                d.addEdge(i, s2, s1, 1, "a");
                d.addEdge(i * 2, s3, s1, 1, "a");
                s2 = s3;
                s3 = s1;
                edges += 2;
            }
            assertEquals("Graph of " + edges + " edges has the wrong number of edges", edges, d.numEdges());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumEdgesDeleteTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.addNode(1, "b");
            d.addEdge(0, "a", "b", 1, null);
            d.addEdge(1, "b", "a", 1, null);
            d.delEdge("a", "b");
            d.delEdge("b", "a");
            assertEquals("Emptied of edges Graph has edges", 0, d.numEdges());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumEdgesManyDeleteTest() {
        DiGraph d = new DiGraph();
        String s1, s2, s3;
        String[] source = new String[2 * NUM_NODES], dest = new String[2 * NUM_NODES];
        d.addNode(0, s1 = "a");
        d.addNode(1, s2 = "b");
        d.addNode(2, s3 = "c");
        d.addEdge(0, s1, s2, 1, "a");
        source[0] = s1;
        dest[0] = s2;
        d.addEdge(1, s1, s3, 1, "a");
        source[1] = s1;
        dest[1] = s3;
        d.addEdge(2, s2, s3, 1, "a");
        source[2] = s2;
        dest[2] = s3;
        for (int i = 3; i < NUM_NODES; i++) {
            d.addNode(i, s1 += "a");
            d.addEdge(i, s2, s1, 1, "a");
            source[i] = s2;
            dest[i] = s1;
            d.addEdge(i * 2, s3, s1, 1, "a");
            source[i * 2] = s3;
            dest[i * 2] = s1;

            s2 = s3;
            s3 = s1;
        }
        for (int i = 0; i < source.length; i++) {
            if (source[i] != null && dest[i] != null)
                d.delEdge(source[i], dest[i]);
        }
        assertEquals("Emptied of edges Graph has edges", 0, d.numEdges());
    }

    @Test
    public void NumNodesNoneTest() {
        try {
            DiGraph d = new DiGraph();
            assertEquals("New Graph has nodes", 0, d.numNodes());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumNodesSingleTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            assertEquals("Graph of 1 node has the wrong number of nodes", 1, d.numNodes());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumNodesManyTest() {
        try {
            DiGraph d = new DiGraph();
            String s = "";
            for (int i = 0; i < NUM_NODES; i++) {
                d.addNode(i, s += "a");
            }
            assertEquals("Graph of " + NUM_NODES + " has the wrong number of nodes", NUM_NODES, d.numNodes());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumNodesDeleteTest() {
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.delNode("a");
            assertEquals("Empty Graph has nodes", 0, d.numNodes());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void NumNodesManyDeleteTest() {
        try {
            DiGraph d = new DiGraph();
            String s = "";
            String[] l = new String[NUM_NODES];
            for (int i = 0; i < NUM_NODES; i++) {
                d.addNode(i, s += "a");
                l[i] = s;
            }
            for (String lab : l) {
                d.delNode(lab);
            }
            assertEquals("Empty Graph has nodes", 0, d.numNodes());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void TopoSortUniqueTest() {
        // This graph has a single, unique topo sort
        // a --> b --> c --> d
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.addNode(1, "b");
            d.addEdge(0, "a", "b", 1, null);
            d.addNode(2, "c");
            d.addEdge(1, "b", "c", 1, null);
            d.addNode(3, "d");
            d.addEdge(2, "c", "d", 1, null);
            String[] sort = new String[] { "a", "b", "c", "d" };
            assertTrue("Incorrect topo sort", sortEquals(d.topoSort(), sort));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    public void TopoSortNonUniqueTest() {
        // This graph has two topo sorts
        // a --> b --> c --> d
        // b --> e --> d
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.addNode(1, "b");
            d.addEdge(0, "a", "b", 1, null);
            d.addNode(2, "c");
            d.addEdge(1, "b", "c", 1, null);
            d.addNode(3, "d");
            d.addEdge(2, "c", "d", 1, null);
            d.addNode(4, "e");
            d.addEdge(3, "b", "e", 1, null);
            d.addEdge(4, "e", "d", 1, null);
            String[] sort = new String[] { "a", "b", "c", "e", "d" };
            String[] sort2 = new String[] { "a", "b", "e", "c", "d" };
            String[] topo = d.topoSort();
            assertTrue("Incorrect topo sort", sortEquals(topo, sort) || sortEquals(topo, sort2));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void TopoSortCyclicTest() {
        // This graph has a cycle
        // a --> b --> c --> d
        // c --> a
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.addNode(1, "b");
            d.addEdge(0, "a", "b", 1, null);
            d.addNode(2, "c");
            d.addEdge(1, "b", "c", 1, null);
            d.addNode(3, "d");
            d.addEdge(2, "c", "d", 1, null);
            d.addEdge(3, "c", "a", 1, null);
            assertTrue("Topo Sort on cycle didn't return null", d.topoSort() == null);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void TopoSortDisconnectedTest() {
        // This graph is disconnected and thus has several possible solutions
        // a --> b
        // c --> d
        try {
            DiGraph d = new DiGraph();
            d.addNode(0, "a");
            d.addNode(1, "b");
            d.addEdge(0, "a", "b", 1, null);
            d.addNode(2, "c");
            d.addNode(3, "d");
            d.addEdge(2, "c", "d", 1, null);
            String[][] sorts = new String[][] {
                {"a", "b", "c", "d"},
                {"a", "c", "b", "d"},
                {"a", "c", "d", "b"},
                {"c", "a", "b", "d"},
                {"c", "a", "d", "b"},
                {"c", "d", "a", "b"},
            };
            String[] topo = d.topoSort();
            boolean result = false;
            for (String[] sort : sorts) {
                result |= sortEquals(topo,sort);
            }
            assertTrue("Disconnected Graph produced invalid topo sort", result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    private static boolean sortEquals(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || b[i] == null)
                return false;
            if (!a.equals(b))
                return false;
        }
        return true;
    }
}
