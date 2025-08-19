package calculator;

public class ExtendedInterpreter extends InputInterpreter{
    private final MemoryStoreOperation memory;
    public ExtendedInterpreter(CalculationEngine engine) {
        super(engine);
        this.memory=new MemoryStoreOperation();

    }

    public Operation getOperation(String operation) {

        return switch (operation) {
            case "/" -> new DivisionOperation();
            case "ms" -> this.memory;
            case "mr" -> new MemoryRecallOperation(memory);
            default -> new MultiplicationOperation();
        };
    }
}
