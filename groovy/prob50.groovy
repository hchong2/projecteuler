def isPrime(num){
	if(num==0 || num==1){
		return false;
	}
	int root = (int)Math.floor(Math.sqrt(num));
	for(int i=2; i<=root; i++){
		if(num%i == 0){
			return false;
		}
	}
	return true;
}

def primes = []
2.upto(1000000){
	if(isPrime(it)){
		primes << it
	}
}
println "Prime Calc Done.."
BigInteger sum = 0
def a = []
def b = []
def max = 0
for(int i=0; i<primes.size(); i++){

	for(int y=i; y<primes.size(); y++){
		sum += primes[y]
		a << primes[y]
		if(sum < 0){
			throw new Exception("Negative sum")
		}
		if(sum > 1000000){
			break
		}
		if(isPrime(sum) && sum <1000000){
			if(a.size() > max){
				println sum + " size: " +a.size()
				max = a.size();
				b = a
			}
		}
	}
	sum = 0;
	a = []
}

