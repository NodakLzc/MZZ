package com.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffect;

@SuppressWarnings("deprecation")
public class Main extends JavaPlugin implements Listener {
	public void onLoad() {
		this.saveDefaultConfig();
		System.out.println("[" + getName() + "]" + " " + "加载成功");
	}

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Designated_magic(this), this);
		System.out.println("[" + getName() + "]" + " " + "开启成功");
	}

	public void onDisable() {
		System.out.println("[" + getName() + "]" + " " + "关闭成功");
	}

	@EventHandler
	public void onPlayerChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		String msg = e.getMessage();
		for (String s : this.getConfig().getStringList("ZY")) {
			if (msg.length() == s.length() & msg.equalsIgnoreCase(s)) {
				for (String msg2 : this.getConfig().getStringList(s)) {
					if (msg2.startsWith("effect")) {
						int i = msg2.indexOf(" ", 0);
						int x = msg2.indexOf(" ", i + 1);
						int x1 = msg2.indexOf(" ", x + 1);
						String point = msg2.substring(i + 1, x);
						String n = msg2.substring(x + 1, x1);
						String nn = msg2.substring(x1 + 1, msg2.length());
						p.addPotionEffect(new PotionEffect(PotionEffectType
								.getByName(point), Integer.parseInt(n) * 20,
								Integer.parseInt(nn) - 1));
					}
					if (msg2.startsWith("msgall")) {
						int i = msg2.indexOf(" ", 0);
						String ma = msg2.substring(i + 1, msg2.length())
								.replace("&", "§")
								.replace("<player>", p.getName());
						Bukkit.broadcastMessage(ma);
					} else {
						if (msg2.startsWith("msg")) {
							int i = msg2.indexOf(" ", 0);
							String ma = msg2.substring(i + 1, msg2.length())
									.replace("&", "§")
									.replace("<player>", p.getName());
							p.sendMessage(ma);
						}
					}
					if (msg2.startsWith("exptake")) {
						int i = msg2.indexOf(" ", 0);
						int d = 0;
						Boolean pp = false;
						String exp = "";
						String mmsg = "";
						if (msg2.indexOf(" ", i + 1) > 0) {
							d = msg2.indexOf(" ", i + 1);
							pp = true;
						}
						if (pp == true) {
							mmsg = msg2.substring(d + 1, msg2.length())
									.replace("&", "§");
							exp = msg2.substring(i + 1, d);
						} else {
							exp = msg2.substring(i + 1, msg2.length());
						}
						if (p.getLevel() >= Integer.parseInt(exp)) {
							p.setLevel(p.getLevel() - Integer.parseInt(exp));
						} else {
							if (pp == true)
								p.sendMessage(mmsg);
							break;
						}
					}
					if (msg2.startsWith("expgive")) {
						int i = msg2.indexOf(" ", 0);
						String mmsg = msg2.substring(i + 1, msg2.length());
						p.giveExp(Integer.parseInt(mmsg));
					}
					if (msg2.startsWith("cmd")) {
						int i = msg2.indexOf("'", 0);
						int j = msg2.indexOf("'", i + 1);
						String cmd = msg2.substring(i + 1, j);
						p.chat("/" + cmd);
					}
					if (msg2.startsWith("permission")) {
						int i = msg2.indexOf(" ", 0);
						String Permission = msg2
								.substring(i + 1, msg2.length());
						if (!p.hasPermission(Permission))
							break;
					}

					if (msg2.startsWith("explset")) {
						int i = msg2.indexOf(" ", 0);
						String exp = msg2.substring(i + 1, msg2.length());
						p.setLevel(Integer.parseInt(exp));
					}

					if (msg2.startsWith("spawn")) {
						int i = msg2.indexOf(" ", 0);
						String s1 = msg2.substring(i + 1, msg2.length());
						if (s1.equalsIgnoreCase("CHICKEN")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.CHICKEN);
						} else if (s1.equalsIgnoreCase("COW")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.COW);
						} else if (s1.equalsIgnoreCase("CREEPER")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.CREEPER);
						} else if (s1.equalsIgnoreCase("GHAST")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.GHAST);
						} else if (s1.equalsIgnoreCase("GIANT")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.GIANT);
						} else if (s1.equalsIgnoreCase("HORSE")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.HORSE);
						} else if (s1.equalsIgnoreCase("PIG")) {
							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.PIG);
						} else if (s1.equalsIgnoreCase("PIGZOMB")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.PIG_ZOMBIE);
						} else if (s1.equalsIgnoreCase("SHEEP")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.SHEEP);
						} else if (s1.equalsIgnoreCase("SKELETON")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.SKELETON);
						} else if (s1.equalsIgnoreCase("SLIME")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.SLIME);
						} else if (s1.equalsIgnoreCase("SPIDER")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.SPIDER);
						} else if (s1.equalsIgnoreCase("SQUID")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.SQUID);
						} else if (s1.equalsIgnoreCase("ZOMBIE")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.ZOMBIE);
						} else if (s1.equalsIgnoreCase("WOLF")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.WOLF);
						} else if (s1.equalsIgnoreCase("CAVESPIDER")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.CAVE_SPIDER);
						} else if (s1.equalsIgnoreCase("ENDERMAN")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.ENDERMAN);
						} else if (s1.equalsIgnoreCase("SILVERFISH")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.SILVERFISH);
						} else if (s1.equalsIgnoreCase("ENDERDRAGON")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.ENDER_DRAGON);
						} else if (s1.equalsIgnoreCase("VILLAGER")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.VILLAGER);
						} else if (s1.equalsIgnoreCase("BLAZE")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.BLAZE);
						} else if (s1.equalsIgnoreCase("MUSHROOMCOW")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.MUSHROOM_COW);
						} else if (s1.equalsIgnoreCase("MAGMACUBE")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.MAGMA_CUBE);
						} else if (s1.equalsIgnoreCase("SNOWMAN")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.SNOWMAN);
						} else if (s1.equalsIgnoreCase("OCELOT")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.OCELOT);
						} else if (s1.equalsIgnoreCase("IRONGOLEM")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.IRON_GOLEM);
						} else if (s1.equalsIgnoreCase("WITHER")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.WITHER);
						} else if (s1.equalsIgnoreCase("BAT")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.BAT);
						} else if (s1.equalsIgnoreCase("WITCH")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.WITCH);
						} else if (s1.equalsIgnoreCase("BOAT")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.BOAT);
						} else if (s1.equalsIgnoreCase("MINECART")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.MINECART);
						} else if (s1.equalsIgnoreCase("MINECART_CHEST")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.MINECART_CHEST);
						} else if (s1.equalsIgnoreCase("MINECART_FURNACE")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.MINECART_FURNACE);
						} else if (s1.equalsIgnoreCase("MINECART_TNT")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.MINECART_TNT);
						} else if (s1.equalsIgnoreCase("MINECART_HOPPER")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.MINECART_HOPPER);
						} else if (s1.equalsIgnoreCase("MINECART_MOB_SPAWNER")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.MINECART_MOB_SPAWNER);
						} else if (s1.equalsIgnoreCase("ENDERCRYSTAL")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.ENDER_CRYSTAL);
						}

						else if (s1.equalsIgnoreCase("EXPERIENCEORB")) {

							p.getWorld().spawnEntity(p.getLocation(),
									EntityType.EXPERIENCE_ORB);
						}

					}
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String lable,
			String args[]) {
		if (cmd.getName().equalsIgnoreCase("zyreload") & sender.isOp()) {
			this.reloadConfig();
			sender.sendMessage("§a已重载");

		}
		return false;
	}
}
