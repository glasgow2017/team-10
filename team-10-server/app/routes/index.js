const clientRoutes = require('./client_routes');
module.exports = function(app, db) {
  clientRoutes(app, db);
  // Other route groups could go here, in the future
};
