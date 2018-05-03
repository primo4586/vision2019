/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4586.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static Jaguar leftFrontMotor;
	public static Jaguar leftBackMotor;
	public static Jaguar rightFrontMotor;
	public static Jaguar rightBackMotor;
	
	public static void Init() {
		// TODO Check connections
		leftFrontMotor = new Jaguar(7); //6
		leftBackMotor = new Jaguar(9); //8
		rightFrontMotor = new Jaguar(6); //7
		rightBackMotor = new Jaguar(8); //9
		leftBackMotor.setInverted(true);
		leftFrontMotor.setInverted(true);
	}
	

	// For example to map the left and right motors, you could define the
	// following variables to use with your subsystem.
	// public static leftMotor = 1;
	// public static rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a :
	// public static rangefinderPort = 1;
	// public static rangefinderModule = 1;
}
