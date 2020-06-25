const mymodule = require('./mymodule.js')  
const ext = process.argv[3]
const dir = process.argv[2]

mymodule(dir, ext, function (err, list) {
    if (err) {
      return console.error('There was an error:', err)
    }
  
    list.forEach(function (file) {
      console.log(file)
    })
  })


/*
mymodule(dir, filterStr, function (err, list) {
    if (err) {
      return console.error('There was an error:', err)
    }
  
    list.forEach(function (file) {
      console.log(file)
    })
  })*/