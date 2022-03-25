package leetcode;

public class Leetcode_43 {
    public String multiply(String num1, String num2) {
        int carry = 0;
        int base = -1;
        String res = "";
        for(int i=num1.length()-1;i>=0;i--){
            int a = num1.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            for(int j=num2.length()-1;j>=0;j--){
                int b = num2.charAt(j) - '0';
                int tmp = a * b + carry;
                if(tmp >= 10){
                    carry = tmp / 10;
                    tmp -= carry * 10;
                }else{
                    carry = 0;
                }
                sb.insert(0, tmp);
            }
            if(carry!=0) sb.insert(0, carry);
            base ++;
            for(int k=0;k<base;k++){
                sb.append('0');
            }
            res = addOne(sb.toString(), res);
        }
        return res;
    }

    public String addOne(String nums1, String nums2){
        int carray = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < nums1.length() || i < nums2.length()){
            int a = 0;
            int b = 0;
            if(i<nums1.length()) a = nums1.charAt(nums1.length() - i - 1) - '0';
            if(i<nums2.length()) b = nums2.charAt(nums2.length() - i - 1) - '0';
            int tmp = a + b + carray;
            if(tmp >= 10){
                tmp -= 10;
                carray = 1;
            }else{
                carray = 0;
            }
            sb.insert(0,tmp);
            i++;
        }
        if(carray!=0) sb.insert(0, carray);
        return sb.toString();
    }
}
