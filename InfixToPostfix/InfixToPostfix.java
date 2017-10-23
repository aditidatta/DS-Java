/**
 * Converts Infix expression to Postfix expression
 * @author Aditi Datta
 */
public class InfixToPostfix {


    /**
     * Converts Infix expression to Postfix expression
     * @param infixExp String Infix Expression
     * @return String Postfix expression
     */
    public String convert(String infixExp) throws IllegalArgumentException{
        ObjectStack operators = new ObjectStack();
        char[] output = new char[infixExp.length()];

        int top = 0;

        int adjOperands = 0;
        int adjOperators = 0;
        int brackets = 0;

        for(char c : infixExp.toCharArray()){

            if (c == ' '){
                continue;
            }
            else if (c >= '0' && c <= '9'){
                if (adjOperands > 0){
                    throw new IllegalArgumentException("Invalid Infix Expression! " +
                            "Adjacent operands! ");
                }
                output[top++] = c;
                adjOperands++;
                adjOperators--;
                //System.out.println(output[top-1]);
            }
            else if(c == '('){
                brackets++;
                operators.push(c);
            }
            else if(c == ')'){
                brackets--;
                if(brackets < 0){
                    throw new IllegalArgumentException("Invalid Infix Expression! " +
                            "Extra Parenthesis!");
                }
                char op = (char)operators.pop();
                while (op != '('){
                    output[top++] = op;
                    //System.out.println(output[top-1]);
                    op = (char)operators.pop();
                }
            }
            else{

                adjOperands--;
                adjOperators++;
                if (adjOperators > 0){
                    throw new IllegalArgumentException("Invalid Infix Expression! " +
                            "Adjacent operators! ");
                }
                while(!operators.isEmpty()){
                    char op = (char)operators.top();
                    int p1 = priority(op);
                    int p2 = priority(c);
                    if ((op != '(' && op != ')') && (p1 == 0 || p2 == 0)){
                        throw new IllegalArgumentException(
                                "Invalid Infix Expression! Only ( ) ^ * / +" +
                                        " - operators are allowed....");
                    }
                    if( p1 >= p2 ){
                        output[top++] = (char)operators.pop();
                        //System.out.println(output[top-1]);
                    }
                    else break;
                }
                operators.push(c);
            }
        }


        if (brackets > 0){
            throw new IllegalArgumentException("Invalid Infix Expression! " +
                    "Missing parenthesis! ");
        }

        //System.out.println(operators.isEmpty());
        while (!operators.isEmpty()){
            output[top++] = (char)operators.pop();
        }

        String postfixExp = new String(output).substring(0,top);
        return postfixExp;
    }

    /**
     * Checks priority of an operator
     * @param op char
     * @return int priority
     */
    private int priority(char op){
        switch(op){
            case '^': return 3;
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;
            default: return 0;
        }
    }
}
