import React from 'react'
import { Button } from '@mui/material';
import NotificationsActiveOutlined from '@mui/icons-material/NotificationsActiveOutlined';
import CalendarMonthOutlinedIcon from '@mui/icons-material/CalendarMonthOutlined';

import { Link } from 'react-router-dom';
import logo from '../assets/images/logo.png';


const headerTextStyle = "hover:cursor-pointer hover:text-gray-800 font-medium text-green-700"

const Header = () => {
  return (
    <div className='flex flex-row justify-between py-2 px-4 w-full h-20 items-center shadow'>
        <div className="flex flex-row items-center">
        <Link to="/" className="flex flex-row items-center">
          <div className="flex flex-row items-center"><img src={logo} alt='logo' className='size-12'/></div>
          <div className="font-bold text-lg">CeylonTea <span className='text-green-600'>Automation</span></div>
        </Link>
        </div>
        <div className="flex flex-row gap-10 items-center">
          <div className={headerTextStyle}><Link to="/dashboard">Dashboard</Link></div>
          <div className={headerTextStyle}>Task</div>
          <div className={headerTextStyle}>Report</div>
          <div className={headerTextStyle}>Settings</div>
          <div className="flex flex-row gap-2">
            <div className=""><Button sx={{backgroundColor:'#E7EEE7',color:'rgba(0, 0, 0, 0.6)',borderRadius:'15px'}}>{<NotificationsActiveOutlined/>}</Button></div>
            <div className=""><Button sx={{backgroundColor:'#E7EEE7',color:'rgba(0, 0, 0, 0.6)',borderRadius:'15px'}} >{<CalendarMonthOutlinedIcon/>}</Button></div>
          </div>
          <div className="bg-gray-100 rounded-full size-14 items-center justify-center flex"><svg className='size-8' viewBox="0 0 32 32" style={{ enableBackground: 'new 0 0 32 32' }}>
            <path d="M16 14c-3.86 0-7-3.14-7-7s3.14-7 7-7 7 3.14 7 7-3.14 7-7 7zm0-12c-2.757 0-5 2.243-5 5s2.243 5 5 5 5-2.243 5-5-2.243-5-5-5zM27 32a1 1 0 0 1-1-1v-6.115a6.95 6.95 0 0 0-6.942-6.943h-6.116A6.95 6.95 0 0 0 6 24.885V31a1 1 0 1 1-2 0v-6.115c0-4.93 4.012-8.943 8.942-8.943h6.116c4.93 0 8.942 4.012 8.942 8.943V31a1 1 0 0 1-1 1z" />
          </svg></div>
        </div>

    </div>
  )
}

export default Header