import React from 'react'

import { Link,NavLink } from 'react-router-dom';

const SideNav = () =>{

    const commonClasses = " items-center justify-center  w-full h-12 bg-green-700 py-2 rounded-md  flex hover:cursor-pointer hover:bg-green-600";

    const text = "font-medium text-sm text-white text-center hover:text-base font-normal"
    


  return (
    <div className='w-64 h-[calc(100vh-80px) bg-green-800 flex flex-col py-6 px-4 gap-3'>
    
    
        <div className={`${commonClasses}  ${text}`}><span>Home</span></div>
        <div className={`${commonClasses}  ${text}`}><span>Employee</span></div>
        <div className={`${commonClasses}  ${text}`}><span>Inventory</span></div>
        <div className={`${commonClasses}  ${text}`}><span>Store</span></div>
        <div className={`${commonClasses}  ${text}`}><span>Fertilizer</span></div>
        <div className={`${commonClasses}  ${text}`}><span>Plant</span></div>
        <div className={`${commonClasses}  ${text}`}><span>Vehicle</span></div>
        <div className={`${commonClasses}  ${text}`}><span>Orders</span></div>
        <div className={`${commonClasses}  ${text}`}><span>Production</span></div>



       
    </div>
  )

}

export default SideNav;