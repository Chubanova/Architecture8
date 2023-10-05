package com.chubanova.controller;

import com.chubanova.command.Command;
import com.chubanova.command.InterpretCommand;
import com.chubanova.entity.CommandMessage;
import com.chubanova.entity.MessageResponse;
import com.chubanova.ioc.IoC;

import java.util.Queue;

@org.springframework.web.bind.annotation.RestController
public class RestController {



    public MessageResponse set(CommandMessage commandMessage){
        Queue<Command> c = IoC.resolve("CommandsQueue");

        InterpretCommand command = new InterpretCommand(commandMessage.getIdGame(),
                commandMessage.getIdObject(), commandMessage.getIdOperation(), commandMessage.getArgs(), c);
        command.execute();


        return new MessageResponse();
    }
}
