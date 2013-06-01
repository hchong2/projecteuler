def isPrime(int num){
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
def findMaxSquareRootFactor(n){
	return (int)Math.floor(Math.sqrt(n/2));
}
def isOddComposite(n){
	if(n % 2 == 0){
		return false
	}

	if(isPrime(n)){
		return false
	}
	return true
}
def testConjecture(n){
	for(int i=findMaxSquareRootFactor(n); i>=1; i--){
		def primeCandidate = (int) n-2*Math.pow(i,2)
		if(isPrime(primeCandidate)){
			return true;
		}
	}
	return false;
}
def n = 9
while(true){
	if(isOddComposite(n) && !testConjecture(n)){
		println n
		break
	}
	n+=2
}