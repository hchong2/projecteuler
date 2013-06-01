def isPandigital(n){
	def foo = n.toString().toList() as Set
	if(foo.size() == 10){
		return true
	}
	return false
}

def isSubstringDivisible(n){
	def divisibleBy = [2,3,5,7,11,13,17]
	def string = n.toString()
	def result = false
	for(int i=1; i<string.size()-2; i++){
		if(string.substring(i, i+3).toInteger() % divisibleBy[i-1] == 0){
			result = true
		}else{
			return false
		}
	}
	return result
}

def permute(list, result, index,set){
	if(list.size() == 0){
		set.add(new BigInteger(result.join("")))
		return
	}

	list.each{ a->
		result[index] = a
		permute(list - result, result, index+1, set)
		result[index]=-1
	}
}
def set = [] as Set
println "\nFinding all 10 digit permutations..."

def startTime = System.currentTimeMillis()
permute([1,2,3,4,5,6,7,8,9,0], [], 0, set)

println "Algorithm finished! Took ${(System.currentTimeMillis()-startTime)/1000} secs"
println "Finding answer.."
def sum = 0
set.each{
	if(isPandigital(it) && isSubstringDivisible(it)){
		sum+= it
	}
}
println sum