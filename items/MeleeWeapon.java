package items;

import creatures.CreatureBase;
import reference.EnumDamageTypes;

public class MeleeWeapon extends Item {
	
	private final EnumDamageTypes[] magicQualities;
	private final int[] magicLevel;
	private final int critChance;
	private final double damage;

	public MeleeWeapon(String name, double weight, double damage, EnumDamageTypes[] magicQualitys, int[] magicLevel, int critChance) {
		super(name, weight, false, false, false, 0);
		this.critChance = critChance;
		this.magicLevel = magicLevel;
		this.magicQualities = magicQualitys;
		this.damage = damage;
	}
	
	public MeleeWeapon(String name, double weight, double damage, int critChance) {
		super(name, weight, false, false, false, 0);
		this.critChance = critChance;
		this.magicLevel = new int[0];
		this.magicQualities = new EnumDamageTypes[0];
		this.damage = damage;
	}

	@Override
	public double[] meleeAttackDamage() {
		double[] attackArray = new double[11];
		//melee
		attackArray[0] = damage;
		for(int x = 1; x < 11; x++){
			attackArray[x] = 0;
		}
		for(int x = 0; x < magicQualities.length; x++){
			attackArray[magicQualities[x].getArrayNum()] = magicLevel[x];
		}
		return attackArray;
	}
	
	public double getCritChance(){
		return critChance;
	}


}
