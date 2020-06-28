const http = require('http')
const bl = require('bl')
const results = []
let count = 0

function printResults () {
  for (let i = 0; i < 3; i++) {
    console.log(results[i])
  }
}

function httpGet (index) {
  http.get(process.argv[2 + index], function (response) {
    response.pipe(bl(function (err, data) {
      if (err) {
        return console.error(err)
      }

      results[index] = data.toString()
      count++

      if (count === 3) {
        printResults()
      }
    }))
  })
}

for (let i = 0; i < 3; i++) {
  httpGet(i)
}

/*const async = require("async");
 
let obj = {first: process.argv[2], second: process.argv[3], third: process.argv[4]};

let dataArr = [];
async.forEachOf(obj, (value, key, callback) => {
    
    http.get(value, function (resp) {
       
        let data = '';
      
        // A chunk of data has been recieved.
        resp.on('data', (chunk) => {
          data += chunk;
        });
      
        // The whole response has been received. Print out the result.
        resp.on('end', () => {
          
          dataArr.push(data)
        });
      
      }).on("error", (err) => {
        console.log("Error: " + err.message);
      });
        
        callback();
    });


    dataArr.forEach(element => {
        console.log(element);
    });
*/