package danil;

import java.util.*;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW1 Fall 2017
 * Professor: Dr. Mike Wu
 */

public class MaxHeapPriorityQueue {

    public static int heapSize; // Maintains the size of the Heap data structure

    /* BuildMaxHeap procedure O(n), produces a max heap from an unordered array.*/
    public static void BuildMaxHeap(List<Patient> A){
        heapSize=A.size();
        for(int i=heapSize/2;i>=1; i--){
            MaxHeapify(A,i);
        }
    }

    /* MaxHeapify O(logn) procedure, maintains the max-heap property - the parent needs to be greater than its children. */
    public static void MaxHeapify(List<Patient> A, int i){
        int largest;
        int left = 2*i;
        int right = 2*i+1;

        if (left <=heapSize-1  && A.get(left).getPriority() > A.get(i).getPriority()) {
            largest = left;
        }
        else{
            largest = i;
        }
        if (right <= heapSize-1 && A.get(right).getPriority() > A.get(largest).getPriority()){
            largest = right;
        }
        if (largest!=i){
            Collections.swap(A,i,largest);
            MaxHeapify(A,largest);
        }

    }

        /*The MAX-HEAP-INSERT, HEAP-EXTRACT-MAX, HEAP-INCREASE-KEY, and HEAP-MAXIMUM procedures, which all run O(logn) time, allow the heap data structure to implement a priority queue.*/

    /* HeapExtractMax O(logn) method provides the user with ability to extract the node with the highest priority - while maintaining MaxHeapify */
    public static Patient HeapExtractMax(List<Patient> A){
        if(heapSize==1){
            System.out.print("\nThere is only one patient in the line!");
            Patient last = A.get(0);
            A.remove(0);
            heapSize--;
            return last;
        }
        if(heapSize<1){
            System.out.print("Heap underflow");
            Patient error = new Patient("error",666);
            return error;
        }
        Patient max = A.get(1);
        A.set(1,A.get(heapSize-1));
        A.remove(heapSize-1);
        heapSize--;
        MaxHeapify(A,1);

        return max;
    }

    /* MaxHeapInsert method procedure provides the user with ability to insert a new node in the heap while maintaining MaxHeap structure*/
    public static void MaxHeapInsert(List<Patient> A, Patient key){
        heapSize++;
        A.add(key);
        HeapIncreaseKey(A,A.size()-1,key);
    }

    /* HeapIncreaseKey is used by MaxHeapInsert method in order to set the key of this new node to its correct value and maintain the Max Heap priority r */
    public static void HeapIncreaseKey(List<Patient> A, int i, Patient key){
        if(key.getPriority()<A.get(i).getPriority()){
            System.out.print("New key is smaller than current key! ");
        }
        //A.get(i).setPriority(key.getPriority());
        while(i>1 && A.get(i/2).getPriority() < A.get(i).getPriority()){
            Collections.swap(A,i/2,i);
            i = i/2;
        }
    }
    /* HeapMaximum method returns the node with the highest priority */
    public static Patient HeapMaximum(List<Patient> A){
        if(heapSize==0){
            System.out.print("The line is empty! ");
            Patient empty = new Patient("empty",0);
            return empty;
        }
        if(heapSize==1){
            return A.get(0);
        }
        else{
            return A.get(1);
        }
    }

    // printArray returns the List in a user friendly form
    public static void printArray(List<Patient> A){
        System.out.print("\n");
        for(int l=1;l<A.size();l++){
            String name = A.get(l).getName();
            int priority = A.get(l).getPriority();
            System.out.print(name+" "+priority+"; ");
        }
    }

    // Heapsort algorithm to sort unordered array
    public static void Sort(List<Patient> A){
        BuildMaxHeap(A);
        for(int i=heapSize-1; i>1; i--){
            Collections.swap(A,1,i);
            heapSize--;
            MaxHeapify(A,1);
        }
    }

    // printTree method print a heap in a user friendly form
    public static void printTree(List<Patient> A){
        Iterator<Patient> iterator = A.iterator();
        int i = 0;
        double levelSize = 0;
        while (iterator.hasNext()) {
            if (i == 0) {
                iterator.next();
                i++;
            }
            else {
                while (levelSize < 5) {
                    boolean tab = true;
                    double max = Math.pow(2,levelSize); // Math.sqrt() and a*a DON"T work - why?
                    while (i < max * 2 && i < 21 && iterator.hasNext()) {
                        if(levelSize == 0) {
                            System.out.print("\t\t\t\t\t\t\t");
                        }
                        if(levelSize == 1 && tab){
                            System.out.print("\t\t\t\t\t\t");
                            tab = false;
                        }
                        if(levelSize == 2 && tab){
                            System.out.print("\t\t\t\t\t");
                            tab = false;
                        }
                        Patient sample = iterator.next();
                        System.out.print(" "+sample.getPriority() + " ("+sample.getName()+")");
                        i++;
                    }
                    levelSize++;
                    System.out.println();
                    System.out.println();
                }

            }
        }
    }

    // Main method that starts the program in the command line
    public static void main(String[] args) {
        List patients = new ArrayList();

        Patient zero = new Patient("zero",0); // Dummy object to fill index 0 of the array
        Patient danil = new Patient("Danil",(int)(Math.random() * 100));
        Patient minh = new Patient("Minh",(int)(Math.random() * 100));
        Patient mike = new Patient("Dr. Mike",(int)(Math.random() * 100));
        Patient laura = new Patient("Laura",(int)(Math.random() * 100));
        Patient alina = new Patient("Alina",(int)(Math.random() * 100));
        Patient pranav = new Patient("Pranav",(int)(Math.random() * 100));
        Patient ari = new Patient("Ari",(int)(Math.random() * 100));
        Patient heather = new Patient("Heather",(int)(Math.random() * 100));
        Patient jesse = new Patient("Jesse",(int)(Math.random() * 100));
        Patient sheila = new Patient("Sheila",(int)(Math.random() * 100));
        Patient insert = new Patient("John",(int)(Math.random() * 100));
        Patient insert2 = new Patient("Samantha",(int)(Math.random() * 100));
        Patient mila = new Patient("Mila",(int)(Math.random() * 100));
        Patient bex = new Patient("Rebecca",(int)(Math.random() * 100));
        Patient jeff = new Patient("Jeff",(int)(Math.random() * 100));
        Patient hailey = new Patient("Hailey",(int)(Math.random() * 100));
        Patient kelly = new Patient("Kelly",(int)(Math.random() * 100));
        Patient isaac = new Patient("Isaac",(int)(Math.random() * 100));
        Patient ahmed = new Patient("Ahmed",(int)(Math.random() * 100));
        Patient vidya = new Patient("Prof. Vidya",(int)(Math.random() * 100));

        //Insert objects in the array using MaxHeapInsert method
        MaxHeapInsert(patients,zero);
        MaxHeapInsert(patients,danil);
        MaxHeapInsert(patients,minh);
        MaxHeapInsert(patients,mike);
        MaxHeapInsert(patients,laura);
        MaxHeapInsert(patients,pranav);
        MaxHeapInsert(patients,ari);
        MaxHeapInsert(patients,alina);
        MaxHeapInsert(patients,jesse);
        MaxHeapInsert(patients,heather);
        MaxHeapInsert(patients,sheila);
        MaxHeapInsert(patients,mila);
        MaxHeapInsert(patients,bex);
        MaxHeapInsert(patients,jeff);
        MaxHeapInsert(patients,hailey);
        MaxHeapInsert(patients,kelly);
        MaxHeapInsert(patients,isaac);
        MaxHeapInsert(patients,ahmed);
        MaxHeapInsert(patients,vidya);

        System.out.print("Array with random priority numbers: ");
        printArray(patients);
        BuildMaxHeap(patients);
        System.out.print("\n\nHeap after BuildMaxHeap: \n");
        printTree(patients);
        Patient max = HeapMaximum(patients);
        System.out.print("Patient with highest priority is: "+max.getName()+" Patient's priority: "+max.getPriority()+" Patient is still in the line!\n\n");
        Patient maxPriority = HeapExtractMax(patients);
        System.out.print("Extract Patient with the highest priority is: "+maxPriority.getName()+". Patient's priority is: "+maxPriority.getPriority());
        System.out.print("\nHeap after HeapExtractMax: \n");
        printTree(patients);
        MaxHeapInsert(patients,insert);
        System.out.print("\nHeap after inserting: "+insert.getName()+". Patient's priority: "+insert.getPriority()+"\n\n");
        printTree(patients);
        System.out.print("\nArray after Sort: ");
        Sort(patients);
        printArray(patients);
        System.out.print("\n\nHeap after BuildMaxHeap again: \n");
        BuildMaxHeap(patients);
        printTree(patients);
        System.out.print("\nHeap after inserting: "+insert2.getName()+". Patient's Priority: "+insert2.getPriority()+"\n");
        MaxHeapInsert(patients,insert2);
        printTree(patients);
        System.out.print("\nArray after Sort: ");
        Sort(patients);
        printArray(patients);

    }
}