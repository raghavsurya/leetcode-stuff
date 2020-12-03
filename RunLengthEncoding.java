import java.util.*;

class Program {
	static class Pair {
	private String string;
  private Integer count;
		public Pair(String s, int i) {
			this.string = s;
			this.count = i;
		}
  //accessors
}
  public String runLengthEncoding(String string) {
    // Write your code here.
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < string.length()) {
			int j = i;
			while(j < string.length() - 1 && string.charAt(j + 1) == string.charAt(i)) {
				j++;
			}
			int successiveCountOfChars = j - i + 1;
			int moreThanNine = successiveCountOfChars / 9;
			int lessThanNine = successiveCountOfChars % 9;
			if(moreThanNine > 0) {
				for(int m = 1; m <= moreThanNine; m++) {
							sb.append(String.valueOf(9) + Character.toString(string.charAt(i)));
						}
			}
			if(lessThanNine > 0) {
				sb.append(String.valueOf(lessThanNine) + Character.toString(string.charAt(i)));
			}
			i = j + 1;
		}
		
					
    return sb.toString();
  }
}
//O(N)
//O(N)
