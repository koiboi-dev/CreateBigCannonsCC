package rbasamoyai.createbigcannons.munitions.autocannon.ammo_container;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class AmmoContainerMenuSlot extends Slot {

	private final AmmoContainerContainer ammoContainer;

	public AmmoContainerMenuSlot(AmmoContainerContainer container, int slot, int x, int y) {
		super(container, slot, x, y);
		this.ammoContainer = container;
	}

	@Override
	public boolean mayPlace(ItemStack stack) {
		AutocannonAmmoType placeType = AutocannonAmmoType.of(stack);
		AutocannonAmmoType type = this.ammoContainer.getType();
		return placeType != AutocannonAmmoType.NONE && type == AutocannonAmmoType.NONE ||
			placeType == type && this.ammoContainer.getTotalCount() < type.getCapacity();
	}

}