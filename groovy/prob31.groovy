def nextFactor(factor){
	if(factor == 1){
		return 1
	}
	def list = [200,100,50,20, 10, 5, 2, 1]
	def index = list.indexOf(factor)

	return list[index+1]
}
def coinCombinations(target, factor){
	def count = 0
	if(factor == 1){
		return 1
	}
	for(int i=target/factor; i>=0; i--){
		def diff = target - factor*i

		if(diff == 0){
			count++
		}
		else{
			count += coinCombinations(diff, nextFactor(factor))
		}
	}
	return count
}

println coinCombinations(200,200)