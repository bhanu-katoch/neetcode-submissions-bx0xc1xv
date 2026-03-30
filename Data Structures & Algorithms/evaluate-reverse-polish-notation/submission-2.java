class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens){
            if(token.equals("+")||token.equals("*")||token.equals("-")||token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operate(a,b,token));
            }
            else stack.push(Integer.parseInt(token));
        }
        return stack.pop(); 
    }
    private int operate(int a, int b, String op){
        if(op.equals("+")){
            return a+b;
        }
        else if(op.equals("-")){
            return a-b;
        }
        else if(op.equals("*")){
            return a*b;
        }
        else{
            return a/b;
        }
    }
}
