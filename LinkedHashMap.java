
public class LinkedHashMap {
	private String key;
	private int value;
	private LinkedHashMap next;
	
	public LinkedHashMap(String key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public LinkedHashMap getNext(){
		return next;
	}

	public void setNext(LinkedHashMap next) {
		this.next = next;
	}

}
