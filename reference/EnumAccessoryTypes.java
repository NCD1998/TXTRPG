package reference;

public enum EnumAccessoryTypes {
	none;
	
	
	public int getLimit(){
		int limit = 0;
		switch(this){
		case none: limit = 0;
		break;
		}
		return limit;
	}
}