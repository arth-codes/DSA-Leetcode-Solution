class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> a = new ArrayList <>();
        List<Integer> b = new ArrayList <>();
    // seperating pos and neg no
    for(int num :nums){
        if (num<0){
            a.add(num);
        }
        else{
            b.add(num);
        }
    }
    // case 1 : all positive
    if (a.size()==0){
        for (int i=0; i< b.size();i++){
            int value= b.get(i);
            int square = value * value;
            b.set(i,square);
        }
        return b.stream().mapToInt(Integer::intValue).toArray();
    }
    //case2: all negative number
    if(b.size()==0){
        for(int i=0; i < a.size();i++) {
            int value = a.get(i);
            int square = value * value;
            a.set(i,square);        
        }
        Collections.reverse(a);
        return a.stream().mapToInt(Integer::intValue).toArray();
    }
    //case 3: both neg and pos exists
    int i=0, j=0 , id=0;
    int n1= a.size();
    int n2 = b.size();
    int [] res = new int[n1+n2];
        // sq and reverse neg no
        for(i =0;i< a.size();i++){
            int value = a.get(i);
            int square = value * value;
            a.set(i,square);
        }
        Collections.reverse(a);

        //sq postive number 
        for ( i=0; i< b.size(); i++){
            int value= b.get(i);
            int square = value * value;
            b.set(i,square);
        }
        i=0;
        j=0;
        while ( i<n1 && j<n2) {
            if (a.get(i)<= b.get(j)){
                res[id++]= a.get(i++);
            }
            else{
                res[id++]= b.get(j++);
            }
        }
        while(i<n1){
            res[id++]= a.get(i++);
        }
        while(j<n2){
            res[id++]=b.get(j++);
        }
        return res;
           }
}
