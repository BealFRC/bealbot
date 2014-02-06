/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author Robotics Club
 */
public class SurgicalTurning extends CommandBase {
    
    public SurgicalTurning() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        boolean isBoostButtonPressed = oi.rightStick.getRawButton(2); //Boost is controlled by trigger
        double rawTwistInputD = oi.rightStick.getZ();
        if (rawTwistInputD < 0) { //Left twist
            drivetrain.setLeftSpeed(0.25, isBoostButtonPressed, false);
            drivetrain.setRightSpeed(-0.25, isBoostButtonPressed, false);
        } else { //Right twist
            drivetrain.setLeftSpeed(-0.25, isBoostButtonPressed, false);
            drivetrain.setRightSpeed(0.25, isBoostButtonPressed,false);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
