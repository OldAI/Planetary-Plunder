package net.moppletop.gamemanager.backend;

import net.moppletop.gamemanager.eventhandler.Cancellable;
import net.moppletop.gamemanager.eventhandler.Event;
import net.moppletop.gamemanager.eventhandler.EventException;
import net.moppletop.gamemanager.eventhandler.EventPriority;
import net.moppletop.gamemanager.eventhandler.Listener;

public class RegisteredListener
{
  private final Listener listener;
  private final EventPriority priority;
  private final Plugin plugin;
  private final EventExecutor executor;
  private final boolean ignoreCancelled;
  
  public RegisteredListener(Listener listener, EventExecutor executor, EventPriority priority, Plugin plugin, boolean ignoreCancelled)
  {
    this.listener = listener;
    this.priority = priority;
    this.plugin = plugin;
    this.executor = executor;
    this.ignoreCancelled = ignoreCancelled;
  }
  
  public Listener getListener()
  {
    return this.listener;
  }
  
  public Plugin getPlugin()
  {
    return this.plugin;
  }
  
  public EventPriority getPriority()
  {
    return this.priority;
  }
  
  public void callEvent(Event event)
    throws EventException
  {
    if (((event instanceof Cancellable)) && 
      (((Cancellable)event).isCancelled()) && (isIgnoringCancelled())) {
      return;
    }
    this.executor.execute(this.listener, event);
  }
  
  public boolean isIgnoringCancelled()
  {
    return this.ignoreCancelled;
  }
}