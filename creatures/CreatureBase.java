package creatures;

import java.util.ArrayList;

public abstract class CreatureBase {
	private String name;
	//Vitality
	private double maxHealth;
	private double currentHealth;
	private double healthRegeneration;
	private double maxMana;
	private double currentMana;
	private double manaRegeneration;
	private double castingChance;
	/*
	 * 0: Strength
	 * 1: Constitution
	 * 2: Intelligence
	 * 3: Wisdom
	 * 4: Dexterity
	 * 5: Charisma
	 * 6: Speed
	 * 7: Luck
	 */
	private int[] abilities;
	private int[] abilityModifiers;
	/*
	 * 0: Melee type (Swords, Maces ect)
	 * 1: Poison type (Poison and negative constitution effects)
	 * 2: Pure type (Never buffed, this damage is never reduced by anything)
	 * 3: Fire type (Fire, Fire Magic, Heat)
	 * 4: Magical type (Magic, Potions, magic effects)
	 * 5: Electrical type (Lighting, electrical devices, electrical magic)
	 * 6: Soul type (Necromancy, Turning, Zombie raise, soul magic)
	 * 7: Water type (Water magic, drowning, cold, if above 3 creature can breath underwater)
	 * 8: Air type (Storm magic, lashing winds, knockback)
	 * 9: Earth type (Crushing, Earthmagic, dust)
	 * 10: Debuff type (Negative effects)
	 */
	private int[] resistances;
	private int[] resistanceModifers;
	
	//Useable abilities
	private ArrayList<CreaturePAbilities> pAbilities;
	
	//Inventory
	private Inventory invent;

	public String getName() {
		return name;
	}
}
