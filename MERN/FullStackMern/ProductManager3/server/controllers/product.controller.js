const Product = require('../models/products.model')

module.exports.getAllProducts = (req, res) => {
    Product.find().then(products => {
        res.json(products);
    })
}

module.exports.getProduct = (req, res) => {
    console.log(req.params)
    Product.findById(req.params.id).then((product) => {
        res.json(product);
    })
}

module.exports.createProduct = (req, res) => {
    console.log(req.body);
    Product.create(req.body).then((product) => {
        res.json(product);
    }).catch((err) => {
        res.status(400).json(err.message);
    })
}

module.exports.updateProduct = (req, res) => {
    console.log("im updating")
    console.log(req.body);
    Product.findByIdAndUpdate(req.params.id, req.body).then((product) => {
        res.json(product);
    }).catch((err) => {
        res.status(400).json(err.message);
    })
}

module.exports.deleteProduct = (req, res) => {
    console.log(req.body);
    Product.findByIdAndDelete(req.params.id).catch((err) => {
        res.status(400).json(err.message);
    })
}