const db = require('../db/queries')

const router = app => {
    app.get('/', (request, response) => {
        response.send({
            message: 'Node.js and Express REST API'
        });
    });
    app.get('/users', (request, response) => {
        db.getUsers(request, response)
    });
}
// Export the router
module.exports = router;