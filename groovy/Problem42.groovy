def findN(triangleNumber){
    (int) (-1+Math.sqrt(1+8*triangleNumber))*1/2
}

def triangleNumber(n){
    (int) 1/2*n*(n+1)
}

def alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def scan = new Scanner(new File("./Problem42.txt"))

def lines = []
while(scan.hasNextLine()){
    lines << scan.nextLine()
}

def words = []
lines.each{ line ->
    words += line.replaceAll("\"", "").tokenize(',')
}


def triangleWords = []
words.each{ word ->
    def sum = 0
    word.each{ letter ->
        sum+= alphabet.indexOf(letter)
    }
    
    def temp = findN(sum)
    
    if(triangleNumber(temp) == sum){
        triangleWords << word       
    }
}

println triangleWords.size()