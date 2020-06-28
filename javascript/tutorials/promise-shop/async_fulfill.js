
function resolveAfter2Seconds() {
    return new Promise(resolve => {
      setTimeout(() => {
        resolve('resolved');
      }, 2000);
    });
  }
  
  async function asyncCall() {
    console.log('calling');
    const result = await resolveAfter2Seconds();
    console.log(result);
    // expected output: 'resolved'
  }
  
  asyncCall();
  

 function wait() {
    return new Promise(function (fulfill, reject) {
        setTimeout(function () {
          fulfill('FULFILLED!')
        }, 300)
      })
  }
  
  async function hello() {
    const result = await wait();
    console.log(result)

  }
    hello()