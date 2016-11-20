public class LinkedList implements List {

    private LinkedListElements last = null;
    private LinkedListElements first = null;
    private int sizeOfTheList = 0;

    public LinkedList() {

    }

    public boolean isEmpty() {
        return (size() == 0);
    }


    public int size() {
        return sizeOfTheList;
    }


    public ReturnObject get(int index) {
        ReturnObject returnIfErrors = checkErrors(index);
        if (returnIfErrors.hasError()) {
            return returnIfErrors;
        }
        return getElementByIndex(index);
    }


    private ReturnObject getElementByIndex(int index) {
        int i = 0;
        LinkedListElements currentElement = first;
        while (i < index) {
            i++;
            currentElement = currentElement.getNext();
        }
        return (new ReturnObjectImpl(currentElement.getValue()));
    }

    public ReturnObject remove(int index) {
        ReturnObject returnIfErrors = checkErrors(index);
        if (returnIfErrors.hasError()) {
            return returnIfErrors;
        } else {
            removeFromIndex(index);
            return returnIfErrors;
        }
    }

    private ReturnObject removeFromIndex(int index) {
        ReturnObject itemToReturn = get(index);
        LinkedListElements itemToRemove = first;
        int i = 0;
        while(i < index) {
            itemToRemove = itemToRemove.getNext();
            i++;
        }
        if (itemToRemove == first) {
            first = itemToRemove.getNext();
            first.setPrevious(null);
        }
        if(itemToRemove == last) {
            last = last.getPrevious();
            last.setNext(null);
        }
        else{
            itemToRemove.getPrevious().setNext(itemToRemove.getNext());
            itemToRemove.getNext().setPrevious(itemToRemove.getPrevious());
        }
        itemToRemove.setNext(null);
        itemToRemove.setPrevious(null);
        return itemToReturn;
    }


    public ReturnObject add(int index, Object item) {
        ReturnObject itemToInsert = checkErrors(index, item);
        if (!itemToInsert.hasError()) {
            addItemAtIndex(index, item);
        }
        return itemToInsert;
    }


    private void addItemAtIndex(int index, Object item) {
        LinkedListElements itemToAdd = new LinkedListElements(item);
        if(size() == 0) {
            first = itemToAdd;
            last = itemToAdd;
            sizeOfTheList++;
            return;
        }
        if(size() == 1) {
            itemToAdd.setPrevious(first);
            first.setNext(itemToAdd);
            last = itemToAdd;
            sizeOfTheList++;
            return;
        }
        int i = 0;
        LinkedListElements currentElement = first;
        while(i < index) {
            i++;
            currentElement = currentElement.getNext();
        }
        if(currentElement == first) {
            currentElement.setPrevious(itemToAdd);
            itemToAdd.setNext(currentElement);
            first = itemToAdd;
            sizeOfTheList++;
            return;
        }
        itemToAdd.setNext(currentElement);
        itemToAdd.setPrevious(currentElement.getPrevious());
        currentElement.getPrevious().setNext(itemToAdd);
        currentElement.setPrevious(itemToAdd);
        sizeOfTheList++;
    }




    public ReturnObject add(Object item) {
        ReturnObject itemToReturn = checkErrors(item);
        if(!itemToReturn.hasError()) {
            LinkedListElements itemToAdd = new LinkedListElements(item);
            if(size() == 0) {
                first = itemToAdd;
                last = itemToAdd;
            } else {
                last.setNext(itemToAdd);
                itemToAdd.setPrevious(last);
                last = itemToAdd;
            }
            sizeOfTheList++;
        }
        return itemToReturn;
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

    private ReturnObject checkErrors(int index) {
        if (index >= size() || index < 0) {
            return (new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS));
        }
        return (new ReturnObjectImpl(ErrorMessage.NO_ERROR));
    }

    private ReturnObject checkErrors(Object object) {
        if (object == null) {
            return (new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT));
        }
        return (new ReturnObjectImpl(object));
    }

}