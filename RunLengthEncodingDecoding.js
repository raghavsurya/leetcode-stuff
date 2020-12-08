
/*
# At FundingCircle we hold most of our data on Kafka topics (think of these as big lists of messages). For performance reasons we try to keep each message under a certain size (currently 1MB). However, recently we've added a new data source that has a message size that breaks this limit. This means we need to implement some form of data compression.

# After a bit of googling we've come across something we think might work: Run length encoding. Your task is to implement the run-length encoding and decoding functions defined below.

# Some details about Run-length encoding:

# Run-length encoding (RLE) is a simple form of data compression, where runs (consecutive data elements) are replaced by just one data value and count.

# For example we can represent the original 53 characters with only 13.

# "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB"  ->  "12WB12W3B24WB"

# RLE allows the original data to be perfectly reconstructed from the compressed data, which makes it a lossless data compression.

# "AABCCCDEEEE"  ->  "2AB3CD4E"  ->  "AABCCCDEEEE"

# For simplicity, you can assume that the unencoded string will only contain the letters A through Z (either lower or upper case) and whitespace. This way data to be encoded will never contain any numbers and numbers inside data to be decoded always represent the count for the following character.")
*/

//WWWWwW - 4W1w1W

const Mocha = require('mocha');
const assert = require('assert');
const mocha = new Mocha();

class RunLengthEncoding {
  static compress(str) {
    var encodedString = '';
    var i = 0;
    //XYZ
    while(i < str.length) {
      var j = i;
      
      while(j < str.length -1 && str.charAt(j + 1) == str.charAt(i)) {
        j++;  
      }
      if(j != i) {
         encodedString += (j - i + 1).toString() + str.charAt(i);
      } else {
         encodedString += str.charAt(i);
      }
     
      i = j + 1;
    }
    return encodedString;
    
  }
  
  static decompress(str) {
   //3W
    //WR
    var decompressedString = '';
    var i = 0;
    while(i < str.length) {
      var j = i;
      var countAsString = '';
      while(j < str.length - 1 && /\d/.test(str.charAt(j))) {
        countAsString += str.charAt(j); //3
        j++;
      }
      //3W
      var character = str.charAt(j); //W
      if(countAsString != '') {
        var countAsInt =  Number.parseInt(countAsString); //"33"
        var count = 0;
        while(count <  countAsInt) { 
          decompressedString += character.toString(); //WWW
          count++;
        }
      } else {
        decompressedString += str.charAt(i);
      }
      //3W5T
      i = j + 1;
    }
    return decompressedString;
  }
}

mocha.suite.emit('pre-require', this, 'solution', mocha);

let rle = RunLengthEncoding;

describe('RunLengthEncoding', ()=> {
  it('returns empty string if input is empty', ()=> {
    assert.equal(rle.compress(''), '');
  });
  
  it('does not compress the input when it does not contain repeating characters', ()=> {
    assert.equal(rle.compress('XYZ'), 'XYZ');
  });
  
  it('correctly compresses the input string when all of its characters are repeating', ()=> {
    assert.equal(rle.compress('AABBBCCCC'), '2A3B4C');
  });
  
  it('correctly compresses the input when some of its characters are repeating', ()=> {
    assert.equal(rle.compress('WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB'), '12WB12W3B24WB');
  });
  
  it('correctly compresses the input when it contains lower case characters', ()=> {
    assert.equal(rle.compress('aabbbcccc'), '2a3b4c');
  });
  
  it('correctly compresses the input when it contains white spaces', ()=> {
    assert.equal(rle.compress('  hsqq qww  '), '2 hs2q q2w2 ');
  });
  
  it('does not decompress when the input is an empty string', ()=> {
    assert.equal(rle.decompress(''), '');
  });
  
  it('correctly decompresses the input when all of its characters are repeating', ()=> {
   assert.equal(rle.decompress('2A3B4C'), 'AABBBCCCC');
  }); 
  
  it('correctly decompresses the input when some of its characters are repeating', ()=> {
   assert.equal(rle.decompress('10WB12W3B24WB'), 'WWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB');
  });
    
  it('correctly decompresses the input when it contains lower case characters', ()=> {
   assert.equal(rle.decompress('2a3b4c'), 'aabbbcccc');
  });
  
  it('correctly decompresses the input when it contains white spaces', ()=> {
   assert.equal(rle.decompress('2 hs2q q2w2 '), '  hsqq qww  ');
  });
  
  it('returns input when decompressing a compressed string', ()=> {
    let inp = 'zzz ZZ  zZ'
    let compressed = rle.compress(inp)
    
   assert.equal(rle.decompress(compressed), inp);
  });
})


mocha.run();
