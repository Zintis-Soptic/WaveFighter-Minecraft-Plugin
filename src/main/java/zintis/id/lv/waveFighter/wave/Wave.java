package zintis.id.lv.waveFighter.wave;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wave {

    private final int waveNumber;
    private final long spawnDelayTicks;
    private final List<Location> spawnPoints;

    private int spawned;
    private int killed;
    private boolean active;

    private Map<EntityType, Integer> enemies;

    Wave(int waveNumber, long spawnDelayTicks, List<Location> spawnPoints, Map<EntityType, Integer> enemies) {
        this.waveNumber = waveNumber;
        this.spawnDelayTicks = spawnDelayTicks;
        this.spawnPoints = spawnPoints;
        this.enemies = enemies;
    }

    public int getWaveNumber() {
        return waveNumber;
    }

    public long getSpawnDelayTicks() {
        return spawnDelayTicks;
    }

    public List<Location> getSpawnPoints() {
        return spawnPoints;
    }

    public int getSpawned() {
        return spawned;
    }

    public void setSpawned(int spawned) {
        this.spawned = spawned;
    }

    public int getKilled() {
        return killed;
    }

    public void setKilled(int killed) {
        this.killed = killed;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<EntityType, Integer> getEnemies() {
        return enemies;
    }

    public void setEnemies(Map<EntityType, Integer> enemies) {
        this.enemies = enemies;
    }

}
