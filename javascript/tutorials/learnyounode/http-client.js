const http = require('http')


http.get(process.argv[2], function (resp) {
  let data = '';

  // A chunk of data has been recieved.
  resp.on('data', (chunk) => {
    console.log(chunk.toString('utf8'))
  });

  // The whole response has been received. Print out the result.
  resp.on('end', () => {
    
  });

}).on("error", (err) => {
  console.log("Error: " + err.message);
});


// http.get("/hello", function(req, res){
//     res.write("hello again");
//     res.end()
//   }).listen(8080);

// http.createServer(function (req, res) {
//     res.write('Hello World!'); //write a response to the client
//     res.end(); //end the response
//   }).listen(8080); //the server object listens on port 8080

  