// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveUtil;

public class OperateDrive extends CommandBase {

  private DriveUtil driveUtil;
  private CannonUtilTemp cannonUtilTemp;

  /** Creates a new OperateDrive. */
  public OperateDrive(DriveUtil du, CannonUtilTemp cut) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveUtil = du;
    addRequirements(this.driveUtil);

    this.cannonUtilTemp = cut;
    addRequirements(this.cannonUtilTemp);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveUtil.driveRobot(RobotContainer.getLeftXboxX(), 
                          RobotContainer.getLeftXboxY(), 
                          RobotContainer.getRightXboxX(),
                          RobotContainer.getRightXboxY());
    if(RobotContainer.getAButtonPressed()){
      cannonUtilTemp.shootBarrel1();
    }
    if(RobotContainer.getBButtonPressed()){
      cannonUtilTemp.shootBarrel2();
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
