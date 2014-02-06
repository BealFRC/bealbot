/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Robotics Club
 */
public class CalibrateCommand extends CommandBase {
    
    public CalibrateCommand() {
        requires(drivetrain);
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drivetrain.getLeftMotor().set(1.0);
        drivetrain.getRightMotor().set(1.0);
        arm.getMotor().set(0.99999999);
        Timer.delay(5.0);
        drivetrain.getLeftMotor().set(-1.0);
        drivetrain.getRightMotor().set(-1.0);
        arm.getMotor().set(-1.0);
        Timer.delay(5.0);
        drivetrain.getLeftMotor().set(0.0);
        drivetrain.getRightMotor().set(0.0);
        arm.getMotor().set(0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.setLeftSpeed(0.0);
        drivetrain.setRightSpeed(0.0);
        arm.getMotor().set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drivetrain.setLeftSpeed(0.0);
        drivetrain.setRightSpeed(0.0);
        arm.getMotor().set(0.0);
    }
}
