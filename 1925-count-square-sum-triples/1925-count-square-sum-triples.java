class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int a=1;a<n;a++){
            for(int b=a+1;b<n;b++){
                int square=a*a+b*b;
                int c=(int)Math.sqrt(square);
                if(c*c==square && c<=n){
                    count=count+2;
                }

            }
        }
        return count;
    }
}