public class ArrayList implements List {

    private Object[] array;

    public ArrayList() {
        array = new Object[0];
    }


    public boolean isEmpty() {
        return (array.length == 0);
    }

    public int size() {
        return array.length;
    }


    public ReturnObject get(int index) {
        ReturnObject returnIfErrors = checkErrors(index);
        if(returnIfErrors.hasError()) {
            return returnIfErrors;
        }
        return (new ReturnObjectImpl(array[index]));
    }

    public ReturnObject remove(int index) {
        ReturnObject returnValue = get(index);
        if (!returnValue.hasError()) {
            removeElementFromArrayByIndex(array, index);
        }
        return returnValue;
    }

    public ReturnObject add(Object item) {
        ReturnObject itemToInsert = checkErrors(item);
        if(!itemToInsert.hasError()) {
            insertItemIntoArrayByIndex(item, size());
        }
        return itemToInsert;
    }

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

}