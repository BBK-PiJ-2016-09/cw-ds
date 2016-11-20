public class FunctionalLinkedList extends LinkedList implements FunctionalList {

    private LinkedListElements last = null;
    private LinkedListElements first = null;
    private int sizeOfTheList = 0;

    /**
     * Returns the element at the beginning of the list.
     *
     * If the list is empty, an appropriate error is returned.
     *
     * @return a copy of the element at the beginning of the list or
     *         an error if the list is empty.
     */
    public ReturnObject head() {
        if(isEmpty()) {
            return (new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE));
        }
        return get(0);
    }

    /**
     * Returns a list with the elements in this list except the
     * head. The elements must be in the same order. The original list
     * must not change or be affected by changes in the new list.
     *
     * If the list is empty, another empty list is returned.
     */
    public FunctionalLinkedList rest() {
        if(first == null) {
            return (new FunctionalLinkedList());
        }
        FunctionalLinkedList listToReturn = this;
        listToReturn.remove(0);
        return listToReturn;
    }
}