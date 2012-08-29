def checkAll(tn, pn, hn){
    def triangle = triangle(tn)
    def pentagonal= pentagonal(pn)
    def hexagonal = hexagonal(hn)
    
    if(triangle == pentagonal && triangle == hexagonal){
        return true
    }
    return false
    
      
}
def triangle(n){
    (int) 1/2*n*(n+1)
}
def pentagonal(n){
    (int) 1/2*n*(3*n-1)
}
def hexagonal(n){
    (int) n*(2*n-1)
}

def findMin(a,b,c){
    Math.min(Math.min(a,b),c)
}

def tn = 286
def pn = 166
def hn = 144

while(!checkAll(tn, pn, hn)){
    def triangle = triangle(tn)
    def pentagonal = pentagonal(pn)
    def hexagonal = hexagonal(hn)
    
    if(triangle < pentagonal && triangle < hexagonal){
        tn++
    }
    else if(triangle == pentagonal && triangle < hexagonal){
        tn++
    }
    else if(triangle == hexagonal && triangle < pentagonal){
        tn++
    }
    else if(pentagonal == hexagonal && hexagonal < triangle){
        pn++
    }
    else if(pentagonal < triangle && pentagonal < hexagonal){
        pn++
    }
    else if(hexagonal < triangle && hexagonal < pentagonal){
        hn++
    }
    
    println triangle + " " + pentagonal + " " + hexagonal
    
}

assert checkAll(tn, pn, hn)
println triangle(tn) + " " + pentagonal(pn) + " " + hexagonal(hn)