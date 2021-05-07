public class Main {
    public static void main(String[] args) throws Exception {
        ConsoleCalculator consoleCalculator = new ConsoleCalculator();
        consoleCalculator.inputData();
        consoleCalculator.parseInputData();
        consoleCalculator.calculate();
        consoleCalculator.showResult();
    }
}
