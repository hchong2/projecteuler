def calcPentagonalNumber(n){
	return n*(3*n-1)/2
}

1.upto(100){
	def diff=calcPentagonalNumber(it+1) - calcPentagonalNumber(it)
	println "n: ${it+1}; diff: ${diff}"
}
