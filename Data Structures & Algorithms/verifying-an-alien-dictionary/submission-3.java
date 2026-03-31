class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        int i=0;
        for(char c: order.toCharArray()){
            map[c-'a']=i;
            i++;
        }
        for(i=0;i<words.length-1;i++){
            char[] w1 = words[i].toCharArray();
            char[] w2 = words[i+1].toCharArray();
            int len = Math.min(w1.length,w2.length);
            boolean flag = false;
            for(int j=0;j<len;j++){
                if(map[w1[j]-'a']>map[w2[j]-'a'])
                    return false;
                else if(map[w1[j]-'a']<map[w2[j]-'a']){
                    flag = true;
                    break;
                }
            }
            if(!flag && w1.length>w2.length)
                return false;
        }
        return true;
    }
}