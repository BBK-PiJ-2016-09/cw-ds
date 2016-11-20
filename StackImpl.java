/**
 * An implementation of a stack that uses a {@List} as the underlying
 * data structure.
 *
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 *
 * @author PiJ
 */
public class StackImpl extends AbstractStack implements Stack {
    /**
     * The data structure where the elements on the stack are stored.
     */
    public List internalList;

    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    public int size() {
        return internalList.size();
    }

    /**
     * Adds an element at the top of the stack.
     *
     * @param item the new item to be added
     */
    public void push(Object item) {
        internalList.add(item);
    }

    /**
     * Returns the element at the top of the stack. The stack is
     * left unchanged.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject top() {
        return (internalList.get(0));
    }

    /**
     * Returns the element at the top of the stack. The element is
     * removed frmo the stack.
     *
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    public ReturnObject pop() {
        if(isEmpty()) {
            return (new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE));
        }
        return (internalList.remove(internalList.size() -1));
    }

    /**
     * Creates a new abstract stack using the provided list as the
     * underlying data structure.
     *
     * Note: This constructor does not check whether the provided list
     * is null. Programmers must do their own checks. If a null list
     * is provided, a NullPointerException will be thrown at runtime
     * as soon as any operation is attempted on the underlying list.
     *
     * @param list the list to be used
     */
    public StackImpl(List list) {
        internalList = list;
    }

}

