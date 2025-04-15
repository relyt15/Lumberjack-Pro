package com.mycompany.lumberjack_pro;


import java.util.ArrayList;

public class Project {
    
    // Project attributes
    private String projectName;
    private String projectDescription;
    private String projectStatus;
    private String projectDueDate;
    private boolean projectCompleted;
    ArrayList<Task> tasksInProject = new ArrayList<Task>();

    // Constructor to initialize the Project object
    public Project() 
    {
        this.projectName = "";
        this.projectDescription = "";
        this.projectDueDate = "";
        this.projectStatus = "pending"; // Default status
        this.projectCompleted = false;  // Default not completed
    }
    
    // Setting up methods to set all data
   public String setProjectName(String projectName)
   {
       this.projectName = projectName;
       return projectName;
   }
   
   public String setProjectDescription(String projectDescription)
   {
       this.projectDescription = projectDescription;
       return projectDescription;
   }
   
   public String setProjectDueDate(String projectDueDate) {
       this.projectDueDate = projectDueDate;
       return projectDueDate;
   }
   
   public void setProjectStatus(String projectStatus)
   {
       this.projectStatus = projectStatus;
   }
   
      public void setProjectCompleted()
   {
        this.projectCompleted = true;
        this.projectStatus = "Completed";
   }
   
      
    // Setting up methods to get all data
   public String getProjectName()
   {
       return projectName;   
   }
   
   public String getProjectDescription()
   {
       return projectDescription;
   }
   
   public String getProjectDueDate()
   {
       return projectDueDate;
   }
   
   public boolean isProjectCompleted()
   {
       return projectCompleted;
   }
   
   public ArrayList<Task> getTasks() {
    return tasksInProject;
}
   
   // methods to add and remove tasks from this project's tasksInProject list
   public void addTaskToProject(Task task) {
        tasksInProject.add(task);
    }
   
   public void removeTaskFromProject(Task task) {
        tasksInProject.remove(task);
   }
   
   @Override
   public String toString() {
       String ProjectDetails = "Project name: " + this.getProjectName() + 
            "\nProject Description: " + this.getProjectDescription() + "\nProject due date: " 
            + this.getProjectDueDate() + "\nProject status: " + this.isProjectCompleted();
       return ProjectDetails;
   }
   
    
} //end of Project Class
