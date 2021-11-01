package yngl.randomchest;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
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
    ItemStack Sword_my;
    ItemStack Diamond_my;
    ItemStack Lapis_my;
    ItemStack Emerald_my;
    ItemStack SwordCrushing;
    Book book_1 = new Book();
    Book book_2 = new Book();
    Book book_3 = new Book();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new EventSpawnChest(), this);

        CreateSword_my();
        CreateDiamond_my();
        CreateEmerald_my();
        CreateLapis_my();
        CraftSwordCrushing();

//        Scanner sc = null;
//        int rows = 152;
//        int columns = 188;
//        int [][] myArray = new int[rows][columns];
////        getLogger().info("запуск");
//        try {
//            sc = new Scanner(new BufferedReader(new FileReader("C:\\Users\\user\\IdeaProjects\\myPlaginMinecraft\\src\\main\\java\\yngl\\randomchest\\lab_map.txt")));
//
//            while(sc.hasNextLine()) {
//                for (int i=0; i<myArray.length; i++) {
//                    String[] line = sc.nextLine().trim().split(" ");
//
//                    for (int j=0; j<line.length; j++) {
//                        myArray[i][j] = Integer.parseInt(line[j]);
////                        getLogger().info(String.valueOf(myArray[i][j]));
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        World world = Bukkit.getServer().getWorld("World");
//        Location loc = null;
//        for (int i = 0; i < 152; i++) {
//            for (int j = 0; j < 188; j++) {
//                loc = new Location(world, 100 + i, 70, 100 + j);
//                Block b_a = loc.getBlock();
//                b_a.setType(Material.BEDROCK);
//                loc = new Location(world, 100 + i, 78, 100 + j);
//                b_a = loc.getBlock();
//                b_a.setType(Material.BEDROCK);
//            }
//        }
//        for (int y = 71; y < 78; y++){
//            for (int i = 0; i < 152; i++) {
//                for (int j = 0; j < 188; j++) {
//                    loc = new Location(world, 100 + i, y, 100 + j);
//                    Block b_a = loc.getBlock();
//                    if (myArray[i][j] == 0){
//                        b_a.setType(Material.BEDROCK);
//                    }
//                    else{
//                        if(y == 71){
//                            b_a.setType(Material.STONE);
//                        }
//                        else{
//                            b_a.setType(Material.AIR);
//                        }
//                    }
//                }
//            }
//        }

        book_1.setTitle(ChatColor.GREEN + "Том 1");
        book_1.setAuthor(ChatColor.RED + "Пингвин написал");
        book_1.addToPage(ChatColor.BLUE + "Найди все плюшки в сундуках и устрой очень нехорошие дела на сервере!!!");
        book_1.addPage();
        book_1.addInfo();

        book_2.setTitle(ChatColor.GREEN + "Том 2");
        book_2.setAuthor(ChatColor.RED + "Пингвин написал");
        book_2.addToPage(ChatColor.BLUE + "Мечь сокрушения: тебе понадобятся три разных камня и мечь. " +
                "Как скрафтишь на вестаке, так сможешь активировать его ПКМ");
        book_2.addPage();
        book_2.addInfo();

        book_3.setTitle(ChatColor.GREEN + "Том 3");
        book_3.setAuthor(ChatColor.RED + "Пингвин написал");
        book_3.addToPage(ChatColor.BLUE + "Думает");
        book_3.addPage();
        book_3.addInfo();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void CreateSword_my(){
        Sword_my = new ItemStack(Material.IRON_SWORD);
        ItemMeta meta = Sword_my.getItemMeta();
        List<String> lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.BLUE + "Оснома меча сокрушения");
        lore.add("Часть чего-то великого");
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setLore(lore);
        Sword_my.setItemMeta(meta);
        ;    }

    public void CreateDiamond_my(){
        Diamond_my = new ItemStack(Material.DIAMOND);
        ItemMeta meta = Diamond_my.getItemMeta();
        List<String> lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.YELLOW + "Блестящий камушек");
        lore.add("Моя прелесть");
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setLore(lore);
        Diamond_my.setItemMeta(meta);
        ;    }

    public void CreateLapis_my(){
        Lapis_my = new ItemStack(Material.LAPIS_LAZULI);
        ItemMeta meta = Lapis_my.getItemMeta();
        List<String> lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.BLUE + "Леденящий душу камушек");
        lore.add("Абсолютно непрозрачный и однотонный");
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setLore(lore);
        Lapis_my.setItemMeta(meta);
        ;    }

    public void CreateEmerald_my(){
        Emerald_my = new ItemStack(Material.EMERALD);
        ItemMeta meta = Emerald_my.getItemMeta();
        List<String> lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.BLUE + "Интересный камушек");
        lore.add("С ним как-то спокойнее");
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.setLore(lore);
        Emerald_my.setItemMeta(meta);
        ;    }

    public void CraftSwordCrushing(){
        SwordCrushing = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = SwordCrushing.getItemMeta();
        List<String> lore = new ArrayList<String>();
        meta.setDisplayName(ChatColor.YELLOW + "Меч сокрушения");
        lore.add("Будь аккуратен");
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        meta.setLore(lore);
        SwordCrushing.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(SwordCrushing);
        r.shape(new String[] {" B ", "CDE"});
        r.setIngredient('B', Diamond_my);
        r.setIngredient('C', Emerald_my);
        r.setIngredient('E', Lapis_my);
        r.setIngredient('D', Sword_my);
        Bukkit.addRecipe(r);
    }

    public static RandomChest getInstance() { return instance; }
}
