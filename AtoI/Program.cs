using System;
using System.Text;

namespace AtoI
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(MyAtoi(" -4000"));
        }

        public static int MyAtoi(string str)
        {
            var trimmedString = str.Trim(' ');
            char[] strToChar = trimmedString.ToCharArray();
            StringBuilder sb = new StringBuilder();
            char[] allowedChars = { '+', '-' };

            foreach (char c in strToChar)
            {
                if ((!allowedChars.Contains(c) && Char.GetNumericValue(c) == -1)
                   || (sb.ToString().Length > 0 && Char.GetNumericValue(c) == -1))
                {
                    break;
                }
                sb.Append(c);
            }

            var possibleNumericStringWithOrWithoutSign = sb.ToString();
            if (!string.IsNullOrEmpty(possibleNumericStringWithOrWithoutSign))
            {
                bool isNegative = possibleNumericStringWithOrWithoutSign.StartsWith("-");
                try
                {

                    return Int32.Parse(possibleNumericStringWithOrWithoutSign);
                }
                catch (System.FormatException ex)
                {
                    return 0;
                }
                catch (System.OverflowException)
                {
                    return isNegative ? Int32.MinValue : Int32.MaxValue;
                }
            }
            return 0;
        }
    }
}
