class Solution {
    public String decodeString(String s) {
        StringBuilder current = new StringBuilder();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        Deque<Integer> countStack = new ArrayDeque<>();
        int k =0;
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                k = k*10 + (c-'0');
            }
            else if(c=='['){
                countStack.push(k);
                k=0;
                stringStack.push(current);
                current = new StringBuilder();
            }
            else if(c==']'){
                int number = countStack.pop();
                StringBuilder prev = stringStack.pop();
                prev.repeat(current,number);
                current = prev;
            }
            else{
                current.append(c);
            }
        }
        return current.toString();
    }
}