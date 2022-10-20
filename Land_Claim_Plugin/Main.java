package zoren3105.zeradentsmp;


import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;


public class ZeradentSMP extends JavaPlugin {

    private Map<String, UUID> chunks = new HashMap<>();
    public Map<String, UUID> TeamZeradent = new HashMap<>();
    public Map<String, UUID> TeamMobros = new HashMap<>();
    public Map<String, UUID> TeamCrypten = new HashMap<>();
    public Map<String, UUID> TeamAri = new HashMap<>();
    public Map<String, UUID> TeamKiwi = new HashMap<>();
    public Map<String, UUID> TeamIrath = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("claim").setExecutor(new ClaimCommand(this));
        getCommand("unclaim").setExecutor(new UnclaimCommand(this));
        getCommand("team").setExecutor(new TeamJoinCommand(this));
        getServer().getPluginManager().registerEvents(new PreventionListener(this),this);
        this.saveDefaultConfig();

        if (this.getConfig().contains("claimedchunks")) {
            this.restoreClaimedChunks();
            getConfig().set("claimedchunks", null);
        }

        if (this.getConfig().contains("zeradent")) {
            this.restoreTeamZeradent();
            getConfig().set("zeradent", null);
        }

        if (this.getConfig().contains("ari")) {
            this.restoreTeamAri();
            getConfig().set("ari", null);
        }

        if (this.getConfig().contains("crypten")) {
            this.restoreTeamCrypten();
            getConfig().set("crypten", null);
        }

        if (this.getConfig().contains("kiwi")) {
            this.restoreTeamKiwi();
            getConfig().set("kiwi", null);
        }

        if (this.getConfig().contains("mobros")) {
            this.restoreTeamMobros();
            getConfig().set("mobros", null);
        }

        if (this.getConfig().contains("irath")) {
            this.restoreTeamIrath();
            getConfig().set("irath", null);
        }
    }

    @Override
    public void onDisable() {
        if (!chunks.isEmpty()) {
            this.saveClaimedChunks();
        }

        if(!TeamZeradent.isEmpty()) {
            saveNamesZeradent();
        }

        if(!TeamAri.isEmpty()) {
            saveNamesAri();
        }

        if(!TeamCrypten.isEmpty()) {
            saveNamesCrypten();
        }

        if(!TeamMobros.isEmpty()) {
            saveNamesMobros();
        }

        if(!TeamIrath.isEmpty()) {
            saveNamesIrath();
        }

        if(!TeamKiwi.isEmpty()) {
            saveNamesKiwi();
        }
    }

    public void saveClaimedChunks() {
        for (Map.Entry<String, UUID> data : chunks.entrySet()) {
            getConfig().set("claimedchunks." + data.getKey(), data.getValue().toString());
        }
        saveConfig();
    }

    public void saveNamesZeradent() {
        for (Map.Entry<String, UUID> data : TeamZeradent.entrySet()) {
            getConfig().set("zeradent." + data.getKey(), data.getValue().toString());
        }
        saveConfig();
    }

    public void saveNamesAri() {
        for (Map.Entry<String, UUID> data : TeamAri.entrySet()) {
            getConfig().set("ari." + data.getKey(), data.getValue().toString());
        }
        saveConfig();
    }

    public void saveNamesCrypten() {
        for (Map.Entry<String, UUID> data : TeamCrypten.entrySet()) {
            getConfig().set("crypten." + data.getKey(), data.getValue().toString());
        }
        saveConfig();
    }

    public void saveNamesKiwi() {
        for (Map.Entry<String, UUID> data : TeamKiwi.entrySet()) {
            getConfig().set("kiwi." + data.getKey(), data.getValue().toString());
        }
        saveConfig();
    }

    public void saveNamesIrath() {
        for (Map.Entry<String, UUID> data : TeamIrath.entrySet()) {
            getConfig().set("irath." + data.getKey(), data.getValue().toString());
        }
        saveConfig();
    }

    public void saveNamesMobros() {
        for (Map.Entry<String, UUID> data : TeamMobros.entrySet()) {
            getConfig().set("Mobros." + data.getKey(), data.getValue().toString());
        }
        saveConfig();
    }

    public void restoreClaimedChunks() {
        ConfigurationSection cfg = getConfig().getConfigurationSection("claimedchunks");
        if (cfg == null) return;

        chunks.clear();
        for (String chunkID : cfg.getKeys(false)) {
            chunks.put(chunkID, UUID.fromString(cfg.getString(chunkID)));
        }

    }

    public void restoreTeamZeradent() {
        ConfigurationSection cfg = getConfig().getConfigurationSection("zeradent");
        if (cfg == null) return;

        TeamZeradent.clear();
        for (String name : cfg.getKeys(false)) {
            TeamZeradent.put(name, UUID.fromString(cfg.getString(name)));
        }

    }

    public void restoreTeamAri() {
        ConfigurationSection cfg = getConfig().getConfigurationSection("ari");
        if (cfg == null) return;

        TeamAri.clear();
        for (String name : cfg.getKeys(false)) {
            TeamAri.put(name, UUID.fromString(cfg.getString(name)));
        }

    }

    public void restoreTeamCrypten() {
        ConfigurationSection cfg = getConfig().getConfigurationSection("crypten");
        if (cfg == null) return;

        TeamCrypten.clear();
        for (String name : cfg.getKeys(false)) {
            TeamCrypten.put(name, UUID.fromString(cfg.getString(name)));
        }

    }

    public void restoreTeamMobros() {
        ConfigurationSection cfg = getConfig().getConfigurationSection("mobros");
        if (cfg == null) return;

        TeamMobros.clear();
        for (String name : cfg.getKeys(false)) {
            TeamMobros.put(name, UUID.fromString(cfg.getString(name)));
        }

    }

    public void restoreTeamKiwi() {
        ConfigurationSection cfg = getConfig().getConfigurationSection("kiwi");
        if (cfg == null) return;

        TeamKiwi.clear();
        for (String name : cfg.getKeys(false)) {
            TeamKiwi.put(name, UUID.fromString(cfg.getString(name)));
        }

    }

    public void restoreTeamIrath() {
        ConfigurationSection cfg = getConfig().getConfigurationSection("irtah");
        if (cfg == null) return;

        TeamIrath.clear();
        for (String name : cfg.getKeys(false)) {
            TeamIrath.put(name, UUID.fromString(cfg.getString(name)));
        }

    }



    public void addChunk(String chunk, UUID owner){
        chunks.put(chunk, owner);
    }

    public boolean isChunk(String chunk){
        return chunks.containsKey(chunk);
    }

    public UUID getOwner(String chunk){
        return chunks.get(chunk);
    }

    public void removeChunk(String chunk, UUID owner) {chunks.remove(chunk, owner);}



    public void addNameZeradent(String name, UUID owner){
        TeamZeradent.put(name, owner);
    }

    public void addNameMobros(String name, UUID owner){ TeamMobros.put(name, owner); }

    public void addNameAri(String name, UUID owner){ TeamAri.put(name, owner); }

    public void addNameCrypten(String name, UUID owner){ TeamCrypten.put(name, owner); }

    public void addNameIrath(String name, UUID owner){
        TeamIrath.put(name, owner);
    }

    public void addNameKiwi(String name, UUID owner){
        TeamKiwi.put(name, owner);
    }


    public void removeNameZeradent(String name, UUID owner){ TeamZeradent.remove(name, owner); }

    public void removeNameMobros(String name, UUID owner){ TeamMobros.remove(name, owner); }

    public void removeNameAri(String name, UUID owner){ TeamAri.remove(name, owner); }

    public void removeNameCrypten(String name, UUID owner){ TeamCrypten.remove(name, owner); }

    public void removeNameIrath(String name, UUID owner){
        TeamIrath.remove(name, owner);
    }

    public void removeNameKiwi(String name, UUID owner){
        TeamKiwi.remove(name, owner);
    }
}

