package reference;

public enum EnumDamageTypes {
	melee,
	poison,
	pure,
	fire,
	magical,
	electrical,
	soul,
	water,
	air,
	earth,
	debuff;
	
	public int getArrayNum(){
		int number = 0;
		switch(this){
		case melee: number = 0; break;
		case poison: number = 1; break;
		case pure: number = 2; break;
		case fire: number = 3; break;
		case magical: number = 4; break;
		case electrical: number = 5; break;
		case soul: number = 6; break;
		case water: number = 7; break;
		case air: number = 8; break;
		case earth: number = 9; break;
		case debuff: number = 10; break;
		}
		return number;
	}
}
