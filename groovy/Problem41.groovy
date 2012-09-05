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

def permute(str){
    def length = str.length()
    def used = new boolean[length]
    def out = new StringBuffer()
    def inn = str.toCharArray()

    doPermute(inn, out, used, length, 0);
}

def doPermute(inn, out, used, length, level){
    if(level == length){
        def output = out.toString()
        if(isPrime(output.toInteger())){
            println output
        }
        return;
    }
    for(int i=0; i<length; i++){
        if(used[i]) continue;

        out.append(inn[i]);
        used[i] = true;
        doPermute(inn, out, used, length, level+1);
        used[i] = false;
        out.setLength(out.length()-1);
    }
}

permute("7654321")