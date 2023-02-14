import RemindMeClient from '../api/remindMeClient';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

class TaskManager extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'displayManagers', 'generateTaskManagerHTML', 
    'displayTasks', 'generateTaskHTML', 'handleMarkCompleteButtonClick', 'handleDeleteTaskButtonClick',
'handleAddTaskButtonClick'], this);
        this.dataStore = new DataStore();
    }

    

    mount() {
        this.client = new RemindMeClient();
        this.displayManagers();
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
        const markIsCompleteButtons = document.querySelectorAll(".markCompleteButton");
        for (let markIsCompleteButton of markIsCompleteButtons) {
            markIsCompleteButton.addEventListener('click', (event) => {
                this.handleMarkCompleteButtonClick(event);
            });
        }
    
        const deleteTaskButtons = document.querySelectorAll(".deleteTaskButton");
        for (let deleteTaskButton of deleteTaskButtons) {
            deleteTaskButton.addEventListener('click', (event) => {
                this.handleDeleteTaskButtonClick(event);
            });
        }
    
        const addTaskButtons = document.querySelectorAll(".addTaskButton");
        for (let addTaskButton of addTaskButtons) {
            addTaskButton.addEventListener('click', (event) => {
                this.handleAddTaskButtonClick(event);
            });
        }
    }
    
    handleMarkCompleteButtonClick(event) {
        const taskManagerId = event.target.id.split("_")[2];
        const taskId = event.target.id.split("_")[1];
        this.client.markIsComplete(taskId, taskManagerId);
    }
    
    handleDeleteTaskButtonClick(event) {
        const taskManagerId = event.target.id.split("_")[2];
        const taskId = event.target.id.split("_")[1];
        this.client.deleteTask(taskId, taskManagerId);
    }
    
    async handleAddTaskButtonClick(event) {
        const taskManagerId = event.target.id.split("_")[1];
        const form = `
            <form id="addTaskForm">
                <input type="text" id="taskName" placeholder="Task Name"></input><br>
                <input type="text" id="taskDescription" placeholder="Task Description"></input><br>
                <input type="datetime-local" id="taskDateTime" placeholder="Task Date and Time"></input><br>
                <input type="hidden" id="taskManagerId" value="${taskManagerId}"></input><br>
                <button type="submit" id="submitTaskButton">Submit</button>
            </form>
        `;
        document.getElementById('addTask').innerHTML = "";
        document.getElementById('addTask').innerHTML = form;
    
        const submitTaskButton = document.getElementById('submitTaskButton');
        submitTaskButton.addEventListener('click', (event) => {
            event.preventDefault();
            const taskName = document.getElementById('taskName').value;
            const taskDescription = document.getElementById('taskDescription').value;
            const taskDueDate = document.getElementById('taskDateTime').value;
            console.log(taskDueDate);
            this.client.addTaskToManager(taskName, taskDescription, taskManagerId, taskDueDate);
        });
    }
} 


const main = async () => {
    const taskManager = new TaskManager();
    taskManager.mount();
};

window.addEventListener('DOMContentLoaded', main);