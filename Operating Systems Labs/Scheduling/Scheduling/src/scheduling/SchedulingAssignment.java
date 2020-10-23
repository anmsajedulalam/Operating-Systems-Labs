/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduling;

import java.util.Scanner;

public class SchedulingAssignment {

    private static int i = 0;
    private static int x = 5;
    private static int turnaround = 0;
    private static String[] ArrayProcess = new String[x];
    private static int[] burstTimeArray = new int[x];
    private static int[] priorityArray = new int[x];

    SchedulingAssignment() {
        i = 0;
        new Task1("A", 10, 3);
        new Task2("B", 6, 5);
        new Task3("C", 2, 2);
        new Task4("D", 4, 1);
        new Task5("E", 8, 4);
    }

    SchedulingAssignment(String process, int burstTime, int priority) {
        ArrayProcess[i] = process;
        burstTimeArray[i] = burstTime;
        priorityArray[i] = priority;
        i++;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("turnaround time for RR");
        turnaround = scanner.nextInt();
        System.out.println();
        System.out.println("**********ROUND ROBIN**********");
        new SchedulingAssignment();
        roundRobin();

        System.out.println("**********ROUND ROBIN ENDS**********");
        System.out.println();
        System.out.println("**********PRIORITY**********");
        new SchedulingAssignment();
        priorityScheduling();
        System.out.println("**********PRIORITY ENDS**********");
        System.out.println();
        System.out.println("**********FCFS**********");
        new SchedulingAssignment();
        firstComeFirstServe();
        System.out.println("**********FCFS ENDS**********");
        System.out.println();
        System.out.println("**********SJF**********");
        new SchedulingAssignment();
        sjf();
        System.out.println("**********SJF ENDS**********");
    }

    private static void sjf() {
        for (int i = 0; i < burstTimeArray.length; i++) {
            for (int j = 1; j < (burstTimeArray.length - i); j++) {
                if (burstTimeArray[j - 1] > burstTimeArray[j]) {
                    int tempBurstTime = burstTimeArray[j - 1];
                    burstTimeArray[j - 1] = burstTimeArray[j];
                    burstTimeArray[j] = tempBurstTime;
                }
            }
        }
        firstComeFirstServe();
    }

    private static void firstComeFirstServe() {
        int count = 0;
        for (int j = 0; j < burstTimeArray.length; j++) {
            count += burstTimeArray[j];
            System.out.println(ArrayProcess[j] + " : " + count);
        }
    }

    private static void priorityScheduling() {
        for (int i = 0; i < burstTimeArray.length; i++) {
            for (int j = 1; j < (burstTimeArray.length - i); j++) {
                if (priorityArray[j - 1] < priorityArray[j]) {
                    int tempPriority = priorityArray[j - 1];
                    priorityArray[j - 1] = priorityArray[j];
                    priorityArray[j] = tempPriority;

                    int tempBurstTime = burstTimeArray[j - 1];
                    burstTimeArray[j - 1] = burstTimeArray[j];
                    burstTimeArray[j] = tempBurstTime;

                    String tempProcess = ArrayProcess[j - 1];
                    ArrayProcess[j - 1] = ArrayProcess[j];
                    ArrayProcess[j] = tempProcess;
                }
            }
        }
        firstComeFirstServe();
    }

    private static void roundRobin() {
        int sumBurstTime = 0;
        int countLastTime = 0;
        for (int j = 0; j < burstTimeArray.length; j++) {
            sumBurstTime += burstTimeArray[j];
        }
        int array = 0;
        for (int j = 0; j < sumBurstTime; j++) {
            if (burstTimeArray[array] != 0) {
                for (int k = 0; k < turnaround; ++k) {
                    burstTimeArray[array] -= 1;
                    countLastTime += 1;
                    if (burstTimeArray[array] == 0) {
                        break;
                    }
                }
                if (burstTimeArray[array] == 0) {
                    System.out.println(ArrayProcess[array] + " : " + countLastTime);
                }
            }
            array++;
            if (array == burstTimeArray.length) {
                array = 0;
            }
        }
    }
}

class Task1 {

    Task1(String process, int burstTime, int priority) {
        new SchedulingAssignment(process, burstTime, priority);
    }
}

class Task2 {

    Task2(String process, int burstTime, int priority) {
        new SchedulingAssignment(process, burstTime, priority);
    }
}

class Task3 {

    Task3(String process, int burstTime, int priority) {
        new SchedulingAssignment(process, burstTime, priority);
    }
}

class Task4 {

    Task4(String process, int burstTime, int priority) {
        new SchedulingAssignment(process, burstTime, priority);
    }
}

class Task5 {

    Task5(String process, int burstTime, int priority) {
        new SchedulingAssignment(process, burstTime, priority);
    }
}
