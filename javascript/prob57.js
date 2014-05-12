var iterations = 1000;

var ans = {num: "1", den:"2"};
if(iterations == 0){
	return ans;
}
var count = 0;
for(var i=1; i<=iterations; i++){
	ans = transform(ans);

	var aa = addTwoNumberStrings(ans.num, ans.den)
	if(aa.length > ans.den.length){
		count++;
	}
}
console.log("COUNT: " + count)


function transform(fraction){
	var num = fraction.num;
	var den = fraction.den;
	num = addTwoNumberStrings(num, multiply(den, 2));
	return {num: den, den: num};
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

function addTwoNumberStrings(st1, st2){
	var arr1 = st1.split("").reverse();
	var arr2 = st2.split("").reverse();

	var len = Math.max(arr1.length, arr2.length);
	var result = [];
	var carryOver = 0;
	for(var i=0; i<len; i++){
		var n1 = parseInt(arr1[i], 10);
		var n2 = parseInt(arr2[i], 10);
		var sum = 0;
		if(!isNaN(n1)) sum += n1;
		if(!isNaN(n2)) sum += n2;
		sum += carryOver;

		if(sum / 10 >= 1){
			carryOver = 1;
		}else{
			carryOver = 0;
		}
		result.push(sum.toString().substring(sum.toString().length-1, sum.toString().length));
	}
	if(carryOver == 1){
		result.push("1");
	}
	return result.reverse().join("");
}