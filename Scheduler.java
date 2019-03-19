/*

========= *** TASK DESCRIPTION *** ===

important/soon: high impact immediate tasks e.g. homework
important/not soon: long-term tasks which will inevitably impact your success. Long term projects, studying, etc.
not important/soon: delegateable tasks. tasks which can be completed during fixed work or less than 15 minutes e.g. planning a weekend trip
not important/not soon: thankless jobs which have no direct impact on your quality of life e.g. purchasing luxury items


Make a program which will be an automatic scheduler based off of inputs. There are two types of work, variable work
and static work. Work which is static is thing like meetings or work. Variable work are tasks like homework.
Variable work should be scheduled using a priority queue based off of factors such as how soon a task is and
the importance of the task. (think the 2x2 grid of importance vs time).

The program should
1. read in a task
2. sort the task into one of two PQs. Important vs non-important tasks
3. for the important task PQ, how soon a task is due will determine its order. for non-important task PQ, how long a task takes will determine its order
4. after both PQs are sorted, they will be joined into a queue where each index of the queue will represent an hour.
5. The fixed tasks should already be in the queue such that the tasks are ordered around them.
   There should be suggestions to do not important/soon tasks within fixed tasks

========= *** OUTPUT REQUIREMENTS *** ===

This program should be able to take input from a textfile and output to a textfile

When printing out it should print out my daily schedule so work, homework order, what time I should do those things.


========= *** TERM DEFINITIONS *** ===
(meal times should be a maybe). Variable work is anything you have control over.
Fixed work is a daily habit or something you don't have control over e.g. meal times, club meetings, exercise times

Important Work: any work where it has a direct influence on your goals (whether long or short term).
                any work where others may be dependent on you

Non-important work: any work which does not have a direct influence on your goals
                    any work where if you are in a group, they are NOT dependent on you. any delegatable task



========= *** TROUBLE SHOOTING THOUGHTS *** ===

The trouble will be translating from the PQ to a daily schedule because PQ will be for variable tasks like homework
but for more static tasks like work those will be immovable so I should first arrange the tasks into order using the PQ
and then when moving them into an output schedule I'll need to put them around a daily task

When moving from PQs to a normal array it's possible to set the array indexes as arrays to help get around setting times


========= *** TO-DO LIST *** ===

TODO Create the formula which will evaluate variable work against each other
https://stackoverflow.com/questions/12917372/priority-queues-of-objects-in-java
https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html
https://beginnersbook.com/2013/12/java-string-compareto-method-example/
https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/

first sort in the PQ by if the task is important then sort by how soon the task is due.
can seperate this into two different PQs, one for tasks which are important and then tasks which are't important
and then within each PQ sort by due date. then join the two PQs back together into a queue


TODO Create file input read methods
https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html


*/


//package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.PriorityQueue;


public class Scheduler {

    private static class Task { //creates individual tasks
        private String name; //name of the task
        private String important; //importance of task. use string because it's based off of
        private int days; //in how many days is the task due. 1 day means tomorrow.
        private double hours; //how many hours the task will take.

        public Task (String name, String important, int days, double hours) { //Task constructor
            this.name = name;
            this.important = important;
            this.days = days;
            this.hours = hours;
        }

        /*
        gets how long the task will take
        getting importance doesn't matter because once a task is input it will go into two different PQs of important vs not important PQ
        within these PQs the only values which matter are how long the task takes
        */
        public double gethours(Task a) {
            return a.hours;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        //creates PQs
        PriorityQueue<Task> urgent = new PriorityQueue<Task>(); //creates the two new priority queues
        PriorityQueue<Task> notUrgent = new PriorityQueue<Task>();

        //creates file input
        //File file = new File("/Users/hangwong/IdeaProjects");
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) { //reads input from scanner
            //gets the values needed to create a new task
            String name = sc.next();
            String priority = sc.next();
            int days = sc.nextInt();
            double hours = sc.nextDouble();
            Task task = new Task(name, priority, days, hours); //constructs new task to be added into PQs



            if(task.important.equals("important")) { //sorts the Task into the proper queue
                urgent.add(task);
            }

            else {
                notUrgent.add(task);
            }

            //now need to get the urgent PQ to sort along days and the nonUrgent PQ to sort along hours



        }





    }

    //this will return if the task is important. This goes into the forloop
    public boolean sortImportance(Task a) {
        return a.important == "yes";
    }

    /*
    meant to test how many hours a task wil take vs another one. this may be irrelevant if they're in PQs

    public double compareHours (Task a, Task b) { //returns int value because
        return a.gethours().compareTo(b.gethours());
    }
    */



}
