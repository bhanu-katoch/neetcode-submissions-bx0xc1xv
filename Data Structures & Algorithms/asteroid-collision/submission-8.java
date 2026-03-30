class Solution {
    public int[] asteroidCollision(int[] asteroids) {
       Deque<Integer> stack = new ArrayDeque<>();
       for(int ast: asteroids){
            if(ast<0){
                if(stack.isEmpty())
                    stack.push(ast);
                else{
                    int abs = Math.abs(ast);
                    boolean finish = false;
                    while(!stack.isEmpty()&&stack.peek()>0){
                        int a = stack.peek();
                        if(a>abs){
                            break;
                        }
                        else if(a==abs){
                            finish = true;
                            stack.pop();
                            break;
                        }
                        else{
                            stack.pop();
                        }
                    }
                    if(finish) continue;
                    if(stack.isEmpty() || stack.peek()<0) stack.push(ast);
                }
            }
            else{
                stack.push(ast);
            }
       }
       List<Integer> list = new ArrayList<>();
       while(!stack.isEmpty()){
            System.out.println(stack.peek());
            list.add(stack.pop());
       }
       int[] ans = new int[list.size()];
       int k=0;
       for(int i=list.size()-1;i>=0;i--){
            ans[k++] = list.get(i);
       }
       return ans;

    }
}