/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Pangaea_Working extends IterativeRobot {
    
    RobotDrive chassis = new RobotDrive(1,2);
    Joystick mainStick = new Joystick(1);
    Jaguar jaguar = new Jaguar(3);
    Compressor compressorOne = new Compressor(1,1);
    Solenoid IntakeOne = new Solenoid(1);
    Solenoid OutputOne = new Solenoid(2);
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        compressorOne.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
      chassis.setSafetyEnabled(false);
      while (isAutonomous() && isEnabled()) {
      chassis.drive(0.5, 1);
      Timer.delay(0.02);
      chassis.drive(0.0, 0.0);
    }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        chassis.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            double speed;
            double rot;
            speed = mainStick.getY();
            rot = -mainStick.getX();
            chassis.arcadeDrive(speed,rot);// drive w/joysticks
            Timer.delay(0.02);
            boolean buttonValue;
            buttonValue = mainStick.getRawButton(3);
            buttonValue = mainStick.getRawButton(4);
            if (buttonValue = mainStick.getRawButton(3)){
                jaguar.set(1);
            }
            if (buttonValue = mainStick.getRawButton(4)){
                jaguar.set(-1);
            }
            else if (buttonValue = mainStick.getRawButton(5)){
                IntakeOne.set(true);
                OutputOne.set(false);
            }
            else if (buttonValue = mainStick.getRawButton(6)){
                IntakeOne.set(false);
                OutputOne.set(true);
            }
            else {
                IntakeOne.set(false);
                OutputOne.set(false);
            }
    }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        chassis.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            double speed;
            double rot;
            speed = mainStick.getY();
            rot = -mainStick.getX();
            chassis.arcadeDrive(speed,rot);// drive w/joysticks
            Timer.delay(0.02);
            boolean buttonValue;
            buttonValue = mainStick.getRawButton(3);
            buttonValue = mainStick.getRawButton(4);
            if (buttonValue = mainStick.getRawButton(3)){
                jaguar.set(1);
            }
            if (buttonValue = mainStick.getRawButton(4)){
                jaguar.set(-1);
            }
                        else if (buttonValue = mainStick.getRawButton(5)){
                IntakeOne.set(true);
                OutputOne.set(false);
            }
            else if (buttonValue = mainStick.getRawButton(6)){
                IntakeOne.set(false);
                OutputOne.set(true);
            }
            else {
                IntakeOne.set(false);
                OutputOne.set(false);
            }
    }
    }
    
}
