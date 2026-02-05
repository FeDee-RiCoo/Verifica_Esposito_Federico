public class DoublyLinkedList {

    private Node head, tail;

    public DoublyLinkedList() {
        this.head = this.tail = null;
    }

    /**
     * Adds a node at the end of the list
     * 
     * @param newNode new node to be added
     */
    public void add(Node newNode) {
        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    // wrapper
    private Node getRec(Node cursor, int index) {

        if (index == 0)
            return cursor;

        return getRec(cursor.getNext(), index - 1);
    }

    /**
     * Gets the element in the specified position
     * 
     * @param index position to read
     * @return the element identified by the index
     * @throws IndexOutOfBoundsException
     */
    public Node get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index");

        return getRec(head, index);
    }

    // ------------ INSERT YOUR CODE HERE ----------------
    /**
     * Prints the whole list from the head to the tail or viceversa
     * 
     * @param forward if it's true it starts from the head, otherwise it starts from
     *                the tail
     */
    public void print(boolean forward) {
        Node current;
        // Empty list case
        // Checks it either the head or the tail are null
        if (this.head == null || this.tail == null) {
            System.out.println("[]");
        }

        // Forward case
        if (forward) {
            // We start from the head
            current = this.head;
            // We cycle until current is null (after the tail)
            while (current != null) {
                System.out.println(current.getLetter());
                // Update the value
                current = current.getNext();

            }
        } else {
            // Backward case
            // We start from the tail
            current = this.tail;
            // We cycle until current is null (before the head)
            while (current != null) {
                System.out.println(current.getLetter());
                // Update the value
                current = current.getPrev();

            }

        }

    }

    /**
     * Returns list's size
     */
    public int size() {
        // counter
        int n = 0;
        // We start from the start beacuse the direction doesn't matter
        Node current = this.head;
        // Empty case
        // Checks it either the head or the tail are null
        if (this.head == null || this.tail == null) {
            return 0;
        }
        // We cycle until current is null (after the tail)
        while (current != null) {
            n += 1;
            // Update the value
            current = current.getNext();
        }

        return n;
    }

    /**
     * Attaches the second list to the first list
     * 
     * @param otherList it's the second list that we are going to attach to the
     *                  first one
     */
    public void attach(DoublyLinkedList otherList) {

        // Case ourList is empty
        if (this.head == null || this.tail == null) {
            this.head = otherList.head;
            this.tail = otherList.tail;
        }
        // Case otherList is empty
        if (otherList.head == null || otherList.tail == null) {
            System.out.println("We didn't attach anything because the otherlist is empty");
        }
        // We set the other list head as the next value of our list's tail
        this.tail.setNext(otherList.head);
        // Our list's tail equals to the other list tail because we merged them
        this.tail = otherList.tail;
        // other list's head equals to our list's head because we merged them
        otherList.head = this.head;
    }

    /**
     * Removes duplicate nodes so we get one list that is an eteroList
     * 
     */
    public void removeRepetitions() {
        // Empty list case
        // Checks it either the head or the tail are null
        if (this.head == null || this.tail == null) {
            System.out.println("[]");
        }
        Node current = this.head;
        // We cycle until current is null (after the tail)
        while (current != this.tail) {
            // Checks current's next node
            if (current.equals(current.getNext())) {
                // We set current's next node as the one that is 2 positions above so we
                // eliminate the clone
                current.setNext(current.getNext().getNext());
            }

        }

    }
      /**
     * Method that starts to mirror the letters from the one that is indicated by the index
     * 
     * @param index it's the index passed that indicates where to start mirroring
     */
    public void mirror(int index) {

        // Empty list case
        // Checks it either the head or the tail are null

        if (this.head == null || this.tail == null) {
            System.out.println("[]");
        }
        Node current = head;
        // Cycles from the start to the end
        for (int i = 0; i < this.size(); i++) {
            current = current.getNext();
            // when i is equal or greater than the index we start mirroring the letters
            if( i >= index){
                current = current.getPrev();
            }
        }

    }
}