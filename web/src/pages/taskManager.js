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
            var temp = "";
            for (let element of managers) {
                temp += `<li class="task" id="task_${element.taskManagerId}"> ${element.taskManagerName} </li>`;
            }
            document.getElementById('task-list').innerHTML = temp;
            var tasks = document.querySelectorAll(".task");
            for (let task of tasks) {
                task.addEventListener('click',  async (event) => {
                    document.getElementById('allTasks').innerHTML = "";
                    var p = "";
                    const allT = await this.client.getAllTasks("jkKEhHX");
                    for (let element of allT) {
                        p += `<li class="anger"> ${element.name}</li>`;
                    }
                    document.getElementById('allTasks').innerHTML = p;
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