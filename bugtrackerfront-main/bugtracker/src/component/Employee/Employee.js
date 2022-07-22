import React,{useState} from "react";

function EmployeeModule() {
    
    const [Employees, setEmployees] = useState([
        { id: 1, email: 'frank@gmail.com', password: 'qwert', Employee_name: 'rohan', bug_id:4 },
        { id: 2, email: 'manish@gmail.com', password: 'zzxcvv', Employee_name: 'manish', bug_id:5 }
    ]);

    return (
        <div className="container">
            <h3 className="p-3 text-center">React - Display a list of Employees</h3>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Project_id</th>
                    </tr>
                </thead>
                <tbody>
                    {Employees && Employees.map(Employee =>
                        <tr key={Employee.id}>
                            <td>{Employee.Employee_name}</td>
                            <td>{Employee.email}</td>
                            <td>{Employee.bug_id}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
}
export default EmployeeModule