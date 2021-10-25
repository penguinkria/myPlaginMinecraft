package yngl.randomchest;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomChest extends JavaPlugin {

    private static RandomChest instance;
    ItemStack itemPalka;
    ItemStack itemPalka2;

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new EventSpawnChest(), this);
        Palka();
        CraftPalka2();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void Palka(){
        itemPalka = new ItemStack(Material.STICK);
        ItemMeta meta = itemPalka.getItemMeta();
        List<String> lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.BLUE + "Палка копалка");
        lore.add("Незаменимая палка");
        meta.setLore(lore);
        itemPalka.setItemMeta(meta);
        ;    }

    public void CraftPalka2(){
        itemPalka2 = new ItemStack(Material.STICK);
        ItemMeta meta = itemPalka2.getItemMeta();
        List<String> lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.BLUE + "Палка копалка 22222");
        lore.add("Незаменимая палка еще лучше чем палка копалка");
        meta.setLore(lore);
        itemPalka2.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(itemPalka2);
        r.shape(new String[] {"A", "A"});
        r.setIngredient('A', itemPalka);
        Bukkit.addRecipe(r);
    }

    public static RandomChest getInstance() { return instance; }
}
