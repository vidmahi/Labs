import junit.framework.*; 
import java.util.*;

public class Lab9Tester extends TestCase
{
	
	public void testAddAndSize()
	{
		MyList list = new ImprovedArrayList();
		
		assertEquals("new list is not empty", 0, list.size());
		
		list.add("first");
		assertEquals("size does not increase when object is added", 1, list.size());
		
		list.add("second");
		list.add("third");
		assertEquals("size does not increase correctly when multiple objects are added", 3, list.size());
	}
	
	public void testGet()
	{
		MyList list = new ImprovedArrayList();
		
		list.add("first");		
		list.add("second");
		list.add("third");
		
		Object obj = list.get(0);
		assertNotNull("get(first index) returned value is null", obj);
		assertEquals("Incorrect value returned from get(first index)", "first", obj);
		assertEquals("size should not change when get(first index) is called", 3, list.size());
		
		obj = list.get(2);
		assertNotNull("get(last index) returned value is null", obj);
		assertEquals("Incorrect value returned from get(last index)", "third", obj);
		assertEquals("size should not change when get(last index) is called", 3, list.size());
		
		obj = list.get(1);
		assertNotNull("get(middle index) returned value is null", obj);
		assertEquals("Incorrect value returned from get(middle index)", "second", obj);
		assertEquals("size should not change when get(middle index) is called", 3, list.size());
		
		obj = list.get(-1);
		assertNull("get(negative index) returned value is not null", obj);
		assertEquals("size should not change when get(negative index) is called", 3, list.size());
		
		obj = list.get(3);
		assertNull("get(too big index) returned value is not null", obj);
		assertEquals("size should not change when get(too big index) is called", 3, list.size());
		
		obj = list.get(7);
		assertNull("get(too big index) returned value is not null", obj);
		assertEquals("size should not change when get(too big index) is called", 3, list.size());
	}
	
	public void testInsertFirst()
	{
		MyList list = new ImprovedArrayList();
		
		list.add("first");		
		list.add("second");
		list.add("third");
		
		list.add(0, "insert");
		
		assertEquals("size does not increase when inserting an object", 4, list.size());
		
		Object obj = list.get(0);
		assertNotNull("Value at index 0 is null", obj);
		assertEquals("Incorrect value inserted at index 0", "insert", obj);
	}
	
	public void testRemoveFirst()
	{
		MyList list = new ImprovedArrayList();		
		list.add("first");		
		list.add("second");
		list.add("third");
		
		Object obj = list.remove(0);
	
		assertNotNull("remove(0) returned null, but should have returned an object", obj);
		assertEquals("The size of list did not change after calling remove()", 2, list.size());
		assertEquals("remove(0) did not return the correct value", "first", obj);
	}
	
	public void testRemoveLast()
	{
		MyList list = new ImprovedArrayList();		
		list.add("first");		
		list.add("second");
		list.add("third");
		
		Object obj = list.remove(2);
	
		assertNotNull("remove(last index) returned null, but should have returned an object", obj);
		assertEquals("The size of list did not change after calling remove()", 2, list.size());
		assertEquals("remove(last index) did not return the correct value", "third", obj);
	}
	
	public void testRemoveMiddle()
	{
		MyList list = new ImprovedArrayList();		
		list.add("first");		
		list.add("second");
		list.add("third");
		
		Object obj = list.remove(1);
	
		assertNotNull("remove(middle index) returned null, but should have returned an object", obj);
		assertEquals("The size of list did not change after calling remove()", 2, list.size());
		assertEquals("remove(middle index) did not return the correct value", "second", obj);
	}
	
	public void testRemoveNegative()
	{
		MyList list = new ImprovedArrayList();		
		list.add("first");		
		list.add("second");
		list.add("third");
		
		Object obj = list.remove(-1);
	
		assertNull("remove(index < 0) did not return null", obj);
		assertEquals("The size of list changed after calling remove(index < 0)", 3, list.size());
	}
	
	public void testRemoveTooBig()
	{
		MyList list = new ImprovedArrayList();		
		list.add("first");		
		list.add("second");
		list.add("third");
		
		Object obj = list.remove(3);
	
		assertNull("remove(index > size) did not return null", obj);
		assertEquals("The size of list changed after calling remove(index > size)", 3, list.size());
		
		obj = list.remove(7);
	
		assertNull("remove(index > size) did not return null", obj);
		assertEquals("The size of list changed after calling remove(index > size)", 3, list.size());
	}
	
	public void testIsEmpty()
	{
		MyList list = new ImprovedArrayList();		
			
		assertTrue("new list should be empty before adding any elements", list.isEmpty());
		
		list.add("first");		
		assertFalse("list should not be empty after adding an object to it", list.isEmpty());
		
		list.add("second");
		list.add("third");
		assertFalse("list should not be empty after adding an object to it", list.isEmpty());
		
		list.remove(0);
		list.remove(0);
		list.remove(0);
		assertTrue("new list should be empty after removing all elements", list.isEmpty());
		
	}
	
	public void testContains()
	{
		MyList list = new ImprovedArrayList();		
			
		list.add("first");		
		list.add("second");
		list.add("third");
		
		assertTrue("Did not detect first element", list.contains("first"));
		assertTrue("Did not detect middle element", list.contains("second"));
		assertTrue("Did not detect last element", list.contains("third"));
		assertFalse("Did not correctly detect element that isn't in list", list.contains("first one"));
		
		list.add("third");
		assertTrue("Did not detect duplicated element", list.contains("third"));
	}
	
	public void testRemoveObject()
	{
		MyList list = new ImprovedArrayList();		
			
		list.add("first");		
		list.add("second");
		list.add("third");
		
		assertTrue("Did not remove first element", list.remove("first"));
		assertEquals("size did not change after remove", 2, list.size());
		list.add(0, "first");
		
		assertTrue("Did not remove middle element", list.remove("second"));
		assertEquals("size did not change after remove", 2, list.size());
		list.add(1, "second");
		
		assertTrue("Did not remove first element", list.remove("third"));
		assertEquals("size did not change after remove", 2, list.size());
		list.add(2, "third");
		
		assertFalse("Somehow removed element that is not in list", list.remove("spoon"));
		assertEquals("size changed after invalid remove", 3, list.size());
		
		list.add(0, "third");
		assertTrue("Did not remove a duplicated object", list.remove("third"));
		assertEquals("size did not change after remove", 3, list.size());
		assertEquals("Did not remove FIRST OCCURENCE of duplciated object", "first", list.get(0));
	}
	
	public void testSet()
	{
		MyList list = new ImprovedArrayList();		
			
		list.add("first");		
		list.add("second");
		list.add("third");
		
		Object obj = list.set(0, "new first");
		assertEquals("List size changed after call to set(0)", 3, list.size());
		assertEquals("value not changed after call to set(0)", "new first", list.get(0));
		assertEquals("incorrect value returned from set(0) method", "first", obj);
		
		obj = list.set(1, "new second");
		assertEquals("List size changed after call to set(middle index)", 3, list.size());
		assertEquals("value not changed after call to set(middle index)", "new second", list.get(1));
		assertEquals("incorrect value returned from set(middle index) method", "second", obj);
		
		obj = list.set(2, "new third");
		assertEquals("List size changed after call to set(last index)", 3, list.size());
		assertEquals("value not changed after call to set(last index)", "new third", list.get(2));
		assertEquals("incorrect value returned from set(last index) method", "third", obj);
		
		obj = list.set(-1, "too small");
		assertEquals("List size changed after call to set(negative index)", 3, list.size());
		assertNull("set(negative index) did not return null", obj);
		assertEquals("set(negative index) should not change any values", "new first", list.get(0));
		assertEquals("set(negative index) should not change any values", "new second", list.get(1));
		assertEquals("set(negative index) should not change any values", "new third", list.get(2));
		
		obj = list.set(3, "too big");
		assertEquals("List size changed after call to set(too big index)", 3, list.size());
		assertNull("set(too big index) did not return null", obj);
		assertEquals("set(too big index) should not change any values", "new first", list.get(0));
		assertEquals("set(too big index) should not change any values", "new second", list.get(1));
		assertEquals("set(too big index) should not change any values", "new third", list.get(2));
		
		obj = list.set(7, "too big");
		assertEquals("List size changed after call to set(too big index)", 3, list.size());
		assertNull("set(too big index) did not return null", obj);
		assertEquals("set(too big index) should not change any values", "new first", list.get(0));
		assertEquals("set(too big index) should not change any values", "new second", list.get(1));
		assertEquals("set(too big index) should not change any values", "new third", list.get(2));
	}
	
	public void testRandomValues()
	{
		MyList list = new ImprovedArrayList();		
			
		String letters = "abcdefghijklmnopqrstuvwxyz0123456789";
		
		String word1 = "";
		String word2 = "";
		String word3 = "";
		String word4 = "";
		for(int i=0; i < 50; i++)
		{
			int r = (int)(Math.random() * letters.length());
			word1 += letters.substring(r, r+1);
			
			r = (int)(Math.random() * letters.length());
			word2 += letters.substring(r, r+1);
			
			r = (int)(Math.random() * letters.length());
			word3 += letters.substring(r, r+1);
			
			r = (int)(Math.random() * letters.length());
			word4 += letters.substring(r, r+1);
		}
		
		list.add(word1);
		list.add(word2);
		list.add(word3);
		list.add(word4);
		
		assertEquals("size() is not correct", 4, list.size());
		assertEquals("get(first index) did not return correct value", word1, list.get(0));
		assertEquals("get(middle index) did not return correct value", word2, list.get(1));
		assertEquals("get(last index) did not return correct value", word4, list.get(3));
		assertNull("get(too big) did not return correct value", list.get(4));
	}
	
	public void testNewConstructor()
	{
		MyList list = new ImprovedArrayList(3);		
			
		assertEquals("The size should be 0 before anything is added to the list", 0, list.size());
		
		list.add("first");
		list.add("second");
		list.add("third");
		
		assertEquals("The size should be 3 after adding 3 elements", 3, list.size());
		
		list.add("fourth");
		
		assertEquals("The size should be 4 after adding 4 elements", 4, list.size());
	}
}