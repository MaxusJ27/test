const bodyParser = require('body-parser')
const express = require('express')
const app = express()
const port = 5000
const cors = require('cors')


const queueModule = require('./models/index')
const queue = new queueModule.Queue();

app.use(cors())
app.use(express.json())
app.use(bodyParser.urlencoded({
  extended: true
}));

/**bodyParser.json(options)
* Parses the text as JSON and exposes the resulting object on req.body.
*/
app.use(bodyParser.json());
app.post('/queue', async (req, res) => {
  console.log(req.body.number)
  queue.enqeueue(req.body.number.toString())
})

app.get('/current', async (req, res) => {
  res.send(queue.dequeue());
})
app.get('/queue', async (req, res) => {
  res.send(queue);
})
app.get('/end', async (req, res) => {
  res.send(queue.getQueue()[queue.size() - 1]);
})
app.get('/head', async (req, res) => {
  res.send(queue.getQueue()[0]);
})



app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})