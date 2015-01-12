package net.moppletop.gamemanager.backend;

import net.moppletop.gamemanager.eventhandler.Event;
import net.moppletop.gamemanager.eventhandler.EventException;
import net.moppletop.gamemanager.eventhandler.Listener;

public abstract interface EventExecutor
{
  public abstract void execute(Listener paramListener, Event paramEvent)
    throws EventException;
}
