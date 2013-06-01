def calcPentagonalNumber(n){
	return n*(3*n-1)/2
}
def store = [] as Set
def n = 1
def flag = true;
while(flag){
	def pk = calcPentagonalNumber(n)
	store << pk

	def i = n+1
	def pi = calcPentagonalNumber(i)
	store << pi

	def pj = pi - pk
	while(pj < pk){
		def diff = pk - pj
		if(store.contains(pj) && store.contains(diff)){
			println "n: ${n}, pk: ${pk}, pj: ${pj}, pi: ${pi} diff: ${diff}"
			flag = false;
			break;
		}
		if(pk < 0 || pi < 0 || pj < 0){
			println "VALUE OVERFLOW"
			println "n: ${n}, pk: ${pk}, pj: ${pj}, pi: ${pi} diff: ${diff}"
			flag = false;
			break;
		}
		i++
		pi = calcPentagonalNumber(i)
		store << pi
		pj = pi - pk
	}

	n++
}