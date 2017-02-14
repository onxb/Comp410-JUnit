package BST_A2;

import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTests {

    static final int MAX = 200;

    @Test
    public void testBST() {
	try {
	    BST b = new BST();
	    assertTrue("Constructor did not establish required semantics",
		    b.empty() && b.size() == 0 && b.getRoot() == null);
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testGetRootEasy() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    assertTrue("getRoot returned wrong value", s.equals(b.getRoot().getData()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testGetRootMedium() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    b.insert("Other world (after)...");
	    assertTrue("getRoot returned wrong value", s.equals(b.getRoot().getData()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testGetRootMediumPlus() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    b.insert("Before world...");
	    assertTrue("getRoot returned wrong value", s.equals(b.getRoot().getData()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testGetRootChallenge() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    b.insert("Other world (after)...");
	    b.insert("Before world...");
	    assertTrue("getRoot returned wrong value", s.equals(b.getRoot().getData()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testInsertEasy() {
	try {
	    BST b = new BST();
	    int size = b.size();
	    assertTrue("Legal first insert failed", b.insert("Hello World!") && size + 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testInsertMedium() {
	try {
	    BST b = new BST();
	    b.insert("Mario World!");
	    int size = b.size();
	    assertTrue("Legal insert failed", b.insert("Hello World!") && size + 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testInsertMediumPlus() {
	try {
	    BST b = new BST();
	    b.insert("Super Mario World!");
	    int size = b.size();
	    assertFalse("Illegal insert returned true", b.insert("Super Mario World!") && size + 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testInsertHard() {
	try {
	    BST b = new BST();
	    for (int i = 0; i < MAX; i++) {
		String next;
		while ((next = MyRandom.nextString()).equals("Hello World!")) {
		}
		b.insert(next);
	    }
	    int size = b.size();
	    assertTrue("Legal first insert failed", b.insert("Hello World!") && size + 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testRemoveEasy() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert("Hello World!");
	    b.insert("Yoshi's World");
	    b.insert(s = "a Mario's World");
	    int size = b.size();
	    assertTrue("Removing node with no children failed", b.remove(s) && size - 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testRemoveMedium() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert("Hello World!");
	    b.insert(s = "Yoshi's World");
	    b.insert("Mario's World");
	    int size = b.size();
	    assertTrue("Removing node with one child failed", b.remove(s) && size - 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testRemoveHard() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert("Hello World!");
	    b.insert(s = "Yoshi's World");
	    b.insert("Mario's World");
	    b.insert("Zuigi's World");
	    int size = b.size();
	    assertTrue("Removing node with two children failed", b.remove(s) && size - 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testRemoveChallenge() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    int size = b.size();
	    assertTrue("Removing root with no children failed", b.remove(s) && size - 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testRemoveChallengePlus() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    b.insert("Yoshi's World");
	    b.insert("a Mario's World");
	    int size = b.size();
	    assertTrue("Removing root with two children failed", b.remove(s) && size - 1 == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testRemoveFalseEasy() {
	try {
	    BST b = new BST();
	    int size = b.size();
	    assertFalse("Removing node in empty tree succeeded", b.remove("any string") && size == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testRemoveFalseMedium() {
	try {
	    BST b = new BST();
	    b.insert("Hello World!");
	    b.insert("Yoshi's World");
	    b.insert("a Mario's World");
	    int size = b.size();
	    assertFalse("Removing nonexistent node in tree succeeded", b.remove("any string") && size == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testRemoveFalseHard() {
	try {
	    BST b = new BST();
	    String s = MyRandom.nextString();
	    System.out.println(s);
	    for (int i = 0; i < MAX; i++) {
		String next;
		while ((next = MyRandom.nextString()).equals(s)) {
		}
		b.insert(next);
	    }
	    int size = b.size();
	    assertFalse("Removing nonexistent node in tree succeeded", b.remove(s) && size == b.size());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testFindMinEasy() {
	try {
	    BST b = new BST();
	    assertTrue("Empty tree returned non-null min value", b.findMin() == null);
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testFindMinMedium() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    assertTrue("Min incorrect", s.equals(b.findMin()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testFindMinHard() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    b.insert("Yoshi's World!");
	    b.insert("Mario's World!");
	    assertTrue("Min incorrect", s.equals(b.findMin()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testFindMinChallenge() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert("Hello World!");
	    b.insert("Yoshi's World!");
	    b.insert("Mario's World!");
	    b.insert(s = "A Toad's World!");
	    assertTrue("Min incorrect", s.equals(b.findMin()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testFindMaxEasy() {
	try {
	    BST b = new BST();
	    assertTrue("Empty tree returned non-null max value", b.findMax() == null);
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testFindMaxMedium() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert(s = "Hello World!");
	    assertTrue("Max incorrect", s.equals(b.findMax()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testFindMaxHard() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert("Hello World!");
	    b.insert(s = "Yoshi's World!");
	    b.insert("Mario's World!");
	    assertTrue("Max incorrect", s.equals(b.findMax()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testFindMaxChallenge() {
	try {
	    BST b = new BST();
	    String s;
	    b.insert("Hello World!");
	    b.insert("Yoshi's World!");
	    b.insert("Mario's World!");
	    b.insert("A Toad's World!");
	    b.insert(s = "Zuigi's World!");
	    assertTrue("Max incorrect", s.equals(b.findMax()));
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testEmptyEasy() {
	try {
	    BST b = new BST();
	    assertTrue("Empty tree reports not empty", b.empty());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testEmptyMedium() {
	try {
	    BST b = new BST();
	    b.insert("Hello World!");
	    assertTrue("Non-empty tree reports empty", !b.empty());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testEmptyHard() {
	try {
	    BST b = new BST();
	    b.insert("Hello World!");
	    b.remove("Hello World!");
	    assertTrue("Empty tree reports not empty", b.empty());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testEmptyChallenge() {
	try {
	    BST b = new BST();
	    b.insert("Hello World!");
	    b.insert("Mario World!");
	    b.remove("Hello World!");
	    assertTrue("Non-empty tree reports empty", !b.empty());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testEmptyChallengePlus() {
	try {
	    BST b = new BST();
	    b.insert("Hello World!");
	    b.insert("Mario World!");
	    b.remove("Hello World!");
	    b.remove("Mario World!");
	    b.insert("It's a whole new world!");
	    assertTrue("Non-empty tree reports empty", !b.empty());
	} catch (Exception e) {
	    fail("Exception thrown");
	}
    }

    @Test
    public void testContains() {
	fail("Not yet implemented");
    }

    @Test
    public void testSize() {
	fail("Not yet implemented");
    }

    @Test
    public void testHeight() {
	fail("Not yet implemented");
    }

}
