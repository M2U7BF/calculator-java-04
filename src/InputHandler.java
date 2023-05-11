import java.util.Scanner;

public class InputHandler {
  private Calculator calculator;
  private Scanner scanner;
  private Logger logger;

  // コンストラクタ
  public InputHandler() {
    calculator = new Calculator();
    scanner = new Scanner(System.in);
    logger = new Logger();
  }

  // 入力を取得するメソッド
  public void getInput() {
    String input = waitForInput();
    System.out.println("operand: " + calculator.getOperand());

    // オペランドの場合
    if (isOperator(input)) {
      calculator.calculate(input);

      logger.log("This is a log message.");
      System.out.println("計算結果: " + String.valueOf(calculator.getResult()));
      return;
    } else {
      if (!isNumeric(input)) {
        return;
      }
      double operand = calculator.getOperand();
      operand = concatDigits(operand, input);
      calculator.setOperand(operand);
      System.out.println("計算結果: " + String.valueOf(calculator.getResult()));
      return;
    }
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
    String regex = "[0-9０-９]+"; // 数字(0-9,０-９)の正規表現
    return str.matches(regex);
  }

  public static boolean isOperator(String str) {
    String regex = "[+\\-÷×%=]+";
    return str.matches(regex);
  }

  public static double concatDigits(double baseValue, String numStr) {
    String concatenatedStr;
    if (baseValue == 0 || baseValue == 0.0) {
      concatenatedStr = "";
    } else {
      concatenatedStr = Double.toString(baseValue);
    }

    for (int i = 0; i < numStr.length(); i++) {
      char digit = numStr.charAt(i); // 1桁の数字を取得する
      concatenatedStr += digit; // 1桁の数字を連結する
    }
    double concatenatedNum = Double.parseDouble(concatenatedStr); // 連結した文字列をdouble型に変換する
    return concatenatedNum; // 連結した数字を返す
  }
}
