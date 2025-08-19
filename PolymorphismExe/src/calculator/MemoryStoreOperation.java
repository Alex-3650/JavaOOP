package calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class MemoryStoreOperation implements Operation{
    private final Deque<Integer> memoryStack;


    public MemoryStoreOperation() {
        memoryStack=new ArrayDeque<>();
    }


    @Override
    public void addOperand(int operand) {
        memoryStack.push(operand);
    }

    @Override
    public int getResult() {
        return memoryStack.pop();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
