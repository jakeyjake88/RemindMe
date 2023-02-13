import RemindMeClient from '../api/remindMeClient';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

class TaskManager extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'displayManagers'], this);
        this.dataStore = new DataStore();
    }

    

    mount() {
        this.client = new RemindMeClient();
        this.displayManagers();
    }

    async displayManagers() {
        const managers = await this.client.getTaskManager();
        if (managers) {
            let temp = "";
            for (let element of managers) {
                temp += `<li class="task" id="task_${element.taskManagerId}"> ${element.taskManagerName} 
                <button class="addTaskButton" id="addTaskButton_${element.taskManagerId}">Add Task</button></li>`;
            }
            document.getElementById('task-list').innerHTML = temp;
            const tasks = document.querySelectorAll(".task");
            for (let task of tasks) {
                task.addEventListener('click', async (event) => {
                    document.getElementById('allTasks').innerHTML = "";
                    let p = "";
                    const taskManagerId = event.target.id.split("_")[1];
                    const allT = await this.client.getAllTasks(taskManagerId);
                    for (let element of allT) {
                        p += `<li class="anger"> ${element.name}</li>`;
                    }
                    document.getElementById('allTasks').innerHTML = p;
                });
            }
            const addTaskButtons = document.querySelectorAll(".addTaskButton");
            for (let addTaskButton of addTaskButtons) {
                addTaskButton.addEventListener('click', async (event) => {
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
                        this.client.addTaskToManager(taskName, taskDescription, taskManagerId);
                    });
                });
            }
        }
    }
} 


const main = async () => {
    const taskManager = new TaskManager();
    taskManager.mount();
};

window.addEventListener('DOMContentLoaded', main);