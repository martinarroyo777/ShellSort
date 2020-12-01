package com.company;

/**
 * Implementation of Shell Sort algorithm for study of Data Structures and Algorithms
 *
 * Time Complexity: varies, but worst case is O(n^2)
 * Type of Sort: Unstable Sort
 */
public class Main {

    public static void main(String[] args) {
        int [] intArray = {20,35,-15,7,55,1,-22};
        printArray(intArray);
        System.out.println("---------------------------");
        shellSort(intArray);
        printArray(intArray);
    }
    // Shell Sort

    /*
        The basic idea behind this algorithm is to use a gap interval to reduce the amount
        of shifting required by something like insertion sort.

        The gap is commonly calculated using the Knuth sequence ( (3^k-1)/2 ) where the derived
        value is less than the array length. However, we will just keep halving the array length until
        we get to a value less than 1.

        The outer loop keeps track of our gap interval. The inner loop goes through the array,
        making comparisons (depending on the current gap), and shifting elements as needed.

        Inside our inner loop we first store the element located at the current gap position in newElement.
        Then we create a variable which will be used to traverse the array and make our comparisons. This
        variable will be the same as our current gap.

        Then we will compare the value at the current loop index with the value at the current index - gap.
        While this displacement is greater than or equal to the gap itself, and the newElement value is smaller
        than the current element, we will perform a shift.

        This essentially continues until the gap is less than 1. At that point the array will be sorted, since
        it essentially becomes an insertion sort.

     */
    public static void shellSort(int [] array){
        for (int gap=array.length/2; gap > 0; gap /= 2){
            for (int i=gap; i < array.length; i++){
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j-gap] > newElement){
                    array[j] = array[j-gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }
    // method to print array
    public static void printArray(int [] array){
        for (int i=0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
