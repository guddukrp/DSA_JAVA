class Solution {
    public boolean isPalindrome(String s) {

        //first remove non-alphanumric chars and convert string to lowercase.
        //then compare the first char with last char 
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                temp = temp + ch;
                // temp = temp + Character.toLowerCase(ch);
            }
        }
        temp = temp.toLowerCase(); //
        int left = 0, right = temp.length() - 1;
        while (left < right) {
            if (temp.charAt(left) != temp.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}