import React,{useEffect, useState} from "react";
import Table from 'react-bootstrap/Table';

function AdminEmployee() {
    
    const [Employees, setEmployees] = useState([]);
    useEffect(async()=>{
        let result = await fetch("http://localhost:8080/employee/viewall");
        result = await result.json();
        setEmployees(result)
    },[])

    function deleteEmployee(id) {
        alert(id)
    }
    function updateEmployee(emp) {
        alert(emp)
    }

    return (
        <div className="container">
            <h3 className="p-3 text-center">React - Display a list of Employees</h3>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Contact</th>
                        <th>Bug_Assigned</th>
                        <th>Operations</th>
                    </tr>
                </thead>
                <tbody>
                    {Employees.map(Employee =>
                        <tr>
                            <td>{Employee.id}</td>
                            <td>{Employee.Employee_name}</td>
                            <td>{Employee.email}</td>
                            <td>{Employee.employee_contact}</td>
                            <td>{Employee.bug_id}</td>
                            <td>
                                <span onClick={updateEmployee(Employee)} className="btn">Update</span>
                                {/* <span onClick={deleteEmployee(Employee.id)} className="btn" >Delete</span> */}
                            </td>
                        </tr>
                    )}
                </tbody>
            </Table>
        </div>
    );
}
export default AdminEmployee;