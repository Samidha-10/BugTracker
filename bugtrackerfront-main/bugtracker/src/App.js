import React from 'react';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Header from './component/Header';
import User from './component/Admin/user/adminUser';
import Adduser from './component/Admin/user/adduser';
import EmployeeModule from './component/Employee/Employee';
import AdminEmployee from './component/Admin/Employee/AdminEmployee';
import Home from './component/Home/home';

function App() {
  return (
    <div className='App'>
      <Header/>
      <Home/>
    </div>
  );
}

export default App;
