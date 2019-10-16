public class Task {
    String taskName;
    String taskDescription;
    String dueDate;
    String statusOfTask;
    
    public Task(String taskName, String taskDescription, String dueDate, String statusOfTask) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.statusOfTask = statusOfTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatusOfTask() {
        return statusOfTask;
    }

    public void setStatusOfTask(String statusOfTask) {
        this.statusOfTask = statusOfTask;
    }


    public String toString() {
        return "{ taskStatus = "+this.getStatusOfTask()+", duedata = "+this.getDueDate()+", taskname = "+this.getTaskName()+", taskdescription = "+this.getTaskDescription() +"}";
    }
    public static void main (String[] args)
    {
        Task tdl=new Task("cleaning","clean the windows and corridors","12/3/2019","pending");

        System.out.println(tdl);
    }
}
