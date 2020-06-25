const fs = require('fs');

let buffer = fs.readFileSync(process.argv[2])
let str = buffer.toString()

console.log(str.split('\n').length - 1)
