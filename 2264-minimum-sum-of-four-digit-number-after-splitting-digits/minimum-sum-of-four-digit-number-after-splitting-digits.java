class Solution {
    public int minimumSum(int num) {
        int[] digits= new int[4];
int i =0;
        while(num!=0){
int ld = num%10;
digits[i]=ld;
i++;
num =num/10;
        }
Arrays.sort(digits);

int new1= digits[0]*10+ digits[2];
int new2 = digits[1]*10 +digits[3];

int ans = new1+new2;
return ans;

    }
}