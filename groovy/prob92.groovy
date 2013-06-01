def chain(n){
	if(n == 1){
		return 1
	}
	if(n == 89){
		return 89
	}
	def sum = 0;
	def string = n.toString()
	0.upto(string.size()-1){
		sum += (int)Math.pow(new Integer(string.substring(it, it+1)), 2)
	}

	chain(sum);
}
def n = 10000000
def count = 0
1.upto(n){
	if(chain(it) == 89){
		count++
	}
}

println count