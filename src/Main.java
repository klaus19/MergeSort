public class Main {

    //nlogn
    public static void divide(int []arr, int si,int li){

        if (si>=li){
            return;
        }

         int mid = si+(li-si)/2;

         divide(arr,si,mid);
         divide(arr,mid+1,li);
         conquer(arr,si,mid,li);

    }

    private static void conquer(int[] arr, int si, int mid, int li) {
               int []merge = new int[li-si+1];

               int indx1 = si;
               int indx2 = mid+1;
               int x=0;

               //O(n)
               while (indx1<=mid && indx2<=li){
                   if (arr[indx1]<=arr[indx2]){
                       merge[x++] = arr[indx1++];
                   }else {
                       merge[x++]=arr[indx2++];
                   }
               }

               while (indx1<=mid){
                   merge[x++] = arr[indx1++];
               }

               while (indx2<=li){
                   merge[x++] = arr[indx2++];
               }

               for (int i=0,j=si;i< merge.length;i++,j++){
                   arr[j]=merge[i];
               }

    }


    public static void main(String[] args) {
        int []arr = new int[]{6,3,9,5,2,8};
        int n = arr.length;


        divide(arr,0,n-1);

        for (int i=0;i<n;i++){
            System.out.println(arr[i]+"");
        }
        System.out.println();
    }
}