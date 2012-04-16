public class Problem19 {
	
	public static void main(String [] args){
		
		int days=366;
		int count=0;
		for(int year=1901; year<=2000; year+=1){

			for(int month=1; month<=12; month++){
				if(matchMonth(month, 1, 3, 5, 7, 8, 10, 12)){
					days+=31;
				}
				else if(matchMonth(month, 4, 6, 9, 11)){
					days+=30;
				}
				else if(month == 2){
					if(year % 100 == 0 && year % 400 == 0){
						days+=29;
					}else if(year%4==0 && year%100!=0){
						days+=29;
					}else{
						days+=28;
					}
				}

				if(days%7==0){
					count++;
					System.out.println("year: " + year + " month: " + month + " days: " + days);
				}
			}
		}
		System.out.println("count: " + count);

	}
	public static boolean matchMonth(int month, int ...numbers){
		for(int i=0; i<numbers.length; i++){
			if(month == numbers[i])
				return true;
		}
		return false;
	}
}