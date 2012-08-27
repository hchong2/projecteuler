def isPrime(int num){
    if(num==0 || num==1){
        return false;
    }
    int root = (int)Math.sqrt(num);

    for(int i=2; i<=root; i++){
        if(num%i == 0){
            return false;
        }
    }
    return true;
}

def truncateRightToLeftPrime(n){
    def string = n.toString()
    if(string.size()==1){
        return false
    }
    
    def bool = true
    1.upto(string.size()){
        if(!isPrime(string[0..(-1)*it].toInteger())){
            bool = false
        }
    }
    return bool
}

def truncateLeftToRightPrime(n){
    def string = n.toString()
    if(string.size()==1){
        return false
    }
    
    def bool = true
    1.upto(string.size()){
        if(!isPrime(string[it-1..-1].toInteger())){
            bool = false
        }
    }
    return bool
}

assert truncateRightToLeftPrime(3797)

def list = []
def sum = 0
1.step(1000000, 2){
    if((it.toString()[-1] == '3' || it.toString()[-1] == '7') && truncateLeftToRightPrime(it) && truncateRightToLeftPrime(it)){
       sum+=it
       list <<it
    }
     
}

assert list.size() == 11
println sum