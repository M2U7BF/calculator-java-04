// 計算機クラス
public class Calculator {
  private double result; // 計算結果を保持する変数
  private double[] operand;
  private String operator;

  // コンストラクタ
  public Calculator() {
    this.result = 0.0;
    this.operand = new double[2];
    this.operator = "";
  }

  public double getResult() {
    return this.result;
  }
  public double[] getOperand() {
    return this.operand;
  }
  public String getOperator() {
    return this.operator;
  }

  public void setOperand(double operand) {
    if(this.operand[0] == 0.0){
      this.operand[0] = operand;
    }else{
      this.operand[1] = operand;
    }
  }
  public void setOperator(String operator) {
    this.operator = operator;
  }
  public void setResult(double result){
    this.result = result;
  }

  // 計算を実行するメソッド
  public double calculate() {
    // POINT: メソッドの処理の最初のあたりで、例外を拒否するのは常套手段です。
    if(this.operand[0] == 0.0 && this.operand[1] == 0.0){
      System.out.println("計算対象が存在しません。");
      return 0;
    }

    if(this.operand[0] != 0.0 && this.operand[1] == 0.0){
      executeCalculate(this.result, this.operand[0]);
    } else {
      executeCalculate(this.operand[0], this.operand[1]);
    }

    this.operand = new double[2];
    this.operator = "";

    return this.result;
  }

  public void initialize(){
    this.result = 0.0;
    this.operand = new double[2];
    this.operator = "";
  }
  private void executeCalculate(double num1, double num2){
    switch (this.operator) {
      case "+":
        this.result = num1 + num2;
        break;
      case "-":
        this.result = num1 - num2;
        break;
      case "*":
      case "×":
        this.result = num1 * num2;
        break;
      case "/":
      case "÷":
        this.result = num1 / num2;
        break;
      case "%":
        this.result = num1 % num2;
        break;
      case "=":
        // Do nothing.
        break;
      default:
        System.out.println("計算の構文に問題があります。");
    }
  }

}
