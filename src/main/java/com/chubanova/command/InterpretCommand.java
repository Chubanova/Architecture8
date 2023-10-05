package com.chubanova.command;

import com.chubanova.Game;
import com.chubanova.UObject;
import com.chubanova.ioc.IoC;
import lombok.RequiredArgsConstructor;

import java.util.Queue;

@RequiredArgsConstructor
public class InterpretCommand implements Command{

    private final  long idGame;
    private final long idObject;
    private final long idOperation;
    private final  String args[];
    private final Queue<Command> gameCommands;

    @Override
    public void execute() {
        UObject gameObject = (UObject) IoC.resolve("GameObject", idObject);
        Game game = IoC.resolve("Game", idGame);
        Command command = (Command) IoC.resolve("Operation", idOperation,game, gameObject, args);
        gameCommands.add(command);
    }

}

