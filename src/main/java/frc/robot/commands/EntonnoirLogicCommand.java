// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Entonnoir;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class EntonnoirLogicCommand extends Command {
  /** Creates a new EntonnoirLogicCommand. */
  private Entonnoir entonnoir;
  public EntonnoirLogicCommand(Entonnoir entonnoir) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.entonnoir = entonnoir;
    addRequirements(entonnoir);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (entonnoir.getSortieState()) {
      if (entonnoir.getProcSensor()) {
        entonnoir.setSortieState(false);
      }
      entonnoir.setSortie(1);
      entonnoir.setEntree(1);
    } else {
      entonnoir.setSortie(0);
      entonnoir.setEntree(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}