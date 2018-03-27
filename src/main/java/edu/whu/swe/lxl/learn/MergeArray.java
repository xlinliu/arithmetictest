package edu.whu.swe.lxl.learn;

public class MergeArray {
    public static void merge(int src[], int boundary,int[] dest) throws Exception {
        int lengthsrc = src.length;
        int lengthDest = dest.length;
        if (lengthDest < lengthsrc)
            throw new Exception("dest is too short");
        if (boundary >= lengthsrc || boundary < 0)
            throw new Exception("boundary is illegal");
        int index = 0, index1 = 0, index2 = boundary;

        while (index1 < boundary && index2 < lengthsrc) {
            if (src[index1] <= src[index2])
                dest[index++] = src[index1++];
            else
                dest[index++] = src[index2++];
        }
        while (index1 < boundary)
            dest[index++] = src[index1++];
        while (index2 < lengthsrc)
            dest[index++] = src[index2++];


    }
}
