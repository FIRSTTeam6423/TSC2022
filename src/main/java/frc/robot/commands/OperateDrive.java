// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveUtil;

public class OperateDrive extends CommandBase {

  public DriveUtil driveUtil;
  public DriveMode mode;

  /** Creates a new OperateDrive. */
  public OperateDrive(DriveUtil driveUtil, DriveMode mode) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveUtil = driveUtil;
    this.mode = mode;
    addRequirements(driveUtil);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch(mode){
      case tank:
        driveUtil.driveTank(RobotContainer.getLeftStickY(), RobotContainer.getRightStickY());
        break;
      case arcade:
        driveUtil.driveArcade(RobotContainer.getRightStickY(), RobotContainer.getRightStickX());
        break;
      default:
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
