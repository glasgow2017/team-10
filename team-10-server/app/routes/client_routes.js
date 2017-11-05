var ObjectID = require('mongodb').ObjectID

module.exports = function(app, db) {
  app.get('/client/:id', (req, res) => {
  	const id = req.params.id;
    const details = { '_id': new ObjectID(id) };
    db.collection('clients').findOne(details, (err, item) => {
      if (err) {
        res.send({'error':'An error has occurred'});
      } else {
        res.send(item);
      }
    });
  });
  
  app.delete('/notes/:id', (req, res) => {
    const id = req.params.id;
    const details = { '_id': new ObjectID(id) };
    db.collection('clients').remove(details, (err, item) => {
      if (err) {
        res.send({'error':'An error has occurred'});
      } else {
        res.send('client ' + id + ' deleted!');
      } 
    });
  });

  app.post('/client', (req, res) => {
    const client = { fName: req.body.fName, age: req.body.age, };
    db.collection('clients').insert(client, (err, result) => {
      if (err) { 
        res.send({ 'error': 'An error has occurred' }); 
      } else {
        res.send(result.ops[0]);
      }
    });
  });
  
  app.put('/client/:id', (req, res) => {
    const id = req.params.id;
    const details = { '_id': new ObjectID(id) };
    const note = { fName: req.body.fName, age: req.body.age, };
    db.collection('client').update(details, client, (err, result) => {
      if (err) {
          res.send({'error':'An error has occurred'});
      } else {
          res.send(note);
      } 
    });
  });
  
};
