package yngl.randomchest;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.apache.logging.log4j.LogManager.getLogger;

public class EventSpawnChest implements Listener {
    private Object RandomChest;

    private int alertId;
    private int blockChec;
    private boolean flagChest = true;
    private int randomX;
    private int randomY;
    private int randomZ;
    private int randomXp;
    private int randomYp;
    private int randomZp;
    private int randomAction;

    public EventSpawnChest(){
        alertId = Bukkit.getScheduler().scheduleSyncRepeatingTask(yngl.randomchest.RandomChest.getInstance(), () -> {
            if(flagChest){
                randomX = ThreadLocalRandom.current().nextInt(-1000, 1000);
//                randomY = ThreadLocalRandom.current().nextInt(20, 80);
                randomZ = ThreadLocalRandom.current().nextInt(-1000, 1000);

                randomY = 255;
                Location loc = null;
                World world = Bukkit.getServer().getWorld("World");
                for(int i = 255; i > 0; i--) {
                    loc = new Location(world, randomX, i, randomZ);
                    Block b1 = loc.getBlock();
                    if (b1.getType() != Material.AIR) {
                        randomY = i + 1;
                        break;
                    }
                }
                loc = new Location(world, randomX, randomY, randomZ);
                Block b = loc.getBlock();

                b.setType(Material.CHEST);

                Chest chest = (Chest)b.getState();
                Inventory inv = chest.getInventory();

//                for(int i = 0; i < ThreadLocalRandom.current().nextInt(4); i++) {
//                    double rnd = new Random().nextFloat();
//                    if (rnd < 0.01) {
//                        ItemStack itemRand = new ItemStack(Material.BEDROCK, 1);
//                        inv.addItem(itemRand);
//                    }
//                    else if (rnd < 0.1){
//                        double rnd_dianobd_num = new Random().nextFloat();
//                        int num_diamond = 0;
//                        if (rnd_dianobd_num < 0.1){
//                            num_diamond = 1;
//                        }
//                        else if (rnd_dianobd_num < 0.25){
//                            num_diamond = 2;
//                        }
//                        else if (rnd_dianobd_num < 0.5){
//                            num_diamond = 3;
//                        }
//                        else if (rnd_dianobd_num < 0.75){
//                            num_diamond = 4;
//                        }
//                        else if (rnd_dianobd_num >= 0.75){
//                            num_diamond = 5;
//                        }
//                        ItemStack itemRand = new ItemStack(Material.DIAMOND, num_diamond);
//                        inv.addItem(itemRand);
//                    }
//                    else if (rnd < 0.25){
//                        double rnd_iron_num = new Random().nextFloat();
//                        int num_iron = 0;
//                        if (rnd_iron_num < 0.1){
//                            num_iron = 1;
//                        }
//                        else if (rnd_iron_num < 0.25){
//                            num_iron = 2;
//                        }
//                        else if (rnd_iron_num < 0.5){
//                            num_iron = 3;
//                        }
//                        else if (rnd_iron_num < 0.75){
//                            num_iron = 4;
//                        }
//                        else if (rnd_iron_num >= 0.75){
//                            num_iron = 5;
//                        }
//                        ItemStack itemRand = new ItemStack(Material.IRON_INGOT, num_iron);
//                        inv.addItem(itemRand);
//                    }
//                    else if (rnd < 0.33){
//                        int rnd_book_tom = ThreadLocalRandom.current().nextInt(3);
//                        if (rnd_book_tom == 0)
//                            inv.addItem(yngl.randomchest.RandomChest.getInstance().book_1.book);
//                        else if (rnd_book_tom == 1)
//                            inv.addItem(yngl.randomchest.RandomChest.getInstance().book_2.book);
//                        else if (rnd_book_tom == 2)
//                            inv.addItem(yngl.randomchest.RandomChest.getInstance().book_3.book);
//                    }
//                    else if (rnd >= 0.5){
//                        int rnd_item = ThreadLocalRandom.current().nextInt(4);
//                        if (rnd_item == 0)
//                            inv.addItem(yngl.randomchest.RandomChest.getInstance().Sword_my);
//                        else if (rnd_item == 1)
//                            inv.addItem(yngl.randomchest.RandomChest.getInstance().Diamond_my);
//                        else if (rnd_item == 2)
//                            inv.addItem(yngl.randomchest.RandomChest.getInstance().Emerald_my);
//                        else if (rnd_item == 3)
//                            inv.addItem(yngl.randomchest.RandomChest.getInstance().Lapis_my);
//                    }
//                }

                double rnd = new Random().nextFloat();
                if (rnd < 0.01) {
                    ItemStack itemRand = new ItemStack(Material.BEDROCK, 1);
                    inv.addItem(itemRand);
                }
                rnd = new Random().nextFloat();
                if (rnd < 0.1){
                    double rnd_dianobd_num = new Random().nextFloat();
                    int num_diamond = 0;
                    if (rnd_dianobd_num < 0.1){
                        num_diamond = 1;
                    }
                    else if (rnd_dianobd_num < 0.25){
                        num_diamond = 2;
                    }
                    else if (rnd_dianobd_num < 0.5){
                        num_diamond = 3;
                    }
                    else if (rnd_dianobd_num < 0.75){
                        num_diamond = 4;
                    }
                    else if (rnd_dianobd_num >= 0.75){
                        num_diamond = 5;
                    }
                    ItemStack itemRand = new ItemStack(Material.DIAMOND, num_diamond);
                    inv.addItem(itemRand);
                }
                rnd = new Random().nextFloat();
                if (rnd < 0.25){
                    double rnd_iron_num = new Random().nextFloat();
                    int num_iron = 0;
                    if (rnd_iron_num < 0.1){
                        num_iron = 1;
                    }
                    else if (rnd_iron_num < 0.25){
                        num_iron = 2;
                    }
                    else if (rnd_iron_num < 0.5){
                        num_iron = 3;
                    }
                    else if (rnd_iron_num < 0.75){
                        num_iron = 4;
                    }
                    else if (rnd_iron_num >= 0.75){
                        num_iron = 5;
                    }
                    ItemStack itemRand = new ItemStack(Material.IRON_INGOT, num_iron);
                    inv.addItem(itemRand);
                }
                rnd = new Random().nextFloat();
                if (rnd < 0.5){
                    int rnd_book_tom = ThreadLocalRandom.current().nextInt(3);
                    if (rnd_book_tom == 0)
                        inv.addItem(yngl.randomchest.RandomChest.getInstance().book_1.book);
                    else if (rnd_book_tom == 1)
                        inv.addItem(yngl.randomchest.RandomChest.getInstance().book_2.book);
                    else if (rnd_book_tom == 2)
                        inv.addItem(yngl.randomchest.RandomChest.getInstance().book_3.book);
                }
                rnd = new Random().nextFloat();
                if (rnd >= 0.5){
                    int rnd_item = ThreadLocalRandom.current().nextInt(4);
                    if (rnd_item == 0)
                        inv.addItem(yngl.randomchest.RandomChest.getInstance().Sword_my);
                    else if (rnd_item == 1)
                        inv.addItem(yngl.randomchest.RandomChest.getInstance().Diamond_my);
                    else if (rnd_item == 2)
                        inv.addItem(yngl.randomchest.RandomChest.getInstance().Emerald_my);
                    else if (rnd_item == 3)
                        inv.addItem(yngl.randomchest.RandomChest.getInstance().Lapis_my);
                }

//                ItemStack itemRand;
//                itemRand = new ItemStack(yngl.randomchest.RandomChest.getInstance().SwordCrushing);
//                inv.addItem(itemRand);

                flagChest = false;
            }
            if(!flagChest) {
                for (Player player : Bukkit.getOnlinePlayers()) {
//                    Bukkit.broadcastMessage(ChatColor.AQUA + "сундук на координатах: " + String.valueOf(randomX) +
//                                    " " + String.valueOf(randomY) + " " + String.valueOf(randomZ));
                    player.sendMessage(ChatColor.AQUA + "сундук на координатах: " + String.valueOf(randomX) +
                            " " + String.valueOf(randomY) + " " + String.valueOf(randomZ));
                }
            }
        }, 0, 1200);

        blockChec = Bukkit.getScheduler().scheduleSyncRepeatingTask(yngl.randomchest.RandomChest.getInstance(), () -> {
            if(!flagChest) {
                World world = Bukkit.getServer().getWorld("World");
                Location loc = null;
                loc = new Location(world, randomX, randomY, randomZ);
                Block b = loc.getBlock();
                if (b.getType() != Material.CHEST) {
                    flagChest = true;
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        player.sendMessage(ChatColor.RED + "Сундук сломан");
                        Location locP = player.getLocation();
                        int xP = (int) locP.getX();
                        int yP = (int) locP.getY();
                        int zP = (int) locP.getZ();
                        if(xP < randomX + 100 && xP > randomX - 100 &&
                                zP < randomZ + 100 && zP > randomZ - 100){
                            if(ThreadLocalRandom.current().nextBoolean()){
                                randomXp = ThreadLocalRandom.current().nextInt(randomX + 100, randomX + 500);
                            }
                            else{
                                randomXp = ThreadLocalRandom.current().nextInt(randomX - 500, randomX - 100);
                            }
                            if(ThreadLocalRandom.current().nextBoolean()){
                                randomZp = ThreadLocalRandom.current().nextInt(randomZ + 100, randomZ + 500);
                            }
                            else{
                                randomZp = ThreadLocalRandom.current().nextInt(randomZ - 500, randomZ - 100);
                            }
                            Location location = new Location(world, randomXp, randomY, randomZp);
                            player.teleport(location);
                        }
                    }
                }

            }
        }, 0, 20);
    }

    @EventHandler
    public void catchChestOpen(InventoryOpenEvent event) throws InterruptedException {
        Player player = (Player) event.getPlayer();
        if(event.getInventory().getType().equals(InventoryType.CHEST))
        {
            if(!flagChest) {
                Location loc = event.getInventory().getLocation();

                int x = (int) loc.getX();
                int y = (int) loc.getY();
                int z = (int) loc.getZ();

                if (x == randomX && y == randomY && z == randomZ) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
//                        Bukkit.broadcastMessage(ChatColor.GREEN + "Игрок " + player.getName() + " открыл сундук!");
//                        player.sendTitle(ChatColor.GREEN + player.getName(), ChatColor.WHITE + "открыл сундук", 1, 60, 1);
                        players.sendMessage(ChatColor.GREEN + "Игрок " + player.getName() + " открыл сундук!");
                    }
                    flagChest = true;

                    Bukkit.getScheduler().scheduleSyncDelayedTask(yngl.randomchest.RandomChest.getInstance(), () -> {
                        loc.getBlock().setType(Material.AIR);

                        randomAction = ThreadLocalRandom.current().nextInt(9);

                        World world = Bukkit.getServer().getWorld("World");

                        if(randomAction == 0){
                            randomXp = ThreadLocalRandom.current().nextInt(-1000, 1000);
                            randomZp = ThreadLocalRandom.current().nextInt(-1000, 1000);

                            Location loc_ = null;

                            loc_ = new Location(world, randomXp, 255, randomZp);
                            Block b_ = loc_.getBlock();
                            b_.setType(Material.MAGMA_BLOCK);

                            Location location = new Location(world, randomXp, 256, randomZp);

                            for (Player players : Bukkit.getOnlinePlayers()) {
//                                player.sendTitle(ChatColor.RED + "Не упади!", "", 1, 60, 1);
                                players.teleport(location);
                                players.sendMessage(ChatColor.RED + "Не упади!");
                            }
                        }
                        else if(randomAction == 1){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.setHealth(0.0);
//                                player.sendTitle(ChatColor.RED + "Увы, не повезло :(", "", 1, 60, 1);
                                players.sendMessage(ChatColor.RED + "Увы, не повезло :(");
                            }
                        }
                        else if(randomAction == 2){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 1));
                                players.sendMessage(ChatColor.YELLOW + "Вот и поюшка :)");
                            }
                        }
                        else if(randomAction == 3){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                randomXp = ThreadLocalRandom.current().nextInt(-1000, 1000);
                                randomZp = ThreadLocalRandom.current().nextInt(-1000, 1000);

                                Location loc1 = null;
                                Location loc2 = null;

                                for(int i = 256; i > 0; i--) {
                                    loc1 = new Location(world, randomXp, i, randomZp);
                                    loc2 = new Location(world, randomXp, i - 1, randomZp);
                                    Block b1 = loc1.getBlock();
                                    Block b2 = loc2.getBlock();
                                    if (b1.getType() != Material.AIR && b2.getType() != Material.AIR) {
                                        randomYp = i + 1;
                                        break;
                                    }
                                }
                                Location location = new Location(world, randomXp, randomYp, randomZp);
                                players.teleport(location);
                                players.sendMessage(ChatColor.RED + "Упс ;)");
                            }
                        }
                        else if(randomAction == 4){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage(ChatColor.RED + "Сгори свинья!");
                                player.setFireTicks(400);

//                                Location locP = players.getLocation();
//
//                                double xP = locP.getX();
//                                double yP = locP.getY();
//                                double zP = locP.getZ();
//
//                                Location loc_a = null;

//                                Material material = Material.MAGMA_BLOCK;

//                                for(double xx = xP - 2; xx <= xP + 2; xx++){
//                                    for(double zz = zP - 2; zz <= zP + 2; zz++){
//                                        loc_a = new Location(world, xx, yP - 2, zz);
//                                        Block b_a = loc_a.getBlock();
//                                        b_a.setType(material);
//                                        loc_a = new Location(world, xx, yP + 2, zz);
//                                        b_a = loc_a.getBlock();
//                                        b_a.setType(material);
//                                    }
//                                }
//
//                                for(double yy = yP - 2; yy <= yP + 2; yy++){
//                                    for(double zz = zP - 2; zz <= zP + 2; zz++){
//                                        loc_a = new Location(world, xP - 2, yy, zz);
//                                        Block b_a = loc_a.getBlock();
//                                        b_a.setType(material);
//                                        loc_a = new Location(world, xP + 2, yy, zz);
//                                        b_a = loc_a.getBlock();
//                                        b_a.setType(material);
//                                    }
//                                }
//
//                                for(double yy = yP - 2; yy <= yP + 3; yy++){
//                                    for(double xx = xP - 2; xx <= xP + 2; xx++){
//                                        loc_a = new Location(world, xx, yy, zP - 2);
//                                        Block b_a = loc_a.getBlock();
//                                        b_a.setType(material);
//                                        loc_a = new Location(world, xx, yy, zP + 2);
//                                        b_a = loc_a.getBlock();
//                                        b_a.setType(material);
//                                    }
//                                }
                            }
                        }
                        else if(randomAction == 5){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage(ChatColor.YELLOW + "Хрю-хрю");

                                Location locP = players.getLocation();
                                Location loc_6 = null;
                                int xP = (int) locP.getX();
                                int yP = (int) locP.getY();
                                int zP = (int) locP.getZ();

                                loc_6 = new Location(world, xP, yP, zP + 3);
                                loc_6.getWorld().spawnEntity(loc_6, EntityType.PIG);
                                loc_6 = new Location(world, xP, yP, zP - 3);
                                loc_6.getWorld().spawnEntity(loc_6, EntityType.PIG);
                                loc_6 = new Location(world, xP + 3, yP, zP );
                                loc_6.getWorld().spawnEntity(loc_6, EntityType.PIG);
                                loc_6 = new Location(world, xP - 3, yP, zP);
                                loc_6.getWorld().spawnEntity(loc_6, EntityType.PIG);

//                                for(int xx = xP - 1; xx <= xP + 1; xx++){
//                                    loc_6 = new Location(world, xx, yP, zP + 2);
//                                    loc_6.getWorld().spawnEntity(loc_6, EntityType.PIG);
//                                    loc_6 = new Location(world, xx, yP, zP - 2);
//                                    loc_6.getWorld().spawnEntity(loc_6, EntityType.PIG);
//                                }
//                                for(int zz = zP - 1; zz <= zP + 1; zz++){
//                                    loc_6 = new Location(world, xP - 2, yP, zz);
//                                    loc_6.getWorld().spawnEntity(loc_6, EntityType.PIG);
//                                    loc_6 = new Location(world, xP + 2, yP, zz);
//                                    loc_6.getWorld().spawnEntity(loc_6, EntityType.PIG);
//                                }
                            }
                        }
                        else if(randomAction == 6){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage(ChatColor.RED + "На дно!");

                                Location locP = players.getLocation();

                                double xP = locP.getX();
                                double yP = locP.getY();
                                double zP = locP.getZ();

                                Location loc_5 = null;

//                                for(double yy = 255; yy > 5; yy--){
//                                    for(double xx = xP - 1; xx <= xP + 1; xx++) {
//                                        for (double zz = zP - 1; zz <= zP + 1; zz++) {
//                                            loc_5 = new Location(world, xx, yy, zz);
//                                            Block b_5 = loc_5.getBlock();
//                                            b_5.setType(Material.AIR);
//                                        }
//                                    }
//                                }

                                for(double yy = 255; yy > 5; yy--){
                                    loc_5 = new Location(world, xP, yy, zP);
                                    Block b_5 = loc_5.getBlock();
                                    b_5.setType(Material.AIR);
                                }
                                locP = new Location(world, xP, yP - 1, zP);
                                players.teleport(locP);
                            }
                        }
                        else if(randomAction == 7){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage(ChatColor.RED + "Кушать поддано!");

                                Location locP = players.getLocation();
                                Location loc_6 = null;
                                int xP = (int) locP.getX();
                                int yP = (int) locP.getY();
                                int zP = (int) locP.getZ();

//                                for(int xx = xP - 3; xx <= xP + 3; xx++){
//                                    loc_6 = new Location(world, xx, yP, zP + 3);
//                                    loc_6.getWorld().spawnEntity(loc_6, EntityType.ZOMBIE);
//                                    loc_6 = new Location(world, xx, yP, zP - 3);
//                                    loc_6.getWorld().spawnEntity(loc_6, EntityType.ZOMBIE);
//                                }
//                                for(int zz = zP - 3; zz <= zP + 3; zz++){
//                                    loc_6 = new Location(world, xP - 3, yP, zz);
//                                    loc_6.getWorld().spawnEntity(loc_6, EntityType.ZOMBIE);
//                                    loc_6 = new Location(world, xP + 3, yP, zz);
//                                    loc_6.getWorld().spawnEntity(loc_6, EntityType.ZOMBIE);
//                                }
                                loc_6 = new Location(world, xP, yP, zP + 3);
                                loc_6.getWorld().spawnEntity(loc_6, EntityType.ZOMBIE);
                                loc_6 = new Location(world, xP, yP, zP - 3);
                                loc_6.getWorld().spawnEntity(loc_6, EntityType.ZOMBIE);
                                loc_6 = new Location(world, xP + 3, yP, zP );
                                loc_6.getWorld().spawnEntity(loc_6, EntityType.ZOMBIE);
                                loc_6 = new Location(world, xP - 3, yP, zP);
                                loc_6.getWorld().spawnEntity(loc_6, EntityType.ZOMBIE);
                            }
                        }
                        else if(randomAction == 8){
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.sendMessage(ChatColor.YELLOW + "Инструмент сделает из тебя человека");

                                Material[] drop = new Material[]{Material.IRON_PICKAXE, Material.IRON_AXE,
                                        Material.IRON_HOE, Material.IRON_SHOVEL, Material.IRON_SWORD,
                                        Material.GOLDEN_PICKAXE, Material.GOLDEN_AXE, Material.GOLDEN_HOE,
                                        Material.GOLDEN_SHOVEL, Material.GOLDEN_SWORD, Material.DIAMOND_PICKAXE,
                                        Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_SHOVEL,
                                        Material.DIAMOND_SWORD};

                                world.dropItem(players.getLocation(), new ItemStack(drop[ThreadLocalRandom.current().nextInt(drop.length)], 1));
                            }
                        }
                    }, 80);
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak_diamond(BlockBreakEvent event){
        if(event.getBlock().getType() == Material.DIAMOND_ORE){
            Location loc = event.getBlock().getLocation();
            loc.getBlock().setType(Material.AIR);
            loc.getWorld().dropItem(loc, new ItemStack(Material.COAL));
        }
    }

    @EventHandler
    public void onSwordCrushing(PlayerInteractEvent event){
        if (event.getItem() == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getPlayer().getItemInHand().equals(yngl.randomchest.RandomChest.getInstance().SwordCrushing)) {
                Player player = event.getPlayer();
//                getLogger().info("запуск");
                Bukkit.broadcastMessage(ChatColor.RED + "Игрок " + player.getName() + " активировал Меч сокрушения!");
                Random r = new Random();
                List<Player> players = new ArrayList<>(Bukkit.getOnlinePlayers());
                players.remove(player);
                if (players.size() != 0) {
                    Player random_player = players.get(r.nextInt(players.size()));
                    random_player.damage(100, player);
//                    player.damage(4.5);
                    if (player.getHealth() > 20.0){
                        player.setHealth(20.0);
//                        player.getWorld().strikeLightning(player.getLocation());
                    }
                    else if (player.getHealth() > 0.5 && player.getHealth() <= 20){
                        player.setHealth(0.5);
                    }
                    else{
                        player.setHealth(0.0);
                    }
                }
                else{
                    player.sendMessage(ChatColor.BLUE + "На сервере нету жертвы :(");
                }
            }
        }

    }

//    @EventHandler
//    public void onArmorWear(InventoryClickEvent e) {
//        if (e.getSlotType().equals(InventoryType.SlotType.ARMOR)) {
//            Bukkit.broadcastMessage(ChatColor.WHITE + "Это броня");
//        }
//    }
    @EventHandler
    public void TNTBabah(BlockPlaceEvent event) {
        if (event.getBlock().getType().equals(Material.TNT)){
            Location lot_tnt = event.getBlock().getLocation();
//            Location lot_tnt = event.getPlayer().getLocation();
            Location loc = null;
            loc = new Location(lot_tnt.getWorld(), lot_tnt.getX(), lot_tnt.getY() + 5, lot_tnt.getZ());
            event.getBlock().setType(Material.AIR);
            for(int i = 0; i < 1; i++) {
                Entity tnt = Bukkit.getWorld("world").spawn(loc, TNTPrimed.class);
                ((TNTPrimed)tnt).setFuseTicks(25);
            }
        }
    }
}