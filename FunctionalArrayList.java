public class FunctionalArrayList extends ArrayList implements FunctionalList {

    private Object[] array;

    public ReturnObject head() {
        if(isEmpty()){
            return (new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE));
        }
        return get(0);
    }

    public FunctionalArrayList rest() {
        FunctionalArrayList newList = this;
        if(size() == 0) {
            return this;
        }
        newList.remove(0);
        return (newList);
    }
}