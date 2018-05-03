package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.OI;
import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MotorActivate extends Command {
	private OI oi;
	private Driver driver;
	private double speed;
	private double rotation;
	private double h;
    public MotorActivate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		this.driver = Robot.driver;
		this.oi = Robot.m_oi;
		h = SmartDashboard.getNumber("Motor", 6);
		setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (h == 6)
    	{
    		driver.activate6();
    	}
    	else if (h == 7)
    	{
    		driver.activate7();
    	}
    	else if (h == 8)
    	{
    		driver.activate8();
    	}
    	else
    	{
    		driver.activate9();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
