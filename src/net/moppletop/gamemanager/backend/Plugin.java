package net.moppletop.gamemanager.backend;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

import com.avaje.ebean.EbeanServer;

public abstract interface Plugin
  extends TabExecutor
{
  public abstract File getDataFolder();
  
  public abstract FileConfiguration getConfig();
  
  public abstract InputStream getResource(String paramString);
  
  public abstract void saveConfig();
  
  public abstract void saveDefaultConfig();
  
  public abstract void saveResource(String paramString, boolean paramBoolean);
  
  public abstract void reloadConfig();
  
  public abstract PluginLoader getPluginLoader();
  
  public abstract Server getServer();
  
  public abstract boolean isEnabled();
  
  public abstract void onDisable();
  
  public abstract void onLoad();
  
  public abstract void onEnable();
  
  public abstract boolean isNaggable();
  
  public abstract void setNaggable(boolean paramBoolean);
  
  public abstract EbeanServer getDatabase();
  
  public abstract Logger getLogger();
  
  public abstract String getName();
}
