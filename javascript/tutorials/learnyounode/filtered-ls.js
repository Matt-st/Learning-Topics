const fs = require('fs')
const ext = '.' + process.argv[3]
fs.readdir(process.argv[2], printMatchingExt)

function printMatchingExt(err, data){
	if(err){
		console.log(err)
	}
	data.forEach(function (item, index) {
		if(item.endsWith(ext)){
			console.log(item);
		}
		
		
	  });
}

/*
example
function printThem(item, index) {
	if(item.endsWith(ext)){
		console.log(item);
	}
	
	
  }
filtering example
function filterByExtension (err, data){
	if(err) {
		console.log(err)
	}	
	let filtered = data.filter(filterMethod)

	console.log(filtered)
}

function filterMethod(str){

	return str.endsWith('.'+process.argv[3])
}*/

