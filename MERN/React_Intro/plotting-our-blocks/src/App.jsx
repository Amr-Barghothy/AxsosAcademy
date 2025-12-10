import React from 'react';
import './App.css';
import Header from './Components/Header';
import Navigation from './Components/Navigation';
import Main from './Components/Main';
import SubContents from './Components/SubContents';
import Advertisement from './Components/Advertisement';


function App() {
    return (
        <div className="min-h-screen">
            <div className="bg-gray-300 w-60/100 mx-auto p-5 my-auto">
                <Header/>
                <div className={"flex"}>
                    <Navigation/>
                    <Main>
                        <div className={"flex  w-full space-x-10 items-center "}>
                            <SubContents/>
                            <SubContents/>
                            <SubContents/>
                        </div>
                        <Advertisement/>
                    </Main>
                </div>
            </div>
        </div>
    );
}

export default App;