// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.handlers.DriveMode;

public class DriveUtil extends SubsystemBase {
  // Motor controllers
  private WPI_VictorSPX leftSecondary, rightSecondary;
  private WPI_TalonSRX leftPrimary, rightPrimary;

  // Drive controller
  private DifferentialDrive differentialDrive;

  // DriveMode defaults to TANK
  private DriveMode driveMode = DriveMode.TANK;

  public DriveUtil() {
    // Initialize speed controllers (VictorSPX)
    leftPrimary = new WPI_TalonSRX(Constants.LEFT_PRIMARY);
    leftSecondary = new WPI_VictorSPX(Constants.LEFT_SECONDARY);
    rightPrimary = new WPI_TalonSRX(Constants.RIGHT_PRIMARY);
    rightSecondary = new WPI_VictorSPX(Constants.RIGHT_SECONDARY);

    // Set secondaries to follow primaries
    leftSecondary.follow(leftPrimary);
    rightSecondary.follow(rightPrimary);

    // Invert secondaries (since they're on the opposite side of the robot)
    //leftSecondary.setInverted(true);
    //rightSecondary.setInverted(true);

    // Initialize DifferentialDrive controller
    differentialDrive = new DifferentialDrive(leftPrimary, rightPrimary);
  }

  public void toggleDriveMode() {
    if (driveMode.equals(DriveMode.ARCADE)) {
      driveMode = DriveMode.TANK;
    } else {
      driveMode = DriveMode.ARCADE;
    }
  }

  /**
   * Drive the robot based on the driveMode class parameter.
   * If in TANK mode, use leftX and rightX values.
   * If in ARCADE mode, use rightX and rightY values.
   * 
   * The DifferentialDrive class will square inputs for us.
   * Squaring inputs results in less sensitive inputs.
   * 
   * @param leftX the left controller's X (forward-backward) value
   * @param leftY the left controller's Y (left-right) value
   * @param rightX the right controller's X (forward-backward) value
   * @param rightY the right controller's Y (left-right) value
   */
  public void driveRobot(double leftX, double leftY, double rightX, double rightY) {
    if (driveMode.equals(DriveMode.ARCADE)) {
      // If we're in ARCADE mode, use arcadeDrive
      differentialDrive.arcadeDrive(rightY, -rightX); //Invert angle
    } else if (driveMode.equals(DriveMode.TANK)) {
      // If we're in TANK mode, use tankDrive
      differentialDrive.tankDrive(leftY, rightY);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
