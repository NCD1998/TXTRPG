package creatures;

import java.util.ArrayList;

import central.Main;
import items.Item;
import logging.NELOGLEVELS;
import reference.EnumAccessoryTypes;

public class Inventory {
	private CreatureBase owner;
	private double weightCap;
	private ArrayList<Item> armor;
	private ArrayList<Item> accessories;
	private ArrayList<Item> inventory;
	private ArrayList<Item> equipedWeapons;
	private int weaponLimit;
	
	public Inventory(CreatureBase owner, double weightCap, int weaponLimit){
		Main.log.log(NELOGLEVELS.verbose, "[Inventory]: Created inventory for " + owner.getName() + " with cap " + weightCap);
		this.owner = owner;
		this.weightCap = weightCap;
		this.armor = new ArrayList<Item>();
		this.accessories = new ArrayList<Item>();
		this.inventory = new ArrayList<Item>();
		this.equipedWeapons = new ArrayList<Item>();
		this.weaponLimit = weaponLimit;
	}
	//Returns false if can't pick up, true if successful
	public boolean pickUp(Item item){
		//Test for inventory room
		 if(item.getWeight() > weightCap - getCurrentWeight()){
			 Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " could not pick up " + item.getName());
			 return false;
		 }else{
			 Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " picked up " + item.getName());
			 //Call the items pickup event
			 item.onPickup(owner);
			 //Add the item to the inventory
			 inventory.add(item);
			 return true;
		 }
	}
	//Drops an item from the inventory
	public void dropItem(Item item){
		Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " dropped up " + item.getName());
		item.onDrop(owner);
		inventory.remove(item);
	}
	
	//Equip Armor
	/*
	 * Returns: 0 if it worked
	 * 1 if creature is already wearing that armor
	 * 2 if item is not armor
	 */
	public int equipArmor(Item item){
		if(item.isArmor()){
			boolean isAlreadyWearing = false;
			for(int x = 0; x < armor.size(); x++){
				if(armor.get(x).getArmorType().equals(item.getArmorType())){
					isAlreadyWearing = true;
				}
			}
			if(isAlreadyWearing){
				Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " was already wearing a similar item as " + item.getName());
				return 1;
			}else{
				Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " equiped " + item.getName());
				armor.add(item);
				item.equip(owner);
				inventory.remove(item);
				return 0;
			}
		}else{
			Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " could not equip non armor item  " + item.getName());
			return 2;
		}
	}
	
	public void dequipArmor(Item item){
		armor.remove(item);
		inventory.add(item);
		item.dequip(owner);
		Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " dequiped  " + item.getName());
	}
	
	public void dequipAccessory(Item item){
		accessories.remove(item);
		inventory.add(item);
		item.dequip(owner);
		Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " dequiped  " + item.getName());
	}
	
	public void dequipWeapon(Item item){
		equipedWeapons.remove(item);
		inventory.add(item);
		item.dequip(owner);
		Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " dequiped  " + item.getName());
	}
	/*
	 * Returns: 0 if it worked
	 * 1 if creature is already wearing the limit of that accessory
	 * 2 if item is not an accessory
	 */
	public int equipAccessory(Item item){
		if(item.isAccessory()){
			int currentTypeCount = 0;
			EnumAccessoryTypes searchType = item.getAccessoryType();
			for(int x = 0; x > accessories.size(); x++){
				if(accessories.get(x).getAccessoryType().equals(searchType)){
					currentTypeCount++;
				}
			}
			if(currentTypeCount > searchType.getLimit()){
				Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " is already wearing too many " + item.getAccessoryType());
				return 1;
			}else{
				Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " equiped  " + item.getName());
				accessories.add(item);
				item.equip(owner);
				inventory.remove(item);
				return 0;
			}
		}else{
			Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " could not equip non accessory item  " + item.getName());
			return 2;
		}
	}
	
	//Returns true if successful, false if the hands were full
	public boolean equipWeapon(Item item){
		if(equipedWeapons.size() == weaponLimit){
			Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " could not equip weapon  " + item.getName());
			return false;
		}else{
			Main.log.log(NELOGLEVELS.info, "[Inventory]: " + owner + " equiped  " + item.getName());
			item.equip(owner);
			equipedWeapons.add(item);
			inventory.remove(item);
			return true;
		}
	}

	//Increases WeightCap
	public void changeInvSize(double amt){
		weightCap += amt;
	}
	private double getCurrentWeight() {
		double tally = 0;
		for(int x = 0; x < armor.size(); x++){
			tally += armor.get(x).getWeight();
		}
		for(int x = 0; x < accessories.size(); x++){
			tally += accessories.get(x).getWeight();
		}
		for(int x = 0; x < inventory.size(); x++){
			tally += inventory.get(x).getWeight();
		}
		return tally;
	}
}
