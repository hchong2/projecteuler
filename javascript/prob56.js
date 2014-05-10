var max = 0;
for(var a=1; a<100; a++){
	for(var b=1; b<100; b++){
		var ex = exp_(a.toString(),b);
		var digSum = digitalSum(ex);
		max = Math.max(max, digSum);
	}
}
console.log(max);

function exp_(a,b){
	var result = a.toString();
	if(a == 1 || b == 0){
		return 1;
	}
	else if(b == 1){
		return a;
	}

	for(var i=1; i<b; i++){
		result = multiply(result, a);
	}
	return result;
}
function digitalSum(s){
	var sum = 0;
	s = s.toString().split("");
	for(var i=0; i<s.length; i++){
		sum += parseInt(s[i], 10);
	}
	return sum;
}

function multiply(s, multiplier){
	var arr = s.split("");
	var aux = [];
	var result = [];
	for(var i=arr.length-1; i>=0; i--){
		var digit = parseInt(arr[i], 10);
		var product = digit * multiplier;
		aux.push(product);
	}
	aux = aux.reverse();
	var carryOver = 0;
	for(var i=aux.length-1; i>=0; i--){
		var number = aux[i] + carryOver;
		var arrayify = number.toString().split("");
		//Push the last digit to result
		result.push(arrayify[arrayify.length-1]);
		if(arrayify.length > 1){
			carryOver = parseInt(arrayify.splice(0, arrayify.length-1).join(""), 10);
		}else{
			carryOver = 0;
		}
	}
	if(carryOver > 0){
		result = result.concat(carryOver.toString().split("").reverse());
	}
	return result.reverse().join("");
}



