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
public class ArcadeDrive extends CommandBase {
    
    public ArcadeDrive() {
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        boolean isBoostButtonPressed = oi.rightStick.getRawButton(2); //Boost is controlled by trigger
        double moveValue = oi.rightStick.getY();
        double rotateValue = oi.rightStick.getX();
        boolean squaredInputs = false;

        double leftMotorSpeed;
        double rightMotorSpeed;

        moveValue = drivetrain.limit(moveValue);
        rotateValue = drivetrain.limit(rotateValue);

        if (squaredInputs) {
            // square the inputs (while preserving the sign) to increase fine control while permitting full power
            if (moveValue >= 0.0) {
                moveValue = (moveValue * moveValue);
            } else  {
                moveValue = -(moveValue * moveValue);
            }
            if (rotateValue >= 0.0) {
                rotateValue = (rotateValue * rotateValue);
            } else if (rotateValue <= -0.0) {
                rotateValue = -(rotateValue * rotateValue);
            }
        }

        if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            } 
        }
           
        drivetrain.setLeftSpeed(leftMotorSpeed, isBoostButtonPressed);
        drivetrain.setRightSpeed(rightMotorSpeed, isBoostButtonPressed);
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
