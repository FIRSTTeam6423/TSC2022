// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.OperateDrive;
import frc.robot.subsystems.DriveUtil;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveUtil driveUtil = new DriveUtil();
  private final CannonUtilTemp cannonUtilTemp = new CannonUtilTemp();

  private final OperateDrive operateDrive = new OperateDrive(driveUtil, cannonUtilTemp);

  public static Joystick leftStick, rightStick;
  public static XboxController operator;
  // private static ButtonMonitor toggleDrive;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    leftStick = new Joystick(Constants.LEFT_STICK);
    rightStick = new Joystick(Constants.RIGHT_STICK);
    operator = new XboxController(Constants.XBOX);

    //toggleDrive = new ButtonMonitor(operator, XboxController.Button.kStart);

    // Configure the button bindings
    configureButtonBindings();

    // Set Default Commands
    configureDefaultCommands();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
      new JoystickButton(operator, Button.kStart.value)
      .whenPressed(new InstantCommand(() -> driveUtil.toggleDriveMode(), driveUtil));
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return null;
  }

  private void configureDefaultCommands(){
    driveUtil.setDefaultCommand(operateDrive);

  }

  public static double getLeftStickX(){
    return leftStick.getX();
  }

  public static double getLeftStickY(){
    return leftStick.getY();
  }

  public static double getRightStickX(){
    return rightStick.getX();
  }

  public static double getRightStickY(){
    return rightStick.getY();
  }

  //========XBOX========//
  
  //Sticks (Xbox)
  public static double getLeftXboxX(){
    return operator.getX(GenericHID.Hand.kLeft);
  }

  public static double getLeftXboxY(){
    return operator.getY(GenericHID.Hand.kLeft);
  }

  public static double getRightXboxX(){
    return operator.getX(GenericHID.Hand.kRight);
  }

  public static double getRightXboxY(){
    return operator.getY(GenericHID.Hand.kRight);
  }

  //Buttons (Xbox)
  public static bool getAButtonPressed(){
    return operator.getAButtonPressed();
  }

  public static bool getBButtonPressed(){
    return operator.getBButtonPressed();
  }
}
