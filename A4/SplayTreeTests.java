package SPLT_A4;

import static org.junit.Assert.*;
import org.junit.Test;

public class SplayTreeTests {
    
    @Test
    public void treeEqualsValidation() {
        BST_Node expected = new BST_Node("a"), tree = new BST_Node("a");
        tree.left = new BST_Node("b", null, null, tree);
        tree.right = new BST_Node("c", null, null, tree);
        tree.left.left = new BST_Node("d", null, null, tree.left);
        tree.left.right = new BST_Node("e", null, null, tree.left);
        tree.right.left = new BST_Node("f", null, null, tree.right);
        tree.right.right = new BST_Node("g", null, null, tree.right);
        
        expected.left = new BST_Node("b", null, null, expected);
        expected.right = new BST_Node("c", null, null, expected);
        expected.left.left = new BST_Node("d", null, null, expected.left);
        expected.left.right = new BST_Node("e", null, null, expected.left);
        expected.right.left = new BST_Node("f", null, null, expected.right);
        expected.right.right = new BST_Node("g", null, null, expected.right);
        assertTrue("Should pass if the `treeEquals` method works", treeEquals(tree, expected));
        
        expected.right.right = new BST_Node("h", null, null, expected.right);
        assertFalse("Should pass if the `treeEquals` method works", treeEquals(tree, expected));
    }

    @Test
    public void testFindMin() {
        try {
            SPLT tree = new SPLT();

            tree.insert("gg");
            tree.insert("dd");
            tree.insert("ss");
            tree.insert("ee");
            tree.insert("cc");
            tree.insert("zz");
            tree.insert("gg");
            tree.insert("bb");
            tree.insert("ff");
            tree.insert("aa");
            
            BST_Node expected = new BST_Node("aa", null, null, null);
            BST_Node bb,ff,cc,dd,zz,ss;
            expected.right = bb = new BST_Node("bb", null, null, expected);
            bb.right = ff = new BST_Node("ff", null, null, bb);
            ff.left = cc = new BST_Node("cc", null, null, ff);
            cc.right = dd = new BST_Node("dd", null, null, cc);
            dd.right = new BST_Node("ee", null, null, dd);
            ff.right = zz = new BST_Node("zz", null, null, ff);
            zz.left = ss = new BST_Node("ss", null, null, zz);
            ss.left = new BST_Node("gg", null, null, ss);

            assertEquals("findMin returns wrong node", "aa", tree.findMin());
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testFindMax() {
        try {
            SPLT tree = new SPLT();

            tree.insert("gg");
            tree.insert("dd");
            tree.insert("ss");
            tree.insert("ee");
            tree.insert("cc");
            tree.insert("zz");
            tree.insert("gg");
            tree.insert("bb");
            tree.insert("ff");
            tree.insert("aa");
            
            BST_Node expected = new BST_Node("zz", null, null, null);
            BST_Node bb,ff,cc,dd,aa,ss;
            expected.left = aa = new BST_Node("aa", null, null, expected);
            aa.right = ff = new BST_Node("ff", null, null, aa);
            ff.left = bb = new BST_Node("bb", null, null, ff);
            bb.right = cc = new BST_Node("cc", null, null, bb);
            cc.right = dd = new BST_Node("dd", null, null, cc);
            dd.right = new BST_Node("ee", null, null, dd);
            ff.right = ss = new BST_Node("ss", null, null, ff);
            ss.left = new BST_Node("gg", null, null, ss);

            assertEquals("findMax returns wrong node", "zz", tree.findMax());
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testContainsTrue() {
        try {
            SPLT tree = new SPLT();

            tree.insert("gg");
            tree.insert("dd");
            tree.insert("ss");
            tree.insert("ee");
            tree.insert("cc");
            tree.insert("zz");
            tree.insert("gg");
            tree.insert("bb");
            tree.insert("ff");
            tree.insert("aa");
            
            BST_Node expected = new BST_Node("cc");
            BST_Node aa,ff,dd,zz,ss;
            expected.left = aa = new BST_Node("aa", null, null, expected);
            aa.right = new BST_Node("bb", null, null, aa);
            expected.right = ff = new BST_Node("ff", null, null, expected);
            ff.left = dd = new BST_Node("dd", null, null, ff);
            dd.right = new BST_Node("ee", null, null, dd);
            ff.right = zz = new BST_Node("zz", null, null, ff);
            zz.left = ss = new BST_Node("ss", null, null, zz);
            ss.left = new BST_Node("gg", null, null, ss);

            assertTrue("contains returns false", tree.contains("cc"));
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testContainsFalse() {
        try {
            SPLT tree = new SPLT();

            tree.insert("gg");
            tree.insert("dd");
            tree.insert("ss");
            tree.insert("ee");
            tree.insert("cc");
            tree.insert("zz");
            tree.insert("gg");
            tree.insert("bb");
            tree.insert("ff");
            tree.insert("aa");
            
            BST_Node expected = new BST_Node("bb", null, null, null);
            BST_Node ff,cc,dd,zz,ss;
            expected.left = new BST_Node("bb", null, null, expected);
            expected.right = ff = new BST_Node("ff", null, null, expected);
            ff.left = cc = new BST_Node("cc", null, null, ff);
            cc.right = dd = new BST_Node("dd", null, null, cc);
            dd.right = new BST_Node("ee", null, null, dd);
            ff.right = zz = new BST_Node("zz", null, null, ff);
            zz.left = ss = new BST_Node("ss", null, null, zz);
            ss.left = new BST_Node("gg", null, null, ss);

            assertFalse("contains returns true", tree.contains("ad"));
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testEmptyTrue() {
        try {
            SPLT tree = new SPLT();

            assertTrue("empty returns false", tree.empty());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testEmptyFalse() {
        try {
            SPLT tree = new SPLT();

            tree.insert("h");

            assertFalse("empty returns true", tree.empty());
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHeightInsertOnly() {
        try {
            SPLT tree = new SPLT();

            tree.insert("a");
            tree.insert("d");
            tree.insert("s");
            tree.insert("e");
            tree.insert("c");
            tree.insert("g");
            tree.insert("b");
            tree.insert("f");

            BST_Node expected = new BST_Node("f");
            BST_Node b,e,c,g;
            expected.left = b = new BST_Node("b", null, null, expected);
            b.left = new BST_Node("a", null, null, b);
            b.right = e = new BST_Node("e", null, null, b);
            e.left = c = new BST_Node("c", null, null, e);
            c.right = new BST_Node("d", null, null, c);
            expected.right = g = new BST_Node("g", null, null, expected);
            g.right = new BST_Node("s", null, null, expected);
            
            assertEquals("height returned wrong height", 4, tree.height());
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHeightRemoveRoot() {
        try {
            SPLT tree = new SPLT();

            tree.insert("a");
            tree.insert("d");
            tree.insert("s");
            tree.insert("e");
            tree.insert("c");
            tree.insert("g");
            tree.insert("b");
            tree.insert("f");
            tree.remove("f");
            
            BST_Node expected = new BST_Node("e");
            BST_Node b,c,g;
            expected.left = b = new BST_Node("b", null, null, expected);
            b.left = new BST_Node("a", null, null, b);
            b.right = c = new BST_Node("c", null, null, b);
            c.right = new BST_Node("d", null, null, c);
            expected.right = g = new BST_Node("g", null, null, expected);
            g.right = new BST_Node("s", null, null, expected);

            assertEquals("height returned wrong height", 3, tree.height());
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHeightRemoveOneChild() {
        try {
            SPLT tree = new SPLT();

            tree.insert("a");
            tree.insert("d");
            tree.insert("s");
            tree.insert("e");
            tree.insert("c");
            tree.insert("g");
            tree.insert("b");
            tree.insert("f");
            tree.remove("g");
            
            BST_Node expected = new BST_Node("f");
            BST_Node b,e,c;
            expected.left = b = new BST_Node("b", null, null, expected);
            b.left = new BST_Node("a", null, null, b);
            b.right = e = new BST_Node("e", null, null, b);
            e.left = c = new BST_Node("c", null, null, e);
            c.right = new BST_Node("d", null, null, c);
            expected.right = new BST_Node("s", null, null, expected);

            assertEquals("height returned wrong height", 4, tree.height());
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testSizeInsertOnly() {
        try {
            SPLT tree = new SPLT();

            tree.insert("a");
            tree.insert("d");
            tree.insert("s");
            tree.insert("e");
            tree.insert("c");
            tree.insert("g");
            tree.insert("b");
            tree.insert("f");
            
            BST_Node expected = new BST_Node("f");
            BST_Node b,e,c,g;
            expected.left = b = new BST_Node("b", null, null, expected);
            b.left = new BST_Node("a", null, null, b);
            b.right = e = new BST_Node("e", null, null, b);
            e.left = c = new BST_Node("c", null, null, e);
            c.right = new BST_Node("d", null, null, c);
            expected.right = g = new BST_Node("g", null, null, expected);
            g.right = new BST_Node("s", null, null, expected);

            assertEquals("size returned wrong size", 8, tree.size());
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testSizeRemove() {
        try {
            SPLT tree = new SPLT();

            tree.insert("a");
            tree.insert("d");
            tree.insert("s");
            tree.insert("e");
            tree.insert("c");
            tree.insert("g");
            tree.insert("b");
            tree.insert("f");
            tree.remove("g");
            
            BST_Node expected = new BST_Node("f");
            BST_Node b,e,c;
            expected.left = b = new BST_Node("b", null, null, expected);
            b.left = new BST_Node("a", null, null, b);
            b.right = e = new BST_Node("e", null, null, b);
            e.left = c = new BST_Node("c", null, null, e);
            c.right = new BST_Node("d", null, null, c);
            expected.right = new BST_Node("s", null, null, expected);

            assertEquals("size returned wrong size", 7, tree.size());
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testInsert() {
        try {
            SPLT tree = new SPLT();

            tree.insert("a");
            tree.insert("d");
            tree.insert("c");
            tree.insert("s");
            tree.insert("e");
            tree.insert("c");
            tree.insert("g");
            tree.insert("b");
            tree.insert("f");
            
            BST_Node expected = new BST_Node("f");
            BST_Node b,e,d,g;
            expected.left = b = new BST_Node("b", null, null, expected);
            b.left = new BST_Node("a", null, null, b);
            b.right = e = new BST_Node("e", null, null, b);
            e.left = d = new BST_Node("d", null, null, e);
            d.left = new BST_Node("c", null, null, d);
            expected.right = g = new BST_Node("g", null, null, expected);
            g.right = new BST_Node("s", null, null, expected);

            assertEquals("inserted wrong node into spot", "s", tree.root.right.right.getData());
            assertEquals("inserted wrong node into spot", "g", tree.root.right.getData());
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveOneChild() {
        try {
            SPLT tree = new SPLT();

            tree.insert("a");
            tree.insert("d");
            tree.insert("s");
            tree.insert("e");
            tree.insert("c");
            tree.insert("g");
            tree.insert("b");
            tree.insert("f");
            tree.remove("e");
            
            BST_Node expected = new BST_Node("d");
            BST_Node c,b,f,g;
            expected.left = c = new BST_Node("c", null, null, expected);
            c.left = b = new BST_Node("b", null, null, c);
            b.left = new BST_Node("a", null, null, b);
            expected.right = f = new BST_Node("f", null, null, expected);
            f.right = g = new BST_Node("g", null, null, f);
            g.right = new BST_Node("s", null, null, g);
            
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    public void testRemoveTwoChildren() {
        try {
            SPLT tree = new SPLT();

            tree.insert("a");
            tree.insert("d");
            tree.insert("s");
            tree.insert("e");
            tree.insert("c");
            tree.insert("g");
            tree.insert("b");
            tree.insert("f");
            tree.insert("w");
            tree.insert("z");
            tree.insert("y");
            tree.insert("u");
            tree.remove("b");
            
            BST_Node expected = new BST_Node("a");
            BST_Node u,f,e,c,s,w,y;
            expected.right = u = new BST_Node("u", null, null, expected);
            u.left = f = new BST_Node("f", null, null, u);
            f.left = e = new BST_Node("e", null, null, f);
            e.left = c = new BST_Node("c", null, null, e);
            c.right = new BST_Node("d", null, null, c);
            f.right = s = new BST_Node("s", null, null, f);
            s.left = new BST_Node("g", null, null, s);
            u.right = w = new BST_Node("w", null, null, u);
            w.right = y = new BST_Node("y", null, null, w);
            y.right = new BST_Node("z");
            
            assertTrue("tree not splayed correctly", treeEquals(tree.getRoot(), expected));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    public boolean treeEquals(BST_Node a, BST_Node b) {
        if (a.getHeight() != b.getHeight())
            return false;
        if (a.par != b.par)
            return false;
        if (!a.getData().equals(b.getData()))
            return false;
        boolean left, right;
        if (a.left == null)
            left = b.left == null;
        else
            left = treeEquals(a.left, b.left);
        if (a.right == null)
            right = b.right == null;
        else
            right = treeEquals(a.right, b.right);
        return left && right;
    }
}
