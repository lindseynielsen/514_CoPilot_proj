public class RecursionHelper {
    /** Self Explanation - Remember to detail your base and recursive cases.
     * 
     * 
     * 
     */
    public String reverseString(String str) {
        if(str.length() == 1) {
            return str;
        } else {
            return str.substring(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
        }
        //TODO: Student
    }
    /** Self Explanation - Remember to detail your base and recursive cases.
     * 
     * 
     * 
     */
    public int armstrongNumber(int num, int total) {
        if(num == 0) {
            return total;
        } else {
            int digit = num % 10;
            return armstrongNumber(num / 10, total + (digit * digit * digit));
        }
        //TODO: Student
    }
    /** Self Explanation - Remember to detail your base and recursive cases.
     * 
     * 
     * 
     */
    public boolean palindromeChecker(String str) {
        if(str.length() == 1 || str.length() == 0) {
            return true;
        } else if(str.charAt(0) == str.charAt(str.length() - 1)) {
            return palindromeChecker(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
        //TODO: Student
    }
}