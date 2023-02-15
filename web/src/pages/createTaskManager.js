import RemindMeClient from '../api/remindMeClient';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';

class CreateTaskManager extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToTaskManager'], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.redirectToTaskManager);
    }

    mount() {
        this.client = new RemindMeClient();
        document.getElementById('create').addEventListener('click', this.submit);
    }

    async submit() {
        const btn = document.getElementById('click');
        const name = document.getElementById('name');
        const decode = decodeURI(name.value);
        const tm = await this.client.createTaskManager(decode);
        this.dataStore.set('tm', decode);
    }

    redirectToTaskManager() {
        console.log("redir");
        const tm = this.dataStore.get('tm');
        if (tm == null) console.log("NULL");
        if (tm != null) {
            window.location.href = `/taskManager.html`;
            console.log("GOOOO");
        }
    }
    

}

const main = async () => {
    const ctm = new CreateTaskManager();
    ctm.mount();
};
window.addEventListener('DOMContentLoaded', main)