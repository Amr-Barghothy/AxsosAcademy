import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import axios from "axios";

const Info = () => {
    const {cat, id} = useParams();
    const [data, setData] = useState([])
    useEffect(() => {
        axios.get("https://swapi.dev/api/" + cat + "/" + id).then((response) => {
            setData(response.data)
        });
        console.log(data)
    }, [cat, id]);
    return (
        <div>
            {data && cat === "people" && (
                <div>
                    <h1>{data.name}</h1>
                    <p><span className={"font-bold"}>Height:</span> {data.height}cm</p>
                    <p><span className={"font-bold"}>mass:</span> {data.mass} KG</p>
                    <p><span className={"font-bold"}>hair_color:</span> {data.hair_color}</p>
                    <p><span className={"font-bold"}>skin_color:</span> {data.skin_color}</p>
                </div>
            )}
            {data && cat === "planets" && (
                <div>
                    <h1>{data.name}</h1>
                    <p><span className={"font-bold"}>gravity:</span> {data.gravity}</p>
                    <p><span className={"font-bold"}>rotation period:</span> {data.rotation_period}</p>
                    <p><span className={"font-bold"}>orbital period:</span> {data.orbital_period}</p>
                    <p><span className={"font-bold"}>diameter:</span> {data.diameter}</p>
                </div>
            )}

            {data && cat === "starships" && (
                <div>
                    <h1>{data.name}</h1>
                    <p><span className={"font-bold"}>starship_class:</span> {data.starship_class}</p>
                    <p><span className={"font-bold"}>model:</span> {data.model}</p>
                    <p><span className={"font-bold"}>manufacturer:</span> {data.manufacturer}</p>
                    <p><span className={"font-bold"}>consumables:</span> {data.consumables}</p>
                </div>
            )}
        </div>
    );
};

export default Info;