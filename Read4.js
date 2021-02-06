//TC: O(n)
//SC: O(n)

/**
 * Definition for read4()
 * 
 * @param {character[]} buf4 Destination buffer
 * @return {number} The number of actual characters read
 * read4 = function(buf4) {
 *     ...
 * };
 */

/**
 * @param {function} read4()
 * @return {function}
 */
var solution = function(read4) {
    /**
     * @param {character[]} buf Destination buffer
     * @param {number} n Number of characters to read
     * @return {number} The number of actual characters read
     */
    
    return function(buf, n) {
        var tmp = [];
        var total = 0;
        var eof = false;    
        while(!eof && total < n) {
            var count = read4(tmp);
            eof = count < 4;
            count = Math.min(count, n - total);
            for(var j = 0; j < count; j++) {
                buf[total++] = tmp[j];
            }
        }
    };
};
