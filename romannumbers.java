class Solution {
    public int romanToInt(String s) {
        // 1. set a hashmap with string and integer denoting the values
        // { I, 10}, {MC 1000} etc
        //replace the input with the strings
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        //s = "MCMXCIV"
        var index = 0;
        var finalAnswer = 0;
        var stringLength = s.length();
        while(index < stringLength){
            if((index + 1) < stringLength) {
            String substring1 = String.valueOf(s.charAt(index)) ;
                String substring2 =  String.valueOf(s.charAt(index + 1));
                String concatStr = substring1 + substring2;
                if(map.containsKey(concatStr)) {

                   finalAnswer = finalAnswer + map.get(concatStr); 
                    index = index + 2;
                }
                 else {
                      System.out.println("puck");
                finalAnswer = finalAnswer + map.get(String.valueOf(s.charAt(index)));

                index++;
                }
              
            }
            else {
               
                finalAnswer = finalAnswer + map.get(String.valueOf(s.charAt(index)));
                
                index++;
            }
        }
        return finalAnswer;
        
    }
}
