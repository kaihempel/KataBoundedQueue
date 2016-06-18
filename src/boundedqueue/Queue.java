package boundedqueue;

import java.util.ArrayList;

/**
 * Queue class
 *
 * @author Kai Hempel
 * @param <E>
 */
public class Queue<E> {

    private int maxSize = 0;
    private final ArrayList<E> itemList;
    private final ArrayList<E> blockedItems;

    /**
     * Constructor
     *
     * @param size
     */
    Queue(int size) {
        this.maxSize        = size;
        this.itemList       = new ArrayList<>();
        this.blockedItems   = new ArrayList<>();
    }

    /**
     * Returns the max queue size
     *
     * @return The number of max items
     */
    public int getSize() {
        return this.maxSize;
    }

    /**
     * Returns the current item count
     *
     * @return The queue item count
     */
    public int getCount() {
        return this.itemList.size();
    }

    /**
     * Sets the item in the queue
     *
     * @param item
     */
    public void enqueue(E item) {
        if (this.itemList.size() < this.maxSize) {
            this.itemList.add(item);

        } else {
            this.blockedItems.add(item);
        }
    }

    /**
     * Returns the first item of the queue and removes it.
     *
     * @return First item of the queue
     */
    public E dequeue() {
        E item = this.itemList.get(0);
        this.itemList.remove(0);

        if (this.blockedItems.size() > 0) {
            this.itemList.add(this.blockedItems.get(0));
            this.blockedItems.remove(0);
        }

        return item;
    }
}
