/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

//Time complexity O(log n)
//Space complexity: O(1)
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0) return 0;
        int left = 1;   
        int right = n;
        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        if(isBadVersion(left)) return left;
        return -1;
        
    }
}
