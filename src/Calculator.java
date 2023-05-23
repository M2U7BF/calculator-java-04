// 計算機クラス
public class Calculator {
  private double result; // 計算結果を保持する変数
  private double[] operand;
  private String operator;
  private boolean isNumber = true;

  // コンストラクタ
  public Calculator() {
    this.result = 0.0;
    this.operand = new double[2];
    this.operator = "";
  }

  // 計算結果を取得するメソッド
  public double getResult() {
    return this.result;
  }
  public double[] getOperand() {
    return this.operand;
  }
  public boolean getIsNumber(){
    return this.isNumber;
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
  public void setIsNumber(boolean isNumber){
    this.isNumber = isNumber;
  }
  public void setResult(double result){
    this.result = result;
  }

  // 計算を実行するメソッド
  public double calculate() {
    double[] operand = this.operand;

    if(operand[0] == 0.0 && operand[1] == 0.0){
      System.out.println("計算対象が存在しません。");
      return 0;
    }

    if(operand[0] != 0.0 && operand[1] == 0.0){
      commonLogic(this.result, operand[0]);
    } else {
      commonLogic(operand[0], operand[1]);
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
  public void commonLogic(double num1, double num2){
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
