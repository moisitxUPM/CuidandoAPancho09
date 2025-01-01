package org.pancho.model;

public interface ICommand {

    public String getCommandName();

    public void execute(String[] args);
}