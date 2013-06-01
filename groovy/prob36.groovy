def number= 1000000
def sum = 0
1.upto(number){
    def string = it.toString()
    def binaryString = Integer.toBinaryString(it)
    if(string == string.reverse() && binaryString == binaryString.reverse()){
        sum+=it
    }
}

println sum