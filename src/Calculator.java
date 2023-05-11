// 計算機クラス
public class Calculator {
  private double result; // 計算結果を保持する変数
  private double operand;
  private String operator;

  // コンストラクタ
  public Calculator() {
    this.result = 0.0;
    this.operand = 0.0;
    this.operator = "";
  }

  // 計算結果を取得するメソッド
  public double getResult() {
    return this.result;
  }

  public double getOperand() {
    return this.operand;
  }

  public void setOperand(double operand) {
    this.operand = operand;
  }

  public String getOperator() {
    return this.operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  // 計算を実行するメソッド
  public double calculate(String operator) {
    double operand = this.operand;

    switch (operator) {
      case "+":
        this.result += this.operand;
        break;
      case "-":
        this.result -= this.operand;
        break;
      case "*":
        this.result *= this.operand;
        break;
      case "/":
        this.result /= this.operand;
        break;
      case "%":
        this.result %= this.operand;
        break;
      case "c":
        this.result = 0;
        break;
      case "=":
        // Do nothing.
        break;
      default:
        System.out.println("無効な演算子です。");
    }

    this.operand = 0.0;
    this.operator = "";

    return this.result;
  }
}
