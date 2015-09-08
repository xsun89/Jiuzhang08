import java.util.Stack;

/**
 * Created by sun38 on 9/8/2015.
 */
public class StackSolution {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public StackSolution(){
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if(minStack.size() == 0){
            minStack.push(number);
        }else{
            minStack.push(Math.min(number, minStack.peek()));
        }


    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }

}
