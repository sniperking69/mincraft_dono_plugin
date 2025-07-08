package me.assman.assPlugin.command;


import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import me.assman.assPlugin.assPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

public class creeperCommand implements CommandExecutor {
    private final assPlugin plugin;
    private static Socket socket;
    private static final String API="Your Stream Labs API key";
    public creeperCommand(assPlugin plugin) {
        this.plugin=plugin;
        plugin.getCommand("creepspawn").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        try {
            socket = IO.socket("https://sockets.streamlabs.com?token="+API);
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    System.out.println("It has connected");
                    //socket.disconnect();
                }

            }).on("event", new Emitter.Listener() {

                @Override
                public void call(Object... args) {
                    JSONObject obj = (JSONObject)args[0];
                    System.out.println(obj);
                    try {
//                        if(obj.getString("for").equals("youtube_account") && obj.getString("type").equals("follow") ) {
//                            System.out.println(obj.getString("type"));
//                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
//                                @Override
//                                public void run() {
//                                    Player p = (Player) sender;
//                                    Location loc=p.getLocation();
//                                    World w= p.getWorld();
//                                    for (int i=0;i<1;i++){
//                                        w.spawnEntity(loc, EntityType.GHAST);
//                                    }
//                                }
//                            },0L);
//
//
//                        }
//                        if(obj.getString("for").equals("twitch_account") && obj.getString("type").equals("follow") ) {
//                            System.out.println(obj.getString("type"));
//                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
//                                @Override
//                                public void run() {
//                                    Player p = (Player) sender;
//                                    Location loc=p.getLocation();
//                                    World w= p.getWorld();
//                                    for (int i=0;i<1;i++){
//                                        w.spawnEntity(loc, EntityType.GHAST);
//                                    }
//                                }
//                            },0L);
//
//
//                        }

                        if(obj.getString("for").equals("youtube_account") && obj.getString("type").equals("superchat") ) {
                            final JSONArray arry = obj.getJSONArray("message");
                            final JSONObject op = arry.getJSONObject(0);
                            final long am =Long.parseLong(op.getString("amount"));
                            double temp= (double) am/1000000;
                            int ammount = (int) Math.round(temp);
                            System.out.println(op);
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    if (ammount==1){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.SPIDER);
                                        w.spawnEntity(loc, EntityType.SKELETON);
                                    }
                                    if (ammount==2){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.CREEPER);
                                    }
                                    if (ammount==3){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.VINDICATOR);
                                        w.spawnEntity(loc, EntityType.VINDICATOR);
                                        for (int i=0;i<2;i++){
                                            w.spawnEntity(loc, EntityType.VINDICATOR);
                                        }
                                    }

                                    if (ammount==4){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        for (int i=0;i<3;i++){
                                            w.spawnEntity(loc, EntityType.BLAZE);
                                        }
                                    }
                                    if (ammount==5){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.RAVAGER);
                                    }
                                    if (ammount==6){
                                        Player p = (Player) sender;
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,7200,2));
                                    }
                                    if (ammount==10){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.EVOKER);
                                    }
                                    if (ammount==15){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        for (int i=0;i<20;i++){
                                            w.spawnEntity(loc, EntityType.ZOMBIE);
                                        }
                                    }
                                    if (ammount==20){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        for (int i=0;i<64;i++){
                                            w.dropItemNaturally(loc, new ItemStack(Material.DIAMOND));
                                        }

                                    }
                                    if (ammount==25){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        for (int i=0;i<64;i++){
                                            w.dropItemNaturally(loc, new ItemStack(Material.NETHERITE_INGOT));
                                        }

                                    }
                                    if (ammount==30){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.WOLF);
                                    }
                                    if (ammount==40){
                                        Player p = (Player) sender;
                                        for(ItemStack m : p.getInventory().getContents()) {
                                            p.getInventory().remove(m);
                                        }
                                    }
                                    if (ammount==50){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc,EntityType.WITHER);
                                    }

                                }
                            },0L);
                        }
                        if(obj.getString("type").equals("donation") ) {
                            final JSONArray arry = obj.getJSONArray("message");
                            final JSONObject op = arry.getJSONObject(0);
                            final double am =Double.parseDouble(op.getString("amount"));
                            int ammount = (int) Math.round(am);
                            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                                @Override
                                public void run() {
                                    if (ammount==1){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.SPIDER);
                                        w.spawnEntity(loc, EntityType.SKELETON);
                                    }
                                    if (ammount==2){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.CREEPER);
                                    }
                                    if (ammount==3){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.VINDICATOR);
                                        w.spawnEntity(loc, EntityType.VINDICATOR);
                                        for (int i=0;i<2;i++){
                                            w.spawnEntity(loc, EntityType.VINDICATOR);
                                        }
                                    }

                                    if (ammount==4){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        for (int i=0;i<3;i++){
                                            w.spawnEntity(loc, EntityType.BLAZE);
                                        }
                                    }
                                    if (ammount==5){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.RAVAGER);
                                    }
                                    if (ammount==6){
                                        Player p = (Player) sender;
                                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,7200,2));
                                    }
                                    if (ammount==10){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.EVOKER);
                                    }
                                    if (ammount==15){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        for (int i=0;i<20;i++){
                                            w.spawnEntity(loc, EntityType.ZOMBIE);
                                        }
                                    }
                                    if (ammount==20){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        for (int i=0;i<64;i++){
                                            w.dropItemNaturally(loc, new ItemStack(Material.DIAMOND));
                                        }

                                    }
                                    if (ammount==25){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        for (int i=0;i<64;i++){
                                            w.dropItemNaturally(loc, new ItemStack(Material.NETHERITE_INGOT));
                                        }

                                    }
                                    if (ammount==30){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc, EntityType.WOLF);
                                    }
                                    if (ammount==40){
                                        Player p = (Player) sender;
                                        for(ItemStack m : p.getInventory().getContents()) {
                                            p.getInventory().remove(m);
                                        }
                                    }
                                    if (ammount==50){
                                        Player p = (Player) sender;
                                        Location loc=p.getLocation();
                                        World w= p.getWorld();
                                        w.spawnEntity(loc,EntityType.WITHER);
                                    }

                                }
                            },0L);
                        }
                    } catch (JSONException e) {
                        //do nothing keep going
                    }


                }

            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

                @Override
                public void call(Object... args) {}

            });
            socket.connect();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
