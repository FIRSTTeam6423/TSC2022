// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CannonUtilTemp;

public class OperateCannon extends CommandBase {
  
  /** Define your variables here so they have class scope */
  private final CannonUtilTemp cannonUtil;
  private final int barrel;

  /** Creates a new OperateCannon. */
  public OperateCannon(CannonUtilTemp cu, int barrel) {

    /** The CannonUtil Object is being passed by reference and needs Class Scope */
    this.cannonUtil = cu;

    /** 
     * We need to know which barrel is being acted upon by the operator
     * The approach coded here works if you are shooting 1 OR 2
     * One way to support the 1 AND 2 condition is to accept an integer of 3, 
     * map a new button and call a new CannontUtil Method that manages both barrels concurrently.
     */
    this.barrel = barrel;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.cannonUtil);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (this.barrel == 1) {
      cannonUtil.shootBarrel1();
    }
    if (this.barrel == 2) {
      cannonUtil.shootBarrel2();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    /** Always ensure motors are OFF when a command ends!! */
    if (this.barrel == 1) {
      cannonUtil.stopBarrel1();
    }
    if (this.barrel == 2) {
      cannonUtil.stopBarrel2();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /** 
     * When there are complex conditions for determining if a Command should end
     * it is best to set a boolean (we call it {done}) to false, then go thru the 
     * conditional logic trying to set it to true.  Then just return the varialbe {done}
     */
    boolean done = false;
    if (this.barrel == 1) {
      if (cannonUtil.getBarrel1Limit()) {
        cannonUtil.stopBarrel1();
        done = true;
      }
    }
    if (this.barrel == 2) {
      if (cannonUtil.getBarrel2Limit()) {
        cannonUtil.stopBarrel2();
        done = true;
      }
    }
    return done;
  }
}
