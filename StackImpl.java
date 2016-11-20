public class StackImpl extends AbstractStack implements Stack {


    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    public int size() {
        return internalList.size();
    }

    public void push(Object item) {
        internalList.add(item);
    }

    public ReturnObject top() {
        return (internalList.get(size() - 1));
    }


    public ReturnObject pop() {
        if(isEmpty()) {
            return (new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE));
        }
        return (internalList.remove(size() -1));
    }

    public StackImpl(List list) {
        super(list);
    }


}

