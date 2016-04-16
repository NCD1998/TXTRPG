package items;

import creatures.CreatureBase;
import reference.EnumAccessoryTypes;
import reference.EnumArmorType;

abstract public class Item {

	private final boolean isAccessory;
	private String name;
	private double weight;
	private final boolean isarmor;
	
	public Item(String name, double weight, boolean isarmor, boolean isaccessory){
		this.name = name;
		this.weight = weight;
		this.isarmor = isarmor;
		this.isAccessory = isaccessory;
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
		// TODO Auto-generated method stub
		return false;
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

}
