import { generateRandomString } from "@aws-amplify/core";
import axios from "axios";
import BindingClass from "../util/bindingClass";
import Authenticator from "./authenticator";

export default class RemindMePlaylistClient extends BindingClass {
    constructor(props = {}) {
        super();
        const methodsToBind = ['clientLoaded', 'getIdentity', 'login', 'logout'];
        this.bindClassMethods(methodsToBind, this);
        this.authenticator = new Authenticator();;
        this.props = props;
        axios.defaults.baseURL = process.env.API_BASE_URL;
        this.axiosClient = axios;
        this.clientLoaded();
    }

    clientLoaded() {
        if (this.props.hasOwnProperty("onReady")) {
            this.props.onReady(this);
        }
    }

    /**
     * Get the identity of the current user
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The user information for the current user.
     */
    async getIdentity(errorCallback) {
        try {
            const isLoggedIn = await this.authenticator.isUserLoggedIn();

            if (!isLoggedIn) {
                return undefined;
            }

            return await this.authenticator.getCurrentUserInfo();
        } catch (error) {
            this.handleError(error, errorCallback)
        }
    }

    async login() {
        this.authenticator.login();
    }

    async logout() {
        this.authenticator.logout();
    }

    async getTokenOrThrow(unauthenticatedErrorMessage) {
        const isLoggedIn = await this.authenticator.isUserLoggedIn();
        if (!isLoggedIn) {
            throw new Error(unauthenticatedErrorMessage);
        }

        return await this.authenticator.getUserToken();
    }

    async createTaskManager(name, errorCallback) {
        try {
            const token = await this.getTokenOrThrow("Only authenticated users can make a tm");
            const response = await this.axiosClient.post('taskManager', {
                taskManagerName: name,
                taskManagerId : this.makeid(8)
            }, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            return response.data.createTaskManager;
        } catch (error) {
            this.handleError(error, errorCallback);
        }
    }

        makeid(length) {
        let result = '';
        const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        const charactersLength = characters.length;
        let counter = 0;
        while (counter < length) {
          result += characters.charAt(Math.floor(Math.random() * charactersLength));
          counter += 1;
        }
        return result;
    }
    

    async createUser(errorCallback) {
        try {
            const token = await this.getTokenOrThrow("Only authenticated users can register.");
            const response = await this.axiosClient.post('users', {}, {
                headers: {
                    Authorization: `Bearer ${token}`
                }
            });
            return response.data.createUser;
        }   catch (error) {
        this.handleError(error, errorCallback);
        }
    }

    async verifyUser(errorCallback) {
        try {
            const token = await this.getTokenOrThrow("Only authenticated users can access their userinfo");
            const response = await this.axiosClient.get('users', {
                headers: {
                    Authorization: `Bearer: ${token}`
                }
            });
            return response.data.verifyUser;
        } catch (error) {
            this.handleError(error, errorCallback);
        }
    }

    handleError(error, errorCallback) {
        console.error(error);
        const errorFromApi = error?.response?.data?.error_message;
        if (errorFromApi) {
            console.error(errorFromApi)
            error.message = errorFromApi;
        }

        if (errorCallback) {
            errorCallback(error);
        }
    }
}