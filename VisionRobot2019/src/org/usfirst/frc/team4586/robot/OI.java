/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4586.robot;

import org.usfirst.frc.team4586.robot.commands.MotorActivate;
import org.usfirst.frc.team4586.robot.commands.TurnByVisionPID;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//driver
	public Joystick joystickDriver;
	public JoystickButton switchMotor;

	public OI()
	{
		joystickDriver = new Joystick(0);
		switchMotor = new JoystickButton(joystickDriver, 1);
		switchMotor.toggleWhenPressed(new TurnByVisionPID());
	}
}