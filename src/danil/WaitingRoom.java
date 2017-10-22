package danil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static danil.MaxHeapPriorityQueue.MaxHeapInsert;

/**
 * @author Danil Kolesnikov danil.kolesnikov@sjsu.edu
 * CS 146 HW1 Fall 2017
 * Professor: Dr. Mike Wu
 */

public class WaitingRoom {

    static List patients = new ArrayList();

    // addPatient inserts a new patient in the list
    public static void addPatient(String name, int priority){
        Patient patient = new Patient(name, priority);
        MaxHeapInsert(patients,patient);
        System.out.print("Patient was successfully added in the line. Name: "+name+" Patient's priority: "+priority+"\n\nYour input: ");
    }

    // removeMaxPatient removes the patient with the highest priority from the list
    public static void removeMaxPatient(){
        Patient maxPatient = MaxHeapPriorityQueue.HeapExtractMax(patients);
        System.out.print("Patient with highest priority is processed and was removed from the line. Name: "+maxPatient.getName()+" Patient's priority number was: "+maxPatient.getPriority()+"\n\nYour input: ");
    }

    // whoMaxPatient outputs which patient has the highest priority
    public static void whoMaxPatient(){
        Patient patient = MaxHeapPriorityQueue.HeapMaximum(patients);
        System.out.print("The patient with the highest priority is: "+patient.getName()+" Patient's priority is: "+patient.getPriority()+"\n\nYour input: ");
    }

    // sortPatients sorts patients in the increasing order using Heapsort and then rebuild the heap maintaining Max Heap Priority
    public static void sortPatients(List<Patient> list){
        MaxHeapPriorityQueue.Sort(list);
        MaxHeapPriorityQueue.printArray(list);
        MaxHeapPriorityQueue.BuildMaxHeap(list); // We must rebuild the heap
        System.out.print("\n\nYour input: ");
    }

    // Main method that starts the program in the command line
    public static void main(String[] args){
        Patient zero = new Patient("zero",0);
        MaxHeapInsert(patients,zero);

        System.out.print("*** Welcome to the CS146 Hospital! ***\nEnter 1 to add a new patient\nEnter 2 to remove a patient with highest priority from the line\nEnter 3 to see the patient with the highest priority\nEnter 4 to see sorted patients based on their priority\nEnter 5 to exit the program\n\nYour input is: ");
        while(true){
            Scanner reader = new Scanner(System.in);
            int a = reader.nextInt();
            switch(a){
                // Case will call to Add new patient
                case 1: Scanner inputName = new Scanner(System.in);
                    System.out.print("Enter patient's name: ");
                    String name = inputName.next();
                    Scanner inputPriority = new Scanner(System.in);
                    System.out.print("Assign priority: ");
                    int priority = inputPriority.nextInt();
                    WaitingRoom.addPatient(name,priority);
                    break;
                case 2: WaitingRoom.removeMaxPatient();
                    break;
                case 3: whoMaxPatient();
                    break;
                case 4: sortPatients(patients);
                    break;
                case 5: System.out.print("\nClosing the program!");
                    return;
            }
        }
    }




}
