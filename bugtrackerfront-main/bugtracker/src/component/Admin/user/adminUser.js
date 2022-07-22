import React,{useState} from "react";

function User() {
    
    const [users, setUsers] = useState([
        { id: 1, email: 'frank@gmail.com', password: 'qwert', user_name: 'rohan', project_id:4 },
        { id: 2, email: 'manish@gmail.com', password: 'zzxcvv', user_name: 'manish', project_id:5 }
    ]);

    return (
        <div className="container">
            <h3 className="p-3 text-center">React - Display a list of users</h3>
            <table className="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Project_id</th>
                    </tr>
                </thead>
                <tbody>
                    {users && users.map(user =>
                        <tr key={user.id}>
                            <td>{user.user_name}</td>
                            <td>{user.email}</td>
                            <td>{user.project_id}</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
}
export default User