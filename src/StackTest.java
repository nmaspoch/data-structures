import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackTest {
    @Test
    public void testPush() {
        // Arrange
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        // Act
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Assert
        assertEquals("Expected stack to have 3 items", stack.size(), 3);
    }

    @Test
    public void testPop() {
        // Arrange
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Act
        int value = stack.pop();
        // Assert
        assertEquals("Expected a value of 3", value, 3);
    }

    @Test
    public void testPopEmpty() {
        // Arrange
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        // Act
        EmptyCollectionException thrown = assertThrows(EmptyCollectionException.class, () -> stack.pop());
        // Assert
        assertEquals("Stack is empty", thrown.getMessage());
        assertTrue("Expected stack to be empty", stack.isEmpty());
    }
    @Test
    public void testPeek()
    {
        // Arrange
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // Act
        int value = stack.peek();
        // Assert
        assertEquals("Expected a value of 3", value, 3);
        assertEquals(3, stack.size());
    }
}
