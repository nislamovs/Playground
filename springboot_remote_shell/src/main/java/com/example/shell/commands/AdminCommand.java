package com.example.shell.commands;

import org.springframework.stereotype.Component;
import sshd.shell.springboot.ShellException;
import sshd.shell.springboot.autoconfiguration.SshdShellCommand;

@Component
@SshdShellCommand(value = "admin", description = "Admin functionality. Type 'admin' for supported subcommands",
    roles = "ADMIN")
public class AdminCommand {

  @SshdShellCommand(value = "manage", description = "Manage task. Usage: admin manage <arg>", roles = "ADMIN")
  public String manage(String arg) {
    return arg + " has been managed by admin";
  }

  @SshdShellCommand(value = "testShellException", description = "Test throwing ShellException")
  public String testShellException(String arg) throws ShellException {
    throw new ShellException("Exception Message:" + arg);
  }
}