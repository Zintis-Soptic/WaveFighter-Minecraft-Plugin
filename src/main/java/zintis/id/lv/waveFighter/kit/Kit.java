package zintis.id.lv.waveFighter.kit;

import org.bukkit.inventory.ItemStack;
import zintis.id.lv.waveFighter.config.Config;

import java.util.ArrayList;
import java.util.List;

public class Kit {

    private String name;
    private int price;
    private int cooldown; // TODO: Implement kit selection cooldown
    private List<ItemStack> items = new ArrayList<>();

    Kit(String name, int price, List<ItemStack> items) {
        this.name = name;
        this.price = price;
        this.items = items;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    public List<ItemStack> getItems() {
        return this.items;
    }

    public void addItem(ItemStack newItem) {
        items.add(newItem);
    }

    public void removeItem(ItemStack item) {
        items.remove(item);
    }

    private boolean isCountValid(int count) {
        return (count > Config.MIN_ITEM_COUNT) && (count < Config.MAX_ITEM_COUNT);
    }

}
