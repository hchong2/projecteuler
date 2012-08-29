def check(n,d){
    def answer
    def ns = n.toString()
    def ds = d.toString()
    
    if(n<d 
           && n%11 != 0 && d%11 != 0
           && n%10 !=0 && d%10 !=0 
           && ns.reverse() != ds){
        if(ns[0] == ds[-1]){
            if(ns[-1].toInteger()/ds[0].toInteger() == n/d){
                answer = [n,d]
            }
        }
        else if(ns[-1] == ds[0]){
            if(ns[0].toInteger()/ds[-1].toInteger() == n/d){
                answer = [n,d]
            }
        }
    }

}


def list = []
10.upto(98){ a ->

    (a+1).upto(99){ b ->
        def t = check(a,b)
        if(t){
            list << t
        }
    }
    
}

def num=1
def den=1
list.each{ pair ->
    num*=pair[0]
    den*=pair[1]
}

println num/den