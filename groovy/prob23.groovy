def divisors(n){
    def divisors = [] as Set
    
    if(n==0) return divisors
    

    divisors<<1
    def a = n/2
    for(int i=2; i<=a; i++){
        if(n%i == 0 && (!divisors.contains(i) || !divisors.contains(n/i))){
            divisors << i
            divisors << n/i
            a=n/i
        }
    }
    return divisors.sort().unique()
}

def sum(list){
    def sum = 0
    list.each{sum+=it}
    sum
}

def abundant = []
1.upto(28123){
    if(sum(divisors(it)) > it){
        abundant << it
    }
}

def abundantSum = [] as Set
abundant.each{ first ->

    abundant.each{ second ->
        def temp = first+second
        if(temp <=28123){
            abundantSum << temp
        }
    }
}

def sumAbundantSum = 28123*28124/2 - sum(abundantSum)
println sumAbundantSum