public class Task {
    
    // Task attributes
    private String taskName;
    private String taskDescription;
    private String taskStatus;
    private String taskDueDate;
    private boolean taskCompleted;

    // Constructor to initialize the Task object
    public Task() 
    {
        this.taskName = "";
        this.taskDescription = "";
        this.taskDueDate = "";
        this.taskStatus = "pending"; // Default status
        this.taskCompleted = false;  // Default not completed
    }
    
    
    
    // Setting up methods to set all data
   public String setTaskName(String taskName)
   {
       this.taskName = taskName;
       return taskName;
   }
   
   public String setTaskDescription(String taskDescription)
   {
       this.taskDescription = taskDescription;
       return taskDescription;
   }
   
   public String setTaskDueDate(String taskDueDate) {
       this.taskDueDate = taskDueDate;
       return taskDueDate;
   }
   
   public void setTaskStatus(String taskStatus)
   {
       this.taskStatus = taskStatus;
   }
   
      public void setTaskCompleted()
   {
        this.taskCompleted = true;
        this.taskStatus = "Completed";
   }
   
      
    // Setting up methods to get all data
   public String getTaskName()
   {
       return taskName;   
   }
   
   public String getTaskDescription()
   {
       return taskDescription;
   }
   
   public String getTaskDueDate()
   {
       return taskDueDate;
   }
   
   public boolean isTaskCompleted()
   {
       return taskCompleted;
   }
   
   public String toString() {
       String taskDetails = "Task name: " + this.getTaskName() + 
            "\nTask Description: " + this.getTaskDescription() + "\nTask due date: " 
            + this.getTaskDueDate() + "\nTask status: " + this.isTaskCompleted();
       return taskDetails;
   }
   
    
} //end of Task Class
