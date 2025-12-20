require('dotenv').config();
const express = require("express");
const app = express();
const port = process.env.PORT;

require("./config/mongoose.config");
const cors = require("cors");

app.use(express.json(), express.urlencoded({extended: true}), cors());

require("./routes/author.route")(app);


app.listen(port, () => console.log(`Listening on port: ${port}`));