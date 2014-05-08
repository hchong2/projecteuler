var counter = 1;

while(true){
	var x = counter;
	var x2 = counter*2;
	var x3 = counter*3;
	var x4 = counter*4;
	var x5 = counter*5;
	var x6 = counter*6;

	var xs = x.toString().split("").sort().join("");
	var x2s = x2.toString().split("").sort().join("");
	var x3s = x3.toString().split("").sort().join("");
	var x4s = x4.toString().split("").sort().join("");
	var x5s = x5.toString().split("").sort().join("");
	var x6s = x6.toString().split("").sort().join("");

	if(xs == x2s && x2s == x3s && x3s == x4s && x4s == x5s && x5s == x6s){
		console.log(x);
		break;
	}
	counter++;
}