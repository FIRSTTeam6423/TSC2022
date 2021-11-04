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
    //  HID Mappings
    public static final int LEFT_STICK = 0;
    public static final int RIGHT_STICK = 1;
    public static final int CONTROLLER = 2;
    
        /**
         * Logitech (DInput) Controller
         */
        //LogiTech F310 Button Mapping X/D Switch = D, Direct Input
        public static final int kLeftXAxisNum = 0;
        public static final int kLeftYAxisNum = 1;
        public static final int kRightXAxisNum = 2;
        public static final int kRightYAxisNum = 3;
        //For DPad, use controller.getPOV();
        public static final int kDPadXAxisNum = 5;
        public static final int kDPadYAxisNum = 6;
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
        /**
        * XInput Controller Mapping (Xbox / Playstation with SCPtoolkit)
        */
        public static final int kOperatorPortNum = 1;
        public static final int kXInputXButtonNum = 3;
        public static final int kXInputAButtonNum = 1;
        public static final int kXInputBButtonNum = 2;
        public static final int kXInputYButtonNum = 4;
        public static final int kXInputLeftBumperNum = 5;
        public static final int kXInputRightBumperNum = 6;
        public static final int kXInputBackButtonNum = 7;
        public static final int kXInputStartButtonNum = 8;
        public static final int kXInputLeftStickButtonNum = 9;
        public static final int kXInputRightStickButtonNum = 10;  
        public static final int kXInputLeftXAxisNum = 0;
        public static final int kXInputRightXAxisNum = 4;
        public static final int kXInputLeftYAxisNum = 1;
        public static final int kXInputRightYAxisNum = 5;
        public static final int kXInputLeftTriggerAxisNum = 2;
        public static final int kXInputRightTriggerAxisNum = 3; 
        /**
         * Joystick Mapping
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


    //  DriveUtil Constants
        //  CAN Mapping
    public static final int LEFT_PRIMARY = 1;
    public static final int LEFT_SECONDARY = 2;
    public static final int RIGHT_PRIMARY = 3;
    public static final int RIGHT_SECONDARY = 4;

        // Autonomous Mapping

    //  ShotUtil Constants
        //  CAN Mapping



}
