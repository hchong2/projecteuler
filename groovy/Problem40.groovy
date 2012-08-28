def n = 1000000

def current = 1
def length = 0
def target =1
def product = 1
1.upto(n){
    length += current.toString().size()
    
    if(length >= target){
        if(length == target){
            println current.toString()[-1]
            product *= current.toString()[-1].toInteger()
        }
        else if(length > target){
            def temp = length - target
            println length +  " " + current.toString() +  " " + current.toString()[-1*(temp+1)]
            product *= current.toString()[-1*(temp+1)].toInteger()
        }
        target *= 10
        
    }    
    current++
    
}
println product