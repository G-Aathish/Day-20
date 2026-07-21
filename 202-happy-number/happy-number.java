class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s= new HashSet<>();
        while(n!=1 && !s.contains(n)){
            s.add(n);
            n = getsum(n);


        }
        return n==1;

    }
    public int getsum(int n){
        int sum =0;
        while(n>0){
            int lastdigit = n%10;
            sum+=lastdigit*lastdigit;
            n/=10;
        }
        return sum;
    }
}