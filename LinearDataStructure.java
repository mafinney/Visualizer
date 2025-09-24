/**
 * An interface for linear data structures.
 * Linear data structures are data structures with set rules on insertion and removal location
 * ex. stacks, queues
 * This is seperate from data structures like graphs or trees where the client can specify where 
 * a value is added or removed
 */

public interface LinearDataStructure {
    public static final int X = 50;
    public static final int Y = 50;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 30;
    /**
     * Adds a node to the data structure
     * @param str the value of the node to be added
     */
    public void push(String str);

    /**
     * Removes a node from the data structure
     */
    public void pop();

    /**
     * Removes all nodes from the data structure
     */
    public void clear();
}