// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /**
    * DriveUtil Constants
    */
    /** TODO
     * The CAN IDs for these motors need to change.  Should not be using 0 as an ID
     * Also need to update the Mapping document to reflect the correct CAN ID Assignments
     */
    public static final int LEFT_PRIMARY = 4;
    public static final int LEFT_SECONDARY = 0;
    public static final int RIGHT_PRIMARY = 5;
    public static final int RIGHT_SECONDARY = 2;

    /**
     * CannonUtil Constants
     */
    public static final int ANGLE_MOTOR = 6;
    public static final int ANGLE_CONTROL = 0;
    public static final int UPPER_LIMIT = 0;
    public static final int LOWER_LIMIT = 1;
    public static final int TRIGGER1_FORWARD = 0;
    public static final int TRIGGER1_BACK = 1;
    public static final int TRIGGER2_FORWARD = 2;
    public static final int TRIGGER2_BACK = 3;
    public static final int TRIGGER3_FORWARD = 4;
    public static final int TRIGGER3_BACK = 5;

    /**
     * CannonUtilTemp Constants
     */
    public static final int BARREL_ONE = 4;
    public static final int BARREL_TWO = 5;
    public static final int STOP_ONE = 0;
    public static final int STOP_TWO = 1;
    public static final double CANNON_MOTOR_SPEED = 0.1;

  /**
   * Controller Input Device Mapping
   */
    public static final int LEFT_STICK = 2;
    public static final int RIGHT_STICK = 1;
    public static final int XBOX = 0;

  /**
   * Joystick Button Mapping
   */
    public static final int kJoystickButton1 = 1;
    public static final int kJoystickButton2 = 2;
    public static final int kJoystickButton3 = 3;
    public static final int kJoystickButton4 = 4;
    public static final int kJoystickButton5 = 5;
    public static final int kJoystickButton6 = 6;
    public static final int kJoystickButton7 = 7;
    public static final int kJoystickButton8 = 8;
    public static final int kJoystickButton9 = 9;
    public static final int kJoystickButton10 = 10;
    public static final int kJoystickButton11 = 11;
    public static final int kJoystickButton12 = 12;

  /**
   * Controller Button Mapping
   */
    public static final int kLeftXAxisNum = 0;
    public static final int kLeftYAxisNum = 1;
    public static final int kRightXAxisNum = 2;
    public static final int kRightYAxisNum = 3;

    public static final int kXButtonNum = 1;
    public static final int kAButtonNum = 2;
    public static final int kBButtonNum = 3;
    public static final int kYButtonNum = 4;
    public static final int kLeftBumperNum = 5;
    public static final int kRightBumperNum = 6;
    public static final int kLeftTriggerNum = 7;
    public static final int kRightTriggerNum = 8;
    public static final int kBackButtonNum = 9;
    public static final int kStartButtonNum = 10;
    public static final int kLeftStickButtonNum = 11;
    public static final int kRightStickButtonNum = 12;
}
