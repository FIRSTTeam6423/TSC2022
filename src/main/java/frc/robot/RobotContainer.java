// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveArcade;
import frc.robot.commands.DriveMode;
import frc.robot.commands.DriveTank;
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
  //  Subsystems...
  private final DriveUtil driveUtil = new DriveUtil();


  //  Commands...
  private final DriveTank driveTank = new DriveTank(driveUtil);
  private final DriveArcade driveArcade = new DriveArcade(driveUtil);


  //  HIDs...
  public final Joystick leftStick, rightStick;
  public final XboxController controller;
  public final JoystickButton tankMode, arcadeMode, operateTank, operateArcade;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    leftStick = new Joystick(Constants.LEFT_STICK);
    rightStick = new Joystick(Constants.RIGHT_STICK);
    controller = new XboxController(Constants.CONTROLLER);

    tankMode = new JoystickButton(rightStick, Constants.kJoystickButton1);
    arcadeMode = new JoystickButton(rightStick, Constants.kJoystickButton3);
    operateTank = new JoystickButton(leftStick, Constants.kJoystickButton1);
    operateArcade = new JoystickButton(leftStick, Constants.kJoystickButton3);

    

    // Configure the button bindings
    configureButtonBindings();
    setDefaultCommands();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    tankMode.whenPressed(new DriveTank(driveUtil));
    arcadeMode.whenPressed(new DriveArcade(driveUtil));
    operateTank.whenPressed(new OperateDrive(driveUtil, DriveMode.tank));
    operateArcade.whenPressed(new OperateDrive(driveUtil, DriveMode.arcade));

  }

  private void setDefaultCommands(){
    driveUtil.setDefaultCommand(driveTank);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
    return null;
  }

  public double getLeftStickX(){
    return leftStick.getX();
  }

  public double getLeftStickY(){
    return leftStick.getY();
  }

  public double getRightStickX(){
    return rightStick.getX();
  }

  public double getRightStickY(){
    return rightStick.getY();
  }
}
