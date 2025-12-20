const mongoose = require('mongoose');


const AuthorSchema = new mongoose.Schema({

    name: {
        type: String,
        required: [true,"required"],
        minLength: [3,"name should be at least 3 characters"],
    },

});


const Author = mongoose.model('Author', AuthorSchema);


module.exports = Author;

