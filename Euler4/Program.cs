/* Joshua Wyckoff
 * Problem 4: Largest Palindrome Product
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
*/


//Console.WriteLine("Hello, World!");

using System;

namespace Program
{
    class Program
    {
        static void Main(string[] args)
        {
            int palindrome = 0;

            //Goes through all possible products of two 3-digit numbers checking if they are palindromes.
            //If the product is a palindrome and greater than the current largest palindrome, the product becomes the new largest palindrome.
            for (int a = 100; a < 1000; a++)
            {
                for (int b = 100; b < 1000; b++)
                {
                    int product = a * b;
                    if (isPalindrome(product) && product > palindrome) palindrome = product;
                }
            }
            
            //Prints the largest palindrome found
            Console.WriteLine(palindrome);
        }

        //Determines if a number is a palindrome by casting it to a string and comparing the characters outside -> in
        static bool isPalindrome(int number)
        {
            string a = number.ToString();
            for (int i = 0; i < a.Length / 2; i++)
            {
                if (a[i] == a[a.Length - 1 - i])
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
            return true;
        }
    }
}
