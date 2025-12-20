import React from 'react';
import {Link} from "react-router-dom";

const Header = ({title,route,routeText,subTitle}) => {
    return (
        <div className={"w-50/100 mx-auto"}>
            <h1 className={"text-3xl"}>{title}</h1>
            <Link to={route} className={"text-xl text-blue-6 underline-blue"}>{routeText}</Link>
            <h2 className={"text-xl text-purple-6"}>{subTitle}</h2>
        </div>
    );
};

export default Header;