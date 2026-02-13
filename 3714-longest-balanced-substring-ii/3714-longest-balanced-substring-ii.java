class Solution {
    public class Pair{
        int a,b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
    public int isBalancedLen2(String s,char x,char y){
        int maxLen=0;
        Map<Integer,Integer> m=new HashMap<>();
        int countx=0,county=0;
        m.put(0,-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==x){
                countx++;
            }
            else if(s.charAt(i)==y){
                county++;
            }
            else{
                countx=0;
                county=0;
                m=new HashMap<>();
            }
            int diff=countx-county;
            if(m.containsKey(diff)){
                maxLen=Math.max(maxLen,i-m.get(diff));
            }
            else
                m.put(diff,i);
        }
        return maxLen;
    }

    public int isBalacedLen3(String s){
        int maxLen=0;
        int counta=0;
        int countb=0;
        int countc=0;
        Map<Pair,Integer> m=new HashMap<>();
        m.put(new Pair(0,0),-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                counta++;
            }
            else if(s.charAt(i)=='b'){
                countb++;
            }
            else{
                countc++;
            }
            int diffab=counta-countb;
            int diffac=counta-countc;
            Pair p=new Pair(diffab,diffac);
            if(m.containsKey(p)){
                maxLen=Math.max(maxLen,i-m.get(p));
            }
            else{
                m.put(p,i);
            }
        }
        return maxLen;
    }
    public int longestBalanced(String s) {
        int n=s.length();
        int maxLen=1;
        int count=1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                count=1;
            }
            maxLen=Math.max(maxLen,count);
        }
        maxLen=Math.max(maxLen,isBalancedLen2(s,'a','b'));
        maxLen=Math.max(maxLen,isBalancedLen2(s,'a','c'));
        maxLen=Math.max(maxLen,isBalancedLen2(s,'b','c'));
        maxLen=Math.max(maxLen,isBalacedLen3(s));
        return maxLen;
        
    }
}