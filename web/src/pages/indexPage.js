import RemindMePlaylistClient from '../api/remindMeClient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

class IndexPage extends BindingClass {
    constructor() {
        super();
        this.bindClassMethods(['mount'], this);
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
        console.log("Index constructor");
    }

    mount() {
        this.header.addHeaderToPage();
        this.client = new RemindMePlaylistClient();
    }
}

const main = async () => {
    const indexPage = new IndexPage();
    indexPage.mount();
};

window.addEventListener('DOMContentLoaded', main);