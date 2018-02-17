
public class HashMapChaining {

	private int maxSize;
	private LinkedHashMap[] hashTable;
	private int size=0;
	
	public HashMapChaining(int table_size){
		maxSize=table_size;
		hashTable=new LinkedHashMap[maxSize];
		
		for (int i = 0; i < maxSize; i++) {
			hashTable[i]=null;
		}
	}

	public int findValue(String key){
		int index=myhash(key)%maxSize;
			if(hashTable[index].getKey().equals(key)){
				return hashTable[index].getValue();
			}
	
		return -1;
	}
	
	public void removeValue(String key){
		int index=myhash(key)%maxSize;
		
		if(hashTable[index]==null){
			return;
		}
		
		else{
			LinkedHashMap prev=null;
			LinkedHashMap entry=hashTable[index];
				while(entry.getNext()!=null && !entry.getKey().equals(key)){
					prev=entry;
					entry=entry.getNext();
				}
				
				if(entry.getKey().equals(key)){
					if(prev!=null)
						prev.setNext(entry.getNext());
					else
						hashTable[index]=entry.getNext();			
				size--;	
				}
		}
	}
	
	public void addElement(String key,int value){
		int index=myhash(key)%maxSize;
		
		if(hashTable[index]==null){
			hashTable[index]=new LinkedHashMap(key,value);
		}
		
		else{
				LinkedHashMap entry=hashTable[index];
				while(entry.getNext()!=null && entry.getKey()!=key)
					entry=entry.getNext();
				if(entry.getKey()==key)
					entry.setValue(value);
				else
					entry.setNext(new LinkedHashMap(key,value));			
		}
		size++;
	}
	
	public void printTheHash(){
		for (int i = 0; i < maxSize; i++) {
			System.out.print("\nBucket "+(i+1)+":");
			LinkedHashMap entry=hashTable[i];
			while(entry!=null){
				System.out.print(entry.getValue()+"->");
				entry=entry.getNext();
			}
		}

	}
	
	
    private int myhash(String x)
    {
        int hashVal = x.hashCode( );
        hashVal %= maxSize;
        if (hashVal < 0)
            hashVal += maxSize;
        return hashVal;
    }
	
	public static void main(String[] args) {
		HashMapChaining xyz=new HashMapChaining(5);
		xyz.addElement("water", 100);
		xyz.addElement("apple", 5);
		xyz.addElement("mango", 24);
		xyz.addElement("guava", 13);
		xyz.addElement("pineapple", 17);
		xyz.addElement("strawberry", 37);
		xyz.addElement("ali", 108);
		
		xyz.printTheHash();
		System.out.println("\n");
		System.out.println("**************************************************************");
	
		xyz.removeValue("water");
		xyz.addElement("strawberry", 100);
		xyz.printTheHash();
		System.out.println("\n");
		System.out.println(xyz.findValue("guava"));
		System.out.println(xyz.findValue("xgvfgbfvx"));
	
	}

}
