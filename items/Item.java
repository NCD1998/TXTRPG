package items;

import creatures.CreatureBase;
import reference.EnumAccessoryTypes;
import reference.EnumArmorType;

abstract public class Item {

	private final boolean isAccessory;
	private String name;
	private double weight;
	private final boolean isarmor;
	private final boolean consumeOnUse;
	private int uses;
	private double[] meleeAttackDamage;
	
	public Item(String name, double weight, boolean isarmor, boolean isaccessory, boolean consumeOnUse, int uses, double meleeAttackDamage){
		this.name = name;
		this.weight = weight;
		this.isarmor = isarmor;
		this.isAccessory = isaccessory;
		this.consumeOnUse = consumeOnUse;
		this.uses = uses;
	}
	public Item(String name, double weight, boolean isarmor, boolean isaccessory, boolean consumeOnUse, int uses){
		this.name = name;
		this.weight = weight;
		this.isarmor = isarmor;
		this.isAccessory = isaccessory;
		this.consumeOnUse = consumeOnUse;
		this.uses = uses;
		this.meleeAttackDamage = new double[1];
		this.meleeAttackDamage[0] = 1;
	}

	//Called on pickup
	public void onPickup(CreatureBase owner) {
		// TODO Auto-generated method stub
		
	}

	public double getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}

	public void onDrop(CreatureBase owner) {
		// TODO Auto-generated method stub
		
	}

	public boolean isArmor() {
		return isarmor;
	}

	public EnumArmorType getArmorType() {
		return EnumArmorType.none;
	}

	public boolean isAccessory() {
		return isAccessory;
	}

	public EnumAccessoryTypes getAccessoryType() {
		return EnumAccessoryTypes.none;
	}

	public void equip(CreatureBase owner) {
		// TODO Auto-generated method stub
		
	}

	public void dequip(CreatureBase owner) {
		// TODO Auto-generated method stub
		
	}
	
	public double[] meleeAttackDamage(){
		return meleeAttackDamage;
	}
	public double[] meleeAttackDamage(CreatureBase owner) {
		// TODO Auto-generated method stub
		return null;
	}

}
