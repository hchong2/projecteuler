def getTriangleSides(n){
    def solutions = []
    
    if(n<12) return solutions
    
    int half = n/2;
    int third = n/3;
    
    1.upto(third){ a ->
    
        
        third.upto(half){ b ->
            int c = n-a-b
            if(c >b && c>a && c**2 == a**2+b**2){
                solutions << [a,b,c]
            }
        }
    }
    
    solutions
}

def max = 0
def maxN = 0 
1.upto(1000){

    def a = getTriangleSides(it)
    if(a && a.size()>max){
        maxN = it
        max = a.size()
        println it  + " " + a.size()
    }
}

println "answer: " + maxN + " " + max