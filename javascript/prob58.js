function isPrime(value){
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

function getCornerNumbers(sideLength){
	if(sideLength == 1){
		return [1];
	}
	if(!getCornerNumbers.answers){
		getCornerNumbers.answers = {};
	}
	if(getCornerNumbers.answers[sideLength]){
		return getCornerNumbers.answers[sideLength];
	}
	
	var n = 1;
	var addFactor = 2;
	var cornerNumbers = [];
	for(var i=3; i<=sideLength; i+=2){
		for(var y=0; y<4; y++){
			n += addFactor;
			// console.log(n)
			if(cornerNumbers.indexOf(n) < 0){
				cornerNumbers.push(n);
			}
		}
		getCornerNumbers.answers[i] = cornerNumbers
		addFactor += 2;
		cornerNumbers = [];
	}
	return getCornerNumbers.answers[sideLength];
}

var assert = require('assert');
assert.deepEqual(getCornerNumbers(1), [1]);
assert.deepEqual(getCornerNumbers(3), [3, 5, 7, 9]);
assert.deepEqual(getCornerNumbers(5), [13, 17, 21, 25]);
assert.deepEqual(getCornerNumbers(7), [31, 37, 43, 49]);


var diagonalNumbers = [1];
var diagonalPrimeNumbers = [];
var sideLength = 3;
var count = 0;
while(true){
	var cornerNumbers = getCornerNumbers(sideLength);
	diagonalNumbers = diagonalNumbers.concat(cornerNumbers);
	var minusRootNumber = cornerNumbers.slice(0, cornerNumbers.length-1);
	for(var i=0; i<minusRootNumber.length; i++){
		if(isPrime(minusRootNumber[i]) && diagonalPrimeNumbers.indexOf(minusRootNumber[i]) < 0){
			diagonalPrimeNumbers.push(minusRootNumber[i]);
		}
	}
	if(diagonalPrimeNumbers.length / diagonalNumbers.length < .1){
		break;
	}
	sideLength += 2;
}
console.log(sideLength);
