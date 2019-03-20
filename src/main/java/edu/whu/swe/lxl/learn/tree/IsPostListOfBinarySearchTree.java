package edu.whu.swe.lxl.learn.tree;

public class IsPostListOfBinarySearchTree {
    public static void main(String[] args){
        int[] array={3,1};
        boolean isPostListBT=isPostListBT(array,0,array.length-1);
        assert isPostListBT;
    }
    public static boolean isPostListBT(int[] array, int left, int right) {

        if (left > right )
            return true;
        int root = array[right];
        int mid = left;
        for (; mid < right; mid++) {
            if (array[mid] > root) {
                break;
            }
        }
        for (int i=mid; i < right; i++) {
            if (array[i] < root)
                return false;
        }
        boolean isleftBT = true,
                isrightBT = true;
        if(mid>left)
            isleftBT= isPostListBT(array,left,mid-1);
        if(mid<right)
            isPostListBT(array,mid,right-1);
        return isleftBT&&isrightBT;

    }
}
