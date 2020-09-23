class Solution {
    public String multiply(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        char[] product = new char[n1+n2];
        Arrays.fill(product, '0');
        
        for(int j=n2-1; j>=0; j--) {
            for(int i= n1-1; i>=0; i--){
                int d1 = ch2[j] - '0';
                int d2 = ch1[i] - '0';
                var temp = ((product[i+j+1] - '0') + (d1*d2));
                product[i+j+1] = (char)  (temp % 10 + '0');
                product[i + j] = (char) ((product[i + j] - '0') + temp / 10 + '0');
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean seen = false;
        for(char i: product) {
            if(i == '0' && !seen) continue;
            sb.append(i);
            seen = true;
        }
        
        
        return sb.length() ==0? "0" : sb.toString();
            
    }
}
