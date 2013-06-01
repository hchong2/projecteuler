def isPandigital(n, digits){
	def set = n.toString().toList() as Set

	def sum = 0
	set.each{
		sum += new Integer(it);
	}
	def expectedsum = digits*(digits+1)/2
	if(set.size() == digits && sum == expectedsum){
		return true
	}
	return false
}

def getConcatProduct(factor, n){
	def string = ""
	(1..n).each{
		string+="${factor*it}"
	}
	return new BigInteger(string)
}

def max = 0
for(int n=2; n<=9; n++){
	def multiplyFactor = 1;
	while(true){
		def concatproduct = getConcatProduct(multiplyFactor, n)
		if(concatproduct.toString().size() > 9){
			break;
		}
		if(isPandigital(concatproduct, 9)){
			max = Math.max(max, concatproduct)
		}
		multiplyFactor++
	}

}
println max