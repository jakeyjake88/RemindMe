import RemindMeClient from '../api/remindMeClient';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';

class CreateTaskManager extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToTaskManager'], this);
        this.dataStore = new DataStore();
    }

    mount() {
        this.client = new RemindMeClient();
        document.getElementById('create').addEventListener('click', this.submit);
    }

    async submit() {
        const btn = document.getElementById('click');
        const name = document.getElementById('name');
        const tm = await this.client.createTaskManager(name)
        this.dataStore.set('tm', tm);
    }

    redirectToTaskManager() {
        const tm = this.dataStore.get('tm');
        if (tm != null) {
            window.location.href = `/taskManager.html`;
        }
    }
    

}

const main = async () => {
    const ctm = new CreateTaskManager();
    ctm.mount();
};
window.addEventListener('DOMContentLoaded', main)