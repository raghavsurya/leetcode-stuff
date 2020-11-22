import java.util.*;

class Program {
  public static int levenshteinDistance(String str1, String str2) {
    // Write your code here.
		int[][] editDistance = new int[str1.length()+1][str2.length()+1];
		editDistance[0][0] = 0;
		int jim = 1;
		while(jim <= str2.length()) {
			editDistance[0][jim] = jim;
			jim++;
		}
		int iim = 1;
		while(iim <= str1.length()) {
			editDistance[iim][0] = iim;
			iim++;
		}
	
		int i = 1;
	
		while(i <= str1.length()) {
				int j = 1;
			while(j <= str2.length()) {
				
					if(str1.charAt(i-1) == str2.charAt(j-1)) {
						editDistance[i][j] = editDistance[i-1][j-1]; 
					} else {
						editDistance[i][j] = 1 + Math.min(Math.min(editDistance[i-1][j], editDistance[i][j-1]), editDistance[i-1][j-1]);
					}
				System.out.printf("Str1 is: %c and Str2 is %c\n", str1.charAt(i-1), str2.charAt(j-1));
				System.out.printf("EditDistance[i][j] is %d\n", editDistance[i][j]);
					j++;
				}
			i++;
			
		}
    return editDistance[str1.length()][str2.length()];
  }
}
//TC: O(NM)
//SC: O(NM)

/*
Can still optimise it to be SC O(min(N,M)) by just having the immediate 2 rows
*/
