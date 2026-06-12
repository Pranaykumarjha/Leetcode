class Solution {
public:
    bool isPalindrome(int x) {
        int d ; double s=0;
        int x1=x;
        while(x>0)
        {
            d = x%10;
            s = s*10 + d;
            x = x/10;
        }
        if(s==x1)
        {
            return true ;
        }
        else
        {
            return false;
        }
        
    }
};