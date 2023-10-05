package com.chubanova.command;

import lombok.Getter;

@Getter
public class PrintCommand implements Command{
    private final int idCommand;

    public PrintCommand(int idCommand) {
        this.idCommand = idCommand;
    }

    @Override
    public void execute() {
        System.out.println("ляляля");
    }
}
