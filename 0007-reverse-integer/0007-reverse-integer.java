class Solution {
   public int reverse(int x) {
      
       boolean is_negative = x < 0;
      
       // convert input integer to string
       String x_string = String.valueOf(x);
       if(x_string.charAt(0) == '-') {
           x_string = x_string.substring(1);
       }
      
       // reverse the converted string
       StringBuilder sb = new StringBuilder(x_string);       
       String reversed_x_string = sb.reverse().toString();       
       reversed_x_string = (is_negative ? '-'+reversed_x_string : reversed_x_string);
      
       // convert the reversed string back to a long number
       long reversed_number = Long.parseLong(reversed_x_string);
      
       // return 0 if the reversed number is not within 32-bit integer range
       if(reversed_number > Integer.MAX_VALUE || reversed_number < Integer.MIN_VALUE) {
           return 0;
       }
      
       // return integer version of the number otherwise
       return (int) reversed_number;
   }
}