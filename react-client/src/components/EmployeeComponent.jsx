import React, { Component } from 'react'
import EmployeeService from '../service/EmployeeService';

export default class EmployeeComponent extends Component {

    constructor(props) {
        super(props);
        this.state ={
            employee:{},
            department:{},
            organizations:{}
        }
    }

    componentDidMount(){
        EmployeeService.getEmployee().then(res=>{
            this.setState({employee : res.data.employee})
            this.setState({department : res.data.department})
            this.setState({organizations : res.data.organization})

            console.log(this.state.employee);
            console.log(this.state.department);
            console.log(this.state.organizations);
            
        })
    }
    
  render() {
    return (
      <div>
        <div className="card col-md-6 offset-md-3 mt-5">
            <h3 className="text-center card-header">
                view Employee Details
            </h3>

            <div className="card-body">
                <div className="row">
                    <p>
                        <strong>Employee First Name:</strong> {this.state.employee.firstName}
                    </p>

                    <p>
                        <strong>Employee Last Name:</strong> {this.state.employee.lastName}
                    </p>

                    <p>
                        <strong>Employee Email:</strong> {this.state.employee.email}
                    </p>
                </div>
            </div>


            <h3 className="text-center card-header">
                view Department Details
            </h3>

            <div className="card-body">
                <div className="row">
                    <p>
                        <strong>Department Name:</strong> {this.state.department.departmentName}
                    </p>

                    <p>
                        <strong>Department Description:</strong> {this.state.department.departmentDescription}
                    </p>

                    <p>
                        <strong>Department Code:</strong> {this.state.department.departmentCode}
                    </p>
                </div>
            </div>


            <h3 className="text-center card-header">
                view Organization Details
            </h3>

            <div className="card-body">
                <div className="row">
                    <p>
                        <strong>Organization Name:</strong> {this.state.department.organizationName}
                    </p>

                    <p>
                        <strong>Organization Description:</strong> {this.state.department.organizationDescription}
                    </p>

                    <p>
                        <strong>Organization Code:</strong> {this.state.department.organizationCode}
                    </p>
                </div>
            </div>
        </div>


        
        

      </div>
    )
  }
}
