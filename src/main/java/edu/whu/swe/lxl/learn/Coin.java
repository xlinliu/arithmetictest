package edu.whu.swe.lxl.learn;

public class Coin {
    public static void main(String[] args) {
        int n = 2;
        int count=function(n);
        System.out.print(count);
    }



    static int function( int n) {

        int i=0;
        int j=0;
        if(n%2!=0)
            ++j;
        int _n=n>>1;
        while(_n!=0){
            ++i;
            if(_n%2!=0)
                ++j;
            _n=_n>>1;
        }
        ++i;
        --j;
        return i-j;


    }

}
