public class Launcher{
    public static void main(String[] args) {
        ArrayList myList = new ArrayList();
        ImprovedStackImpl myStack = new ImprovedStackImpl(myList);
        myList.add("enric");
        System.out.println(myList.size());

        myStack.push("Enric");
        //System.out.println(myObj);


        myStack.push("Serra");
        myStack.push("Sanz");
        //SampleableListImpl anotherList = myList.sample();
        Object myReturn = myStack.top().getReturnValue();
        System.out.println(myStack.size());
        System.out.println(myReturn);


        /*myReturn = myList.get(myList.size()-1).getReturnValue();

        /*Object myReturn = myList.get(0).getReturnValue();

        //System.out.println(myReturn);


        //myList.add(myString);
        //Object myReturn2 = myList.get(1).getReturnValue();
        //System.out.println(myReturn2);
        myList.add("20");

        Object myReturn2 = myList.get(1).getReturnValue();
        System.out.println("Sould print 20 " + myReturn2);
        Object myReturn3 = myList.remove(1).getReturnValue();
        System.out.println("Should print 10 " + myReturn3);

        myList.add(0, "1");
        //myReturn2 = myList.head().getReturnValue();
        //System.out.println("Should print 1 " + myReturn2);
        //myList.remove(1);
        //FunctionalLinkedList anotherList = myList.rest();
        //System.out.println("Should print " + anotherList.head().getReturnValue());
        //System.out.println("Should print 20 " + myReturn2);
*/






    }
}
