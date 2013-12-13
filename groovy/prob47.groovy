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
def isSquare(n){
	def sqrt = Math.floor(Math.sqrt(n));
	if(Math.pow(sqrt, 2) == n){
		return true;
	}
	return false;
}
def hasManyDistinctPrimeFactors(number, numberOfFactors){
	def allFactors = findAllFactors(number).sort();
	def factorTracker = allFactors

	while(!isAllFactorsPrime(factorTracker)  && factorTracker.size() > 1){
		factorTracker = findAllFactors(factorTracker[-1]).sort()
	}
	if(factorTracker.size() + 1 == numberOfFactors){
		return true;
	}
	return false
}

def isAllFactorsPrime(list){
	def isAllPrime = false;

	for(int i=0; i<list.size(); i++){
		if(isPrime((int)list[i])){
			isAllPrime = true;
		}
		else{
			return false;
		}
	}
	return isAllPrime
}
def findAllFactors(n){
	def factors = [] as Set
	def root = (int)Math.floor(Math.sqrt(n))
	for(int i=2; i<=root; i++){
		def isDivisible = ((int)n) % (int)i == 0 ? true : false
		if(isDivisible){
			factors << (int)i
			factors << (int)n/i
		}
	}
	return factors
}

// println findAllFactors(644).sort()
// println findAllFactors(322).sort()
// println findAllFactors(161).sort()

// println ""

// println findAllFactors(645).sort()
// println findAllFactors(215).sort()

// println ""

// println findAllFactors(646).sort()
// println findAllFactors(323).sort()

// println isPrime(43)
println hasManyDistinctPrimeFactors(644, 3)
assert hasManyDistinctPrimeFactors(644, 3)
assert hasManyDistinctPrimeFactors(645, 3)
assert hasManyDistinctPrimeFactors(646, 3)



def n = 1000
def counter = 0

while(true){
		println n
	if(hasManyDistinctPrimeFactors(n, 4)){
		counter++
	}else{
		counter = 0
	}
	if(counter == 4){
		println n
		break
	}
	n++
}