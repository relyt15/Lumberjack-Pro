# Lumberjack-Pro

### *How Would You Want To Trim The Day?*

Task and Project manager

Project Name: **Lumberjack Pro**

Team name: **Timbermen**

Team members: **Tyler Conway**, **Neo Hang**, **Alex Matovski**

Lumberjack Pro is a forest themed project and task manager. Aimed at taking larger projects and breaking them down into smaller items in a to-do list, Lumberjack Pro can help organize and achieve your goals.

It will be useful for managing work, class assignments, chores, hobbies, and other projects. This will be done by having a single place to look at all of the progress on any project someone is working on in any scenario.

The design and concept of the program is collabrative.

Tyler -Handled dialog boxes for creating and editing tasks/projects, added editing functionality, made the arrays that are used to keep track of the projects and tasks, and created the add Project and add Task Buttons.

Neo - Designed the UI, added scroll panes, created the calendar due-date selection, added delete functions, and created the completed task/project checkbox.

Alex -Created the first iteration of the user-defined project and task information, helped create the completed task/project checkboxes.

**User Manual:**
To use the application, download all of the files into your IDE, 
make sure the image files are located in their proper resource folder, and run the program. 
The starting page of Lumberjack Pro will show a mostly blank project section aside from an "Add project" button. 
Click this to add your first project, fill out the dialog box, then more options for editing, deleting, and adding tasks for your project will appear. 
There is a powerpoint attached to the .ReadMe file showing how to use the application in its second half.

**Implementation Manual:**
Our application used 7 classes in total:

Task - Contains information about a user-added task such as name, description, due date, and completion status.

Project - Contains information about a user-added project such as name, description, due date, completion status, and an array of the tasks that correspond with the specified task.

TaskService - Contains a list of all tasks within all projects, contains methods to add and remove a task, as well as the dialog box methods for adding and editing a task.

Project Service - Contains a list of all projects, contains methods to add and remove a project, as well as the dialog box methods for adding and editing a project.

Task Pane - Contains Ui attributes that correspond with the task class. Such as nanme, due date, and completion check box. Also contains a button to edit the task by using the task service class to call its editTaskDialog method in order to edit any attributes in the task and task pane.

Project Pane - Contains UI attributes that correspond with the project class. Such as name, due date, and completion checkbox. Also contains buttons to edit the project information that uses project service to call its edit project dialog method then saves the information back into the project and project pane. This class also contains a section dedicated to tasks that can be placed in the specified project pane. It does this by calling on the taskService class' method for popping up a dialog box that saves any information entered into a new task and taskPane. 

Lumberjack Pro (Main)- The main driver class. Utilizes various pane layouts such as BorderPane and ScrollPane to display the ProjectPanes and TaskPanes. The organization of these UI elements is done with a variety of HBox and VBox objects. The general flow of this class is to layout a BorderPane that holds the Logo and Greeting text at the top of the page. This BorderPane also holds a ScrollPane that is the main UI element that the user will interact with. The Scroll Pane holds an add project button, any added project pane, and each project pane holds its corresponding task panes all of which is filled out by the user via dialog boxes.

![UML LumberjackPro - Frame 1](https://github.com/user-attachments/assets/db2916a8-b6f4-4037-94e9-5b77561fab55)

[Lumberjack Pro.pptx](https://github.com/user-attachments/files/19785135/Lumberjack.Pro.pptx)

