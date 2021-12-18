// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CannonUtil extends SubsystemBase {
  /** Creates a new CannonUtil. */
  /** Place your variables here so they have class scope */
  private WPI_TalonSRX shotAngle; 
  private DigitalInput lowerSwitch;
  private DigitalInput upperSwitch;
  private AnalogInput angleSensor;
  
  private DoubleSolenoid trigger1;
  private DoubleSolenoid trigger2;
  private DoubleSolenoid trigger3;

  public CannonUtil() {
  /** instanciate your objects here in the class constructor */


  }

  public void fireCannon(int cn) {
    switch(cn){
      case 1:
        trigger1.set(DoubleSolenoid.Value.kForward);
        break;
      case 2: 
        trigger2.set(DoubleSolenoid.Value.kForward);
        break;
      case 3:
        trigger3.set(DoubleSolenoid.Value.kForward);
        break;
    }
  }

  /** Add specific methods the Util must expose to Commands */


  // private float triggerCloseTimeout = 1.0;
  // private int triggerCloseTicker = 0;
  
  @Override
  public void periodic() {
    //20ms
    // This method will be called once per scheduler run
    /** Typically we send sensor and motor outputs to the SmartDashboard here */
  }
}
