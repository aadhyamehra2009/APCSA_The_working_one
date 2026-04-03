package tower;

public class IntegerStack {

    private int[] stack;
    private int depth;

    public IntegerStack(int depth)
    {
        this.depth = 0;
        stack = new int[depth]; 
    }

    public int peek()
    {
        if (depth > 0)
        {
            return stack[depth -1];
        }
        return 0;
    }

    public int pop()
    {
        int result = 0;
        if (depth > 0) {
            result = stack[depth-1];
            stack[depth - 1] = 0;
            depth--;
        }
        return result;
    }

    public void push(int value)
    {
        if ((depth >= 0) && (depth < stack.length))
        {
            stack[depth++] = value;
        }
    }

    public int get(int index)
    {
        return stack[index];
    }
}
