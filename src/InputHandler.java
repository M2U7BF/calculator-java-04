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

    // オペランドの場合
    if (isOperator(input)) {
      if(input.equals("=")) {
        calculator.calculate();
      } else if(input.equals("c")){
        calculator.initialize();
      } else {
        calculator.setOperator(input);
      }
    } else if (isNumeric(input)) {
      if(calculator.getResult() != 0.0 && calculator.getOperand()[0] == 0.0 && calculator.getOperator() == ""){
        System.out.println("ERROR: 演算子を入力してください。\n");
      }else{
        double operand = Double.parseDouble(input);
        calculator.setOperand(operand);

        if(calculator.getOperator() != "" && calculator.getResult() != 0.0){
          calculator.calculate();
        }
      }
    } else {
      System.out.println("ERROR: 無効な入力です。\n");
    }

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
    String regex = "[+\\-÷*×%=c]+";
    return str.matches(regex);
  }

  // public static String concatDigits(String baseValue, String numStr) {
  //   if (baseValue == "0" || baseValue == null) {
  //     baseValue = "";
  //   }

  //   for (int i = 0; i < numStr.length(); i++) {
  //     char digit = numStr.charAt(i); // 1桁の数字を取得する
  //     baseValue += digit; // 1桁の数字を連結する
  //   }
  //   // double concatenatedNum = Double.parseDouble(baseValue); // 連結した文字列をdouble型に変換する
  //   // return concatenatedNum; // 連結した数字を返す
  //   return baseValue;
  // }
}
