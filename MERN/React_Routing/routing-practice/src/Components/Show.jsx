import React from 'react';
import {useParams} from "react-router-dom";

const Show = () => {
    const {word, color1, color2} = useParams()
    let data
    if (word === "home") {
        data = "Welcome"
    } else if (!isNaN(word)) {
        data = "The number is: " + word
    } else {
        data = "The word is: " + word
    }
    return (
        <div>
            {color1 && (
                <h1 style={{backgroundColor:color2, color:color1}} className={`text-center text-red animate-ease-in animate-count-1`}>{data}</h1>
            )}
            {!color1 && (
                <h1 className={"text-center"}>{data}</h1>
            )}
        </div>
    );
};

export default Show;