import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {
  private Calculator calculator;
  private Scanner scanner;

  // コンストラクタ
  public InputHandler() {
    calculator = new Calculator();
    scanner = new Scanner(System.in);
  }

  // 入力を取得するメソッド
  public void getInput() {
    String input = waitForInput();

    if (isOperator(input)) {
      handleOperatorInput(input, calculator);
    } else if (isNumeric(input)) {
      handleNumericInput(input, calculator);
    } else {
      printErrorMessage("無効な入力です。");
    }

    // 出力
    System.out.println("________________________________________");
    System.out.println("計算結果: " + String.valueOf(calculator.getResult()));
    System.out.println("operand: " + Arrays.toString(calculator.getOperand()));
    System.out.println("operator: " + calculator.getOperator());
    System.out.println("----------------------------------------");
    System.out.println("\n");
  }

  public static String waitForInput() {
    Scanner scanner = new Scanner(System.in);
    StringBuilder inputBuilder = new StringBuilder();

    System.out.println("電卓: ");

    while (true) {
      String line = scanner.nextLine();

      if (line.isEmpty()) { // エンターキーが押された場合
        break;
      }

      inputBuilder.append(line);
    }

    return inputBuilder.toString();
  }

  public static boolean isNumeric(String str) {
    String regex = "[-0-9０-９]+"; // 数字(0-9,０-９)の正規表現
    return str.matches(regex);
  }

  public static boolean isOperator(String str) {
    String regex = "[+-÷*×%=c\\/]";
    return str.matches(regex);
  }

  public void handleOperatorInput(String input, Calculator calculator) {
    if (input.equals("=")) {
        calculator.calculate();
    } else if (input.equals("c")) {
        calculator.initialize();
    } else {
        calculator.setOperator(input);
    }
  }

  public void handleNumericInput(String input, Calculator calculator) {
      if (calculator.getResult() != 0.0 && calculator.getOperand()[0] == 0.0 && calculator.getOperator().isEmpty()) {
          printErrorMessage("演算子を入力してください。");
      } else {
          double operand = Double.parseDouble(input);
          calculator.setOperand(operand);

          if (!calculator.getOperator().isEmpty() && calculator.getResult() != 0.0) {
              calculator.calculate();
          }
      }
  }

  public void printErrorMessage(String message) {
      System.out.println("ERROR: " + message + "\n");
  }
}
