const { faker } = require("@faker-js/faker");
const express = require("express");

const app = express();
const port = 8000;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

function createRandomUser() {
    return {
        _id: faker.string.uuid(),
        firstname: faker.person.firstName(),
        lastname: faker.person.lastName(),
        email: faker.internet.email(),
        password: faker.internet.password(),
        phoneNumber: faker.phone.imei(),
    };
}

function createRandomCompany() {
    return {
        _id: faker.string.uuid(),
        name: faker.company.name(),
        address: {
            street: faker.location.street(),
            city: faker.location.city(),
            state: faker.location.state(),
            zip: faker.location.zipCode(),
            county: faker.location.county(),
        }
    };
}

app.get("/api/users/new", (req, res) => {
    res.json(createRandomUser());
});

app.get("/api/companies/new", (req, res) => {
    res.json(createRandomCompany());
});

app.get("/api/user/company", (req, res) => {
    res.json([createRandomUser(), createRandomCompany()]);
});

app.listen(port, () => {
    console.log(`Listening on port ${port}`);
});
