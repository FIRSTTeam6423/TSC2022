// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveUtil extends SubsystemBase {

  private Talon leftPrimary;
  private Talon leftSecondary;
  private Talon rightPrimary;
  private Talon rightSecondary;

  private SpeedController leftMotor;
  private SpeedController rightMotor;

  private DifferentialDrive drive;

  /** Creates a new DriveUtil. */
  public DriveUtil() {
    leftPrimary = new Talon(Constants.LEFT_PRIMARY);
    leftSecondary = new Talon(Constants.LEFT_SECONDARY);
    rightPrimary = new Talon(Constants.RIGHT_PRIMARY);
    rightSecondary = new Talon(Constants.RIGHT_SECONDARY);

    leftMotor = new SpeedControllerGroup(leftPrimary, leftSecondary);
    rightMotor = new SpeedControllerGroup(rightPrimary, rightSecondary);

    drive = new DifferentialDrive(leftMotor, rightMotor);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void driveTank(double leftSpeed, double rightSpeed){
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void driveArcade(double xSpeed, double zRotation){
    //zRotation can be substituted by the yAxis.get() method call
    drive.arcadeDrive(xSpeed, zRotation);
  }
}
