package com.chubanova.ioc;


import com.chubanova.command.Command;
import com.chubanova.ioc.command.ChangeScopeCommand;
import com.chubanova.ioc.command.CreateScopeCommand;
import com.chubanova.ioc.command.RegisterCommand;

public class InitializerCommandHandler implements Initializer<IoCDictionary<Command>> {
    @Override
    public void initialize(IoCDictionary<Command> handler) {
        handler.add("IoC.Register",
                RegisterCommand::new);

        handler.add("Scopes.New",
                CreateScopeCommand::new);

        handler.add("Scopes.Current",
                ChangeScopeCommand::new);
    }
}