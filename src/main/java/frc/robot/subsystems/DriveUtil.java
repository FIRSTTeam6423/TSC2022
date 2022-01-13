// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveUtil extends SubsystemBase {
  // Motor controllers
  private WPI_VictorSPX leftSecondary, rightSecondary;
  private WPI_TalonSRX leftPrimary, rightPrimary;

  // Drive controller
  private DifferentialDrive differentialDrive;

  private double damp;

  public DriveUtil() {
    // Initialize speed controllers (VictorSPX)
    leftPrimary = new WPI_TalonSRX(Constants.LEFT_PRIMARY);
    leftSecondary = new WPI_VictorSPX(Constants.LEFT_SECONDARY);
    rightPrimary = new WPI_TalonSRX(Constants.RIGHT_PRIMARY);
    rightSecondary = new WPI_VictorSPX(Constants.RIGHT_SECONDARY);

    // Set secondaries to follow primaries
    leftSecondary.follow(leftPrimary);
    rightSecondary.follow(rightPrimary);

    damp = 0.0;

    // Invert secondaries (since they're on the opposite side of the robot)
    //leftSecondary.setInverted(true);
    //rightSecondary.setInverted(true);

    // Initialize DifferentialDrive controller
    differentialDrive = new DifferentialDrive(leftPrimary, rightPrimary);
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
  public void driveRobot() {
    setDriveControls();
    if (RobotContainer.driveType.getSelected().equals(RobotContainer.arcade)) {
      // If we're in ARCADE mode, use arcadeDrive
      differentialDrive.arcadeDrive(RobotContainer.getRightStickY(), RobotContainer.getRightStickY());
    } else if (RobotContainer.driveType.getSelected().equals(RobotContainer.tank)) {
      // If we're in TANK mode, use tankDrive
      differentialDrive.tankDrive(RobotContainer.getLeftStickY(), RobotContainer.getRightStickY());
    } else if (RobotContainer.driveType.getSelected().equals(RobotContainer.sparrow)) {
      // If we are in SPARROW mode, use the custom code.
      driveSparrow();
    } else if (RobotContainer.driveType.getSelected().equals(RobotContainer.curvature)) {
      // If we are in CURVATURE mode, use the curvature mode
      differentialDrive.curvatureDrive(RobotContainer.getLeftXboxTrigger() - RobotContainer.getRightXboxTrigger(), RobotContainer.getLeftXboxX(), true);
    }
  }

  private void setDriveControls(){
    if (RobotContainer.noobMode.getSelected().equals(RobotContainer.pro)) {
      this.damp = 1.0;
    }
    if (RobotContainer.noobMode.getSelected().equals(RobotContainer.noob)) {
      this.damp = 0.6;
    }

  }

  private void driveSparrow(){
    if(RobotContainer.getLeftXboxX() < 0) {
      sparrowDrive(((RobotContainer.getLeftXboxTrigger() - RobotContainer.getRightXboxTrigger()) * damp),
                                   (-RobotContainer.getLeftXboxX() * damp), 0.0);
    } else {
      sparrowDrive(((RobotContainer.getLeftXboxTrigger() - RobotContainer.getRightXboxTrigger()) * damp),
                                   0.0, (RobotContainer.getLeftXboxX() * damp));
    } 

  }

  public void sparrowDrive(double straight, double left, double right) {
    left = left*Constants.ARCADE_LEFT_DAMPENING/100;
    right = right*Constants.ARCADE_RIGHT_DAMPENING/100;
    leftPrimary.set(ControlMode.PercentOutput, straight + left - right);
    rightPrimary.set(ControlMode.PercentOutput, -(straight - left + right)); 
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    /** This is normally where we send important values to the SmartDashboard */
    SmartDashboard.putString("Driver Mode  ::  ", RobotContainer.noobMode.getSelected().toString());
    SmartDashboard.putString("Drive Type   ::  ", RobotContainer.driveType.getSelected().toString());
  }
  
}
