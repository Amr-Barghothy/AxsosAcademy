const JokeController = require('../controllers/author.controller');


module.exports = app => {
    app.get('/api/author', JokeController.findAllAuthors);
    app.get('/api/author/:id', JokeController.findAuthor);
    app.post('/api/author', JokeController.createAuthor);
    app.patch('/api/author/:id', JokeController.updateAuthor);
    app.delete('/api/author/:id', JokeController.deleteAuthor);
}