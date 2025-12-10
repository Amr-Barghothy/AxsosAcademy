import React, {useContext} from 'react';
import MyContext from "../Contexts/MyContext.jsx";

const NavBar = () => {
    const holder =useContext(MyContext);
    return (
        <div>
            <div className={"bg-purple-700 p-10 sticky top-0 text-right text-white text-3xl"}>
                {holder.name}
            </div>
        </div>
    );
};

export default NavBar;