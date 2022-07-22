import Admin from "../Admin/admin"
import EmployeeModule from "../Employee/Employee"
import User from "../User/User"

function logedin() {
    return(
        <>
        <h2>this is Loggged in page</h2>
        <button onClick={Admin}>Admin</button>
        <button onClick={EmployeeModule}>Employee</button>
        <button onClick={User}>User</button>
        </>
    )
}
export default logedin