
public class LinearProbing {

	private int[] keys;
	private int[] values;
	private int size,count=0;
	
	private int empty=Integer.MIN_VALUE;
	
	public LinearProbing(int table_size){
		size=table_size;
		keys=new int[size];
		values=new int[size];
	}
	
	public void addElement(int key,int value){
		int index=key%size;
		int counter=1;
		
		for (int i = 0; i < index; i++) {
			if(keys[i]==0 && values[i]==0){
				keys[i]=key;
				values[i]=value;
				count++;
				return;
			}
			if(keys[i]==key){
				System.out.println("Exist Already");
				return;
			}
			counter=(counter+i)%size;
		}
	
	}
	
	public int findElement(int key){
		int index=key%size;
		int counter=1;
		
		for (int i = 0; i < index; i++) {
			if(keys[i]==key)
				return values[i];
			counter=(counter+i)%size;
		}
		return -1;
	}
	
	public void printThaHash(){
		System.out.println("Hash Table Linear Probing");
		for (int i = 0; i < count; i++) {
			System.out.println(keys[i]+":"+values[i]);
		}
	}
	
	public void deleteElement(int key){
		int index=key%size;
		
		while(keys[index]!=key)
			index=(index+1)%size;
		keys[index]=0;
		values[index]=0;
		
		index=(index+1)%size;
		while(keys[index]!=0){
			int keyToHash=keys[index];
			int valueToHash=values[index];
			keys[index]=0;
			keys[index]=0;
			count--;
			addElement(keyToHash, valueToHash);
			index=(index+1)%size;
		}
		count--;

	}
	
	public static void main(String[] args) {
		LinearProbing lp = new LinearProbing(10);
		
		lp.addElement(1, 2);
		lp.addElement(4, 5);
		lp.addElement(7, 10);
		lp.addElement(9, 90);
		
		lp.printThaHash();
		System.out.println(lp.findElement(7));
		System.out.println(lp.count);
		lp.deleteElement(4);
		System.out.println("**************************");
		lp.printThaHash();
	
	}

}
