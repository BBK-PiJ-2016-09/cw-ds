public class LinkedListElements {

    private LinkedListElements previous = null;
    private LinkedListElements next = null;

    private Object object;

    public LinkedListElements getPrevious() {
        return this.previous;
    }
    public LinkedListElements getNext() {
        return this.next;
    }
    public Object getValue(){
        return object;
    }
    public void setPrevious(LinkedListElements object) {
        this.previous = object;
    }
    public void setNext(LinkedListElements object) {
         this.next = object;
    }

    public LinkedListElements(Object object) {
        this.object = object;
    }
}