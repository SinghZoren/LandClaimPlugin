package zoren3105.zeradentsmp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class TeamJoinCommand implements CommandExecutor {
    private final Main plugin;

    public TeamJoinCommand(Main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {

            Player player = (Player) sender;

            String name = player.getName();

            int numberOfArguments = args.length;


            if (numberOfArguments == 2) {

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("join")) {
                            if (args[1].equalsIgnoreCase("zeradent")) {
                                plugin.addNameZeradent(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Joined Team Zeradent");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("join")) {
                            if (args[1].equalsIgnoreCase("aridonnie")) {
                                plugin.addNameAri(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Joined Team Aridonnie");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("join")) {
                            if (args[1].equalsIgnoreCase("TheMoBrosGaming")) {
                                plugin.addNameMobros(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Joined Team Mobros");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("join")) {
                            if (args[1].equalsIgnoreCase("CryptenGaming_Tv")) {
                                plugin.addNameCrypten(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Joined Team Crypten");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("join")) {
                            if (args[1].equalsIgnoreCase("kashiikiwii")) {
                                plugin.addNameKiwi(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Joined Team Kiwi");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("join")) {
                            if (args[1].equalsIgnoreCase("IrathTEG")) {
                                plugin.addNameIrath(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Joined Team Irath");
                            }
                        }
                    }
                }







                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("leave")) {
                            if (args[1].equalsIgnoreCase("zeradent")) {
                                plugin.removeNameZeradent(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Left Team Zeradent");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("leave")) {
                            if (args[1].equalsIgnoreCase("aridonnie")) {
                                plugin.removeNameAri(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Left Team Aridonnie");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("leave")) {
                            if (args[1].equalsIgnoreCase("TheMoBrosGaming")) {
                                plugin.removeNameMobros(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Left Team Mobros");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("leave")) {
                            if (args[1].equalsIgnoreCase("CryptenGaming_Tv")) {
                                plugin.removeNameCrypten(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Left Team Crypten");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("leave")) {
                            if (args[1].equalsIgnoreCase("kashiikiwii")) {
                                plugin.removeNameKiwi(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Left Team Kiwi");
                            }
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("team")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("leave")) {
                            if (args[1].equalsIgnoreCase("IrathTEG")) {
                                plugin.removeNameIrath(name, player.getUniqueId());
                                sender.sendMessage(ChatColor.GREEN + "Succesfully Left Team Irath");
                            }
                        }
                    }
                }

            } else {
                sender.sendMessage(ChatColor.RED + "/team <Join / Leave> <Team Leader Name>");
            }
        }
        return true;
    }
}
