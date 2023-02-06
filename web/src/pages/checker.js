import RemindMeClient from '../api/remindMeClient';
import BindingClass from '../util/bindingClass';
import DataStore from '../util/DataStore';

class Checker extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount', 'redirectToPage'], this);
        this.dataStore = new DataStore();
    }

    mount() {
        this.client = new RemindMeClient();
        this.redirectToPage();
    }

    async redirectToPage() {
        const isUser = await this.client.verifyUser();
        if (isUser) {
            window.location.href = `/taskManager.html`;
        } else {
            window.location.href = `/welcomePage.html`;
        }
    }
}
const main = async () => {
    const checker = new Checker();
    checker.mount();
};

window.addEventListener('DOMContentLoaded', main);