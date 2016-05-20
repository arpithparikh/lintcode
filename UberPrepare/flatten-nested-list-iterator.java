c interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<NestedInteger>();

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        NestedInteger t = stack.pop();
        return t.getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while(!stack.isEmpty()){
            NestedInteger t = stack.peek();
            if(t.isInteger() == true){
                return true;
            }else{
                t = stack.pop();
                List<NestedInteger> list = t.getList();
                for(int i = list.size() - 1; i >=0; i--){
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }

    @Override
    public void remove() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */
