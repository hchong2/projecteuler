def multiplyLastTenDigits(n){
    Long product = 1
    1.upto(n){
        product *= n
        if(product.toString().size() > 10){
            product = product.toString()[-10..-1].toLong()
        }
    }
    product
}

def n = 10
def sum=0
1.upto(n){
    sum += it**it
}


Long sum2 = 0
1.upto(n){
    sum2 += multiplyLastTenDigits(it)
}
assert sum.toString()[-10..-1].toLong() == sum2


Long sum3= 0 
1.upto(1000){
sum3 +=multiplyLastTenDigits(it)
}
println sum3.toString()[-10..-1]