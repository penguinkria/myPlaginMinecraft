package yngl.randomchest;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Scanner sc = null;
        int rows = 152;
        int columns = 188;
        int [][] myArray = new int[rows][columns];
//        getLogger().info("запуск");
        try {
            sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\myPlaginMinecraft\\src\\main\\java\\yngl\\randomchest\\lab_map.txt")));

            while(sc.hasNextLine()) {
                for (int i=0; i<myArray.length; i++) {
                    String[] line = sc.nextLine().trim().split(" ");

                    for (int j=0; j<line.length; j++) {
                        myArray[i][j] = Integer.parseInt(line[j]);
//                        getLogger().info(String.valueOf(myArray[i][j]));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        World world = Bukkit.getServer().getWorld("World");
        Location loc = null;
        for (int i = 0; i < 152; i++) {
            for (int j = 0; j < 188; j++) {
                loc = new Location(world, 100 + i, 70, 100 + j);
                Block b_a = loc.getBlock();
                b_a.setType(Material.BEDROCK);
                loc = new Location(world, 100 + i, 78, 100 + j);
                b_a = loc.getBlock();
                b_a.setType(Material.BEDROCK);
            }
        }
        for (int y = 71; y < 78; y++){
            for (int i = 0; i < 152; i++) {
                for (int j = 0; j < 188; j++) {
                    loc = new Location(world, 100 + i, y, 100 + j);
                    Block b_a = loc.getBlock();
                    if (myArray[i][j] == 0){
                        b_a.setType(Material.BEDROCK);
                    }
                    else{
                        if(y == 71){
                            b_a.setType(Material.STONE);
                        }
                        else{
                            b_a.setType(Material.AIR);
                        }
                    }
                }
            }
        }
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
