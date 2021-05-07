import java.io.IOException;

public class ConsoleCalculator {
    Calculator calculator;
    ViewConsole viewConsole;

    public ConsoleCalculator() {
        viewConsole = new ViewConsole();
        calculator = new Calculator();
    }

    public void inputData() throws IOException {
        viewConsole.showInputForm();
        calculator.setInputString();
    }

    public void parseInputData() throws Exception {
        if (calculator.getInputString().matches("^([1-9]|(10))[+*\\-/]([1-9]|(10))$")) {
            calculator.parseArab();
        } else if (calculator.getInputString().matches("^I?X?V?I{0,3}[+/\\-*](I?X?V?I{0,3})$")) {
            calculator.parseRoman();
        } else throw new Exception();
    }

    public void calculate() throws Exception {
        calculator.calculate();
    }

    public void showResult() {
        viewConsole.showOutputForm();
        calculator.showResult();
    }

}
