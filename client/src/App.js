import './App.css';
import Home from './views/Home';
import Header from './components/Header';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Dashboard from './views/Dashboard';
import SideNav from './components/SideNav';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Header/>
        <main className='flex flex-row'>
        <SideNav/>

        <Routes>
     
            <Route path='/' element={<Home/>}/>
            <Route path='/dashboard' element={<Dashboard/>}/>
       
        </Routes>
        </main>
      </BrowserRouter>
      

     
    </div>
  );
}

export default App;
