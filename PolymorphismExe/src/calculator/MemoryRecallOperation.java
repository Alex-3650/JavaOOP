package calculator;

public class MemoryRecallOperation implements Operation{

    private final MemoryStoreOperation memory;

    public MemoryRecallOperation(MemoryStoreOperation memory) {
        this.memory=memory;
    }


    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return this.memory.getResult();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
