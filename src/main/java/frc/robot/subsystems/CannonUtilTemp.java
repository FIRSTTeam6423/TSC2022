// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CannonUtil extends SubsystemBase {
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

  public void shootBarrel1(){
    barrel1.set(.1);
  }
  public void shootBarrel2(){
    barrel2.set(.1);
  }

  @Override
  public void periodic() {
    //20ms
    if(stop1.get() && barrel1.get() != 0){
      barrel1.set(0);
    }
    if(stop2.get() && barrel2.get() != 0){
      barrel2.set(0);
    }
    // This method will be called once per scheduler run
    /** Typically we send sensor and motor outputs to the SmartDashboard here */
  }
}
