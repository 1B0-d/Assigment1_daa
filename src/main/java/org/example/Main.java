package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int CUTOFF = 24;

    public static void main(String[] args) {
        int[] n ={3,2,1,4,5,8,6,7,1};
        mergesort(n);
        for(int i=0;i<n.length;i++){
            System.out.print(n[i]);
        }
    }
    public static void mergesort(int[] a){
        if (a.length<=CUTOFF) {
            insertion(a);
            return;
        }
        int mid = a.length/2;
        int [] left=new int [mid];
        int [] right= new int[a.length - mid];
        int j =0;

        for(int i =0;i< a.length;i++){
            if(i<mid){
                left[i]= a[i];
            }
            else{
                right[j]= a[i];
                j++;
            }
        }
        mergesort(left);
        mergesort(right);
        merge(left,right,a);
    }
    public static void merge(int []left,int []right, int[] a){
        int lsize=a.length/2;
        int rsize=a.length-lsize;
        int i=0,l=0,r=0;

        while (l<lsize && r < rsize) {
            if (left[l] < right[r]) {
                a[i] = left[l];
                i++;
                l++;
            } else {
                a[i] = right[r];
                r++;
                i++;
            }
        }
        while(l<lsize){
            a[i]=left[l];
            i++;
            l++;
        }
        while(r<rsize){
            a[i]=right[r];
            r++;
            i++;
        }
    }
    private static void insertion(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int x = a[i], j = i - 1;
            while (j >= 0 && a[j] > x) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = x;
        }
    }
}