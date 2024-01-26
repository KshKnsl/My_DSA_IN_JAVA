import java.util.*;
public class Sorting
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size : ");
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter "+(i+1)+"th element : ");
            arr[i]=sc.nextInt();
        }
        System.out.println("Original Array : "+Arrays.toString(arr));
        //cycle_sort(arr);
        quick_sort(arr,0,arr.length-1);
        System.out.println("Sorted Array   : "+Arrays.toString(arr));
        sc.close();
    } 

    static void swap(int[] arr, int first, int second) 
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int getMaxIndex(int[] arr, int start, int end) 
    {
        int max = start;
        for (int i = start; i <= end; i++)
            if (arr[max] < arr[i])
                max = i;
        return max;
    }

    static void bubble(int[] arr) 
    {
        boolean swapped;
        // run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            // for each step, max item will come at the last respective index
            for (int j = 1; j < arr.length - i; j++) {
                // swap if the item is smaller than the previous item
                if (arr[j] < arr[j-1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular value of i, it means the array is sorted hence stop the program
            if (!swapped)      break;
        }
    }

    static void selection(int[] arr) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            // find the max item in the remaining array and swap with correct index
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    static void insertion(int[] arr) 
    {
        for (int i = 0; i < arr.length - 1; i++) 
        {
            for (int j = i+1; j > 0; j--) 
                if (arr[j] < arr[j-1]) 
                    swap(arr, j, j-1);
                else
                    break;
        }
    }

    static void cycle_sort(int[] arr) 
    {
        for(int i=0;i<arr.length;) 
        {   int correct = arr[i] - 1;
            if(arr[i]!=arr[correct])     swap(arr, i , correct);
            else    i++;
        }
    }

    static int[] merge_sort(int arr[])
    { 
        if(arr.length==1)   return arr;
        int mid=arr.length/2;
        int left[] = merge_sort(Arrays.copyOfRange(arr, 0, mid));
        int right[] = merge_sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left,right);
    }

    static int[] merge(int left[],int right[])
    {
        int a=0,b=0,k=0,res[]=new int[left.length+right.length];
        while(a!=left.length&&b!=right.length)
        {
            if(right[b]>left[a])    res[k++]=left[a++];
            else                    res[k++]=right[b++];
        }
        while(a!=left.length)       res[k++]=left[a++];
        while(b!=right.length)      res[k++]=right[b++];
        return res;
    }

    static void quick_sort(int arr[],int low,int high)
    {
        if(low >= high)        return;
        int s=low,e=high,m=s+(e-s)/2;
        int pivot=arr[m];
        while(s<=e) 
        {
            // also a reason why if its already sorted it will not swap
            while(arr[s] < pivot)     s++;
            while(arr[e] > pivot)     e--;

            if(s<=e) 
            {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;     e--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        quick_sort(arr, low, e);
        quick_sort(arr, s, high);
    }
    static void countSort(int[] array) 
    {
        if(array == null || array.length <= 1)    return;
        int max = array[0];
        for(int num : array) 
        {
            if(num > max)       max = num;
        }
        int[] countArray = new int[max + 1];
        for(int num : array) 
        {
            countArray[num]++;
        }
    
        int index = 0;
        for(int i=0; i<= max; i++)
            while(countArray[i] > 0) 
            {
                array[index] = i;
                index++;
                countArray[i]--;
            }
        
      }
    
    public static void countSortHash(int[] arr) 
    {
        if(arr == null || arr.length <= 1)          return;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : arr) 
        {
          countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
    
        int index = 0;
        for(int i=min; i<=max; i++) 
        {
            int count = countMap.getOrDefault(i, 0);
            for(int j=0; j < count; j++) 
                arr[index++] = i;
        }
    }

    public static void radixSort(int[] arr) 
    {
        int max = Arrays.stream(arr).max().getAsInt();
        // do count sort for every digit place
        //loop till no of digits in the max number
        for(int exp = 1; max/exp > 0; exp *= 10)
          radix_countSort(arr, exp);
       
    }
    static void radix_countSort(int[] arr, int exp) 
    {
        int n = arr.length;
        int[] output = new int[n],freq= new int[10];
        Arrays.fill(freq, 0);
    
        for(int i=0; i<n; i++)
          freq[(arr[i] / exp) % 10]++;
    
        System.out.println("\nCount array for " + exp + " : " + Arrays.toString(freq));
        for(int i=1; i<10; i++)
          freq[i] =freq[i] +freq[i-1];
        System.out.println("Updated count array " + Arrays.toString(freq));
    
        for(int i=n-1; i>=0; i--)
        {
          output[freq[(arr[i] / exp) % 10] - 1] = arr[i];
          freq[(arr[i] / exp) % 10]--;
        }
        System.out.println("Output array " + Arrays.toString(output));
        System.arraycopy(output, 0, arr, 0, n);
    }  
}