package reference;

public enum EnumAccessoryTypes {
	none,
	ring,
	necklace,
	lens,
	crystal,
	bracelet,
	runeSigil,
	belt;
	
	
	
	public int getLimit(){
		int limit = 0;
		switch(this){
		case none: limit = 0; break;
		case ring: limit = 2;break;
		case necklace: limit = 1;break;
		case lens: limit = 2;break;
		case crystal:limit = 1;break;
		case bracelet: limit = 2;break;
		case runeSigil: limit = 1;break;
		case belt: limit = 1;
		break;
		}
		return limit;
	}
}