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
                temp += "<li>";
                temp += "<td>" + element.taskManagerName + "</td>";
            }
            document.getElementById('task-list').innerHTML = temp;
        }
        }
    }

const main = async () => {
    const taskManager = new TaskManager();
    taskManager.mount();
};

window.addEventListener('DOMContentLoaded', main);