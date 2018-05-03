package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.command.Command;

/*
 *
 */
public class TurnByVisionPID extends Command {
	private Driver driver;
	private double rotation;
	double setPoint;
	double kP;
	double prevError;
	double kD;
	private double error;
	private NetworkTable table;
	double angle;

	public TurnByVisionPID() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.driver = Robot.driver;
		this.rotation = 0;
		this.table = Robot.table;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.setPoint = 0;
		this.kP = 0.11;
		this.kD = 0.0;
		this.prevError = 0;

		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		/*this.error = this.setPoint - this.table.getEntry("angle").getDouble(0.0);
		double der = (this.error - this.prevError) / 0.2;
		double drcw = this.kD * der;
		double prcw = this.kP * this.error;
		if (Math.abs(this.error) >= 1) {
			this.driver.arcadeDrive(0, -(prcw + drcw) * 0.7);
		} else {
			this.driver.arcadeDrive(0, 0);
		}
		prevError = error;
		*/
		
		angle = this.table.getEntry("angle").getDouble(0.0);
		if (angle > 2)
		{
			this.driver.arcadeDrive(0, -0.32);
		}
		else if (angle < 2)
		{
			this.driver.arcadeDrive(0, 0.32);
		}
		else
		{
			this.driver.arcadeDrive(0, 0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return this.driver.isOnTarget();
	}

	// Called once after isFinished returns true
	protected void end() {
		this.driver.stopAllWheels();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
	}
}
