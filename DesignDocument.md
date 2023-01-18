<h1> 1. Problem Statement</h1>
People have busy lives, and find it easy to lose track of the things they need to accomplish on a day-to-day basis. I want to solve this problem by developing a web-application that allows individuals to
create a task manager, add tasks, and set reminders - as well as collaborate with others who may partake in their daily schedule.

<h2> 1.1 <a href="https://www.figma.com/file/AWzYFwfgcWTkbYy00JJg7N/Untitled?node-id=0%3A1&t=3N4ohA8MC7kbgAWQ-1"> Wireframe </a></h2>
draft PUML https://github.com/jakeyjake88/RemindMe/blob/main/draftCD.puml

<h1> 2. Top Questions to Resolve </h1>
1. How will I store, query, and get tasks?

2. How will I keep track of time and reminders?

3. How can I allow other users to sign up for a reminder on a task that is not directly their own?

<h1> 3. Use Cases </h1>
<b>U1.</b> As someone who does spends a lot of time away from the computer, I would like to be able to plan out my tasks ahead of time to keep track of my day.

<b>U2.</b> As a busy individual who has scheduled my day with RemindMe, I want to be able to receive text message reminders whenever I have something coming up.

<b>U3.</b> As a working professional, I want to be able to invite my co-workers to participate in a to-do list so we can manage our workload for the day.

<b>U4.</b> As a team leader using RemindMe, I want my employees to receive SMS notifications when something important during the day is coming up.

<b>U5. </b> As a person with a busy schedule, I want to be able to set up recurring tasks, so that I can be reminded to do regular activities like taking medication, paying bills, and doing exercise.

<b>U6. </b> As someone interested in RemindMe, I want to be able to securely create an account and keep track of my username and password.

<b>U7. </b> As a RemindMe user, I want to be able to sign up for SMS texts for certain reminders.

<b>U8. </b> As a web user, I want to be able to comfortably utilize this application from the comfort of my PC.


<h1> 4. Scope </h1>
<h2> 4.1. In Scope</h2>

* A user can sign up for the application using a username, password, and phone number.

* User can create a task manager to store their daily tasks

* The creator of the task manager should be able to allow other users, upon invitation, to access the task manager.

* The creator should be able to add a task using a date for which the task is due.

* The daily tasks page, for sake of length, will only be able to hold 10 tasks per page.

* The all tasks page will only be able to hold 15 tasks per page.

* Creator and users should be able to select a RemindMe button for each task, giving them an SMS reminder shortly before the task is due.


<h2> 4.2. Out of Scope</h2>

* May want creators/users to customize the amount of texts/reminders they receive for each task

* May want creators/users to customize the exact time they receive a text/reminder per task

* May want creators to have the ability to prioritize certain tasks

* May want to allow for email reminders for tasks

<h1> 5. Architecture Overview </h1>

<b> Pages: </b>

* Homepage (<i>Login/Create account pop-ups)

* Profile page (Overview of task managers)

* Task Manager Page 

<b> Tables: </b>

* TaskManager table
* User Table
* Task table

<b> API: </b>

* Gets the TaskManager
* Gets the tasks
* Adds tasks
* Adds TaskManager
* Create user
* Add user to TaskManager
* Remove Tasks
* Remove TaskManager


<h1> 6. API </h1>
<h2> 6.1. Public Models </h2>

*`TaskManagerModel`*

- id : String

- taskManagerName : String

- tasks : Set<Task>

*`TaskModel`*

- id : String

- taskName : String

- taskDueDate : String / LocalDateTime *need clarification*

*`UserModel`*

- id : String

- userName : String

- isOwner : boolean

- phoneNumber : String
  
  <h2> 6.1.1. Create TaskManager</h2>
  * Accepts POST requests to /taskmanager/
  * Creates a new TaskManager with a corresponding ID

  <h2> 6.2. Get TaskManager </h2>
  
  * Accepts GET requests to /taskmanager/:taskmanagerid
  * Accepts a task manager id and returns the corresponding TaskManager
  
  <h2> 6.3. Add Task to TaskManager </h2>
  
  * Accepts PUT requests to /taskmanager/taskManagerId/taskid
  * Accepts data to add an additional task to the specified Taskmanager
  * Returns the added task
  
  <h2> 6.4 Get Task </h2>
  
  * Accepts GET requests to /taskmanager/taskmanagerid/taskid
  * Accepts a taskmanagerId and a taskId to return the corresponding taskmodel
  
  <h2> 6.5 Delete Task </h2>
  
  * Accepts DELETE requests to taskmanager/taskmanagerid/taskid
  * Takes a task and removes it from the TaskManager. Returns the deleted Task
  
  <h2> 6.6 GetUser </h2>
  
  * Accepts GET requests to /user/userId
  * Returns the corresponding usermodel
  
  <h2> 6.7 CreateUser </h2>
  
  * Accepts POST requests to /user/
  * Accepts data to add a new user with a provided first name, last name, and phone number - creating a user ID and returning the new user.
  
  
  
  


