const Author = require('../models/author.model');


module.exports.findAllAuthors = async (req, res) => {
    try {
        const answer = await Author.find()
        res.json(answer)
    } catch (error) {
        return res.status(400).send({error: error.message})
    }
}


module.exports.findAuthor = async (req, res) => {
    try {
        const answer = await Author.findOne({_id: req.params.id})
        res.json(answer)
    } catch (error) {
        return res.status(400).send({error: error.message})
    }
}


module.exports.createAuthor = async (req, res) => {
    try {
        const answer = await Author.create(req.body);
        res.json(answer);
    } catch (error) {
        if (error.name === "ValidationError") {
            return res.status(400).json(error.errors);
        }
        return res.status(500).json({ message: "Server error" });
    }
};



module.exports.updateAuthor = async (req, res) => {
    try {
        const resp = await Author.findByIdAndUpdate(
            req.params.id,
            req.body,
            { new: true, runValidators: true }
        );
        res.json(resp);
    } catch (error) {
        if (error.name === "ValidationError") {
            return res.status(400).json(error.errors);
        }
        return res.status(500).json({ message: "Server error" });
    }
};


module.exports.deleteAuthor = async (req, res) => {
    try {
        const answer = await Author.deleteOne({_id: req.params.id})
        res.json(answer)
    } catch (error) {
        return res.status(400).send({error: error.message})
    }
}
