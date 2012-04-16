import java.util.*;

public class Problem26 {
	
	public static void main(String [] args){
		int maxLength=0;
		for(int i=2; i<1000; i++){
			int length = cycleLength(i);
			if(length>maxLength){
				maxLength = length;
				System.out.println("number: " + i + " length: " + length);
			}
		}
	}

	public static int cycleLength(int denom){
		ArrayList<KV> list = new ArrayList<KV>();

		int numerator = 10;
		int quotient = 0;
		int remainder = 0;

		while(true){
			if(numerator < denom){
				quotient=0;
				remainder = numerator;
				KV temp = new KV(quotient, remainder);
				int index = KV.getIndex(list, temp);
				if(index==-1){
					list.add(temp);
				}else{
					return list.size() - index;
				}

				numerator = numerator * 10;
			}
			else{
				quotient = (int)Math.floor(numerator/denom);
				remainder = numerator % denom;
				numerator = remainder*10;
				if(remainder == 0){
					break;
				}
				KV temp = new KV(quotient, remainder);

				int index = KV.getIndex(list, temp);
				if(index==-1){
					list.add(temp);
				}else{
					return list.size() - index;
				}
			}
			
		}
		return 0;
	}
}

class KV{
	int key;
	int value;
	public KV(int k, int v){
		this.key = k;
		this.value = v;
	}

	public static int getIndex(ArrayList<KV> list, KV kv){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).myEquals(kv)){
				return i;
			}
		}
		return -1;
	}
	public boolean myEquals(KV kv){
		if(this.key == kv.key && this.value == kv.value){
			return true;
		}
		return false;
	}
}