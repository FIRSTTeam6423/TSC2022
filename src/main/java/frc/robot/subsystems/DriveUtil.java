// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveUtil extends SubsystemBase {

  private WPI_VictorSPX leftPrimary, leftSecondary, rightPrimary, rightSecondary;

  private DifferentialDrive drive;

  /** Creates a new DriveUtil. */
  public DriveUtil() {
    leftPrimary = new WPI_VictorSPX(Constants.LEFT_PRIMARY);
    leftSecondary = new WPI_VictorSPX(Constants.LEFT_SECONDARY);
    rightPrimary = new WPI_VictorSPX(Constants.RIGHT_PRIMARY);
    rightSecondary = new WPI_VictorSPX(Constants.RIGHT_SECONDARY);

    leftSecondary.setInverted(true);
    rightSecondary.setInverted(true);

    leftSecondary.follow(leftPrimary);
    rightSecondary.follow(rightPrimary);


    drive = new DifferentialDrive(leftPrimary, rightPrimary);
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
