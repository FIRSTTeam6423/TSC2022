// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CannonUtilTemp extends SubsystemBase {
  /** Creates a new CannonUtil. */
  /** Place your variables here so they have class scope */

  private WPI_TalonSRX barrel1;
  private WPI_TalonSRX barrel2;

  private DigitalInput stop1;
  private DigitalInput stop2;

  public CannonUtilTemp() {
  /** instanciate your objects here in the class constructor */
    barrel1 = new WPI_TalonSRX(Constants.BARREL_ONE);
    barrel2 = new WPI_TalonSRX(Constants.BARREL_TWO);

    stop1 = new DigitalInput(Constants.STOP_ONE);
    stop2 = new DigitalInput(Constants.STOP_TWO);
  }

   /**
    * These are helper methods for Command classes to
    * start and stop the barrel motors
    */
  public void shootBarrel1() {
    if (getBarrel1Limit()) {
      stopBarrel1();
    } else {
      /** 
       * Note: ControlMode.PercentOutput is expecting input as double -1 thru +1.  
       * Be explicit about the Control Mode
       */
      barrel1.set(ControlMode.PercentOutput, Constants.CANNON_MOTOR_SPEED);
    }
  }

  public void stopBarrel1(){
    barrel1.set(ControlMode.PercentOutput, 0.0);
  }

  public void shootBarrel2(){
    if (getBarrel2Limit()) {
      stopBarrel2();
    } else {
      barrel2.set(ControlMode.PercentOutput, Constants.CANNON_MOTOR_SPEED);
    }
  }

  public void stopBarrel2(){
    barrel2.set(ControlMode.PercentOutput, 0.0);
  }

  /** 
   * These are helper methods to let Commands know
   * if the limit switch is reached.
   */
  public boolean getBarrel1Limit(){
    return stop1.get();
  }

  public boolean getBarrel2Limit(){
    return stop2.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    /** Typically we send sensor and motor outputs to the SmartDashboard here */
    SmartDashboard.putBoolean("Barrel 1 Limit Switch :: ", getBarrel1Limit());
    SmartDashboard.putNumber("Barrel 1 Speed         :: ", barrel1.get());
    SmartDashboard.putBoolean("Barrel 2 Limit Switch :: ", getBarrel2Limit());
    SmartDashboard.putNumber("Barrel 2 Speed         :: ", barrel2.get());

  }
}
