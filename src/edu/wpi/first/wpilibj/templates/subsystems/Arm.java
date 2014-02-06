/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.FreeArmControl;

/**
 *
 * @author Robotics Club
 */
public class Arm extends Subsystem {
    
    //The drivetrain motors
    Jaguar jaguar = new Jaguar(RobotMap.armMotorPort);
    
    //Variables related to speed controlling
    double lowerSpeed = -0.175;
    double raiseSpeed = 0.175;
    double launchSpeed = 0.9; 
    double stopSpeed = 0.0;
    
    //Timing related variables
    double launchTime = 1.0;
    
    public void initDefaultCommand() {
        //Eliminate deadband
        jaguar.enableDeadbandElimination(true);
        
        // Set the default command for a subsystem here.
        setDefaultCommand(new FreeArmControl());
    }
    
    /*
    Lowers the arm at lowerspeed
    */
    public void lowerArm() {
        jaguar.set(lowerSpeed);
    }
    
    /*
    Raises the arm at raiseSpeed
    */
    public void raiseArm() {
        jaguar.set(raiseSpeed);
    }
    
    /*
    Stops the jaguar completely
    */
    public void stopArm() {
        jaguar.set(stopSpeed);
    }
    
    /*
    Puts them arm into launch mode
    */
    public void launchArm() {
        jaguar.set(launchSpeed);
        Timer.delay(launchTime);
        jaguar.set(-0.10);
        Timer.delay(launchTime);
        stopArm();
    }

    public Jaguar getMotor() {
        return jaguar;
    }
}
