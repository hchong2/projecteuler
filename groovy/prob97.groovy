def n = 1;

for(int i=1; i<=7830457; i++){
	n *= 2
	n = n%10000000000
}

n = n*28433+1
println n.toString().toList()[-10..-1].join("")