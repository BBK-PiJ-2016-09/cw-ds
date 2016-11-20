
public class SampleableListImpl extends FunctionalLinkedList implements SampleableList  {

    /**
     * Returns a list containing the first, third, fifth...
     * items of this list, or an empty list if the list is empty.
     *
     * @return a list containing the first, third, fifth... items of this list
     */
    public SampleableListImpl sample() {
        int i = 0;
        SampleableListImpl newList = new SampleableListImpl();
        while(i < this.size()) {
            newList.add(this.get(i).getReturnValue());
            i = i + 2;
        }
        return newList;
    }
}
