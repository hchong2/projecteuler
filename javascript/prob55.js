var start = 10;
var end = 10000;
function reverseToString(n){
	var n = n.toString().split("").reverse().join("");
	return n;
}
function reverseAdd(n){
	return n + parseInt(reverseToString(n), 10);
}
function isPalindrome(n){
	var reverse = reverseToString(n);
	return n.toString() === reverse;
}

var iterationCount = 0;
var iterationLimit = 50;
var lychrelCount = 0;

for(var i=start; i<end; i++){
	var num = i;
	iterationCount++;
	num = reverseAdd(num);

	while(iterationCount < iterationLimit){
		if(isPalindrome(num)){
			break;
		}
		else{
			iterationCount++;
			num = reverseAdd(num);
		}
	}
	if(iterationCount >= iterationLimit){
		lychrelCount++;
	}
	iterationCount = 0;
}
console.log(lychrelCount);