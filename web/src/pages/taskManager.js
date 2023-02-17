import RemindMeClient from '../api/remindMeClient';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

class TaskManager extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'displayManagers', 'generateTaskManagerHTML', 
    'displayTasks', 'generateTaskHTML', 'handleMarkCompleteButtonClick', 'handleDeleteTaskButtonClick',
'handleAddTaskButtonClick', 'handleDateSelection', 'displayTasksForSelectedDate'], this);
        this.dataStore = new DataStore();
    }

    mount() {
        this.client = new RemindMeClient();
        this.displayManagers();
        this.handleDateSelection();
    }

    async handleDateSelection() {
        const submitDateButton = document.getElementById('submitDateButton');
        submitDateButton.addEventListener('click', async (event) => {
            event.preventDefault();
            const selectedDate = new Date(document.getElementById('date-box').value + "T00:00");
            const allTasks = await this.client.getAllTasksForCreator();
            const tasksForSelectedDate = allTasks.filter(task => {
              const dateString = `${task.dueDate}`;
              const dateParts = dateString.split(",");
              const dateObj = new Date(dateParts[0], parseInt(dateParts[1] -1), dateParts[2]);
              const selectedDateFormatted = selectedDate.toLocaleDateString('en-US');
              const dateObjFormatted = dateObj.toLocaleDateString('en-US');
              console.log(dateObjFormatted);
              console.log(selectedDateFormatted);
              return (
                dateObjFormatted === selectedDateFormatted
              );
            });
            this.displayTasksForSelectedDate(tasksForSelectedDate);
          });

    }

        displayTasksForSelectedDate(tasks) {
      
        const allTasksDate = document.getElementById("allTasksDate");
      
        allTasksDate.innerHTML = "";
      
        const taskList = document.createElement("ul");
      
        tasks.forEach(task => {
          const taskItem = document.createElement("li");
          taskItem.textContent = task.description;
          taskList.appendChild(taskItem);
        });
      
        allTasksDate.appendChild(taskList);
      } 

    async displayManagers() {
        const managers = await this.client.getTaskManager();
        if (managers) {
            const temp = this.generateTaskManagerHTML(managers);
            document.getElementById('task-list').innerHTML = temp;
            const tasks = document.querySelectorAll(".task");
            for (let task of tasks) {
                task.addEventListener('click', async (event) => {
                    await this.displayTasks(event);
                });
            }
            const addTaskButtons = document.querySelectorAll(".addTaskButton");
            for (let addTaskButton of addTaskButtons) {
                addTaskButton.removeEventListener('click', this.handleAddTaskButtonClick);
            }
    
            const newAddTaskButtons = document.querySelectorAll(".addTaskButton");
            for (let newAddTaskButton of newAddTaskButtons) {
                newAddTaskButton.addEventListener('click', this.handleAddTaskButtonClick);
            }
        }
    }

    generateTaskManagerHTML(managers) {
        let temp = "";
        for (let element of managers) {
            temp += `<li class="task" id="task_${element.taskManagerId}"> ${element.taskManagerName} 
            <button class="addTaskButton" id="addTaskButton_${element.taskManagerId}">Add Task</button></li>`;
        }
        return temp;
    } 

    
    generateTaskHTML(tasks) {
        let temp = "";
        for (let element of tasks) {
            let checkmark = "";
            let completeButton = `<button class="markCompleteButton" id="markCompleteButton_${element.taskId}_${element.taskManagerId}">Complete</button>`;
            if (element.isActive === false) {
                checkmark = "&#10003;";
                completeButton = "";
            }

            const dateString = `${element.dueDate}`;
            const dateParts = dateString.split(",");
            const dateObj = new Date(
                dateParts[0],
                parseInt(dateParts[1]) - 1,
                dateParts[2],
                dateParts[3],
                dateParts[4]
              );
            const formattedDate = `${dateObj.toLocaleTimeString("en-US", {hour12: true, hour: "numeric", minute: "numeric"})}, ${dateObj.toLocaleDateString("en-US", {month: "long", day: "numeric", year: "numeric"})}`;
            temp += `<li class="anger"> ${checkmark} ${element.name}
            <p>Description: ${element.description}</p>
            <p>Due Date: ${formattedDate}</p>
            ${completeButton}
            <button class="deleteTaskButton" id="deleteTaskButton_${element.taskId}_${element.taskManagerId}">Delete</button>
            </li>`;
        }
        return temp;
    } 

    async displayTasks(event) {
        document.getElementById('allTasks').innerHTML = "";
        let p = "";
        const taskManagerId = event.target.id.split("_")[1];
        const allT = await this.client.getAllTasks(taskManagerId);
        const taskHTML = this.generateTaskHTML(allT);
        p += taskHTML;
        document.getElementById('allTasks').innerHTML = p;
    
        const newMarkIsCompleteButtons = document.querySelectorAll(".markCompleteButton");
        for (let newMarkIsCompleteButton of newMarkIsCompleteButtons) {
            newMarkIsCompleteButton.addEventListener('click', this.handleMarkCompleteButtonClick);
        }
    
        const newDeleteTaskButtons = document.querySelectorAll(".deleteTaskButton");
        for (let newDeleteTaskButton of newDeleteTaskButtons) {
            newDeleteTaskButton.addEventListener('click', this.handleDeleteTaskButtonClick);
        }
    } 
    
    async handleMarkCompleteButtonClick(event) {
        const taskManagerId = event.target.id.split("_")[2];
        const taskId = event.target.id.split("_")[1];
        await this.client.markIsComplete(taskId, taskManagerId);
        document.getElementById('allTasks').innerHTML = "";
        let p = "";
        const allT = await this.client.getAllTasks(taskManagerId);
        const taskHTML = this.generateTaskHTML(allT);
        p += taskHTML;
        document.getElementById('allTasks').innerHTML = p;
        const newMarkIsCompleteButtons = document.querySelectorAll(".markCompleteButton");
        const newDeleteTaskButtons = document.querySelectorAll(".deleteTaskButton");
        for (let newDeleteTaskButton of newDeleteTaskButtons) {
            newDeleteTaskButton.addEventListener('click', this.handleDeleteTaskButtonClick);
        }
        for (let newMarkIsCompleteButton of newMarkIsCompleteButtons) {
            newMarkIsCompleteButton.addEventListener('click', this.handleMarkCompleteButtonClick);
        }
    }
    
    async handleDeleteTaskButtonClick(event) {
        const taskManagerId = event.target.id.split("_")[2];
        const taskId = event.target.id.split("_")[1];
        await this.client.deleteTask(taskId, taskManagerId);
        document.getElementById('allTasks').innerHTML = "";
        let p = "";
        const allT = await this.client.getAllTasks(taskManagerId);
        const taskHTML = this.generateTaskHTML(allT);
        p += taskHTML;
        document.getElementById('allTasks').innerHTML = p;
        const newDeleteTaskButtons = document.querySelectorAll(".deleteTaskButton");
        const newMarkIsCompleteButtons = document.querySelectorAll(".markCompleteButton");
            for (let newMarkIsCompleteButton of newMarkIsCompleteButtons) {
                newMarkIsCompleteButton.addEventListener('click', this.handleMarkCompleteButtonClick);
            }
            for (let newDeleteTaskButton of newDeleteTaskButtons) {
                newDeleteTaskButton.addEventListener('click', this.handleDeleteTaskButtonClick);
            }
    }

    async handleAddTaskButtonClick(event) {
        const taskManagerId = event.target.id.split("_")[1];
        const form = `
            <form class="form" id="addTaskForm">
                <input type="text" id="taskName" placeholder="Task Name" required></input><br>
                <input type="text" id="taskDescription" placeholder="Task Description" required></input><br>
                <input type="datetime-local" id="taskDateTime" placeholder="Task Date and Time" required></input><br>
                <input type="hidden" id="taskManagerId" value="${taskManagerId}"></input><br>
                <button type="submit" id="submitTaskButton" disabled>Submit</button>
            </form>
        `;
        document.getElementById('addTask').innerHTML = "";
        document.getElementById('addTask').innerHTML = form;
    
        const submitTaskButton = document.getElementById('submitTaskButton');
        const taskNameInput = document.getElementById('taskName');
        const taskDescriptionInput = document.getElementById('taskDescription');
        const taskDateTimeInput = document.getElementById('taskDateTime');
    
        function checkInputs() {
            if (taskNameInput.value && taskDescriptionInput.value && taskDateTimeInput.value) {
                submitTaskButton.disabled = false;
            } else {
                submitTaskButton.disabled = true;
            }
        }
    
        taskNameInput.addEventListener('input', checkInputs);
        taskDescriptionInput.addEventListener('input', checkInputs);
        taskDateTimeInput.addEventListener('input', checkInputs);
    
        submitTaskButton.addEventListener('click', async (event) => {
            event.preventDefault();
            const taskName = document.getElementById('taskName').value;
            const taskDescription = document.getElementById('taskDescription').value;
            const taskDueDate = document.getElementById('taskDateTime').value;
            console.log(taskDueDate);
            await this.client.addTaskToManager(taskName, taskDescription, taskManagerId, taskDueDate);
            document.getElementById('allTasks').innerHTML = "";
            let p = "";
            const allT = await this.client.getAllTasks(taskManagerId);
            const taskHTML = this.generateTaskHTML(allT);
            p += taskHTML;
            document.getElementById('allTasks').innerHTML = p;
            const newDeleteTaskButtons = document.querySelectorAll(".deleteTaskButton");
            for (let newDeleteTaskButton of newDeleteTaskButtons) {
                newDeleteTaskButton.addEventListener('click', this.handleDeleteTaskButtonClick);
            }
            const newMarkIsCompleteButtons = document.querySelectorAll(".markCompleteButton");
            for (let newMarkIsCompleteButton of newMarkIsCompleteButtons) {
                newMarkIsCompleteButton.addEventListener('click', this.handleMarkCompleteButtonClick);
            }
            document.getElementById('addTaskForm').reset();
        });
    }
} 


const main = async () => {
    const taskManager = new TaskManager();
    taskManager.mount();
};

window.addEventListener('DOMContentLoaded', main);