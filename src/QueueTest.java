import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueTest {
    @Test
    public void testDequeue()
    {
        // Arrange
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        // Act
        int data = queue.dequeue();
        // Assert
        assertEquals(data, 1);
    }

    @Test
    public void testEnqueue()
    {
        // Arrange
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        // Act
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        // Assert
        int data = queue.first();
        assertEquals(data, 1);
        assertEquals(queue.size(), 3);
    }

    @Test
    public void testDequeueIsEmpty()
    {
        // Arrange
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        // Act
        EmptyCollectionException thrown = assertThrows(EmptyCollectionException.class, () -> queue.dequeue());
        // Assert
        assertEquals("Queue is empty", thrown.getMessage());
        assertTrue("Expected queue to be empty", queue.isEmpty());
        assertEquals(queue.size(), 0);
    }
}
