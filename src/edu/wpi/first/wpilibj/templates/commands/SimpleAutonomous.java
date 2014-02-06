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
public class SimpleAutonomous extends CommandBase {
    
    public SimpleAutonomous() {
        requires(drivetrain);
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.setLeftSpeed(0.4);
        drivetrain.setRightSpeed(-0.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.setLeftSpeed(0.0);
        drivetrain.setRightSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drivetrain.setLeftSpeed(0.0);
        drivetrain.setRightSpeed(0.0);  
    }
}
