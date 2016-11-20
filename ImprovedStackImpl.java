/**
 * An implementation of a stack with additional methods. 
 * 
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack. 
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
public class ImprovedStackImpl implements Stack {
	/**
	 * Returns a copy of this stack with the items reversed, the top
	 * elements on the original stack is at the bottom of the new
	 * stack and viceversa.
	 * 
	 * @return a copy of this stack with the items reversed. 
	 */
	private List internalList;
	public ImprovedStackImpl reverse() {
		List anotherList = internalList;
		int i = 0;
		while(i < internalList.size()) {
			i++;
			Object item = anotherList.get(i).getReturnValue();
			anotherList.remove(i);
			anotherList.add(internalList.size()-1-i, item);
		}
		ImprovedStackImpl toReturn = new ImprovedStackImpl(anotherList);
		return toReturn;
	}

	/**
	 * Removes the given object from the stack if it is
	 * there. Multiple instances of the object are all removed.
	 *
	 * Classes implementing this method must use method .equals() to
	 * check whether the item is in the stack or not.
	 * 
	 * @param object the object to remove
	 */
	public void remove(Object object){
		int i = 0;
		while( i < internalList.size()) {
			if(internalList.get(i).getReturnValue().equals(object)){
				internalList.remove(i);
			} else {
				i++;
			}

		}
	}
	public boolean isEmpty(){
		return internalList.isEmpty();
	}

	public int size(){
		return internalList.size();
	}

	public void push(java.lang.Object o){
		internalList.add(o);
	}

	public ReturnObject top(){
		return internalList.get(internalList.size()-1);
	}

	public ReturnObject pop() {
		ReturnObject toReturn = internalList.get(internalList.size() -1);
		if(!toReturn.hasError()){
			internalList.remove(internalList.size() -1);
		}
		return toReturn;
	}
	public ImprovedStackImpl(List list) {
		internalList = list;
	}
}

