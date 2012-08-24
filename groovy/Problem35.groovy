def isPrime(int num){
	if(num==0 || num==1){
		return false;
	}

	int root = (int)Math.sqrt(num);

	for(int i=2; i<=root; i++){
		if(num%i == 0){
			return false;
		}
	}
	return true;
}
def primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
primes.each{
	assert isPrime(it)
}


def isCircularPrime(int num){

	if(!isPrime(num)){
		return false
	}
	def numString = num.toString()

	if(numString.size()==1) return true
	
	def isCircular = false
	
	numString.size().times{
		if(isPrime(numString.toInteger())){
			isCircular = true
			numString = numString[1..-1,0]
		}else{
			isCircular = false
		}
	}
	return isCircular
}
def circularPrimes = [2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, 97, 197]
circularPrimes.each{
	assert isCircularPrime(it)
}


def count = 0

def bound = 1000000
bound.times{
	if(isCircularPrime(it))
		count++
}

println count