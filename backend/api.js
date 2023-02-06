const bodyParser = require('body-parser')
const express = require('express')
const app = express()
const port = 5000
const cors = require('cors')

/*
Uses Queue class model in models/Queue.ts
Index is used to import Queue as submodule.
tsc index.ts
*/
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
// posts value into the backend queue array
// show that backend is currently functional
app.get('/', (req, res) => {
  res.send('<h1>NodeJS started</h1>')
})
// enqueue value into the backend string 
app.post('/queue', async (req, res) => {
  queue.enqeueue(req.body.number.toString())
})

// dequeue and get the current ticket number
app.get('/current', async (req, res) => {
  res.json({'currentVal': queue.dequeue()});
})

// displays the array in the backend queue
app.get('/queue', async (req, res) => {
  res.json({'queue': queue});
})
// get the end of queue to display as now serving
app.get('/end', async (req, res) => {
  res.json({'end': queue.getQueue()[queue.size() - 1]});
})
// get the head end of queue
app.get('/head', async (req, res) => {
  res.send(queue.getQueue()[0]);
})



app.listen(process.env.PORT || port, () => {
  console.log(`Queue backend started on ${port}`)
})