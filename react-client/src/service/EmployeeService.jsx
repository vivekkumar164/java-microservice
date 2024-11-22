import axios from "axios";

const EMPLOYEE_SERVICE_URL = "http://localhost:9191/api/employees";

const EMPLOYEE_ID = 10;

class EmployeeServive{
    getEmployee(){
        return axios.get(EMPLOYEE_SERVICE_URL + '/' + EMPLOYEE_ID);
    }
}

export default new EmployeeServive