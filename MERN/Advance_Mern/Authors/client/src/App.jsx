import './App.css'
import Header from "./Components/Header.jsx";
import {Route, Routes} from "react-router-dom";
import Form from "./Components/Form.jsx";
import Authors from "./Components/Authors.jsx";
// import {useSelector} from "react-redux";

function App() {
    // const auth = authors.authors


    return (
        <>
            <Routes>
                <Route path={"/authors"} element={<><Header title={"Favorite Authors"} route={"/authors/new"}
                                                            subTitle={"We have quotes by:"}
                                                            routeText={"Add an author"}/> <Authors /></>}/>
                <Route path={"/authors/new"}
                       element={<> <Header title={"Favorite Authors"} route={"/authors"} subTitle={"Add a new author:"}
                                           routeText={"Home"}/> <Form/></>}/>

                <Route path={"/authors/:id"}
                       element={<><Header title={"Favorite Authors"} route={"/authors"} subTitle={"Edit this author:"}
                                          routeText={"Home"}/> <Form/></>}/>
            </Routes>
        </>
    )
}

export default App
