
// Radix sort Java implementation
 
import java.io.*;
import java.util.*;
 
class RadixSort {
 
    // A utility function to get maximum value in list
    static Earthquake getMax(ArrayList<Earthquake> list)
    {
        Earthquake mx = list.get(0);
        for (int i = 1; i < list.size(); i++)
            if (list.get(i).getDepth() > mx.getDepth())
                mx = list.get(i);
        return mx;
    }
 
    // A function to do counting sort of list according to
    // the digit represented by exp.
    static void countSort(ArrayList<Earthquake> list, int n, int exp)
    {
        Earthquake output[] = new Earthquake[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[((Math.abs((int)list.get(i).getDepth()) / exp)) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[((Math.abs((int)list.get(i).getDepth())) / exp) % 10] - 1] = list.get(i);
            count[((Math.abs((int)list.get(i).getDepth())) / exp) % 10]--;
        }
 
        // Copy the output list to list, so that list now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            list.set(i , output[i]);
    }
 
    // The main function to that sorts list of
    // size n using Radix Sort
    static void radixsort(ArrayList<Earthquake> list, int n)
    {
        // Find the maximum number to know number of digits
        Earthquake maxEarthquake = getMax(list);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; ((int)maxEarthquake.getDepth())/ exp > 0; exp *= 10)
            countSort(list, n, exp);
    }   
    
}

