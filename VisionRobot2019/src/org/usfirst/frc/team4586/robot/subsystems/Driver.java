package org.usfirst.frc.team4586.robot.subsystems;

import org.usfirst.frc.team4586.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Driver extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Jaguar leftFrontMotor;
	Jaguar leftBackMotor;
	Jaguar rightFrontMotor;
	Jaguar rightBackMotor;
	SpeedControllerGroup rightController, leftController;
	DifferentialDrive diffDrive;

	PIDNetworkTable pidNetworkTable;
	PIDRotation pidRotation;
	PIDController tableController;
	NetworkTable table;

	public Driver(Jaguar leftFrontMotor, Jaguar leftBackMotor, Jaguar rightFrontMotor, Jaguar rightBackMotor) {
		this.leftFrontMotor = leftFrontMotor;
		this.leftBackMotor = leftBackMotor;
		this.rightFrontMotor = rightFrontMotor;
		this.rightBackMotor = rightBackMotor;
		this.rightController = new SpeedControllerGroup(this.rightBackMotor, this.rightFrontMotor);
		this.leftController = new SpeedControllerGroup(this.leftBackMotor, this.leftFrontMotor);
		this.diffDrive = new DifferentialDrive(this.leftController, this.rightController);

		this.table = Robot.table;

		this.pidNetworkTable = new PIDNetworkTable(this.table);
		this.pidRotation = new PIDRotation();
		this.tableController = new PIDController(0, 0, 0, this.pidNetworkTable, this.pidRotation);
	}

	public double getPIDRotation() {
		return this.pidRotation.getRotation();
	}

	public void setSetPoint(double setPoint) {
		this.tableController.setSetpoint(setPoint);
	}

	public void enable() {
		this.tableController.enable();
	}

	public void disable() {
		this.tableController.disable();
	}
	
	public boolean isOnTarget()
	{
		return this.tableController.onTarget() && getPIDRotation()<0.2;
	}

	// wheels
	public double getWheelSpeedLeftFront() {
		return leftFrontMotor.get();
	}

	public double getWheelSpeedLeftBack() {
		return leftBackMotor.get();
	}

	public double getWheelSpeedRightBack() {
		return rightBackMotor.get();
	}

	public double getWheelSpeedRightFront() {
		return rightFrontMotor.get();
	}

	// stops the wheels
	public void stopAllWheels() {
		this.leftBackMotor.set(0);
		this.leftFrontMotor.set(0);
		this.rightFrontMotor.set(0);
		this.rightBackMotor.set(0);
	}

	public void activate6() {
		leftFrontMotor.set(0.5);
	}

	public void activate7() {
		rightFrontMotor.set(0.5);
	}

	public void activate8() {
		leftFrontMotor.set(0.5);
	}

	public void activate9() {
		rightBackMotor.set(0.5);
	}

	// drive
	public void arcadeDrive(double speed, double rotation) {
		this.diffDrive.arcadeDrive(speed, rotation);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
