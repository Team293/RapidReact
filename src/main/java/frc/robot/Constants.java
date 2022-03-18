// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.I2C.Port;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be
 * declared globally (i.e. public static). Do not put anything functional in
 * this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
    public static final class DrivetrainConstants {
        public static final double DEFAULT_JOYSTICK_DEADBAND = 0.15;
        public static final double DEFAULT_FORZA_DEADBAND = 0.01;
        public static final double DEFAULT_ARCADE_JOY_DEADBAND = 0.01;
        public static final boolean DEFAULT_FORZA_MODE = true;

        // PID Constants
        /*
         * To tune the PID:
         * 1. Using Pheonix tuner, set motors to factory default
         * 2. Set the velocity to 100%, this is the MAX_ENCODER_VELOCITY,
         * use the slower of the two motor systems!
         * 3. Calculate KF by hand using the KF equation below
         * 4. Increase P until the system oscillates by a measureable time
         * 5. Measure the period of the oscillation in seconds
         * 6. The P gain used to get this measureable oscillation is KU, enter KU
         * 7. The measured period of the oscillation, in seconds, is TU, enter TU
         * Done.
         */

        // Choose the slower motor speed max, in this case the right motor
        public static final double MAX_ENCODER_VELOCITY = 20743.0d;
        public static final double KF_TYPICAL_PERCENT_USAGE = 0.75d; // We will typically use 75% of max speed
        public static final double TALON_FULL_OUTPUT_SETTING = 1023;
        public static final double VELOCITY_KF = 0.046d;
        public static final double VELOCITY_KP = 0.03d;
        public static final double VELOCITY_KI = 0.0d;
        public static final double VELOCITY_KD = 0.06d;

        public static final double POSITION_KF = 0.0d;
        public static final double POSITION_KP = 0.016d;
        public static final double POSITION_KI = 0.0001d;
        public static final double POSITION_KD = 0.16d;

        public static final double CLOSED_LOOP_RAMP = 0.5;
        public static final double MAX_VELOCITY = 21549;

        public static final double DEFAULT_MAX_VELOCITY_PERCENTAGE = 0.6;
        public static final double DEFAULT_MAX_TURNING_SPEED = 0.5d;
        public static final double VELOCITY_SLOWDOWN_MODIFIER = 0.25d;
        public static final int LEFT_LEAD_TALON_CAN_ID = 2;
        public static final int LEFT_FOLLOWER_TALON_CAN_ID = 0;
        public static final int RIGHT_LEAD_TALON_CAN_ID = 1;
        public static final int RIGHT_FOLLOWER_TALON_CAN_ID = 3;
        public static final int VELOCITY_PID_SLOT_ID = 0;
        public static final int POSITION_PID_SLOT_ID = 1;
        public static final int PID_CONFIG_TIMEOUT_MS = 10;
        public static final int CONFIG_FEEDBACKSENSOR_TIMEOUT_MS = 4000;
        public static final double MOTOR_NEUTRAL_DEADBAND = 0.001d;

        // MISC Constants
        public static final double WHEEL_CIRCUMFERENCE_FEET = (4.0d / 12.0d) * Math.PI; // Wheel radius 4 in, converting
                                                                                        // to feet
        public static final double SECONDS_TO_DECISEC = 1.0d / 10.0d;
        public static final double DECISEC_TO_SECONDS = 10.0d / 1.0d;
        public static final double GEARBOX_RATIO_TO_ONE = 9.52d;
        public static final int ENCODER_COUNTS_PER_REVOLUTION = 2048;
        public static final int ENCODER_EDGES_PER_STEP = 1;
        public static final int ENCODER_UNITS_PER_REVOLUTION = ENCODER_COUNTS_PER_REVOLUTION; // Edges per Rotation
        public static final double TRACK_WIDTH_FEET = 27.5d / 12.0d; // Track width is 27.5 inches
        public static final boolean USE_NAVX_HEADING = false;
    }

    public static final class SmoothControlConstants {
        public static final double K1 = 1.0d;
        public static final double K2 = 3.0d;
    }

    public static final class AutonomousCommandConstants {
        public static final double TARGET_WITHIN_RANGE_FEET = DrivetrainConstants.TRACK_WIDTH_FEET / 4.0d; // quarter of
                                                                                                           // trackwidth
        public static final double STARTING_X = 0.0d;
        public static final double STARTING_Y = 0.0d;
        public static final double STARTING_HEADING = Math.toRadians(0.0d);
        public static final int AUTO_LAUNCHER_RPM = 2160;

        // Positions relative to location of driver station

        public static enum StartPositions {
            INVALID,
            BLUE_LEFT,
            BLUE_MIDDLE,
            BLUE_RIGHT,
            RED_LEFT,
            RED_MIDDLE,
            RED_RIGHT
        }
    }

    public static final class LauncherConstants {
        public static final int LAUNCHER_CAN_ID = 6;
        public static final double TARGET_RPM_READY_THRESHOLD = 10;
        public static final int DEFAULT_TARGET_RPM = 2400;
        public static final double CLOSED_LOOP_RAMPRATE = 0.5d;
        public static final int PID_SLOT_ID = 0;
        public static final int PID_CONFIG_TIMEOUT_MS = 10;
        public static final double KF = 0.059d;
        public static final double KP = 1.1d;
        public static final double KI = 0.0001d;
        public static final double KD = 15.0d;
        public static final double I_ZONE = 100.0d;
        public static final double GEAR_RATIO = 1.0d;
        public static final int ENCODER_UNITS_PER_REVOLUTION = 2048;
        public static final double MINUTES_TO_DECISECONDS = 600.0d;
        public static final double VOLTAGE_SATURATION = 12.0d;
        public static final double DUMP_RPM = 1000.0d;
    }

    public static final class FeederConstants {
        public static final int BELT_CAN_ID = 5;
        public static final int TRIGGER_CAN_ID = 4;
        public static final int BELT_SENSOR_PORT = 0;
        public static final Port COLOR_SENSOR_PORT = I2C.Port.kMXP;
        public static final int PROXIMITY_THRESHOLD = 110;
    }

    public static final class TargetingConstants {
        public static final int LIMELIGHT_LED_ON = 3;
        public static final int LIMELIGHT_LED_OFF = 1;
        public static final int LEFT_MOTOR_IND = 0;
        public static final int RIGHT_MOTOR_IND = 1;
        public static final double TARGET_ACQUIRED = 1.0;
        public static final double TARGET_NO_TARGET = 0.0;
        public static final double INTEGRAL_WEIGHT = .2;
        public static final double CONFIRMED_THRESHOLD = 0.5;
        public static final double CONFIRMED_TIME = .25; // Amount of seconds before it considers a target confirmed
        public static final double INTEGRAL_LIMIT = 0.5;
        public static final double LIMELIGHT_ERROR_MAX = 29.5;
        public static final double PERCENT_OUTPUT_LIMIT = .5;
        public static final double TIMER_NOT_STARTED_VALUE = 0.0;
        public static final double DEFAULT_LAUNCHER_RPM = 1200.0;
        public static final double ERROR_INTEGRAL_DEFAULT = 0.0;
        public static final double LAST_ERROR_DEFAULT = 0.0;
    }

    public static final class ClimberConstants
    {
        public static final int CLIMB_RETRACTION_SOLENOID = 0;
        public static final int CLIMB_EXTENSION_SOLENOID = 1;
    }

    public static final class PneumaticConstants
    {
        public static final int PNEUMATIC_MODULE_ID = 7;
        public static final double LOWEST_COMPRESSOR_PSI = 100.0d;
        public static final double HIGHEST_COMPRESSOR_PSI = 119.5d;
        public static final PneumaticsModuleType PNUEMATIC_MODULE_TYPE = PneumaticsModuleType.REVPH;
    }
}
