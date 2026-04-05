class Solution {
    public String simplifyPath(String path) {
        String[] files = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String file:files){
            if(!file.equals("")){
                if(file.equals("..")){
                    if(stack.isEmpty())
                        continue;
                    stack.pop();
                } 
                else if(!file.equals(".")) stack.push(file);
            }

            // System.out.println(file);
        }
        StringBuilder sb = new StringBuilder("");
        Deque<String> help = new ArrayDeque<>();
        
        while(!stack.isEmpty()){
            String s = stack.pop();
            System.out.println(s);
           
                    help.push(s);
        }
        while(!help.isEmpty()){
            sb.append("/");
            sb.append(help.pop());
        }
        return sb.length()==0?"/":sb.toString();
    }
}