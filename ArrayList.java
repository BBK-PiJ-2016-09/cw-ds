public class ArrayList implements List {

    private Object[] array;

    public ArrayList() {
        array = new Object[0];
    }

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (array.length == 0);
    }

    /**
     * Returns the number of items currently in the list.
     *
     * @return the number of items currently in the list
     */
    public int size() {
        return array.length;
    }

    /**
     * Returns the element at the given position.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObject get(int index) {
        ReturnObject returnIfErrors = checkErrors(index);
        if(returnIfErrors.hasError()) {
            return returnIfErrors;
        }
        return (new ReturnObjectImpl(array[index]));
    }

    /**
     * Returns the elements at the given position and removes it
     * from the list. The indeces of elements after the removed
     * element must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message,
     *         encapsulated in a ReturnObject
     */
    public ReturnObject remove(int index) {
        ReturnObject returnValue = get(index);
        if (!returnValue.hasError()) {
            removeElementFromArrayByIndex(array, index);
        }
        return returnValue;
    }
    private void removeElementFromArrayByIndex(Object[] element, int index) {
        Object[] newArray = new Object[size() -1];
        int i = 0;
        while (i < index) {
            newArray[i] = array[i];
            i++;
        }
        i++;
        while(i < size()) {
            newArray[i - 1] = array[i];
            i++;
        }
        array = newArray;
    }

    /**
     * Adds an element to the list, inserting it at the given
     * position. The indeces of elements at and after that position
     * must be updated accordignly.
     *
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param index the position at which the item should be inserted in
     *              the list
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         or containing an appropriate error message otherwise
     */
    public ReturnObject add(int index, Object item) {
        ReturnObject itemToInsert = checkErrors(index, item);
        if(!itemToInsert.hasError()) {
            insertItemIntoArrayByIndex(item, index);
        }
        return itemToInsert;
    }

    private ReturnObject checkErrors(int index, Object object) {
        if (index >= size() || index < 0) {
            return (new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS));
        }
        if (object == null) {
            return (new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT));
        }
        return (new ReturnObjectImpl(ErrorMessage.NO_ERROR));
    }

    private ReturnObject checkErrors(Object object) {
        if (object == null) {
            return (new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT));
        }
        return (new ReturnObjectImpl(ErrorMessage.NO_ERROR));
    }
    private ReturnObject checkErrors(int index) {
        if (index >= size() || index < 0) {
            return (new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS));
        }
        return (new ReturnObjectImpl(ErrorMessage.NO_ERROR));
    }

    private void insertItemIntoArrayByIndex(Object element, int index){
        Object[] newArray = new Object[size() + 1];
        int i = 0;
        while(i < index) {
            newArray[i] = array[i];
            i++;
        }
        newArray[i] = element;
        while(i < size()) {
            newArray[i + 1] = array[i];
            i++;
        }
        array = newArray;
        System.out.println(size());
    }



    /**
     * Adds an element at the end of the list.
     *
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     *
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         or containing an appropriate error message otherwise
     */
    public ReturnObject add(Object item) {
        ReturnObject itemToInsert = checkErrors(item);
        if(!itemToInsert.hasError()) {
            insertItemIntoArrayByIndex(item, size());
        }
        return itemToInsert;
    }
}