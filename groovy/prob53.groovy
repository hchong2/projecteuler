def fac(n){
	if(n == 0){
		return 1;
	}
	return (BigInteger)n*fac(n-1)
}
def comb(n, r){
	return fac(n)/(fac(r)*fac(n-r))
}

n = 100

def a = 0
for(int i=23; i<=n; i++){

	for(int y=1; y<=i; y++){
		if(comb(i, y) > 1000000){
			a++;
		}
	}

}

println a