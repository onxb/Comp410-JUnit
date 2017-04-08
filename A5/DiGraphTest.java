package DiGraph_A5;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiGraphTest {

    @Test
    public void DiGraph() {
        try {
            new DiGraph();
        } catch (Exception e) {
            fail("Exception throw " + e.getMessage());
        }
    }

}
