package net.moppletop.gamemanager.eventhandler;

public abstract interface Cancellable
{
  public abstract boolean isCancelled();
  
  public abstract void setCancelled(boolean paramBoolean);
}
