package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.OI;
import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArcadeDrive extends Command {
	private OI oi;
	private Driver driver;
	private double speed;
	private double rotation;

	public ArcadeDrive() {
		this.driver = Robot.driver;
		this.oi = Robot.m_oi;

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drivingWithOutGyro();
	}

	private void drivingWithOutGyro() {
		this.speed = (this.oi.joystickDriver.getRawAxis(1)
						+ ((this.oi.joystickDriver.getRawAxis(1)) / Math.abs(this.oi.joystickDriver.getRawAxis(1)))
								* (oi.joystickDriver.getRawAxis(3) * 0.3 - oi.joystickDriver.getRawAxis(2) * 0.3));
		this.rotation = this.oi.joystickDriver.getRawAxis(4);
		if (Math.abs(speed) < 0.2) {
			speed = 0;
		}
		if (Math.abs(rotation) < 0.2) {
			rotation = 0;
		}
		this.driver.arcadeDrive(speed, rotation);
	}

	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.driver.stopAllWheels();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.driver.stopAllWheels();
	}
}
