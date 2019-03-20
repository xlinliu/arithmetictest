package edu.whu.swe.lxl.learn.string;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceBlank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        int blankNum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                blankNum += 1;
        }
        int originalLength=chars.length;
        int newLength=originalLength+blankNum*2;
        char[] newChars = new char[newLength];
        System.arraycopy(chars,0,newChars,0,chars.length);
        int originalIndex=originalLength-1,
        newIndex=newLength-1;
        while(originalIndex>=0&&newIndex>originalIndex){
            if(chars[originalIndex]==' '){
                originalIndex--;
                newChars[newIndex--] = '0';
                newChars[newIndex--] = '2';
                newChars[newIndex--] = '%';
            }else
            newChars[newIndex--]=chars[originalIndex--];
        }

        System.out.print(String.valueOf(newChars));

    }
}
