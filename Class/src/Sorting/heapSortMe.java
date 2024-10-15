import java.util.Arrays;

public class heapSortMe {
    public static void main(String[]args){
        int[]arr={3,4,2,5,1,9};
        arr=createHeap(arr);
        System.out.println(Arrays.toString(arr));
        int end=arr.length-1;
        while(end>0){
            swap(arr,0,end);
            downheapyfy(arr,0,end);
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int[] createHeap(int[]arr){
        int[]ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            ans[i]=arr[i];
            upheapyfy(ans,i);
        }
        return ans;
    }
    public static void upheapyfy(int[]ans,int ci){
        int pi=(ci-1)/2;
        // pi is parent index and ci is child index
        if(ans[pi]<ans[ci]){
            swap(ans,pi,ci);
            upheapyfy(ans, pi);
        }
    }
    // for ascending order
    // public static void downheapyfy(int[]ans,int pi,int end){
    //     int lci=2*pi+1;
    //     int rci=2*pi+2;
    //     int idx=pi;
    //     // pi is parent index and lci is left child index rci is right child index
    //     if(lci<end && ans[lci]>ans[idx]){
    //         idx=lci;
    //     }
    //     if(rci<end && ans[rci]>ans[idx]){
    //         idx=rci;
    //     }
    //     if(idx!=pi){
    //         swap(ans,pi,idx);
    //         downheapyfy(ans,idx,end);
    //     }
    // }

    // for descending order
    public static void downheapyfy(int[]ans,int pi,int end){
        int lci=2*pi+1;
        int rci=2*pi+2;
        int idx=pi;
        // pi is parent index and lci is left child index rci is right child index
        if(lci<ans.length && ans[lci]>ans[idx]){
            idx=lci;
        }
        if(rci<ans.length && ans[rci]>ans[idx]){
            idx=rci;
        }
        if(idx!=pi){
            swap(ans,pi,idx);
            downheapyfy(ans,idx,end);
        }
    }
    public static void swap(int[]ans,int i,int j){
        int temp=ans[i];
        ans[i]=ans[j];
        ans[j]=temp;
    }
}
