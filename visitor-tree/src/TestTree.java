import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestTree {

	private static Tree tree;
	
	@BeforeAll
	static void setupTests()
	{
		tree = new Tree(50);
		
		tree.add(25);
		tree.add(75);
		tree.add(15);
		tree.add(90);
		tree.add(100);
		
		tree.add("Apple");
		tree.add("Montana");
		tree.add("City");
		tree.add("Egypt");
		tree.add("Zebra");
	}
	
	@Test
	void testSearchString() throws Exception {
		String treeApple = tree.search("Apple");
		
		assertEquals(treeApple,"Apple");
		
	}
	
	@Test
	void testSearchStringDoesNotExist() {
		
		Exception thrown = Assertions.assertThrows(Exception.class, () -> {
			String treeApple = tree.search("NOT IN TREE");
		});
		
		assertEquals(thrown.getMessage(),"No such string in tree");
	}
	
	@Test
	void testSearchIntDoesNotExist() {
		
		Exception thrown = Assertions.assertThrows(Exception.class, () -> {
			String treeApple = tree.search("NOT IN TREE");
		});
		
		assertEquals(thrown.getMessage(),"No such string in tree");
	}

}
