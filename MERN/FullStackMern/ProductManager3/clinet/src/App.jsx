import {useEffect, useState} from "react";
import './App.css'
import {Link, Route, Routes, useNavigate} from "react-router-dom";
import axios from "axios";
import InputField from "./components/InputField.jsx";
import ProductData from "./components/ProductData.jsx";

function App() {
    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState("");
    const [products, setProducts] = useState([]);
    const [currentId, setCurrentId] = useState(0)
    const navigate = useNavigate()

    useEffect(() => {
        axios.get("http://localhost:8000/api/products")
            .then(res => setProducts(res.data));
    }, [products]);

    function handleSubmit(e) {
        e.preventDefault();
        axios.post("http://localhost:8000/api/products", {
            title,
            description,
            price
        }).then(() => {
            return axios.get("http://localhost:8000/api/products");
        }).then(res => setProducts(res.data));
    }

    function handleUpdate() {
        axios.patch(`http://localhost:8000/api/products/${currentId}`, {
            title: title,
            description: description,
            price: price
        }).then(() => {
            setTitle("")
            setDescription("")

            setPrice("")
            navigate('/')
        })

    }

    function handleDelete(id) {
        axios.delete(`http://localhost:8000/api/products/${id}`).then(() => {
            setProducts((prevState) => prevState.filter((item) => item.id !== id));
        })
    }

    return (
        <Routes>
            <Route
                path="/"
                element={
                    <>
                        <form onSubmit={handleSubmit}>
                            <InputField type="text" label="Title" data={title} onChange={setTitle}/>
                            <InputField type="number" label="Price" data={price} onChange={setPrice}/>
                            <InputField type="text" label="Description" data={description} onChange={setDescription}/>
                            <button type="submit">Submit</button>
                        </form>

                        <ul style={{display: "flex", justifyContent: "space-between", flexDirection: "column",}}>
                            {products.map((product, index) => (
                                <li style={{display: "flex", gap: 20}} key={product._id}>
                                    <Link state={{id: product._id}} to={`/products/${index}`}>
                                        {product.title}
                                    </Link>

                                    <Link onClick={() => {
                                        setCurrentId(product._id);
                                        setTitle(product.title);
                                        setDescription(product.description);
                                        setPrice(product.price);
                                    }} state={{id: product._id}} to={`/products/${index}/edit`}>
                                        Edit
                                    </Link>

                                    <button onClick={() => {
                                        handleDelete(product._id)
                                    }}>
                                        Delete
                                    </button>
                                </li>
                            ))}
                        </ul>
                    </>
                }
            />

            <Route path="/products/:id" element={<ProductData/>}/>
            <Route path="/products/:id/edit" element={<>
                <InputField type="text" label="Title" data={title} onChange={setTitle}/>
                <InputField type="number" label="Price" data={price} onChange={setPrice}/>
                <InputField type="text" label="Description" data={description} onChange={setDescription}
                            update={true}/>
                <button onClick={handleUpdate}>Confirm</button>
            </>
            }/>
        </Routes>
    );
}

export default App;
