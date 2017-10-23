/**
 * Evaluates a Postfix expression given in form of a string
 * @author Aditi Datta
 */
public class EvalPostfix {

    /**
     * Evaluates a Postfix expression given in form of a string
     * @param postfixExp String input
     * @return int result
     */
    public double evaluate(String postfixExp){
        double result = 0;
        ObjectStack operands = new ObjectStack();

        for (char c : postfixExp.toCharArray()){
            if(c == ' ')
                continue;
            else if(c >= '0' && c <= '9') {

                operands.push((double)(c - '0'));
            }
            else{
                double operand2 = (double) operands.pop();
                double operand1 = (double) operands.pop();
                switch(c){
                    case '^':
                        result = (int)Math.pow(operand1, operand2);
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid Postfix Expression!");
                }

                operands.push(result);
            }
        }

        if(!operands.isEmpty()){
            result = (double) operands.pop();
        }

        return result;
    }

}
