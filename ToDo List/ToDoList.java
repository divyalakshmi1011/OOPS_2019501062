import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.Collections;   

public class ToDoList {
    Task taskArray[];
    int taskCount;
    public ToDoList()
    {
        taskArray=new Task[10];
        taskCount=0;
    }

    public void addTask(Task task)
    {
        this.taskArray[taskCount]=task;
        taskCount++;
        System.out.println(taskCount);
        System.out.println(taskArray[taskCount-1]);
    }

    public void removeTask(String taskname) {
        for(int i = 0; i < taskCount; i++) {
            if(taskArray[i].getTaskName().equals(taskname)) {
                for(int j = i+1; j < taskCount; j++) {
                    taskArray[i] = taskArray[j];
                    i++;
                }
                taskArray[taskCount] = null;
                taskCount--;
                System.out.println(taskCount);
                System.out.println(taskArray[taskCount+1]);
            }
        }
    }
    public void updateTaskStatus(String taskname,String taskStatus)
    {
        for(int i=0; i < taskCount;i++)
        {
            if(taskArray[i].getTaskName() == taskname)
            {
                taskArray[i].statusOfTask = taskStatus;
            }
        }
    }
    public void displayPendingTasks(Task []taskArray)
    {
        for(int i=0; i<taskCount ;i++)
        {
            if(taskArray[i].getStatusOfTask().equals("pending"))
            {
                System.out.println(taskArray[i]);
            }
        }
    }
    public void displayTasksDate(Task[] taskArray, String dueDate)
    {
        for(int i=0; i < taskCount; i++)
        {
            if(taskArray[i].getDueDate().equals(dueDate))
            {
                System.out.println(taskArray[i]);

            }
        }
    }
    public Task returnTaskName(Task[] taskArray,String taskname)
    {
        for(int i=0; i<taskCount ;i++)
        {
            if(taskArray[i].getTaskName().equals(taskname))
            {
                return taskArray[i];
            }
        }
        return null;
    }
    public ArrayList<Task> overdueTasks(Task[] taskArray)
    {
        ArrayList<Task> overdueList = new ArrayList<Task>(10); 
        for(int i=0; i < taskCount; i++)
        {
            if(taskArray[i].getStatusOfTask().equals("overdue"))
            {
                overdueList.add(taskArray[i]);
            }
        }
            return overdueList;
    }
    public void displayAllTasks(Task[] taskArray)
    {
        for(int i=0; i < taskCount; i++)
        {                
           System.out.println(taskArray[i]);
        }
    }
    public static void main (String []args) {
        ToDoList L1 = new ToDoList();
        Task task1=new Task("cleaning","windows and corridors"," 20/9/2019","pending");
        Task task2=new Task("mopping","all floors","21/4/2019","overdue");
        System.out.println(task1);
        L1.addTask(task1);
        L1.addTask(task2);
        L1.removeTask("mopping");
    }
}
