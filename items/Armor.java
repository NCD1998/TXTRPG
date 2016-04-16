package items;

import creatures.CreatureBase;
import reference.EnumArmorType;
import reference.EnumDamageTypes;

public class Armor extends Item {

	private final EnumArmorType type;
	private final EnumDamageTypes[] resistances;
	private final int[] resistanceAmts;
	private final double protection;
	private final double castingDamage;
	
	
	public Armor(String name, double weight, EnumArmorType type, double castingDamage, double protection) {
		super(name, weight, true, false, false, 0);
		this.type = type;
		this.resistances = new EnumDamageTypes[0];
		this.resistanceAmts = new int[0];
		this.castingDamage = castingDamage;
		this.protection = protection;
	}
	
	public Armor(String name, double weight, EnumArmorType type, double castingDamage, double protection, EnumDamageTypes[] resistances, int[] resistanceAmts) {
		super(name, weight, true, false, false, 0);
		this.type = type;
		this.resistances = resistances;
		this.resistanceAmts = resistanceAmts;
		this.castingDamage = castingDamage;
		this.protection = protection;
	}

	@Override
	public void onPickup(CreatureBase owner) {
		super.onPickup(owner);
	}

	@Override
	public void onDrop(CreatureBase owner) {
		super.onDrop(owner);
	}

	@Override
	public EnumArmorType getArmorType() {
		return type;
	}

	@Override
	public void dequip(CreatureBase owner) {
		super.dequip(owner);
		if(resistances.length > 0){
			owner.removeResistanceModifiers(resistances, resistanceAmts);
		}
		owner.applyProtection(-protection);
		owner.applyCastingDamage(-castingDamage);
	}

	@Override
	public void equip(CreatureBase owner) {
		super.equip(owner);
		if(resistances.length > 0){
			owner.appyResistanceModifiers(resistances, resistanceAmts);
		}
		owner.applyProtection(protection);
		owner.applyCastingDamage(castingDamage);
	}

}
