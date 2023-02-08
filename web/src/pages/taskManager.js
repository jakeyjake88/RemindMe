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
        var maindiv = document.getElementById('side-bar');
        if (managers) {
            managers.forEach(tm => {
                console.log("entered forloop");
                var a = document.createElement('a');
                console.log("a created");
                var tmname = document.createTextNode(tm.taskManagerName);
                console.log(tmname);
                a.appendChild(tmname);
                a.title = tm.taskManagerName;
                maindiv.append(a);
            });
        }
    }

}

const main = async () => {
    const taskManager = new TaskManager();
    taskManager.mount();
};

window.addEventListener('DOMContentLoaded', main);