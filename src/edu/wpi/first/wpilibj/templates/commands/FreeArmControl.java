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
public class FreeArmControl extends CommandBase {
    
    public FreeArmControl() {
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double armDirection = oi.leftStick.getY();
        if (armDirection < -0.25) {
            arm.lowerArm();
        } else if (armDirection > 0.25) {
            arm.raiseArm();
        } else {
            arm.stopArm();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        arm.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        arm.stopArm();
    }
}
