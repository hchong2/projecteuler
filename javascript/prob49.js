function isPrime_(value){
	if(!isPrime.answers){
		isPrime.answers = {};
	}
	if(isPrime.answers[value] != null){
		return isPrime.answers[value];
	}

	var prime = value != 1; //1 can never be prime
	var root = Math.floor(Math.sqrt(value));
	for(var i=2; i<root; i++){
		if(value % i == 0){
			prime = false;
			break;
		}
	}
	return isPrime.answers[value] = prime;
}

var primeNumbers = [];
for(var i=2; i<10000; i++){
	if(i % 2 == 1){
		if(isPrime_(i) && i > 1000){
			primeNumbers.push(i);
		}

	}
}

var a = 2;

for(var i=0; i<primeNumbers.length; i++){
	var x = primeNumbers[i];
	while(true){
		var y = x+a;
		var z = y+a;
		if(y % 2 == 0 || z % 2 == 0){
			a++;
			continue;
		}
		if(y >= 10000 || z >= 10000){
			break;
		}
		if(primeNumbers.indexOf(y) > -1 && primeNumbers.indexOf(z) > -1){
			var xs = x.toString().split("").sort().join("");
			var ys = y.toString().split("").sort().join("");
			var zs = z.toString().split("").sort().join("");
			if(xs == ys && ys == zs){
				console.log("FOUND: " + x + " " + y + " " + z + " DIFF: " + a);
			}
		}
		a++;
	}
	a = 2;
}
